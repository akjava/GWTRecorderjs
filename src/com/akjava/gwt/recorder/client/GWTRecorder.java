package com.akjava.gwt.recorder.client;

import com.akjava.gwt.html5.client.download.HTML5Download;
import com.akjava.gwt.html5.client.file.Blob;
import com.akjava.gwt.html5.client.file.File;
import com.akjava.gwt.html5.client.file.FileUtils;
import com.akjava.gwt.html5.client.file.FileUtils.DataArrayListener;
import com.akjava.gwt.html5.client.file.Uint8Array;
import com.akjava.gwt.recorder.client.Recorder.ExportListener;
import com.akjava.gwt.recorder.client.UserMedia.ErrorListener;
import com.akjava.gwt.recorder.client.UserMedia.SuccessListener;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.media.client.Audio;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTRecorder implements EntryPoint {

	private Recorder recorder;
	private AudioContext audioContext;
	private boolean initialized;
	private MediaStreamSource source;
	private LocalMediaStream localMediaStream;
	private Blob lastBlob;
	public void onModuleLoad() {
		
		boolean ac=AudioContext.isAvailable();
		log("audioContext:"+ac);
		
		boolean uc=UserMedia.isAvailable();
		log("userMedia:"+uc);
		
		boolean rc=Recorder.isAvailable();
		log("recorder:"+rc);
		
	
		
		VerticalPanel root=new VerticalPanel();
		RootLayoutPanel.get().add(root);
		HorizontalPanel h=new HorizontalPanel();
		root.add(h);
		final VerticalPanel links=new VerticalPanel();
		root.add(links);
		
		
		final Button record=new Button("Record");
		final Button stop=new Button("Stop");
		record.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				record.setEnabled(false);
				stop.setEnabled(true);
				recorder.record();
			}
		});
		h.add(record);
		
		stop.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				record.setEnabled(true);
				stop.setEnabled(false);
				
				recorder.stop();
				recorder.exportWAV(new ExportListener() {
					
					@Override
					public void onExport(Blob blob) {
						lastBlob=blob;
						links.clear();
						Anchor download=HTML5Download.get().generateDownloadLink(blob,"audio/wav", "test.wav", "download",true);
						links.add(download);
						
					}
				});
				recorder.clear();
			}
		});
		h.add(stop);
		stop.setEnabled(false);
		
		Button stopAll=new Button("stop MediaStream",new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//source.disconnect(audioContext.getDestination());
				localMediaStream.stop();
				log("media:"+localMediaStream.isEnded());
			}
		});
		h.add(stopAll);
		
		Button play=new Button("play",new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
					audio=Audio.createIfSupported();
					if(audio!=null){
						String url=HTML5Download.get().URL().createObjectURL(lastBlob);
						audio.addSource(url);
						audio.play();
					}
				}
			
		});
		h.add(play);
		
		audioContext=AudioContext.create();
		
		
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			
			@Override
			public void execute() {
				UserMedia.getUserMedia(true, new SuccessListener() {
					
					@Override
					public void onSuccess(LocalMediaStream loaclMediaStream) {
						log("media:"+loaclMediaStream.isEnded());
						startUserMedia(loaclMediaStream);
					}
				}, new ErrorListener(){

					@Override
					public void onError(UserMediaError error) {
						log(error);
					}});
			}
		});

		
		root.add(new Label("offline-text"));
		HorizontalPanel h2=new HorizontalPanel();
		root.add(h2);
		FileUtils.createSingleFileUploadForm(new DataArrayListener() {
			@Override
			public void uploaded(File file, Uint8Array array) {
				
			}
		}, false, true);
	}
	
	Audio audio;
	
	protected void startUserMedia(LocalMediaStream loaclMediaStream) {
		this.localMediaStream=loaclMediaStream;
		source = audioContext.createMediaStreamSource(loaclMediaStream);
		source.connect(audioContext.getDestination());
		recorder=Recorder.create(source);
	}

	/*
	 * can not shift
	 */
	public static final native void log(JavaScriptObject obj)/*-{
		$wnd.console.log(obj);
	}-*/;

	public static final native void log(String obj)/*-{
		$wnd.console.log(obj);
	}-*/;
}

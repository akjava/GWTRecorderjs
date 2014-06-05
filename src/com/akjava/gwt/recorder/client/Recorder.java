package com.akjava.gwt.recorder.client;

import com.akjava.gwt.html5.client.file.Blob;
import com.akjava.gwt.html5.client.file.Uint8Array;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Recorder extends JavaScriptObject{

	protected Recorder(){}
	
	public final static native Recorder create(MediaStreamSource source)/*-{
	return new $wnd.Recorder(source);
	}-*/;
	
	public final static native Recorder create(MediaStreamSource source,RecorderConfig config)/*-{
	return new $wnd.Recorder(source,config);
	}-*/;
	
	public final static native boolean isAvailable()/*-{
	if($wnd.Recorder){
		return true;
		}
	else{
		return false;
	}
	}-*/;
	
	
	
	
	public final  native void record()/*-{
	 this.record();
	}-*/;
	
	public final  native void stop()/*-{
	 this.stop();
	}-*/;
	
	public final  native void clear()/*-{
	 this.clear();
	}-*/;
	
	public final void exportWAV(ExportListener listener){
		exportWAV(listener,"audio/wav");//bugs,setted value from config does not work
	}
	public final  native void exportWAV(ExportListener listener,String type)/*-{
	 this.exportWAV(
	  function(blob){
	 listener.@com.akjava.gwt.recorder.client.Recorder.ExportListener::onExport(Lcom/akjava/gwt/html5/client/file/Blob;)(blob);	
	 },type
	 );
	}-*/;
	
	public final  native void getBuffer(BufferListener listener)/*-{
	 this.getBuffer(
	  function(buffer){
	 listener.@com.akjava.gwt.recorder.client.Recorder.BufferListener::onBuffer(Lcom/google/gwt/core/client/JsArray;)(buffer);	
	 }
	 );
	}-*/;
	
	public static interface ExportListener{
		public void onExport(Blob blob);
	}
	public static interface BufferListener{
		public void onBuffer(JsArray<JavaScriptObject> array);
	}
}

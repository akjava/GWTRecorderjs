package com.akjava.gwt.recorder.client;

import com.google.gwt.core.client.JavaScriptObject;

public class MediaStreamSource extends JavaScriptObject{
	protected MediaStreamSource(){}
	
	public final  native void connect(AudioDestinationNode node)/*-{
	this.connect(node);
	}-*/;
	
	public final  native void connect(Analyser node)/*-{
	this.connect(node);
	}-*/;
	
	public final  native void disconnect(AudioDestinationNode node)/*-{
	this.disconnect(node);
	}-*/;
	
	public final  native void disconnect(Analyser node)/*-{
	this.disconnect(node);
	}-*/;
	
	public final  native void setBuffer(Buffer buffer)/*-{
	this.buffer=buffer;
	}-*/;
	
	public final  native void start(double position)/*-{
	this.start(position);
	}-*/;
	
	public final  native void stop()/*-{
	this.stop();
	}-*/;
	
	
	
	public final  native int getPlaybackState()/*-{
	return this.playbackState;
	}-*/;
}

package com.akjava.gwt.recorder.client;

import com.akjava.gwt.html5.client.file.Uint8Array;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.typedarrays.shared.ArrayBuffer;

public class AudioContext extends JavaScriptObject{

	protected AudioContext(){}
	
	public final static native AudioContext create()/*-{
	$wnd.window.AudioContext=$wnd.window.AudioContext || $wnd.window.webkitAudioContext;
	return new $wnd.window.AudioContext();
	}-*/;
	
	public final static native boolean isAvailable()/*-{
		if(window.AudioContext || window.webkitAudioContext){
		return true;
		}else{
		return false; 
		}
	}-*/;
	
	public final  native MediaStreamSource createBufferSource()/*-{
	return this.createBufferSource();
	}-*/;
	
	public final  native MediaStreamSource createMediaStreamSource(LocalMediaStream stream)/*-{
	return this.createMediaStreamSource(stream);
	}-*/;
	
	
	public final  native AudioDestinationNode getDestination()/*-{
	return this.destination;
	}-*/;
	
	public final  native Buffer createBuffer(ArrayBuffer buffer,boolean mono)/*-{
	return this.createBuffer(buffer,mono);
	}-*/;
	
	public final  native Analyser createAnalyser()/*-{
	return this.createAnalyser();
	}-*/;
	
	public final  native int getSampleRate()/*-{
	return this.sampleRate;
	}-*/;
}

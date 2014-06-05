package com.akjava.gwt.recorder.client;

import com.google.gwt.core.client.JavaScriptObject;

/*
 * TODO more
 */
public class OfflineAudioContext extends JavaScriptObject{

	protected OfflineAudioContext(){}
	
	public final static native OfflineAudioContext create(int channel,int length,int sampleRate)/*-{
	$wnd.window.OfflineAudioContext=$wnd.window.OfflineAudioContext || $wnd.window.webkitOfflineAudioContext;
	return new $wnd.window.OfflineAudioContext(channel,length,sampleRate);
	}-*/;
	
	public final static native boolean isAvailable()/*-{
		if(window.OfflineAudioContext || window.webkitOfflineAudioContext){
		return true;
		}else{
		return false; 
		}
	}-*/;
	

	public final static native ScriptProcessorNode createScriptProcessor(int bufferSize,int numberOfInputChannels,int numberOfOutputChannels)/*-{
		return this.createScriptProcessor(bufferSize,numberOfInputChannels,numberOfOutputChannels);
	}-*/;
	
}

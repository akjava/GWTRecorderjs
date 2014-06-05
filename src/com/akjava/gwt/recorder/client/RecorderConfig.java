package com.akjava.gwt.recorder.client;

import com.google.gwt.core.client.JavaScriptObject;

public class RecorderConfig extends JavaScriptObject{

	protected RecorderConfig(){}
	
	public final static native RecorderConfig create()/*-{
	return {};
	}-*/;
	
	public final  native RecorderConfig workerPath(String workerPath)/*-{
	this.workerPath=workerPath;
	return this;
	}-*/;
}

package com.akjava.gwt.recorder.client;

import com.google.gwt.core.client.JavaScriptObject;

public class UserMedia extends JavaScriptObject{
	protected UserMedia(){}

	public final static native void getUserMedia(boolean audio,SuccessListener onSuccess,ErrorListener onError)/*-{
	$wnd.navigator.getUserMedia=$wnd.navigator.getUserMedia || $wnd.navigator.webkitGetUserMedia;

	$wnd.navigator.getUserMedia({audio:audio}
	, function(loaclMediaStream){
	onSuccess.@com.akjava.gwt.recorder.client.UserMedia.SuccessListener::onSuccess(Lcom/akjava/gwt/recorder/client/LocalMediaStream;)(loaclMediaStream);
	}
	, function(error){
	onError.@com.akjava.gwt.recorder.client.UserMedia.ErrorListener::onError(Lcom/akjava/gwt/recorder/client/UserMediaError;)(error);	
	}
	);
	console.log("called");
	}-*/;
	
	public final static native boolean isAvailable()/*-{
	if($wnd.navigator.getUserMedia || $wnd.navigator.webkitGetUserMedia){
		return true;
	}else{
		return false ;
	}
	}-*/;
	
	
	public static interface SuccessListener{
		public void onSuccess(LocalMediaStream loaclMediaStream);
	}
	
	public static interface ErrorListener{
		public void onError(UserMediaError error);
	}
}

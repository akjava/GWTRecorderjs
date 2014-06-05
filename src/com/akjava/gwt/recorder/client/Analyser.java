package com.akjava.gwt.recorder.client;

import com.akjava.gwt.html5.client.file.Uint8Array;
import com.google.gwt.core.client.JavaScriptObject;

public class Analyser extends JavaScriptObject {
protected Analyser(){}

public final  native void setSmoothingTimeConstant(double time)/*-{
this.smoothingTimeConstant =time;
}-*/;

public final  native void setFftSize(int size)/*-{
this.fftSize =size;
}-*/;

public final  native int getFftSize()/*-{
return this.fftSize;
}-*/;

public final  native void getByteFrequencyData(Uint8Array array)/*-{
this.getByteFrequencyData(array);
}-*/;

}

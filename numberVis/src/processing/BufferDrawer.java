package processing;
import ddf.minim.*;
import processing.core.PGraphics;
import ddf.minim.analysis.*;

public class BufferDrawer {
	Minim minim;
	AudioPlayer audioPlayer;  
	BeatDetect beat;
	int bufferSize;
	String song;
	float k = 0;
	Visualization parent;
	PGraphics canvas;
	
	int numPanelsX;
	int numPanelsY;
	
	public static enum Phase {
		POS, NEG, BOTH
	};
	public static enum Channel {
		LEFT, RIGHT, MIX
	};

	public BufferDrawer(Visualization visualization, int bufferSize, String song){
		this.parent = visualization;
		this.bufferSize = bufferSize;
		this.song = song;
		minim = new Minim(parent);
		audioPlayer = minim.loadFile(song, bufferSize);
		audioPlayer.play();
		audioPlayer.loop();
		//audioPlayer.mute();
		beat = new BeatDetect();
	}


	public void drawBufferMaskX(PGraphics viewPort, int amp, Phase phase, Channel channel){
		canvas = parent.createGraphics(viewPort.width, viewPort.height, NumbersLauncher.P3D);
		canvas.beginDraw();
		canvas.background(0,0,0,255); //full transparency
		//canvas.background(0,0,0,0);
		for (int i = 0; i < audioPlayer.bufferSize(); i++)  {
			switch (channel) {
			case LEFT: 
				k = audioPlayer.left.get(i);
				break;
			case RIGHT: 
				k = audioPlayer.right.get(i);
				break;
			case MIX: 
				k = audioPlayer.mix.get(i);
				break;
			}
			k = Math.min(k*amp,255);
			System.out.println(k);
			switch (phase){
			case BOTH:
				if (Math.abs(k) > 0)  {
					canvas.stroke(Math.abs(k));
					canvas.line(i,0,i,canvas.height);    //  Define the colour range of the panels
					//canvas.line(0,i,canvas.width,i);
				}
			case POS:
				if (k > 0)  {
					canvas.stroke(k);
					canvas.line(i,0,i,canvas.height);    //  Define the colour range of the panels
					//canvas.line(0,i,canvas.width,i);
				}
			case NEG:
				if (k > 0)  {
					canvas.stroke(k);
					canvas.line(i,0,i,canvas.height);    //  Define the colour range of the panels
					//canvas.line(0,i,canvas.width,i);
				}
			}		
		}
		canvas.endDraw();
		//canvas.resize(viewPort.width, viewPort.height);
		viewPort.beginDraw();
		viewPort.mask(canvas);
		viewPort.endDraw();
	}
	
	public void drawBufferMaskTransparentX(PGraphics viewPort, int amp, Phase phase, Channel channel){
		viewPort.beginDraw();
		//viewPort.background(0,0,0,0);
		for (int i = 0; i < audioPlayer.bufferSize(); i++)  {
			switch (channel) {
			case LEFT: 
				k = audioPlayer.left.get(i);
				break;
			case RIGHT: 
				k = audioPlayer.right.get(i);
				break;
			case MIX: 
				k = audioPlayer.mix.get(i);
				break;
			}
			k = Math.min(k*amp,255);
			System.out.println(k);
			switch (phase){
			case BOTH:
				if (Math.abs(k) > 0)  {
					viewPort.stroke(Math.abs(k));
					viewPort.line(i,0,i,viewPort.height);    //  Define the colour range of the panels
				}
			case POS:
				if (k > 0)  {
					viewPort.stroke(k);
					viewPort.line(i,0,i,viewPort.height);    //  Define the colour range of the panels
				}
			case NEG:
				if (k > 0)  {
					viewPort.stroke(k);
					viewPort.line(i,0,i,viewPort.height);    //  Define the colour range of the panels
				}
			}		
		}
		viewPort.endDraw();
	}
	
	
	
	public void drawBufferX(PGraphics viewPort, int amp, Phase phase, Channel channel){
		viewPort.beginDraw();
		viewPort.background(0,0,0,0);
		for (int i = 0; i < audioPlayer.bufferSize(); i++)  {
			switch (channel) {
			case LEFT: 
				k = audioPlayer.left.get(i);
				break;
			case RIGHT: 
				k = audioPlayer.right.get(i);
				break;
			case MIX: 
				k = audioPlayer.mix.get(i);
				break;
			}
			k = Math.min(k*amp,255);
			System.out.println(k);
			switch (phase){
			case BOTH:
				if (Math.abs(k) > 0)  {
					viewPort.stroke(Math.abs(k));
					viewPort.line(i,0,i,viewPort.height);    //  Define the colour range of the panels
				}
			case POS:
				if (k > 0)  {
					viewPort.stroke(k);
					viewPort.line(i,0,i,viewPort.height);    //  Define the colour range of the panels
				}
			case NEG:
				if (k > 0)  {
					viewPort.stroke(k);
					viewPort.line(i,0,i,viewPort.height);    //  Define the colour range of the panels
				}
			}		
		}
		viewPort.endDraw();
	}
	
	public void drawBufferY(PGraphics viewPort, int amp, Phase phase, Channel channel){
		viewPort.beginDraw();
		viewPort.background(0,0,0,0);
		for (int i = 0; i < audioPlayer.bufferSize(); i++)  {
			switch (channel) {
			case LEFT: 
				k = audioPlayer.left.get(i);
				break;
			case RIGHT: 
				k = audioPlayer.right.get(i);
				break;
			case MIX: 
				k = audioPlayer.mix.get(i);
				break;
			}
			k = Math.min(k*amp,255);
			System.out.println(k);
			switch (phase){
			case BOTH:
				if (Math.abs(k) > 0)  {
					viewPort.stroke(Math.abs(k));
					viewPort.line(0,i,viewPort.width,i);    //  Define the colour range of the panels
				}
			case POS:
				if (k > 0)  {
					viewPort.stroke(k);
					viewPort.line(0,i,viewPort.width,i);    //  Define the colour range of the panels
				}
			case NEG:
				if (k > 0)  {
					viewPort.stroke(k);
					viewPort.line(0,i,viewPort.width,i);   //  Define the colour range of the panels
				}
			}		
		}
		viewPort.endDraw();
	}
	
	
	
	
	public void drawBufferXY(PGraphics viewPort, int amp, Phase phase, Channel channel){
		viewPort.beginDraw();
		viewPort.background(0,0,0,0);
		for (int i = 0; i < audioPlayer.bufferSize(); i++)  {
			switch (channel) {
			case LEFT: 
				k = audioPlayer.left.get(i);
				break;
			case RIGHT: 
				k = audioPlayer.right.get(i);
				break;
			case MIX: 
				k = audioPlayer.mix.get(i);
				break;
			}
			k = Math.min(k*amp,255);
			System.out.println(k);
			switch (phase){
			case BOTH:
				if (Math.abs(k) > 0)  {
					viewPort.stroke(Math.abs(k));
					viewPort.line(i,0,i,viewPort.height);
					viewPort.line(0,i,viewPort.width,i);    //  Define the colour range of the panels
				}
			case POS:
				if (k > 0)  {
					viewPort.stroke(k);
					viewPort.line(i,0,i,viewPort.height);
					viewPort.line(0,i,viewPort.width,i);    //  Define the colour range of the panels
				}
			case NEG:
				if (k > 0)  {
					viewPort.stroke(k);
					viewPort.line(i,0,i,viewPort.height);
					viewPort.line(0,i,viewPort.width,i);   //  Define the colour range of the panels
				}
			}		
		}
		viewPort.endDraw();
	}
	
	public boolean detectBeat(){
		beat.detect(audioPlayer.mix);
		if(beat.isKick()){
			return true;
		}else{
			return false;
		}
	}
}
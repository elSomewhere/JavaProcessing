package processing;

import processing.core.PGraphics;

public class SubtleSorting {
	
	Visualization parent;
	MemoryRandom memoryRandomGenerator;
	
	int c;
	String name = "maria"; //file name 
	String type = "jpg"; //file type
	int col;
	
	int ch;
	float cc;
	
	final static int RED = 0;
	final static int GREEN = 1;
	final static int BLUE = 2;
	final static int HUE = 3;
	final static int SATURATION = 4;
	final static int BRIGHTNESS = 5;
	final static int NRED = 6;
	final static int NGREEN = 7;
	final static int NBLUE = 8;
	final static int NHUE = 9;
	final static int NSATURATION = 10;
	final static int NBRIGHTNESS = 11;

	// channels for depth: RED, GREEN, BLUE, HUE, SATURATION, BRIGHTNESS, NRED, NGREEN, NBLUE, NHUE, NSATURATION, NBRIGHTNESS. 
	int channel = BRIGHTNESS;
	// channel weight.
	float channel_weight = 0.1f;
	
	public SubtleSorting(Visualization visualization){
		this.parent = visualization;
		memoryRandomGenerator  = new MemoryRandom();
	}
	
	public void subtleSort(PGraphics viewPort){
		for (int i = 0; i < viewPort.width; i++) {
		    for (int j = 0; j < viewPort.height; j++) {
		      c = i+(j*viewPort.width);
		      col = viewPort.pixels[c];
		      viewPort.fill(col);
		      viewPort.noStroke();
		      viewPort.rect(i, j+getChannel(col), 1, getChannel(col));
		    }
		  }
	}
	
	float getChannel(int c) {
		  ch = channel>5?channel-6:channel;

		  switch(ch) {
		  case RED: 
		    cc = parent.red(c); 
		    break;
		  case GREEN: 
		    cc = parent.green(c); 
		    break;
		  case BLUE: 
		    cc = parent.blue(c); 
		    break;
		  case HUE: 
		    cc = parent.hue(c); 
		    break;
		  case SATURATION: 
		    cc = parent.saturation(c); 
		    break;
		  default: 
		    cc = parent.brightness(c); 
		    break;
		  }
		  return channel_weight * (channel>5?255-cc:cc);
		}

}


package processing;

import processing.core.PGraphics;

public class LineGlitch {
	
	Visualization parent;
	MemoryRandom memoryRandomGenerator;
	
	int c;
	int val;
	int threshold;
	final static int LEFT = 0;
	final static int TOP = 1;

	int mode = TOP; // glitch mode: LEFT, TOP.
	float amt; // threshold amount.
	
	public LineGlitch(Visualization visualization){
		this.parent = visualization;
		memoryRandomGenerator  = new MemoryRandom();
		mode = NumbersLauncher.TOP; // glitch mode: LEFT, TOP.
		amt = 20;
	}
	
	public void lineGlitch(PGraphics viewPort){
		viewPort.loadPixels();
		for (int i = 0; i < viewPort.width-1; i++) {
		  for (int j = 0; j < viewPort.height-1; j++) {
		    val = viewPort.pixels[i+(j*viewPort.width)];
		    threshold = viewPort.pixels[i+(j+1)*viewPort.width];
		    if (parent.brightness(val) > parent.brightness(threshold) + amt) { 
		      switch(mode) {
		      case LEFT:
		        c = val;
		        viewPort.pixels[(i+1)+(j*viewPort.width)] = c;
		        break;
		      case TOP:
		        c = val;
		        viewPort.pixels[i+((j+1)*viewPort.width)] = c;
		        break;
		      }
		    }
		  }
		}
		viewPort.updatePixels();
	}

}
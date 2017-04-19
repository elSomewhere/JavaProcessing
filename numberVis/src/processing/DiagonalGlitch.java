package processing;

import processing.core.PGraphics;

public class DiagonalGlitch {

	Visualization parent;
	MemoryRandom memoryRandomGenerator;
	int c;
	int v;
	int t;


	public DiagonalGlitch(Visualization visualization){
		this.parent = visualization;
		memoryRandomGenerator  = new MemoryRandom();
	}

	public void diagonalGlitch(PGraphics viewPort){
		viewPort.loadPixels();
		for (int i = 0; i < viewPort.width-1; i++) {
			for (int j = 0; j < viewPort.height-1; j++) {
				v = viewPort.pixels[i+(j*viewPort.width)];
				t = viewPort.pixels[i+(j+1)*viewPort.width];

				if (v > t) { 
					c = v;
					viewPort.pixels[(i+1)+((j+1)*viewPort.width)] = c;
				}
			}
		}
		viewPort.updatePixels();
	}

}

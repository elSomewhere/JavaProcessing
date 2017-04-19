package processing;

import processing.core.PGraphics;

public class Shifter {

	Visualization parent;
	MemoryRandom memoryRandomGenerator;
	int[] PixelsArray;
	float direction;
	int shiftCounter;
	enum Dir {
		LEFT, RIGHT, UP, DOWN
	}

	public Shifter(Visualization visualization){
		this.parent = visualization;
		memoryRandomGenerator  = new MemoryRandom();
		shiftCounter = 0;
	}

	public void constantShift(Dir dir, int strength, PGraphics viewPort){
		shiftCounter = shiftCounter + strength;
		viewPort.loadPixels();
		PixelsArray = viewPort.pixels.clone();
		for(int ty = 0; ty<viewPort.height;ty++){
			for(int tx = 0; tx<viewPort.width;tx++){
				switch (dir) {
				case LEFT: 
					viewPort.pixels[viewPort.width*((ty)%viewPort.height)+((tx-shiftCounter)%viewPort.width)] = PixelsArray[viewPort.width*ty+tx];
					break;
				case RIGHT: 
					viewPort.pixels[viewPort.width*((ty)%viewPort.height)+((tx+shiftCounter)%viewPort.width)] = PixelsArray[viewPort.width*ty+tx];
					break;
				case UP:
					viewPort.pixels[viewPort.width*((ty-shiftCounter)%viewPort.height)+((tx)%viewPort.width)] = PixelsArray[viewPort.width*ty+tx];
					break;
				case DOWN: 
					viewPort.pixels[viewPort.width*((ty+shiftCounter)%viewPort.height)+((tx)%viewPort.width)] = PixelsArray[viewPort.width*ty+tx];
					break;
				default: 
					break;
				}
			}
		}
		viewPort.updatePixels();		
	}

	public void shift(int x, int y, PGraphics viewPort){
		viewPort.loadPixels();
		PixelsArray = viewPort.pixels.clone();
		for(int ty = 0; ty<viewPort.height;ty++){
			for(int tx = 0; tx<viewPort.width;tx++){
				viewPort.pixels[viewPort.width*((ty+y)%viewPort.height)+((tx+x)%viewPort.width)] = PixelsArray[viewPort.width*ty+tx];
			}
		}
		viewPort.updatePixels();		
	}

	public void shiftRandomly(int shifter,PGraphics viewPort){
		direction = memoryRandomGenerator.getRandomFloat("1", Visualization.stopRandom);
		if(direction > 0.25){
			shift(shifter,0,viewPort);
		}else if(direction > 0.50){
			shift(shifter,0,viewPort);
		}else if(direction > 0.75){
			shift(0,shifter,viewPort);
		}else{
			shift(0,shifter,viewPort);
		}
	}


}

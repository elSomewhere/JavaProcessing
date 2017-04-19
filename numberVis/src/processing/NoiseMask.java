package processing;

import java.util.Random;

import processing.core.PGraphics;

public class NoiseMask {

	Visualization parent;
	MemoryRandom memoryRandomGenerator;
	PGraphics canvas;
	
	public NoiseMask(Visualization parent){
		this.parent = parent;
		memoryRandomGenerator  = new MemoryRandom();
	}
	
	
	
	
	public void drawLargeNoise(PGraphics viewPort,int pixelWidth,int pixelHeight){
		canvas = parent.createGraphics(viewPort.width, viewPort.height, NumbersLauncher.P3D);
		canvas.beginDraw();
		for(int i = 0;i<(canvas.width/pixelWidth);i++){
			for(int j = 0;j<(canvas.height/pixelHeight);j++){
				canvas.fill(memoryRandomGenerator.getRandomFloat("i"+i+"j"+j, Visualization.stopRandom)*255);
				canvas.noStroke();
				canvas.rect(i*pixelWidth, j*pixelHeight, pixelWidth, pixelHeight);
			}
		}
		canvas.endDraw();
		viewPort.beginDraw();
		viewPort.mask(canvas);
		viewPort.endDraw();
	}
}

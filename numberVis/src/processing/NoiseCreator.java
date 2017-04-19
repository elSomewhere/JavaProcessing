package processing;

import java.util.Random;

import processing.core.PGraphics;

public class NoiseCreator {

	Visualization parent;
	MemoryRandom memoryRandomGenerator;
	Random randomGenerator;
	
	public NoiseCreator(Visualization parent){
		this.parent = parent;
		memoryRandomGenerator  = new MemoryRandom();
		randomGenerator = new Random();
	}
	
	
	public void drawPixelNoise(PGraphics viewPort){
		viewPort.beginDraw();
		viewPort.loadPixels();
		for (int i = 0; i < viewPort.pixels.length; i++) {
			viewPort.pixels[i] = parent.color(memoryRandomGenerator.getRandomFloat(Integer.toString(i), Visualization.stopRandom)*255);
			//viewPort.pixels[i] = memoryRandomGenerator.getRandom(Integer.toString(i), Visualization.stopRandom);
			System.out.println(viewPort.pixels[i]);
		}
		viewPort.updatePixels();
		viewPort.endDraw();
	}
	
	
	public void drawLargeNoise(PGraphics viewPort,int pixelWidth,int pixelHeight){
		viewPort.beginDraw();
		for(int i = 0;i<(viewPort.width/pixelWidth);i++){
			for(int j = 0;j<(viewPort.height/pixelHeight);j++){
				viewPort.fill(randomGenerator.nextInt(255));
				viewPort.noStroke();
				viewPort.rect(i*pixelWidth, j*pixelHeight, pixelWidth, pixelHeight);
			}
		}
		viewPort.endDraw();
	}
	
	
	public void drawLargeDynamicNoise(PGraphics viewPort, int pixelSize, float noiseAmount){
		if(pixelSize==0){
			pixelSize = 1;
		}
		
		viewPort.loadPixels();	
		int c;
		double displace;

		for (int x = 0; x < viewPort.width; x+=pixelSize) {
			for (int y = 0; y < viewPort.height; y+=pixelSize) {
				c = viewPort.pixels[x+(y*viewPort.width)];
				System.out.println(c);
				displace = randomGenerator.nextGaussian()*noiseAmount*255;

				for(int xd = x; (xd < x + pixelSize) && (xd < viewPort.width); xd++) {
					for(int yd = y; (yd < y + pixelSize) && (yd < viewPort.height); yd++) {
						if(c<-1){
							c=-1;
						}
						viewPort.pixels[(xd)+((yd)*viewPort.width)] = c+(int)(displace);
					}
				}
			}
		}
		viewPort.updatePixels();
	}
}

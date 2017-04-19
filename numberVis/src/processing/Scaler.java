package processing;

import processing.core.PGraphics;

public class Scaler {

	
	Visualization parent;
	MemoryRandom memoryRandomGenerator;
	int[] PixelsArrayNew;
	double x_ratio;
	double y_ratio;
	double px, py;
	float scaleCounter;
	enum Dir {
		GROW, SHRINK
	}
	
	public Scaler(Visualization visualization){
		this.parent = visualization;
		memoryRandomGenerator  = new MemoryRandom();
	}
	
	
	public void constantScalePixels(double wRatio,double hRatio, PGraphics viewPort, float strength) {
		scaleCounter = scaleCounter + strength;
		viewPort.loadPixels();
		PixelsArrayNew = viewPort.pixels.clone();
		x_ratio = wRatio ;
		y_ratio = hRatio ;
		for (int i=0;i<viewPort.height;i++) {
			for (int j=0;j<viewPort.width;j++) {
				px = Math.floor(j%(wRatio*viewPort.width)/x_ratio) ;
				py = Math.floor(i%(hRatio*viewPort.height)/y_ratio) ;
				viewPort.pixels[(int)(i*viewPort.width)+j] = PixelsArrayNew[(int)((py*viewPort.width)+px)] ;
			}
		}
		viewPort.updatePixels();	
	}
	
	public void scalePixels(double wRatio,double hRatio, PGraphics viewPort) {
		viewPort.loadPixels();
		PixelsArrayNew = viewPort.pixels.clone();
		x_ratio = wRatio ;
		y_ratio = hRatio ;
		for (int i=0;i<viewPort.height;i++) {
			for (int j=0;j<viewPort.width;j++) {
				px = Math.floor(j%(wRatio*viewPort.width)/x_ratio) ;
				py = Math.floor(i%(hRatio*viewPort.height)/y_ratio) ;
				viewPort.pixels[(int)(i*viewPort.width)+j] = PixelsArrayNew[(int)((py*viewPort.width)+px)] ;
			}
		}
		viewPort.updatePixels();	
	}
	
	public void scalePixelsRandomly(PGraphics viewPort, float minX, float minY, float maxX, float maxY){	
		scalePixels(memoryRandomGenerator.getRandomFloat("1", Visualization.stopRandom)*(maxX-minX)+minX,memoryRandomGenerator.getRandomFloat("2", Visualization.stopRandom)*(maxY-minY)+minY,viewPort);
	}
	
	public void scalePixelsRandomlyEqual(PGraphics viewPort, float min, float max){	
		scalePixels(memoryRandomGenerator.getRandomFloat("1", Visualization.stopRandom)*(max-min)+min,memoryRandomGenerator.getRandomFloat("1", Visualization.stopRandom)*(max-min)+min,viewPort);
	}
	
}

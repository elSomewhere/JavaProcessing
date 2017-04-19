package processing;

import processing.core.PGraphics;

public class LineChart {
	Visualization parent;
	MemoryRandom memoryRandomGenerator;
	float[] numbersArray;
	
	public LineChart(Visualization visualization){
		this.parent = visualization;	
		memoryRandomGenerator = new MemoryRandom();
		numbersArray = new float[visualization.width];
	}
	
	public void randomWalk(PGraphics viewPort, float mean, float vol){
		numbersArray[0] = (memoryRandomGenerator.getRandomGaussian("init", Visualization.stopRandom))*vol+mean;
		float min = numbersArray[0];
		float max = numbersArray[0];
		for(int i = 1; i<viewPort.width; i++){
			numbersArray[i] = numbersArray[i-1]*(1+((memoryRandomGenerator.getRandomGaussian("i "+i, Visualization.stopRandom))*vol+mean)/100);		
			if(numbersArray[i]>max){
				max = numbersArray[i];
			}else if(numbersArray[i]<min){
				min = numbersArray[i];
			}
		}
		
		System.out.println("min is: " + min + "max is: " + max);
		
		viewPort.beginDraw();
		viewPort.background(0,0,0,0);
		viewPort.stroke(255);
		for(int i = 1; i<viewPort.width; i++){
			viewPort.line((float)(i-1), (numbersArray[i-1]-min)/(max-min)*viewPort.height,(float)i,(numbersArray[i]-min)/(max-min)*viewPort.height);
			System.out.println("i-1 is: "+ (numbersArray[i-1]) + "max-min is: " + (max-min) + " x1: " + (float)(i-1) + " y1: " + (numbersArray[i-1]-min)/(max-min)*viewPort.height + " x2: " + (float)i + " y2: " + (numbersArray[i]-min)/(max-min)*viewPort.height);
		
		}
		viewPort.endDraw();
	}
}

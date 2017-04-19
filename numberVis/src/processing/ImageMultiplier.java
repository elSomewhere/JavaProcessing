package processing;

import java.util.ArrayList;

import processing.core.PGraphics;
import processing.core.PImage;

public class ImageMultiplier {

	Visualization parent;
	MemoryRandom memoryRandomGenerator;
	PImage img;
	PGraphics canvas;

	
	int startX;
	int startY;
	int sizeX;
	int sizeY;
	int scaleX_min;
	int scaleX_max;
	int scaleY_min;
	int scaleY_max;
	
	public ImageMultiplier(Visualization visualization){
		this.parent = visualization;
		memoryRandomGenerator  = new MemoryRandom();
	}

	public void multiplySeveral(PGraphics viewPortDest, PGraphics[] viewPortsSource, int density){

		canvas = parent.createGraphics(viewPortDest.width, viewPortDest.height, NumbersLauncher.P3D);
		canvas.beginDraw();
		for(int i = 0; i < density; i++){		
			canvas.image(viewPortsSource[(int)(Math.ceil(memoryRandomGenerator.getRandomFloat("decider_"+i,Visualization.stopRandom) * viewPortsSource.length))], (int)(memoryRandomGenerator.getRandomFloat("numStage_"+i+"_1",Visualization.stopRandom)*viewPortDest.width*2-viewPortDest.width), (int)(memoryRandomGenerator.getRandomFloat("numStage_"+i+"_2",Visualization.stopRandom)*viewPortDest.height*2-viewPortDest.height),(int)(memoryRandomGenerator.getRandomFloat("numStage_"+i+"_3",Visualization.stopRandom)*viewPortDest.width), (int)(memoryRandomGenerator.getRandomFloat("numStage_"+i+"_4",Visualization.stopRandom)*viewPortDest.height));
		}
		canvas.endDraw();
		viewPortDest.beginDraw();
		viewPortDest.clear();
		viewPortDest.image(canvas,0,0);
		viewPortDest.endDraw();
	}

	
	
	
	public void multiplySame(PGraphics viewPort, int density){

		canvas = parent.createGraphics(viewPort.width, viewPort.height, NumbersLauncher.P3D);
		canvas.beginDraw();
		canvas.background(0, 0,0,0);
		for(int i = 0; i < density; i++){
			canvas.image(viewPort, (int)(memoryRandomGenerator.getRandomFloat("numStage_"+i+"_1",Visualization.stopRandom)*viewPort.width*2-viewPort.width), (int)(memoryRandomGenerator.getRandomFloat("numStage_"+i+"_2",Visualization.stopRandom)*viewPort.height*2-viewPort.height),(int)(memoryRandomGenerator.getRandomFloat("numStage_"+i+"_3",Visualization.stopRandom)*viewPort.width), (int)(memoryRandomGenerator.getRandomFloat("numStage_"+i+"_4",Visualization.stopRandom)*viewPort.height));
		}
		canvas.endDraw();
		viewPort.beginDraw();
		viewPort.clear();
		viewPort.image(canvas,0,0);
		viewPort.endDraw();
	}
	
	
	
	
	
	
	
	
	public void multiplySameFlex(PGraphics viewPort, int density,float scaleX_min_s, float scaleX_max_s, float scaleY_min_s, float scaleY_max_s){

		scaleX_min = (int)(scaleX_min_s * viewPort.width);
		scaleX_max = (int)(scaleX_max_s * viewPort.width);
		scaleY_min = (int)(scaleY_min_s * viewPort.height);
		scaleY_max = (int)(scaleY_max_s * viewPort.height);
		
		canvas = parent.createGraphics(viewPort.width, viewPort.height, NumbersLauncher.P3D);
		canvas.beginDraw();
		canvas.background(0, 0,0,0);
		for(int i = 0; i < density; i++){
			sizeX = (int)(memoryRandomGenerator.getRandomFloat("a"+i+"x",Visualization.stopRandom)*(scaleX_max-scaleX_min)+scaleX_min);
			sizeY = (int)(memoryRandomGenerator.getRandomFloat("a"+i+"y",Visualization.stopRandom)*(scaleY_max-scaleY_min)+scaleY_min);
			
			startX = (int)(memoryRandomGenerator.getRandomFloat("b"+i+"x",Visualization.stopRandom)*(viewPort.width+2*sizeX)-sizeX);
			startY = (int)(memoryRandomGenerator.getRandomFloat("b"+i+"y",Visualization.stopRandom)*(viewPort.height+2*sizeY)-sizeY);
			
			
			canvas.image(viewPort,startX, startY,sizeX, sizeY);
		}
		canvas.endDraw();
		viewPort.beginDraw();
		viewPort.clear();
		viewPort.image(canvas,0,0);
		viewPort.endDraw();
	}
	
	
	//equal scaling
	public void multiplySameFlexEqual(PGraphics viewPort, int density,float scale_min_s, float scale_max_s){

		scaleX_min = (int)(scale_min_s * viewPort.width);
		scaleX_max = (int)(scale_max_s * viewPort.width);
		scaleY_min = (int)(scale_min_s * viewPort.height);
		scaleY_max = (int)(scale_max_s * viewPort.height);
		
		canvas = parent.createGraphics(viewPort.width, viewPort.height, NumbersLauncher.P3D);
		canvas.beginDraw();
		for(int i = 0; i < density; i++){
			sizeX = (int)(memoryRandomGenerator.getRandomFloat("a"+i,Visualization.stopRandom)*(scaleX_max-scaleX_min)+scaleX_min);
			sizeY = (int)(memoryRandomGenerator.getRandomFloat("a"+i,Visualization.stopRandom)*(scaleY_max-scaleY_min)+scaleY_min);
			
			startX = (int)(memoryRandomGenerator.getRandomFloat("b"+i+"x",Visualization.stopRandom)*(viewPort.width+2*sizeX)-sizeX);
			startY = (int)(memoryRandomGenerator.getRandomFloat("b"+i+"y",Visualization.stopRandom)*(viewPort.height+2*sizeY)-sizeY);
			
			
			canvas.image(viewPort,startX, startY,sizeX, sizeY);
		}
		canvas.endDraw();
		viewPort.beginDraw();
		viewPort.clear();
		viewPort.image(canvas,0,0);
		viewPort.endDraw();
	}
	


}

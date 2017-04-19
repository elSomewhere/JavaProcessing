package processing;

import processing.core.PGraphics;
import processing.core.PImage;

public class BlockJuggler {

	Visualization parent;
	MemoryRandom memoryRandomGenerator;
	PImage img;
	
	int finalStartX;
	int finalStartY;
	int finalIterStepWidth;
	int finalIterStepHeight;
	int finalCopyStepWidth;
	int finalCopyStepHeight;
	int finalDisplaceX;
	int finalDisplaceY;
	int finalPasteStepWidth;
	int finalPasteStepHeight;
	
	public BlockJuggler(Visualization visualization){
		this.parent = visualization;
		memoryRandomGenerator  = new MemoryRandom();
	}
	
	public void blockJuggle(PGraphics viewPort, float startX, float startY, float iterSizeWidth, float iterSizeHeight, float copyStepWidth, float copyStepHeight, float displaceX, float displaceY, float pasteStepWidth, float pasteStepHeight){
		finalStartX = (int)(startX*viewPort.width);
		finalStartY = (int)(startY*viewPort.height);
		finalIterStepWidth = (int)(iterSizeWidth*viewPort.width);
		finalIterStepHeight = (int)(iterSizeWidth*viewPort.height);
		finalCopyStepWidth = (int)(copyStepWidth*viewPort.width);
		finalCopyStepHeight = (int)(copyStepHeight*viewPort.height);
		finalDisplaceX = (int)(displaceX*viewPort.width);
		finalDisplaceY = (int)(displaceY*viewPort.height);
		finalPasteStepWidth = (int)(pasteStepWidth*viewPort.width);
		finalPasteStepHeight = (int)(pasteStepHeight*viewPort.height);
		
		//necessary for per pixel image manipulation
		viewPort.loadPixels();	
		img = parent.createImage(viewPort.width, viewPort.height, NumbersLauncher.RGB);
		img.pixels = viewPort.pixels;
		img.updatePixels();
		viewPort.image(img,0,0);

		//per pixel image manipulation
		//the higher the step the higher prob that it wil be copied into nirvana
		for (int i = 0; i < img.width; i+=finalIterStepWidth) {
			for (int j = 0; j < img.height; j+=finalIterStepHeight) {
				viewPort.copy(img,finalStartX,finalStartY, finalCopyStepWidth, finalCopyStepHeight,finalDisplaceX,finalDisplaceY,finalPasteStepWidth,finalPasteStepHeight);
			}
		}
	}
	
	
public void blockJuggleStepRandomly(PGraphics viewPort,int stepX, int stepY){
		
		finalStartX = (int)(memoryRandomGenerator.getRandomFloat("1", Visualization.stopRandom)*stepX)+1;
		finalStartY = (int)(memoryRandomGenerator.getRandomFloat("2", Visualization.stopRandom)*stepY)+1;
		finalIterStepWidth = (int)(memoryRandomGenerator.getRandomFloat("3", Visualization.stopRandom)*stepX)+1;
		finalIterStepHeight = (int)(memoryRandomGenerator.getRandomFloat("4", Visualization.stopRandom)*stepY)+1;
		finalCopyStepWidth = (int)(memoryRandomGenerator.getRandomFloat("5", Visualization.stopRandom)*stepX)+1;
		finalCopyStepHeight = (int)(memoryRandomGenerator.getRandomFloat("6", Visualization.stopRandom)*stepY)+1;
		finalDisplaceX = (int)(memoryRandomGenerator.getRandomFloat("7", Visualization.stopRandom)*stepX)+1;
		finalDisplaceY = (int)(memoryRandomGenerator.getRandomFloat("8", Visualization.stopRandom)*stepY)+1;
		finalPasteStepWidth = (int)(memoryRandomGenerator.getRandomFloat("9", Visualization.stopRandom)*stepX)+1;
		finalPasteStepHeight = (int)(memoryRandomGenerator.getRandomFloat("10", Visualization.stopRandom)*stepY)+1;
		
		//per pixel image manipulation
		//the higher the step the higher prob that it wil be copied into nirvana
		viewPort.beginDraw();
		for (int i = 0; i < viewPort.width; i+=50) {
			for (int j = 0; j < viewPort.height; j+=50) {
				//viewPort.copy(finalStartX,finalStartY, finalCopyStepWidth, finalCopyStepHeight,finalDisplaceX,finalDisplaceY,finalPasteStepWidth,finalPasteStepHeight);
				viewPort.copy(i,j, i, j,i+200,j+200,100,100);
			}
		}
		viewPort.endDraw();
	}

	
	
	
	
public void blockJuggleAllRandomly(PGraphics viewPort){
	
		finalStartX = (int)(memoryRandomGenerator.getRandomFloat("1", Visualization.stopRandom)*viewPort.width);
		finalStartY = (int)(memoryRandomGenerator.getRandomFloat("2", Visualization.stopRandom)*viewPort.height);
		finalIterStepWidth = (int)(memoryRandomGenerator.getRandomFloat("3", Visualization.stopRandom)*viewPort.width);
		finalIterStepHeight = (int)(memoryRandomGenerator.getRandomFloat("4", Visualization.stopRandom)*viewPort.height);
		finalCopyStepWidth = (int)(memoryRandomGenerator.getRandomFloat("5", Visualization.stopRandom)*viewPort.width);
		finalCopyStepHeight = (int)(memoryRandomGenerator.getRandomFloat("6", Visualization.stopRandom)*viewPort.height);
		finalDisplaceX = (int)(memoryRandomGenerator.getRandomFloat("7", Visualization.stopRandom)*viewPort.width);
		finalDisplaceY = (int)(memoryRandomGenerator.getRandomFloat("8", Visualization.stopRandom)*viewPort.height);
		finalPasteStepWidth = (int)(memoryRandomGenerator.getRandomFloat("9", Visualization.stopRandom)*viewPort.width);
		finalPasteStepHeight = (int)(memoryRandomGenerator.getRandomFloat("10", Visualization.stopRandom)*viewPort.height);
		
		//necessary for per pixel image manipulation
		viewPort.loadPixels();	
		img = parent.createImage(viewPort.width, viewPort.height, NumbersLauncher.RGB);
		img.pixels = viewPort.pixels;
		img.updatePixels();
		viewPort.image(img,0,0);

		//per pixel image manipulation
		//the higher the step the higher prob that it wil be copied into nirvana
		for (int i = 0; i < img.width; i+=finalIterStepWidth) {
			for (int j = 0; j < img.height; j+=finalIterStepHeight) {
				viewPort.copy(img,finalStartX,finalStartY, finalCopyStepWidth, finalCopyStepHeight,finalDisplaceX,finalDisplaceY,finalPasteStepWidth,finalPasteStepHeight);
			}
		}
	}
	
}

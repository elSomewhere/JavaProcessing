package processing;

import processing.core.PApplet;
import processing.core.PGraphics;


//ideally works as follows:
//choose numbers - noise - lines
//choose 
public class NumbersCreatorMultiple {

	Visualization parent;
	int numX;
	int numY;
	int size;
	int[][] numbersArray;
	MemoryRandom memoryRandomGenerator;
	int posX;
	int posY;
	int stepX;
	int stepY;
	PGraphics[] windows; 
	
	public NumbersCreatorMultiple(Visualization visualization, int density, int size){
		this.parent = visualization;
		this.size = size;
		memoryRandomGenerator = new MemoryRandom();
		numX = visualization.width/size;
		numY = visualization.height/size;
		numbersArray = new int[numX][numY];
		for(int i = 0; i < numX; i++){
			for(int j = 0; j < numY; j++){
				numbersArray[i][j] = (int)(memoryRandomGenerator.getRandomFloat("init_"+(j*numY+i),Visualization.stopRandom)*10);
			}
		}
		windows = new PGraphics[density];
		for(int i = 0; i< windows.length; i++){
			windows[i] = parent.createGraphics(1, 1, NumbersLauncher.P3D);
		}
	}
	
	
	
	
	public void drawNumbersOnce(PGraphics viewPort){
		viewPort.beginDraw();
		viewPort.clear();
		for(int i = 0; i< windows.length; i++){
			
			//windows[i].setSize((int)(viewPort.width/(i+1)), (int)(viewPort.height/(i+1)));
			
			windows[i].setSize((int)(viewPort.width), (int)(viewPort.height));
			
			//windows[i] = parent.createGraphics((int)(viewPort.width*memoryRandomGenerator.getRandom(" i "+i,Visualization.stopRandom)), (int)(viewPort.height*memoryRandomGenerator.getRandom(" i "+i,Visualization.stopRandom)), NumbersLauncher.P3D);
			windows[i].beginDraw();
			windows[i].textMode(NumbersLauncher.MODEL);
			windows[i].textAlign(NumbersLauncher.LEFT,NumbersLauncher.TOP);
			windows[i].textSize(size);
			windows[i].background(0,0,0);
			posX = 0;
			posY = 0;	
			numX = windows[i].width/size;
			numY = windows[i].height/size;
			
			stepX = windows[i].width/(numX);
			stepY = windows[i].height/(numY);
			for(int j = 0; j < numY; j++){
				for(int k = 0; k < numX; k++){
					posX = k*stepX;
					posY = j*stepY;
					windows[i].fill(255,255,255);
					windows[i].text(numbersArray[k][j],posX,posY);
				}
			}
			windows[i].endDraw();	
			windows[i].setSize((int)(viewPort.width*memoryRandomGenerator.getRandomFloat(" i "+i,Visualization.stopRandom)), (int)(viewPort.height*memoryRandomGenerator.getRandomFloat(" i "+i,Visualization.stopRandom)));
			//viewPort.image(windows[i], 0, 0, windows[i].width, windows[i].height);
			
			viewPort.image(windows[i], (int)(memoryRandomGenerator.getRandomFloat("numStage_"+i+"_1",Visualization.stopRandom)*viewPort.width*2-viewPort.width), (int)(memoryRandomGenerator.getRandomFloat("numStage_"+i+"_2",Visualization.stopRandom)*viewPort.height*2-viewPort.height),windows[i].width, windows[i].height);
		}
		viewPort.endDraw();
	}
	
	
	

}

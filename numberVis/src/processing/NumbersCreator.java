package processing;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;

public class NumbersCreator {

	Visualization parent;
	int numX;
	int numY;
	int[][] numbersArray;
	MemoryRandom memoryRandomGenerator;
	int posX;
	int posY;
	float stepX;
	float stepY;

	int textSize;
	PFont font;

	public NumbersCreator(Visualization visualization){
		this.textSize = 20;
		this.parent = visualization;
		this.numX = visualization.width;
		this.numY = visualization.height;
		font = parent.createFont("Helvetica", 32);
		memoryRandomGenerator = new MemoryRandom();
		numbersArray = new int[numX][numY];
		for(int i = 0; i < numX; i++){
			for(int j = 0; j < numY; j++){
				numbersArray[i][j] = (int)(memoryRandomGenerator.getRandomFloat("init_"+(j*numY+i),Visualization.stopRandom)*10);
			}
		}
	}

	public void drawNumbers(PGraphics viewPort){
		viewPort.textMode(NumbersLauncher.SHAPE);
		viewPort.textAlign(NumbersLauncher.LEFT,NumbersLauncher.TOP);
		viewPort.textSize(26);
		viewPort.beginDraw();
		for(int i = 0; i < numX; i++){
			for(int j = 0; j < numY; j++){
				numbersArray[i][j] = (int)(memoryRandomGenerator.getRandomFloat("getNumber_"+j*numY+i,Visualization.stopRandom)*10);
			}
		}
		if(Visualization.transparentNumbers){
			viewPort.background(0,0,0,0);
		}else{
			viewPort.background(0,0,0,255);
		}

		posX = 0;
		posY = 0;

		stepX = viewPort.width/numX;
		stepY = viewPort.height/numY;
		for(int i = 0; i < numY; i++){
			for(int j = 0; j < numX; j++){
				posX = (int)(j*stepX);
				posY = (int)(i*stepY);
				viewPort.fill(255,255,255);
				viewPort.text(numbersArray[j][i],posX,posY);
			}
		}
		viewPort.endDraw();
	}



	public void drawNumbersOnce(PGraphics viewPort){
		viewPort.textMode(NumbersLauncher.MODEL);
		viewPort.textAlign(NumbersLauncher.CENTER,NumbersLauncher.CENTER);
		viewPort.textSize(textSize);
		viewPort.beginDraw();
		if(Visualization.transparentNumbers){
			viewPort.background(0,0,0,0);
		}else{
			viewPort.background(0,0,0,255);
		}



		posX = 0;
		posY = 0;

		stepX = viewPort.width/numX;
		stepY = viewPort.height/numY;
		for(int i = 0; i < numY; i++){
			for(int j = 0; j < numX; j++){
				posX = (int)(j*stepX);
				posY = (int)(i*stepY);
				viewPort.fill(255,255,255);
				viewPort.text(numbersArray[j][i],posX,posY);
			}
		}
		viewPort.endDraw();
	}

	public void drawNumbersOnceFromIn(PGraphics viewPort,float thicknessX, float thicknessY, int numX, int numY,float density){

		int finalThicknessX = 2*(int)(thicknessX*(numX/2));
		int finalThicknessY = 2*(int)(thicknessY*(numY/2));

		viewPort.textMode(NumbersLauncher.MODEL);
		viewPort.textAlign(NumbersLauncher.CENTER,NumbersLauncher.CENTER);
		viewPort.textFont(font);
		viewPort.textSize(textSize);
		viewPort.beginDraw();
		if(Visualization.transparentNumbers){
			viewPort.background(0,0,0,0);
		}else{
			viewPort.background(0,0,0,255);
		}

		posX = 0;
		posY = 0;

		stepX = (float)viewPort.width/numX;
		stepY = (float)viewPort.height/numY;

		//System.out.println("thicknessX: "+thicknessX + " thicknessY: " + thicknessY + " numX: "+numX + " numY: " + numY + " finalThicknessX:"+finalThicknessX+" finalThicknessY:"+finalThicknessY+" stepX"+stepX+" stepY"+stepY);

		//draw towards top
		for(int i = ((numY-finalThicknessY)/2); i < ((numY+finalThicknessY)/2); i++){
			for(int j = ((numX-finalThicknessX)/2); j < ((numX+finalThicknessX)/2); j++){
				//System.out.println("i is " + i + " and j is " + j + " and id is " + "i&jIn "+i+ " " + j +" and the value is "+memoryRandomGenerator.getRandomFloat("i&jIn"+i+ " " + j , Visualization.stopRandom) );
				if(memoryRandomGenerator.getRandomFloat("i&jIn"+i+ " " + j , Visualization.stopRandom)>(1f-density)){
					posX = (int)(j*stepX);
					posY = (int)(i*stepY);
					viewPort.fill(255,255,255);
					viewPort.text(numbersArray[j][i],posX,posY);
				}

			}
		}

		viewPort.endDraw();
	}


	public void drawNumbersOnceFromOut(PGraphics viewPort,float thicknessX, float thicknessY, int numX, int numY,float density){

		int finalThicknessX = (int)(thicknessX*(numX/2));
		int finalThicknessY = (int)(thicknessY*(numY/2));

		viewPort.textMode(NumbersLauncher.MODEL);
		viewPort.textAlign(NumbersLauncher.CENTER,NumbersLauncher.CENTER);
		viewPort.textFont(font);
		viewPort.textSize(textSize);
		viewPort.beginDraw();
		if(Visualization.transparentNumbers){
			viewPort.background(0,0,0,0);
		}else{
			viewPort.background(0,0,0,255);
		}

		posX = 0;
		posY = 0;

		stepX = (float)viewPort.width/numX;
		stepY = (float)viewPort.height/numY;

		//System.out.println("thicknessX: "+thicknessX + " thicknessY: " + thicknessY + " numX: "+numX + " numY: " + numY + " finalThicknessX:"+finalThicknessX+" finalThicknessY:"+finalThicknessY+" stepX: "+stepX+" stepY: "+stepY);


		//draw towards top
		for(int i = 1; i <= numY; i++){
			for(int j = 1; j <= numX; j++){
				//System.out.println("i is " + i + " and j is " + j + " and id is " + "i&jIn"+i+ " " + j);
				if(memoryRandomGenerator.getRandomFloat("i&jOut"+i+ " " + j , Visualization.stopRandom)>(1f-density)){
					if(
							(i<=finalThicknessY&&j>finalThicknessX&&j<=numX-finalThicknessX)|| //top row
							(i>numY-finalThicknessY&&j>finalThicknessX&&j<=numX-finalThicknessX)|| //bottom row
							(j<=finalThicknessX&&i>finalThicknessY&&i<=numY-finalThicknessY)|| //left row
							(j>numX-finalThicknessX&&i>finalThicknessY&&i<=numY-finalThicknessY)|| //right row

							(i<=finalThicknessY&&j<=finalThicknessX)|| //top left corner
							(i<=finalThicknessY&&j>numX-finalThicknessX)||//top right corner
							(i>numY-finalThicknessY&&j<=finalThicknessX)||//bottom left corner					
							(i>numY-finalThicknessY&&j>numX-finalThicknessX)//bottom right corner
							){
						posX = (int)((j-1)*stepX);
						posY = (int)((i-1)*stepY);

						viewPort.fill(255,255,255);
						viewPort.text(numbersArray[j][i],posX,posY);
					}
				}
			}
		}
		viewPort.endDraw();
	}
}

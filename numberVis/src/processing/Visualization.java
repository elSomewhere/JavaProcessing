package processing;

import java.util.Random;

import codeanticode.syphon.SyphonServer;
import controlP5.Controller;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PConstants;
import themidibus.MidiBus;

//missing: textsize bar
//visual start / stop button and and a button to always call next frame / before frame
// a recursive tunnel effect
//top - down - left - right shifter
//scaler with x and y  and optionla locked equal scaling
//Ideally a variant which switches beteen finak rendering and bein rendering
//flulscreen button

public class Visualization  extends PApplet{
	//meta rnadomizer
	Random metaRandomizer;
	//timer stuff
	static int timer;
	static int timerBeat;

	//global vars
	public static int w;
	public static int h;

	static int timeRate = 33;
	static int beat = 484; //ALVAS NOTO: 517 //124 BPM = 483.87

	//drawing canvas
	PGraphics canvas;

	//
	NumbersCreatorMultiple numbersCreatorMultiple;

	//numbers modules
	PGraphics numbers;
	NumbersCreator numbersCreator;
	Scaler numbersScaler;
	Shifter numbersShifter;	
	ImageMultiplier numbersImageMultiplier;
	RecursiveTunnel numbersRecursiveTunnel;
	NoiseMask numbersNoiseMask;
	BufferDrawer bufferDrawer;

	//noise modules
	PGraphics noise;
	NoiseCreator noiseCreator;
	Scaler noiseScaler;
	ImageMultiplier noiseImageMultiplier;
	RecursiveTunnel noiseRecursiveTunnel;


	//final modules
	Shifter finalShifter;
	BlockJuggler finalBlockJuggler;
	Scaler finalScaler;
	ImageMultiplier finalImageMultiplier;
	RecursiveTunnel finalRecursiveTunnel;

	LineGlitch finalLineGlitch;
	DiagonalGlitch finalDiagonalGlitch;
	SubtleSorting finalSubtleSort;
	ContrastBrightness finalContrastBrightness;

	LineChart lineChart;

	static boolean stopRandom = false;	
	static boolean stopAll = false;	
	static boolean equalMult = false;
	static boolean equalScale = false;
	static boolean fillNumbers = false;
	static boolean transparentNumbers = false;
	static boolean reverseTunnel = false;
	static boolean activateMultiplier = false;
	static boolean activateTunnel = false;
	static boolean activateScale = false;
	static boolean activateBuffer = false;
	static boolean transparentBuffer = false;

	static Decreaser decreaser;

	public void settings(){
		fullScreen(1);
		w = displayWidth;
		h = displayHeight;
		size(w,h,P3D);


	}

	public void setup(){
		//hint(ENABLE_DEPTH_SORT); //used for alpha depth sorting back
		metaRandomizer = new Random();
		decreaser = new Decreaser();

		timer = 0;
		timerBeat = 0;

		//numbers modules
		numbers = createGraphics(w/NumbersLauncher.resDiv, h/NumbersLauncher.resDiv, P3D);
		//((processing.opengl.PGraphicsOpenGL)numbers).textureSampling(POINT);

		numbersCreator = new NumbersCreator(this);
		numbersScaler = new Scaler(this);
		numbersShifter = new Shifter(this);
		numbersImageMultiplier = new ImageMultiplier(this);
		numbersRecursiveTunnel = new RecursiveTunnel(this);
		numbersCreatorMultiple = new NumbersCreatorMultiple(this, 10, 100);
		numbersNoiseMask = new NoiseMask(this);
		//		//noise modules
		//		noise = createGraphics(w, h, P3D);;
		//		noiseCreator = new NoiseCreator(this);
		//		noiseScaler = new Scaler(this);
		//		noiseImageMultiplier = new ImageMultiplier(this);
		//		noiseRecursiveTunnel = new RecursiveTunnel(this);

		lineChart = new LineChart(this);
		
		bufferDrawer = new BufferDrawer(this,1024,"Alva Noto - Uni dia (video- Jacopsen VJ).mp3");
		//bufferDrawer = new BufferDrawer(this,1024,"ryoji_ikeda-data_matrix.mp3");
		
		//final modules
		finalShifter = new Shifter(this);
		finalBlockJuggler = new BlockJuggler(this);
		finalScaler = new Scaler(this);
		finalImageMultiplier = new ImageMultiplier(this);
		finalRecursiveTunnel = new RecursiveTunnel(this);

		finalLineGlitch = new LineGlitch(this);
		finalDiagonalGlitch = new DiagonalGlitch(this);
		finalSubtleSort = new SubtleSorting(this);
		finalContrastBrightness = new ContrastBrightness(this);

		String[] fontList = PFont.list();
		printArray(fontList);

		metaRandomizer = new Random();

	}


	public void chain(){

		background(0,0,0);	
		
		//numbers creator
		numbersCreator.numX = (int)(NumbersLauncher.numX_temp);
		numbersCreator.numY = (int)(NumbersLauncher.numY_temp);
		numbersCreator.textSize = (int)(NumbersLauncher.textSize_temp);
		if(fillNumbers){
			numbersCreator.drawNumbersOnceFromIn(numbers,((NumbersLauncher.drawNumbersThicknessX_max-NumbersLauncher.drawNumbersThicknessX_min) * NumbersLauncher.drawNumbersThicknessX_temp+NumbersLauncher.drawNumbersThicknessX_min),((NumbersLauncher.drawNumbersThicknessY_max-NumbersLauncher.drawNumbersThicknessY_min) * NumbersLauncher.drawNumbersThicknessY_temp+NumbersLauncher.drawNumbersThicknessY_min),(int)(NumbersLauncher.numX_temp),(int)(NumbersLauncher.numY_temp),NumbersLauncher.numDensity_temp);
		}else{
			numbersCreator.drawNumbersOnceFromOut(numbers,((NumbersLauncher.drawNumbersThicknessX_max-NumbersLauncher.drawNumbersThicknessX_min) * NumbersLauncher.drawNumbersThicknessX_temp+NumbersLauncher.drawNumbersThicknessX_min),((NumbersLauncher.drawNumbersThicknessY_max-NumbersLauncher.drawNumbersThicknessY_min) * NumbersLauncher.drawNumbersThicknessY_temp+NumbersLauncher.drawNumbersThicknessY_min),(int)(NumbersLauncher.numX_temp),(int)(NumbersLauncher.numY_temp),NumbersLauncher.numDensity_temp);
			}
		
		//bufferDrawer.drawBufferXY(numbers, 1024, BufferDrawer.Phase.POS, BufferDrawer.Channel.MIX);
		
		//lineChart.randomWalk(numbers,0,1);

		//numbersNoiseMask.drawLargeNoise(numbers, (int)(50*NumbersLauncher.shiftIncrementX_temp), (int)(50*NumbersLauncher.shiftIncrementX_temp));

		if(activateMultiplier){
			if(!equalMult){
				numbersImageMultiplier.multiplySameFlex(numbers, (int)((NumbersLauncher.mult_max-NumbersLauncher.mult_min) * NumbersLauncher.mult_temp+NumbersLauncher.mult_min), NumbersLauncher.multScaleXMin_temp, NumbersLauncher.multScaleXMax_temp, NumbersLauncher.multScaleYMin_temp, NumbersLauncher.multScaleYMax_temp);
			}else{
				numbersImageMultiplier.multiplySameFlexEqual(numbers, (int)((NumbersLauncher.mult_max-NumbersLauncher.mult_min) * NumbersLauncher.mult_temp+NumbersLauncher.mult_min), NumbersLauncher.multScaleXMin_temp, NumbersLauncher.multScaleXMax_temp);
			}
		}



		

		if(activateScale){
			if(!equalScale){
				numbersScaler.scalePixelsRandomly(numbers, NumbersLauncher.randomScaleXMin_temp, NumbersLauncher.randomScaleXMax_temp,NumbersLauncher.randomScaleYMin_temp, NumbersLauncher.randomScaleYMax_temp);
			}else{
				numbersScaler.scalePixelsRandomlyEqual(numbers, NumbersLauncher.randomScaleXMin_temp, NumbersLauncher.randomScaleXMax_temp);
			}
		}
	
		
		
		
		finalScaler.scalePixels(NumbersLauncher.scaleIncrementX_temp,NumbersLauncher.scaleIncrementY_temp,numbers);
		finalShifter.shift((int)(NumbersLauncher.shiftIncrementX_temp*w),(int)(NumbersLauncher.shiftIncrementY_temp*h), numbers);

		if(activateBuffer){
			if(transparentBuffer){
				bufferDrawer.drawBufferMaskTransparentX(numbers, 1024, BufferDrawer.Phase.POS, BufferDrawer.Channel.MIX);
			}else{
				bufferDrawer.drawBufferMaskX(numbers, 1024, BufferDrawer.Phase.POS, BufferDrawer.Channel.MIX);
			}
			
		}
		

		if(activateTunnel){
			if(!reverseTunnel){
				//numbersRecursiveTunnel.recursiveTunnelReverse3D(numbers, (NumbersLauncher.tunnelStep_min+NumbersLauncher.tunnelStep_temp*(NumbersLauncher.tunnelStep_max-NumbersLauncher.tunnelStep_min)), (NumbersLauncher.tunnelHorizon_min+NumbersLauncher.tunnelHorizon_temp*(NumbersLauncher.tunnelHorizon_max-NumbersLauncher.tunnelHorizon_min)),(NumbersLauncher.tunnelExpansion_min+NumbersLauncher.tunnelExpansion_temp*(NumbersLauncher.tunnelExpansion_max-NumbersLauncher.tunnelExpansion_min)));
				numbersRecursiveTunnel.recursiveTunnel(numbers, (NumbersLauncher.tunnelStep_min+NumbersLauncher.tunnelStep_temp*(NumbersLauncher.tunnelStep_max-NumbersLauncher.tunnelStep_min)), (NumbersLauncher.tunnelHorizon_min+NumbersLauncher.tunnelHorizon_temp*(NumbersLauncher.tunnelHorizon_max-NumbersLauncher.tunnelHorizon_min)),(NumbersLauncher.tunnelExpansion_min+NumbersLauncher.tunnelExpansion_temp*(NumbersLauncher.tunnelExpansion_max-NumbersLauncher.tunnelExpansion_min)));
			}else{
				//numbersRecursiveTunnel.recursiveTunnel(numbers, (NumbersLauncher.tunnelStep_min+NumbersLauncher.tunnelStep_temp*(NumbersLauncher.tunnelStep_max-NumbersLauncher.tunnelStep_min)), (NumbersLauncher.tunnelHorizon_min+NumbersLauncher.tunnelHorizon_temp*(NumbersLauncher.tunnelHorizon_max-NumbersLauncher.tunnelHorizon_min)),(NumbersLauncher.tunnelExpansion_min+NumbersLauncher.tunnelExpansion_temp*(NumbersLauncher.tunnelExpansion_max-NumbersLauncher.tunnelExpansion_min)));
				numbersRecursiveTunnel.recursiveTunnelReverse(numbers, (NumbersLauncher.tunnelStep_min+NumbersLauncher.tunnelStep_temp*(NumbersLauncher.tunnelStep_max-NumbersLauncher.tunnelStep_min)), (NumbersLauncher.tunnelHorizon_min+NumbersLauncher.tunnelHorizon_temp*(NumbersLauncher.tunnelHorizon_max-NumbersLauncher.tunnelHorizon_min)),(NumbersLauncher.tunnelExpansion_min+NumbersLauncher.tunnelExpansion_temp*(NumbersLauncher.tunnelExpansion_max-NumbersLauncher.tunnelExpansion_min)));

			}
		}




	}

	public void draw(){
		if (millis() - timer >= timeRate) {
			System.out.println(stopAll);
			if (millis() - timerBeat >= beat) {
				if(!stopAll){
					stopRandom = false;
					randomizeMetaParameters();
					resetDecreasorParameters();
					timerBeat = millis();
				}	
			}
			chain();
			stopRandom = true;
			if(!stopAll){
				decreaseMetaParameters();
			}

			image(numbers,0,0,w,h);



			timer = millis();
		}

	}





	public void resetDecreasorParameters(){
		decreaser.initDecreaser(Interface.c1.getController("slider_1"));
		decreaser.initDecreaser(Interface.c2.getController("slider_2"));
		decreaser.initDecreaser(Interface.c3.getController("slider_3"));
		decreaser.initDecreaser(Interface.c4.getController("slider_4"));
		decreaser.initDecreaser(Interface.c5.getController("slider_5"));
		decreaser.initDecreaser(Interface.c6.getController("slider_6"));
		decreaser.initDecreaser(Interface.c7.getController("slider_7"));
		decreaser.initDecreaser(Interface.c16.getController("slider_16"));
		decreaser.initDecreaser(Interface.c17.getController("slider_17"));
		decreaser.initDecreaser(Interface.c23.getController("slider_23"));
		decreaser.initDecreaser(Interface.c24.getController("slider_24"));
		decreaser.initDecreaser(Interface.c25.getController("slider_25"));
		//Interface.c25.getController("slider_25").setValue(1.0f);
		decreaser.initDecreaser(Interface.c26.getController("slider_26"));
		decreaser.initDecreaser(Interface.c27.getController("slider_27"));
		decreaser.initDecreaser(Interface.c31.getController("slider_31"));

		decreaser.initDecreaser(Interface.c9.getController("slider_9"));
		decreaser.initDecreaser(Interface.c10.getController("slider_10"));
		decreaser.initDecreaser(Interface.c11.getController("slider_11"));

		decreaser.initDecreaser(Interface.c12.getController("slider_12"));
		decreaser.initDecreaser(Interface.c13.getController("slider_13"));
		decreaser.initDecreaser(Interface.c14.getController("slider_14"));
		decreaser.initDecreaser(Interface.c15.getController("slider_15"));
	};
	public void decreaseMetaParameters(){
		decreaser.decreaseParameters(Interface.c1.getController("slider_1"),1f);
		decreaser.decreaseParameters(Interface.c2.getController("slider_2"),1f);
		decreaser.decreaseParameters(Interface.c3.getController("slider_3"),1f);
		decreaser.decreaseParameters(Interface.c4.getController("slider_4"),0.2f);
		decreaser.decreaseParameters(Interface.c5.getController("slider_5"),0.2f);
		decreaser.decreaseParameters(Interface.c6.getController("slider_6"),0.3f);
		decreaser.decreaseParameters(Interface.c7.getController("slider_7"),0.3f);
		decreaser.decreaseParameters(Interface.c16.getController("slider_16"),1f);
		decreaser.decreaseParameters(Interface.c17.getController("slider_17"),1f);
		decreaser.decreaseParameters(Interface.c23.getController("slider_23"),1f);
		decreaser.decreaseParameters(Interface.c24.getController("slider_24"),1f);
		decreaser.decreaseParameters(Interface.c25.getController("slider_25"),1f);
		decreaser.decreaseParameters(Interface.c26.getController("slider_26"),1f);
		decreaser.decreaseParameters(Interface.c27.getController("slider_27"),1f);
		decreaser.decreaseParameters(Interface.c31.getController("slider_31"),1f);
		

		decreaser.decreaseParameters(Interface.c9.getController("slider_9"),1f);
		decreaser.decreaseParameters(Interface.c10.getController("slider_10"),1f);
		decreaser.decreaseParameters(Interface.c11.getController("slider_11"),1f);

		decreaser.decreaseParameters(Interface.c12.getController("slider_12"),1f);
		decreaser.decreaseParameters(Interface.c13.getController("slider_13"),1f);
		decreaser.decreaseParameters(Interface.c14.getController("slider_14"),1f);
		decreaser.decreaseParameters(Interface.c15.getController("slider_15"),1f);
		//Interface.c9.getController("slider_9").setValue(Interface.c9.getController("slider_9").getValue()-5f);
	}

	public void randomizeMetaParameters(){
		Interface.c1.getController("slider_1").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.mult_max-NumbersLauncher.mult_min)+NumbersLauncher.mult_min);
		Interface.c12.getController("slider_12").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.multScaleXMin_max-NumbersLauncher.multScaleXMin_min)+NumbersLauncher.multScaleXMin_min);
		Interface.c13.getController("slider_13").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.multScaleXMax_max-NumbersLauncher.multScaleXMax_min)+NumbersLauncher.multScaleXMax_min);
		Interface.c14.getController("slider_14").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.multScaleYMin_max-NumbersLauncher.multScaleYMin_min)+NumbersLauncher.multScaleYMin_min);
		Interface.c15.getController("slider_15").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.multScaleYMax_max-NumbersLauncher.multScaleYMax_min)+NumbersLauncher.multScaleYMax_min);
		Interface.c26.getController("slider_26").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.drawNumbersThicknessX_max-NumbersLauncher.drawNumbersThicknessX_min)+NumbersLauncher.drawNumbersThicknessX_min);
		Interface.c27.getController("slider_27").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.drawNumbersThicknessY_max-NumbersLauncher.drawNumbersThicknessY_min)+NumbersLauncher.drawNumbersThicknessY_min);
		Interface.c31.getController("slider_31").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.numDensity_max-NumbersLauncher.numDensity_min)+NumbersLauncher.numDensity_min);

		Interface.c2.getController("slider_2").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.tunnelStep_max-NumbersLauncher.tunnelStep_min)+NumbersLauncher.tunnelStep_min);
		Interface.c3.getController("slider_3").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.tunnelHorizon_max-NumbersLauncher.tunnelHorizon_min)+NumbersLauncher.tunnelHorizon_min);
		Interface.c25.getController("slider_25").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.tunnelExpansion_max-NumbersLauncher.tunnelExpansion_min)+NumbersLauncher.tunnelExpansion_min);

		Interface.c4.getController("slider_4").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.shiftIncrementX_max-NumbersLauncher.shiftIncrementX_min)+NumbersLauncher.shiftIncrementX_min);
		Interface.c5.getController("slider_5").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.shiftIncrementY_max-NumbersLauncher.shiftIncrementY_min)+NumbersLauncher.shiftIncrementY_min);


		Interface.c6.getController("slider_6").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.scaleIncrementX_max-NumbersLauncher.scaleIncrementX_min)+NumbersLauncher.scaleIncrementX_min);
		Interface.c7.getController("slider_7").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.scaleIncrementY_max-NumbersLauncher.scaleIncrementY_min)+NumbersLauncher.scaleIncrementY_min);


		Interface.c16.getController("slider_16").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.randomScaleXMin_max-NumbersLauncher.randomScaleXMin_min)+NumbersLauncher.randomScaleXMin_min);
		Interface.c17.getController("slider_17").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.randomScaleXMax_max-NumbersLauncher.randomScaleXMax_min)+NumbersLauncher.randomScaleXMax_min);
		Interface.c23.getController("slider_23").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.randomScaleYMin_max-NumbersLauncher.randomScaleYMin_min)+NumbersLauncher.randomScaleYMin_min);
		Interface.c24.getController("slider_24").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.randomScaleYMax_max-NumbersLauncher.randomScaleYMax_min)+NumbersLauncher.randomScaleYMax_min);


		Interface.c9.getController("slider_9").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.textSize_max-NumbersLauncher.textSize_min)+NumbersLauncher.textSize_min);
		Interface.c10.getController("slider_10").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.numX_max-NumbersLauncher.numX_min)+NumbersLauncher.numX_min);
		Interface.c11.getController("slider_11").setValue(metaRandomizer.nextFloat()*(NumbersLauncher.numY_max-NumbersLauncher.numY_min)+NumbersLauncher.numY_min);

		if(metaRandomizer.nextBoolean()){
			Interface.fillNumbersButton.setOn();
		}else{
			Interface.fillNumbersButton.setOff();
		}

		if(metaRandomizer.nextBoolean()){
			Interface.transparentNumbersButton.setOn();
		}else{
			Interface.transparentNumbersButton.setOff();
		}

		if(metaRandomizer.nextBoolean()){
			Interface.equalMultButton.setOn();
		}else{
			Interface.equalMultButton.setOff();
		}

		if(metaRandomizer.nextBoolean()){
			Interface.equalScaleButton.setOn();
		}else{
			Interface.equalScaleButton.setOff();
		}

		if(metaRandomizer.nextBoolean()){
			Interface.reverseTunnelButton.setOn();
		}else{
			Interface.reverseTunnelButton.setOff();
		}

		if(metaRandomizer.nextBoolean()){
			Interface.activateMultiplierButton.setOn();
		}else{
			Interface.activateMultiplierButton.setOff();
		}

		if(metaRandomizer.nextBoolean()){
			Interface.activateTunnelButton.setOn();
		}else{
			Interface.activateTunnelButton.setOff();
		}

		if(metaRandomizer.nextBoolean()){
			Interface.activateScaleButton.setOn();
		}else{
			Interface.activateScaleButton.setOff();
		}


	}

	public void keyPressed(){
		if (key == ' ') {
			stopRandom = !stopRandom;
		}
	}

}

package processing;

import controlP5.ControlEvent;
import controlP5.ControlP5;
import processing.core.PApplet;
import themidibus.MidiBus;

public class Interface extends PApplet{

	MidiBus myBus;

	public static ControlP5 c1;
	public static ControlP5 c2;
	public static ControlP5 c3;
	public static ControlP5 c4;
	public static ControlP5 c5;
	public static ControlP5 c6;
	public static ControlP5 c7;

	public static ControlP5 c8;
	public static controlP5.Button stopButton;

	public static ControlP5 c9;
	public static ControlP5 c10;
	public static ControlP5 c11;
	public static ControlP5 c12;
	public static ControlP5 c13;
	public static ControlP5 c14;
	public static ControlP5 c15;
	public static ControlP5 c16;
	public static ControlP5 c17;
	public static ControlP5 c23;
	public static ControlP5 c24;
	public static ControlP5 c25;
	public static ControlP5 c26;
	public static ControlP5 c27;
	public static ControlP5 c31;
	public static ControlP5 c32;


	public static ControlP5 c18;
	public static controlP5.Button equalMultButton;
	public static ControlP5 c19;
	public static controlP5.Button equalScaleButton;
	public static ControlP5 c20;
	public static controlP5.Button fillNumbersButton;
	public static ControlP5 c21;
	public static controlP5.Button transparentNumbersButton;
	public static ControlP5 c22;
	public static controlP5.Button reverseTunnelButton;
	public static ControlP5 c28;
	public static controlP5.Button activateMultiplierButton;
	public static ControlP5 c29;
	public static controlP5.Button activateTunnelButton;
	public static ControlP5 c30;
	public static controlP5.Button activateScaleButton;
	public static ControlP5 c33;
	public static controlP5.Button activateBufferButton;
	public static ControlP5 c34;
	public static controlP5.Button transparentBufferButton;

	float slider_1;
	float slider_2;
	float slider_3;
	float slider_4;
	float slider_5;
	float slider_6;
	float slider_7;
	float slider_9;
	float slider_10;
	float slider_11;
	float slider_12;
	float slider_13;
	float slider_14;
	float slider_15;
	float slider_16;
	float slider_17;
	float slider_23;
	float slider_24;
	float slider_25;
	float slider_26;
	float slider_27;
	float slider_31;
	float slider_32;

	public void settings(){
		size( 800, 800 ,P3D  );
	}

	public void setup(){
		myBus = new MidiBus(this, 0, -1);
		MidiBus.list();


		//textSize
		c9 = new ControlP5( this );
		c9.enableShortcuts();
		c9.addSlider("slider_9").setSize(180,20).setPosition( 20 , 20 ).setRange(NumbersLauncher.textSize_min, NumbersLauncher.textSize_max).setValue(NumbersLauncher.textSize_temp).setLabel("textSize");

		//textSize
		c10 = new ControlP5( this );
		c10.enableShortcuts();
		c10.addSlider("slider_10").setSize(180,20).setPosition( 20 , 40 ).setRange(NumbersLauncher.numX_min, NumbersLauncher.numX_max).setValue(NumbersLauncher.numX_temp).setLabel("numX");

		//textSize
		c11 = new ControlP5( this );
		c11.enableShortcuts();
		c11.addSlider("slider_11").setSize(180,20).setPosition( 20 , 60 ).setRange(NumbersLauncher.numY_min, NumbersLauncher.numY_max).setValue(NumbersLauncher.numY_temp).setLabel("numY");

		//drawNumbersThickness
		c26 = new ControlP5( this );
		c26.enableShortcuts();
		c26.addSlider("slider_26").setSize(180,20).setPosition( 20 , 80 ).setRange(NumbersLauncher.drawNumbersThicknessX_min, NumbersLauncher.drawNumbersThicknessX_max).setValue(NumbersLauncher.drawNumbersThicknessX_temp).setLabel("drawNumbersThicknessX");
		c27 = new ControlP5( this );
		c27.enableShortcuts();
		c27.addSlider("slider_27").setSize(180,20).setPosition( 20 , 100 ).setRange(NumbersLauncher.drawNumbersThicknessY_min, NumbersLauncher.drawNumbersThicknessY_max).setValue(NumbersLauncher.drawNumbersThicknessY_temp).setLabel("drawNumbersThicknessY");

		//textSize
		c31 = new ControlP5( this );
		c31.enableShortcuts();
		c31.addSlider("slider_31").setSize(180,20).setPosition( 20 , 120 ).setRange(NumbersLauncher.numDensity_min, NumbersLauncher.numDensity_max).setValue(NumbersLauncher.numDensity_temp).setLabel("numDensity");



		//multiplier density
		c1 = new ControlP5( this );
		c1.enableShortcuts();
		c1.addSlider("slider_1").setSize(180,20).setPosition( 20 , 160 ).setRange(NumbersLauncher.mult_min, NumbersLauncher.mult_max).setValue(NumbersLauncher.mult_temp).setLabel("Multiplier");
		//multiplier scaleX_min
		c12 = new ControlP5( this );
		c12.enableShortcuts();
		c12.addSlider("slider_12").setSize(180,20).setPosition( 20 , 180 ).setRange(NumbersLauncher.multScaleXMin_min, NumbersLauncher.multScaleXMin_max).setValue(NumbersLauncher.multScaleXMin_temp).setLabel("multScaleXMin");
		//multiplier scaleX_max
		c13 = new ControlP5( this );
		c13.enableShortcuts();
		c13.addSlider("slider_13").setSize(180,20).setPosition( 20 , 200 ).setRange(NumbersLauncher.multScaleXMax_min, NumbersLauncher.multScaleXMax_max).setValue(NumbersLauncher.multScaleXMax_temp).setLabel("multScaleXMax");
		//multiplier scaleY_min
		c14 = new ControlP5( this );
		c14.enableShortcuts();
		c14.addSlider("slider_14").setSize(180,20).setPosition( 20 , 220 ).setRange(NumbersLauncher.multScaleYMin_min, NumbersLauncher.multScaleYMin_max).setValue(NumbersLauncher.multScaleYMin_temp).setLabel("multScaleYMin");
		//multiplier scaleY_max
		c15 = new ControlP5( this );
		c15.enableShortcuts();
		c15.addSlider("slider_15").setSize(180,20).setPosition( 20 , 240 ).setRange(NumbersLauncher.multScaleYMax_min, NumbersLauncher.multScaleYMax_max).setValue(NumbersLauncher.multScaleYMax_temp).setLabel("multScaleYMax");


		//randomScaler x min
		c16 = new ControlP5( this );
		c16.enableShortcuts();
		c16.addSlider("slider_16").setSize(180,20).setPosition( 20 , 280 ).setRange(NumbersLauncher.randomScaleXMin_min, NumbersLauncher.randomScaleXMin_max).setValue(NumbersLauncher.randomScaleXMin_temp).setLabel("randomScaleXMin");
		//randomScaler x max
		c17 = new ControlP5( this );
		c17.enableShortcuts();
		c17.addSlider("slider_17").setSize(180,20).setPosition( 20 , 300 ).setRange(NumbersLauncher.randomScaleXMax_min, NumbersLauncher.randomScaleXMax_max).setValue(NumbersLauncher.randomScaleXMax_temp).setLabel("randomScaleXMax");
		//randomScaler y min
		c23 = new ControlP5( this );
		c23.enableShortcuts();
		c23.addSlider("slider_23").setSize(180,20).setPosition( 20 , 320 ).setRange(NumbersLauncher.randomScaleYMin_min, NumbersLauncher.randomScaleYMin_max).setValue(NumbersLauncher.randomScaleYMin_temp).setLabel("randomScaleYMin");
		//randomScaler y max
		c24 = new ControlP5( this );
		c24.enableShortcuts();
		c24.addSlider("slider_24").setSize(180,20).setPosition( 20 , 340 ).setRange(NumbersLauncher.randomScaleYMax_min, NumbersLauncher.randomScaleYMax_max).setValue(NumbersLauncher.randomScaleYMax_temp).setLabel("randomScaleYMax");



		//tunneler
		c2 = new ControlP5( this );
		c2.enableShortcuts();
		c2.addSlider("slider_2").setSize(180,20).setPosition( 20 , 380 ).setRange(NumbersLauncher.tunnelStep_min, NumbersLauncher.tunnelStep_max).setValue(NumbersLauncher.tunnelStep_temp).setLabel("Density");
		c3 = new ControlP5( this );
		c3.enableShortcuts();
		c3.addSlider("slider_3").setSize(180,20).setPosition( 20 , 400 ).setRange(NumbersLauncher.tunnelHorizon_min, NumbersLauncher.tunnelHorizon_max).setValue(NumbersLauncher.tunnelHorizon_temp).setLabel("Start");
		c25 = new ControlP5( this );
		c25.enableShortcuts();
		c25.addSlider("slider_25").setSize(180,20).setPosition( 20 , 420 ).setRange(NumbersLauncher.tunnelExpansion_min, NumbersLauncher.tunnelExpansion_max).setValue(NumbersLauncher.tunnelExpansion_temp).setLabel("Expansion");



		//Shifter x
		c4 = new ControlP5( this );
		c4.enableShortcuts();
		c4.addSlider("slider_4").setSize(180,20).setPosition( 20 , 460 ).setRange(NumbersLauncher.shiftIncrementX_min, NumbersLauncher.shiftIncrementX_max).setValue(NumbersLauncher.shiftIncrementX_temp).setLabel("Shifter x");
		//Shifter y
		c5 = new ControlP5( this );
		c5.enableShortcuts();
		c5.addSlider("slider_5").setSize(180,20).setPosition( 20 , 480 ).setRange(NumbersLauncher.shiftIncrementY_min, NumbersLauncher.shiftIncrementY_max).setValue(NumbersLauncher.shiftIncrementY_temp).setLabel("Shifter y");



		//scaler x
		c6 = new ControlP5( this );
		c6.enableShortcuts();
		c6.addSlider("slider_6").setSize(180,20).setPosition( 20 , 520 ).setRange(NumbersLauncher.scaleIncrementX_min, NumbersLauncher.scaleIncrementX_max).setValue(NumbersLauncher.scaleIncrementX_temp).setLabel("Scaler x");
		//scaler y
		c7 = new ControlP5( this );
		c7.enableShortcuts();
		c7.addSlider("slider_7").setSize(180,20).setPosition( 20 , 540 ).setRange(NumbersLauncher.scaleIncrementY_min, NumbersLauncher.scaleIncrementY_max).setValue(NumbersLauncher.scaleIncrementY_temp).setLabel("Scaler y");


		//scaler y
		c32 = new ControlP5( this );
		c32.enableShortcuts();
		c32.addSlider("slider_32").setSize(180,20).setPosition( 400 , 540 ).setRange(NumbersLauncher.bufferAmp_min, NumbersLauncher.bufferAmp_max).setValue(NumbersLauncher.bufferAmp_temp).setLabel("bufferAmp");



		c8 = new ControlP5(this);
		stopButton = c8.addButton("stop").setPosition( 20 , 580 ).setLabel("stop").setSize(240,60);
		stopButton.setSwitch(true);

		c18 = new ControlP5(this);
		equalMultButton = c18.addButton("equalMult").setPosition( 400 , 180 ).setLabel("equalMult");
		equalMultButton.setSwitch(true);

		c19 = new ControlP5(this);
		equalScaleButton = c19.addButton("equalScale").setPosition( 400 , 280 ).setLabel("equalScale");
		equalScaleButton.setSwitch(true);

		c20 = new ControlP5(this);
		fillNumbersButton = c20.addButton("fillNumbers").setPosition( 400 , 20 ).setLabel("fillNumbers");
		fillNumbersButton.setSwitch(true);

		c21 = new ControlP5(this);
		transparentNumbersButton = c21.addButton("transparentNumbers").setPosition( 400 , 40 ).setLabel("transparentNumbers");
		transparentNumbersButton.setSwitch(true);

		c22 = new ControlP5(this);
		reverseTunnelButton = c22.addButton("reverseTunnel").setPosition( 400 , 400 ).setLabel("reverseTunnel");
		reverseTunnelButton.setSwitch(true);

		c28 = new ControlP5(this);
		activateMultiplierButton = c28.addButton("activateMultiplier").setPosition( 400 , 160 ).setLabel("activateMultiplier");
		activateMultiplierButton.setSwitch(true);

		c29 = new ControlP5(this);
		activateTunnelButton = c29.addButton("activateTunnel").setPosition( 400 , 380 ).setLabel("activateTunnel");
		activateTunnelButton.setSwitch(true);

		c30 = new ControlP5(this);
		activateScaleButton = c30.addButton("activateScale").setPosition( 400 , 280 ).setLabel("activateScale");
		activateScaleButton.setSwitch(true);

		c33 = new ControlP5(this);
		activateBufferButton = c33.addButton("activateBuffer").setPosition( 500 , 280 ).setLabel("activateBuffer");
		activateBufferButton.setSwitch(true);

		c34 = new ControlP5(this);
		transparentBufferButton = c30.addButton("transparentBuffer").setPosition( 500 , 300 ).setLabel("transparentBuffer");
		transparentBufferButton.setSwitch(true);



	}


	public void draw(){
		NumbersLauncher.mult_temp = slider_1;
		NumbersLauncher.tunnelStep_temp = slider_2;
		NumbersLauncher.tunnelHorizon_temp = slider_3;
		NumbersLauncher.tunnelExpansion_temp = slider_25;
		NumbersLauncher.shiftIncrementX_temp = slider_4;
		NumbersLauncher.shiftIncrementY_temp = slider_5;
		NumbersLauncher.scaleIncrementX_temp = slider_6;
		NumbersLauncher.scaleIncrementY_temp = slider_7;	
		NumbersLauncher.textSize_temp = slider_9;
		NumbersLauncher.numX_temp = slider_10;
		NumbersLauncher.numY_temp = slider_11;
		NumbersLauncher.multScaleXMin_temp = slider_12;
		NumbersLauncher.multScaleXMax_temp = slider_13;
		NumbersLauncher.multScaleYMin_temp = slider_14;
		NumbersLauncher.multScaleYMax_temp = slider_15;
		NumbersLauncher.randomScaleXMin_temp = slider_16;
		NumbersLauncher.randomScaleXMax_temp = slider_17;
		NumbersLauncher.randomScaleYMin_temp = slider_23;
		NumbersLauncher.randomScaleYMax_temp = slider_24;
		NumbersLauncher.drawNumbersThicknessX_temp = slider_26;
		NumbersLauncher.drawNumbersThicknessY_temp = slider_27;
		NumbersLauncher.numDensity_temp = slider_31;
		NumbersLauncher.bufferAmp_temp = slider_32;

		background(100);
	}

	public void noteOn(int channel, int pitch, int velocity) {
		// Receive a noteOn
		println();
		println("Note On:");
		println("--------");
		println("Channel:"+channel);
		println("Pitch:"+pitch);
		println("Velocity:"+velocity);
	}

	public void controlEvent(ControlEvent theEvent) {
		switch(theEvent.getController().getName()) {
		case("stop"):
			Visualization.stopAll = stopButton.getBooleanValue();
		case("equalMult"):
			Visualization.equalMult = equalMultButton.getBooleanValue();
		case("equalScale"):
			Visualization.equalScale = equalScaleButton.getBooleanValue();
		case("fillNumbers"):
			Visualization.fillNumbers = fillNumbersButton.getBooleanValue();
		case("transparentNumbers"):
			Visualization.transparentNumbers = transparentNumbersButton.getBooleanValue();
		case("reverseTunnel"):
			Visualization.reverseTunnel = reverseTunnelButton.getBooleanValue();
		case("activateMultiplier"):
			Visualization.activateMultiplier = activateMultiplierButton.getBooleanValue();
		case("activateTunnel"):
			Visualization.activateTunnel = activateTunnelButton.getBooleanValue();
		case("activateScale"):
			Visualization.activateScale = activateScaleButton.getBooleanValue();
		case("activateBuffer"):
			Visualization.activateBuffer = activateBufferButton.getBooleanValue();
		case("transparentBuffer"):
			Visualization.transparentBuffer = transparentBufferButton.getBooleanValue();
		};
	};
}

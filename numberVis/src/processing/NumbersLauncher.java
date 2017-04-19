package processing;

import java.util.Random;

import codeanticode.syphon.SyphonServer;
import controlP5.ControlP5;
import g4p_controls.GCustomSlider;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import themidibus.MidiBus;

public class NumbersLauncher extends PApplet{

	//resolution divider
	public static int resDiv = 4;
	
	//global vars controlled by interface

	//textSize
	public static float textSize_min = 5f;
	public static float textSize_max = 20f;
	public static float textSize_temp = 10f;

	//numX
	public static float numX_min = 5f;
	public static float numX_max = 200f;
	public static float numX_temp = 50f;

	//numY
	public static float numY_min = 5f;
	public static float numY_max = 200f;
	public static float numY_temp = 50f;

	//numDensity
	public static float numDensity_min = 0f;
	public static float numDensity_max = 1;
	public static float numDensity_temp = 0.5f;


	//multiplier
	public static float drawNumbersThicknessX_min = 0.00f;
	public static float drawNumbersThicknessX_max = 1f;
	public static float drawNumbersThicknessX_temp = 0.75f;

	//multiplier
	public static float drawNumbersThicknessY_min = 0.00f;
	public static float drawNumbersThicknessY_max = 1f;
	public static float drawNumbersThicknessY_temp = 0.75f;

	//multiplier
	public static float mult_min = 0.01f;
	public static float mult_max = 10f;
	public static float mult_temp = 0.75f;
	//
	public static float multScaleXMin_min = 0.01f;
	public static float multScaleXMin_max = 2f;
	public static float multScaleXMin_temp = 1.0f;
	//
	public static float multScaleXMax_min = 0.01f;
	public static float multScaleXMax_max = 2f;
	public static float multScaleXMax_temp = 1.0f;
	//
	public static float multScaleYMin_min = 0.01f;
	public static float multScaleYMin_max = 2f;
	public static float multScaleYMin_temp = 1.0f;
	//
	public static float multScaleYMax_min = 0.01f;
	public static float multScaleYMax_max = 2f;
	public static float multScaleYMax_temp = 1.0f;

	//Tunneler
	public static float tunnelStep_min = 0.00f;
	public static float tunnelStep_max = 1f;
	public static float tunnelStep_temp = 0.02f;
	//
	public static float tunnelHorizon_min = 0.00f;
	public static float tunnelHorizon_max = 1f;
	public static float tunnelHorizon_temp = 0.02f;
	//
	public static float tunnelExpansion_min = 0.00f;
	public static float tunnelExpansion_max = 1f;
	public static float tunnelExpansion_temp = 0.02f;

	//finalShifter
	public static float shiftIncrementX_min = 0.1f;
	public static float shiftIncrementX_max = 1f;
	public static float shiftIncrementX_temp = 0.05f;
	//
	public static float shiftIncrementY_min = 0.1f;
	public static float shiftIncrementY_max = 1f;
	public static float shiftIncrementY_temp = 0.05f;

	//finalScaler
	public static float scaleIncrementX_min = 0.0f;
	public static float scaleIncrementX_max = 2.0f;
	public static float scaleIncrementX_temp = 0.5f;
	//
	public static float scaleIncrementY_min = 0.0f;
	public static float scaleIncrementY_max = 2.0f;
	public static float scaleIncrementY_temp = 0.5f;

	//randomScaleer
	public static float randomScaleXMin_min = 0.0f;
	public static float randomScaleXMin_max = 2.0f;
	public static float randomScaleXMin_temp = 0.5f;
	//
	public static float randomScaleXMax_min = 0.0f;
	public static float randomScaleXMax_max = 2.0f;
	public static float randomScaleXMax_temp = 1f;
	//
	public static float randomScaleYMin_min = 0.0f;
	public static float randomScaleYMin_max = 2.0f;
	public static float randomScaleYMin_temp = 0.5f;
	//
	public static float randomScaleYMax_min = 0.0f;
	public static float randomScaleYMax_max = 2.0f;
	public static float randomScaleYMax_temp = 1f;

	//bufferAmp
	public static float bufferAmp_min = 0.0f;
	public static float bufferAmp_max = 10.0f;
	public static float bufferAmp_temp = 1f;

	public static boolean stopRandom = false;




	public static void main(String... args){
		PApplet.main("processing.Visualization");
		PApplet.main("processing.Interface");
		System.out.println("now running");
	}
}

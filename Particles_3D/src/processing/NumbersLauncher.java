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
	public static int resDiv = 4;
	
	public static void main(String... args){
		PApplet.main("processing.Visualization");
		PApplet.main("processing.Interface");
		System.out.println("now running");
	}
}

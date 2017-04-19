package processing;

import controlP5.ControlEvent;
import controlP5.ControlP5;
import processing.core.PApplet;
import themidibus.MidiBus;

public class Interface extends PApplet{

	public void settings(){
		size( 800, 800 ,P3D  );
	}

	public void setup(){
	
	}


	public void draw(){
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
		
	};
}

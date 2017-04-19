package processing;


import java.util.Random;


import processing.core.PApplet;

import processing.core.PGraphics;


public class Visualization  extends PApplet{
	//meta rnadomizer
	Random metaRandomizer;
	public static Random randomGen = new Random();
	//timer stuff
	static int timer;
	static int timerBeat;

	//global vars
	public static int w0 = 0;
	public static int w1;
	public static int h0 = 0;
	public static int h1;
	public static int z0 = 0;
	public static int z1 = -200;

	

	static int timeRate = 33;
	static int beat = 484; //ALVAS NOTO: 517 //124 BPM = 483.87

	//drawing canvas
	PGraphics canvas;

	//numbers modules
	PGraphics numbers;

	int count = 50000;
	int neg = 0;
	int pos = 1;
	int neutral = 2;
	Particle[] p = new Particle[count];

	public void settings(){
		fullScreen(1);
		size(displayWidth,displayHeight,P3D);
		w1 = displayWidth;
		h1 = displayHeight;

	}

	public void setup(){
		//hint(ENABLE_DEPTH_SORT); //used for alpha depth sorting back


		metaRandomizer = new Random();

		timer = 0;
		timerBeat = 0;

		
		metaRandomizer = new Random();

		for(int i = 0; i < count; i++)
		{
			p[i] = new Particle(this.g);
		}

	}


	public void chain(){
		
		background(255);
		stroke(0,0,0,50);

		

		p[count-1].px = randomGen.nextFloat()*p[count-1].sx;
		p[count-1].py = randomGen.nextFloat()*p[count-1].sy;
		p[count-1].pz = randomGen.nextFloat()*p[count-1].sz;

		p[count-1].vx = 0;
		p[count-1].vy = 0;
		p[count-1].vz = 0;
		p[count-1].force = 2000;

		//beginShape(POINTS);
		for (int i = 0; i < count; i++)
		{
			p[i].interact(p[count-1]);
			p[i].update();  

			//vertex(p[i].px, p[i].py, p[i].pz);
			fill(0, 0, 0,50);
			textSize(8);
			text("1",p[i].px, p[i].py,p[i].pz);
			//System.out.println("px is "+p[i].px+" and py is "+ p[i].py + " and pz is " + p[i].pz);
		}
		//endShape();

	}

	public void draw(){

		//System.out.println("bla");

		if (millis() - timer >= timeRate) {
			chain();
			if (millis() - timerBeat >= beat) {

			}
			
			//System.out.println((height/2.0) / tan((float) ((PI/3.0)/2.0)));
			timer = millis();
		}

	}
	
	
	public void mousePressed() {
		  p[count-1].px = mouseX;
		  p[count-1].py = mouseY;
		  
		  p[count-1].vx = 0;
		  p[count-1].vy = 0;
		  p[count-1].force = 5000;
		  print("mouseoressed");
		}



}

package processing;

import java.util.Random;

import processing.core.PGraphics;

public class Particle {
	public static Random randomGen = new Random();

	//screensize
	public int sx;
	public int sy;
	public int sz;

	//position
	public float px, py, pz;
	//velocity
	public float vx, vy, vz;


	public float force;



	public PGraphics parent;

	public Particle(PGraphics parent){
		this.parent = parent;
		sx = Visualization.w1-Visualization.w0;
		sy = Visualization.h1-Visualization.h0;
		sz = Visualization.z1-Visualization.z0;
		px = randomGen.nextFloat()*sx;
		py = randomGen.nextFloat()*sy;
		pz = randomGen.nextFloat()*sz;
		vx = randomGen.nextFloat()*8-4;
		vy = randomGen.nextFloat()*8-4; 
		vz = randomGen.nextFloat()*8-4; 
//		vx = 0;
//		vy = 0; 
//		vz = 0; 
		force = .1f;  
	}

	public void interact(Particle p)
	{
		float dis;
		float fx;
		float fy;
		float fz;
		float f;

		//distance
		dis = (p.px - px)*(p.px - px) + (p.py - py)*(p.py - py) + (p.pz - pz)*(p.pz - pz);

		//temp force, small if distance high
		f = (force + p.force) / (dis);

		if(f > 2000)
		{  
			f = 2000;
		}

		//force in x y direction depends on distance to other particle
		fx = f * (p.px - px);
		fy = f * (p.py - py);
		fz = f * (p.pz - pz);

		//the higher the distance, the lower the velocity increase the force
		vx += fx;
		vy += fy;
		vz += fz;
	}

	public void update()
	{
		
		px += vx;
		py += vy;
		pz += vz;

		if(px < Visualization.w0)
		{
			px = Visualization.w0;
			vx = 0;
			vy += randomGen.nextFloat()-2;
			vz += randomGen.nextFloat()-2; 
		}
		else if(px > Visualization.w1)
		{
			px = Visualization.w1;
			vx = 0;
			vy += randomGen.nextFloat()-2;
			vz += randomGen.nextFloat()-2;
		}

		if(py < Visualization.h0)
		{
			py = Visualization.h0;
			vy = 0;
			vx += randomGen.nextFloat()-2;
			vz += randomGen.nextFloat()-2; 
		}
		else if(py > Visualization.h1)
		{
			py = Visualization.h1;
			vy = 0;
			vx += randomGen.nextFloat()-2;
			vz += randomGen.nextFloat()-2;
		}
		
		if(pz > Visualization.z0)
		{
			pz = Visualization.z0;
			vz = 0;
			vx += randomGen.nextFloat()-2;
			vy += randomGen.nextFloat()-2; 
		}
		else if(pz < Visualization.z1)
		{
			pz = Visualization.z1;
			vz = 0;
			vx += randomGen.nextFloat()-2;
			vy += randomGen.nextFloat()-2;
		}

		vx *= .9f;
		vy *= .9f;
		vz *= .9f;  
	}
}

package processing;

import processing.core.PGraphics;

public class RecursiveTunnel {
	Visualization parent;
	PGraphics canvas;
	int maxNumCopies;
	int finalNumCopies;
	public RecursiveTunnel(Visualization visualization){
		this.parent = visualization;
	}



	public  void recursiveTunnelReverse3D(PGraphics viewPort, float density, float start, float expansion){
		int smallest = 1000;
		int startAt = (int)(smallest*start);
		int endAt = (int)((startAt)*(1-expansion));
		int step = (int)((startAt-endAt)*(1-density));
		if(step==0){
			step = 1;
		}
		System.out.println("startAt is " + startAt + " endAt is "+ endAt + " step is "+step);
		viewPort.beginDraw();
		viewPort.background(0,0,0,0);
		int iEnd = 0;

		int rest =(startAt-endAt)%step;
		//System.out.println(((startAt-endAt)+(step-rest))%step);
		for(int i = startAt+(step-rest)+1; i>endAt; i=i-step){
			viewPort.pushMatrix();
			//viewPort.rotateY(NumbersLauncher.radians(90));
			viewPort.translate(0, 0,-i);
			viewPort.image(viewPort, 0, 0);
			viewPort.popMatrix();
			iEnd = i;
		}

		viewPort.endDraw();
	}
	
	
	
	public  void recursiveTunnelReverse(PGraphics viewPort, float density, float start, float expansion){
		//density 1 is all
		//start at 0 is from o point, which is c
		//expansion 1 is full expansion
		
		double a = viewPort.width/2;
		double b = viewPort.height/2;
		double c = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
		double sin = b/c;
		double cos = a/c;
		
		int startAt = Math.max(1,(int)((1-start)*c));
		//int startAt = (int)((1-start)*c);
		int endAt = (int)((startAt)*(1-expansion));
		
		System.out.println("startat: " + startAt + " endAt is: " + endAt + " density: " + density + " expansion: " + expansion);
		viewPort.beginDraw();
		viewPort.background(0,0,0);
		for(int i = startAt; i>endAt; i=i-(int)((startAt-endAt)/((startAt-endAt)*density))){
			viewPort.image(viewPort, (int)(i*cos), (int)(i*sin), viewPort.width-2*(int)(i*cos), viewPort.height-2*(int)(i*sin));
		}		
		viewPort.endDraw();
	}
	
	public  void recursiveTunnel(PGraphics viewPort, float density, float start, float expansion){
		//density 1 is all
		//start at 0 is from o point, which is c
		//expansion 1 is full expansion
		
		double a = viewPort.width/2;
		double b = viewPort.height/2;
		double c = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
		double sin = b/c;
		double cos = a/c;
		
		int startAt = Math.max(1,(int)((1-start)*c));
		//int startAt = (int)((1-start)*c);
		int endAt = (int)((startAt)*(1-expansion));
		
		System.out.println("startat: " + startAt + " endAt is: " + endAt + " density: " + density + " expansion: " + expansion);
		viewPort.beginDraw();
		viewPort.background(0,0,0);
		for(int i = endAt; i<startAt; i=i+(int)((startAt-endAt)/((startAt-endAt)*density))){
			viewPort.image(viewPort, (int)(i*cos), (int)(i*sin), viewPort.width-2*(int)(i*cos), viewPort.height-2*(int)(i*sin));
		}		
		viewPort.endDraw();
	}

}

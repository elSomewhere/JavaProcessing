package processing;

import java.util.HashMap;
import java.util.Random;

import controlP5.Controller;
import processing.core.PApplet;

public class Decreaser {


	HashMap<String, Values> startValues;
	Random randomizer;

	class Values {
        float startVal;
        boolean active;
        boolean direction;
        public Values(float startVal, boolean active, boolean direction){
        	this.startVal = startVal;
        	this.active = active;
        	this.direction = direction;
        }
        public float getValue() {
            return startVal;
        }
        public boolean getActive(){
        	return active;
        }
        public boolean getDirection(){
        	return direction;
        }
    }
	
	
	public Decreaser(){
		randomizer = new Random();
		startValues = new HashMap<String, Values>();
	}


	public void initDecreaser(Controller<?> in){
		startValues.put(in.getName(), new Values((((float)in.getValue()-(float)in.getMin())/(int)Math.floor(((float)(Visualization.beat)/(float)Visualization.timeRate))),randomizer.nextBoolean(),randomizer.nextBoolean()));
	}

	


	public void decreaseParameters(Controller<?> in, float dampen) {
		// TODO Auto-generated method stub
		//System.out.println(1f-((float)millis() - (float)timerBeat)/(float)timerBeat);
		if(startValues.get(in.getName()).getActive()){
			if(startValues.get(in.getName()).getDirection()){
				in.setValue(in.getValue()-dampen*startValues.get(in.getName()).getValue());
			}else{
				in.setValue(in.getValue()+dampen*startValues.get(in.getName()).getValue());
			}
		}
		//System.out.println(startValues.get(in.getName()));
		//in.setValue(in.getValue()-dampen*startValues.get(in.getName()));
		
	}

}

package processing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class MemoryRandom {
	
	int IDCounter;
	HashMap<String, Float> generators;
	HashMap<String, Boolean> generatorsBool;
	Random randomGenerator = new Random();
	
	public MemoryRandom(){
		generators = new HashMap<String, Float>();
		generatorsBool = new HashMap<String, Boolean>();
		IDCounter = 0;
	}
	
	public float getNewRandomFloat(String id){
		float output;
		output = randomGenerator.nextFloat();
		generators.put(id,output);
		return(output);
	}
	
	public float getNewRandomGaussian(String id){
		float output;
		output = (float)randomGenerator.nextGaussian();
		generators.put(id,output);
		return(output);
	}
	
	public boolean getNewRandomBoolean(String id){
		boolean output;
		output = randomGenerator.nextBoolean();
		generatorsBool.put(id,output);
		return(output);
	}
	
	
	
	public float getMemoryRandomFloat(String id){
		float output;
		
		if(!generators.containsKey(id)){	
			output = randomGenerator.nextFloat();
			generators.put(id,output);
			IDCounter++;
			return(output);
		}else{
			output = generators.get(id);
			return(output);
		}
		
	}
	
	public float getMemoryRandomGaussian(String id){
		float output;
		
		if(!generators.containsKey(id)){	
			output = (float)randomGenerator.nextGaussian();
			generators.put(id,output);
			IDCounter++;
			return(output);
		}else{
			output = generators.get(id);
			return(output);
		}
		
	}
	
	public boolean getMemoryRandomBoolean(String id){
		boolean output;
		
		if(!generators.containsKey(id)){	
			output = randomGenerator.nextBoolean();
			generatorsBool.put(id,output);
			IDCounter++;
			return(output);
		}else{
			output = generatorsBool.get(id);
			return(output);
		}
		
	}
	
	public float getRandomFloat(String id, boolean stopRandom){
		float output;
		if(stopRandom){
			output = getMemoryRandomFloat(id);
		}else{
			output = getNewRandomFloat(id);
		}
		return(output);
	}
	
	public float getRandomGaussian(String id, boolean stopRandom){
		float output;
		if(stopRandom){
			output = getMemoryRandomGaussian(id);
		}else{
			output = getNewRandomGaussian(id);
		}
		return(output);
	}
	
	public boolean getRandomBoolean(String id, boolean stopRandom){
		boolean output;
		if(stopRandom){
			output = getMemoryRandomBoolean(id);
		}else{
			output = getNewRandomBoolean(id);
		}
		return(output);
	}
	
	public float getNumIDs(){
		return(IDCounter);
	}
}

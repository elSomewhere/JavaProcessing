package processing;

import processing.core.PGraphics;

public class ContrastBrightness {
	Visualization parent;
	int w;
	int h;
	int inColor;
	int r;
	int b;
	int g;

	public ContrastBrightness(Visualization visualization){
		this.parent = visualization;
	}

	public void ContrastAndBrightness(PGraphics viewPort,float cont,float bright)
	{
		w = viewPort.width;
		h = viewPort.height;


		//this is required before manipulating the image pixels directly
		viewPort.loadPixels();

		//loop through all pixels in the image
		for(int i = 0; i < w*h; i++)
		{  
			//get color values from the current pixel (which are stored as a list of type 'color')
			inColor = viewPort.pixels[i];

			//here the much faster version (uses bit-shifting) - uncomment to try
			r = (inColor >> 16) & 0xFF; //like calling the function red(), but faster
			g = (inColor >> 8) & 0xFF;
			b = inColor & 0xFF;      

			//apply contrast (multiplcation) and brightness (addition)
			r = (int)(r * cont + bright); //floating point aritmetic so convert back to int with a cast (i.e. '(int)');
			g = (int)(g * cont + bright);
			b = (int)(b * cont + bright);

			//slow but absolutely essential - check that we don't overflow (i.e. r,g and b must be in the range of 0 to 255)
			//to explain: this nest two statements, sperately it would be r = r < 0 ? 0 : r; and r = r > 255 ? 255 : 0;
			//you can also do this with if statements and it would do the same just take up more space
			r = r < 0 ? 0 : r > 255 ? 255 : r;
			g = g < 0 ? 0 : g > 255 ? 255 : g;
			b = b < 0 ? 0 : b > 255 ? 255 : b;

			//and again in reverse for illustration - calling the color function is slow so use the bit-shifting version below
			//output.pixels[i] = color(r ,g,b);
			viewPort.pixels[i]= 0xff000000 | (r << 16) | (g << 8) | b; //this does the same but faste
		}

		//so that we can display the new image we must call this for each image
		viewPort.updatePixels();
	}

}

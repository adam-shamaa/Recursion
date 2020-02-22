//Adam Shamaa
//Graphical program that creates a spiralling image using recursion

import java.applet.Applet;
import java.util.*;
import java.applet.Applet;
import java.awt.*;
import javax.swing.*;

public class spiral extends Applet{

	//Initializing Switches
	int onSwitch = 1;
	int add = -1;
	int finalAdd  = 0;

	public void paint (Graphics g){

		//Method call to fractal method here

		//First value indicates start position in the x axis
		//Second value indicates start position in the y axis
		//Third value indicates level to draw to


		//*NOTE best effect happens when levels does not go above 15 so levels stay within screen
		arc(600,400,15);

	}

	public void arc(int x,int y,int level) {
		//Method to prevent unnecessary addition of two more parameters when calling method  

			//Creates time variable so that a timer can be created
			long time = System.currentTimeMillis();

			//If statement with a switch that removes levels
			if (onSwitch == 1) {
				//Indicates how much levels to decrease each time
				add = -1;
				//Once removed all levels switches to adding levels
				if (finalAdd <= -level) {
					onSwitch = 0;
				}
			}

			//If statement with a switch that adds levels
			if (onSwitch == 0) {
				//Indicates how much levels to add each time
				add = 1;
				if (finalAdd >= level/2) {
					//Once added all levels back switches to removing levels
					onSwitch = 1;
				}
			}

			//final add count
			finalAdd = finalAdd + add;

			//Calls drawing method
			//Third variable is the max level
			//Fourth parameter is the start angle
			//Fifth variable is the current level
			arc(x,y,level+finalAdd,0,1);

			//Repaints current screen
			repaint();

			//Creates delay
			long wait = time + 65 - System.currentTimeMillis();
			if (wait > 0)
				try {
					Thread.sleep(wait);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

	//Fibonacci method
	public int fibonacci(int x) {
		if (x== 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}else if (x== 2) {
			return 1;
		}

		return fibonacci(x-1) + fibonacci(x-2);

	}

	public void arc(int x,int y,int level,int arc,int l) {

		//Calls Methods
		Random rand = new Random();
		Graphics g = getGraphics();


		//Creates new color for each level
		g.setColor(new Color((rand.nextInt(255)),rand.nextInt(255),rand.nextInt(255)));

		//Base Case
		l++;
		if (l >= level) {
			//Indicates when recursion level is done
			return;	

		}

		//Calls fibonnoci method for current level
		int currentWidth = fibonacci(l);
		//Calls fibonnoci method 2 levels behind current
		int widthPrevious2 = fibonacci(l-2);


		//Resets angle to 0 if reaches 360
		if (arc >= 360) {
			arc = 0;
		}

		//Changes start location of arc depending on the start angle
		if(arc == 0) {
			x = x - widthPrevious2/2;
		}else if (arc == 90) {
			y = y-widthPrevious2/2 ;
		}else if (arc == 180) {
			x = x - widthPrevious2/2;
			y = y - widthPrevious2;
		}else if (arc == 270) {
			y = y - widthPrevious2/2;
			x = x - widthPrevious2;
		}

		//Changes arc to 90 degrees more counterclockwise
		arc = arc + 90;

		//Draws the arc 
		g.drawArc(x, y, currentWidth, currentWidth, arc, 90);
		g.drawArc(x-25, y-25, currentWidth, currentWidth, arc, 90);
		g.drawArc(x+25, y+25, currentWidth, currentWidth, arc,90);
		g.drawArc(x, y+50, currentWidth, currentWidth, arc, 90);
		g.drawArc(x-25, y+75, currentWidth, currentWidth, arc, 90);
		g.drawArc(x-75, y+25, currentWidth, currentWidth, arc, 90);
		g.drawArc(x-50,y, currentWidth, currentWidth, arc, 90);
		g.drawArc(x-50,y+50, currentWidth, currentWidth, arc, 90);

		g.drawArc(x-25,y+25, currentWidth, currentWidth, arc, 90);



		//Recursively calls same arc method to move on to next level
		arc(x,y,level,arc,l);
	}



} 


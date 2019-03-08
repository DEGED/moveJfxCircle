package threads;

import ui.CircleController;
import javafx.scene.shape.Rectangle;
import java.util.*;
public class SimpleThreadMove extends Thread{
	
	private CircleController cc;
	private boolean c;
	private boolean r;
	private int id;
	private ArrayList<Rectangle> rectangles;
//	Rectangle p
	public SimpleThreadMove(CircleController cc, boolean r, int idd, Rectangle x) {
		this.cc = cc;
		c = true;
		this.r = r;
		id = idd;
		rectangles	= new ArrayList<Rectangle>();
		rectangles.add(x);
		
		
	}
	
	public void run() {
		while(c) {
			cc.setShape(rectangles.get(id));
			r = cc.rigth(r);
			r = cc.left(r);
			try {
//				cc.getPane().getChildren().add(rectangles.get(id));
				sleep(30);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void s() {
		c = !c;
	}
	
	public boolean getC() {
		return c;
	}
	
	public boolean getR() {
		return r;
	}
}


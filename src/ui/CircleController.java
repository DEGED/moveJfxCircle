package ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import threads.SimpleThreadMove;

public class CircleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane pane;
    
    @FXML
    private Rectangle shape;

    @FXML
    private Button move;

    @FXML
    private Button stop;
    
    @FXML
    private Button DownButt;
    
    private SimpleThreadMove t;
    
    private boolean r;
    
    private Rectangle square;
    private ArrayList<Rectangle> po;
//    private ArrayList<SimpleThreadMove> threads;
    
    @FXML
    void DownMethod(ActionEvent event) {
    	shape.setLayoutY(pane.getHeight());
    }

    @FXML
    void generateNew(MouseEvent event) {
    	int idd = 1;
    	
    	double x = event.getX();
    	double y = event.getY();
//    	ArrayList<Rectangle> squareList = new  ArrayList<Rectangle>();
    	shape = new Rectangle(x,y, shape.getWidth(),shape.getHeight());
    	SimpleThreadMove xio = new SimpleThreadMove(this,r,idd,shape);
    	pane.getChildren().add(po.get(idd));
    	xio.start();
    	
//    	SimpleThreadMove l = new SimpleThreadMove(this, r, idd);
//    	l.start();
//    	threads.add(l);
    	idd++;
    }
    @FXML
    void move(ActionEvent event) {
    	t = new SimpleThreadMove(this,r,0,shape);
    	t.start();
    	
    	stop.setDisable(false);
    	move.setDisable(true);
    }
	@FXML
    void stop(ActionEvent event) {
    	stop.setDisable(true);
    	move.setDisable(false);
    	t.s();
    	r = t.getR();
    }
    
    public boolean rigth(boolean r) {
    	if(r){
    		shape.setLayoutX(shape.getLayoutX()+5);
    		shape.setLayoutY(shape.getLayoutY()+5);
    		shape.setRotate(shape.getRotate()+4);
    		shape.
    		System.out.println("Derecha");
    	}
// 	 || shape.getLayoutY()>=pane.getMaxHeight()
    	if(shape.getLayoutX()>=pane.getWidth() || shape.getLayoutY()>=pane.getHeight()) {
			r = false;
		}
		return r;
    }
    ParallelTransition poo= new ParallelTransition();
    public boolean left(boolean r){
    	if(!r){
    		shape.setLayoutX(shape.getLayoutX()-5);
    		shape.setLayoutY(shape.getLayoutY()-5);
    		shape.setRotate(shape.getRotate()-4);
    		System.out.println("Izquierda");
    	}
//    	 || pane.getLayoutY() <= 0
    	if(shape.getLayoutX() <= 0 || shape.getLayoutY() <= 0) {
			r = true;
		}	
		return r;
    }
    	
    public void setShape(Rectangle l) {
    	shape = l;
    }
    public boolean getR() {
    	return r;
    }
    @FXML
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'Circle.fxml'.";
        assert shape != null : "fx:id=\"shape\" was not injected: check your FXML file 'Circle.fxml'.";
//        id = 0;
        po = new ArrayList<Rectangle>();
    }
}


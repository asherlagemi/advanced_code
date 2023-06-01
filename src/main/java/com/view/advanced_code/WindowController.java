package com.view.advanced_code;

import java.util.Observable;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import viewmodel.ViewModel;

@SuppressWarnings("deprecation")
public class WindowController extends Observable{

    @FXML
    Canvas joystick;	//reference to the joystick in the canvas
    @FXML
    Slider throttle;
    @FXML
    Slider rudder;
    ViewModel vm;
    DoubleProperty aileron, elevators;
    boolean mousePushed;	//says if the mouse is pushed
    double jx,jy;
    double mx,my;
    //double aileron,elevator,thr_val;	//used to normalise the values for when the window changes
    //-----these properties are not relevant - everything will be data-binded--------//

    //public double getThrottle() {
    //	return thr_val;
    //}
    //public double getAileron() {
    //	return aileron;
    //}
    //public double getElevator() {
    //	return elevator;
    //}

    public WindowController() {
        mousePushed = false;
        jx = 0;
        jy = 0;
        aileron = new SimpleDoubleProperty();
        elevators = new SimpleDoubleProperty();
        //aileron = 0;
        //elevator = 0;
        //thr_val = 0;
    }

    void init(ViewModel vm) {
        this.vm = vm;
        vm.throttle.bind(throttle.valueProperty());	//binding to the properties of the viewmodel
        vm.rudder.bind(rudder.valueProperty());
        vm.aileron.bind(aileron);
        vm.elevators.bind(elevators);
        //throttle.valueProperty().addListener((o,ov,nv)->{
        //	thr_val = (double)nv;
        //	setChanged();
        //	notifyObservers();
        //});
    }

    void paint() {
        GraphicsContext gc = joystick.getGraphicsContext2D();
        mx = joystick.getWidth()/2;
        my = joystick.getHeight()/2;	//finding the middle of the canvas
        gc.clearRect(0, 0, joystick.getWidth(), joystick.getHeight());	//clearing the canvas before new paint
        gc.strokeOval(jx-50, jy-50, 100, 100);	//drawing an oval around the middle
        aileron.set((jx-mx)/mx);
        elevators.set((jy-my)/my);	//normalising the values according to the window size
        //setChanged();
        //notifyObservers();	//notifying the controller
        //System.out.println(aileron+","+elevator);
    }

    public void mouseDown(MouseEvent me) {
        if(!mousePushed) {
            mousePushed = true;
            System.out.println("mouse is down");
        }
    }

    public void mouseUp(MouseEvent me) {
        if(mousePushed) {
            mousePushed = false;
            System.out.println("mouse is up");
            jx = mx;
            jy = my;
            paint();
        }
    }

    public void mouseMove(MouseEvent me) {
        if(mousePushed) {
            jx = me.getX();
            jy = me.getY();
            paint();	//drawing the joystick while the joystick is dragged
        }
    }
}


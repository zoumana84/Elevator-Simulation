/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gagnon
 */
package lab1;

public class Elevator {
    private String name;
    private int enterFloor;
    private int exitFloor;
    private int tempOff = 0;

    public Elevator(String name, int enterFloor, int exitFloor) {
        this.name = name;
        this.enterFloor = enterFloor;
        this.exitFloor = exitFloor;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnterFloor() {
        return enterFloor;
    }

    public void setEnterFloor(int enterFloor) {
        this.enterFloor = enterFloor;
    }

    public int getExitFloor() {
        return exitFloor;
    }

    public void setExitFloor(int exitFloor) {
        this.exitFloor = exitFloor;
    }
    
    public void tempOffIncrease(){
        tempOff++;
    }

    public int getTempOff() {
        return tempOff;
    }

    @Override
    public String toString() {
        return "Name: " + name+"\nEnter Floor: " + enterFloor+"\nDestination Floor: " + exitFloor;
    }
    
}

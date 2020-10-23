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
public class ElevatorStack {
    private Elevator[] elevatorStack = new Elevator[5];
    private int index = 0;
    
    public boolean push(Elevator elevator){
        if(isFull()){
            return false;
        }
        elevatorStack[index] = elevator;
        index++;
        return true;
    }
    
    public Elevator pop(int currentFloor){
        if(isEmpty()){
            return null;
        }
        Elevator elevator = elevatorStack[index-1];
        if(elevator.getExitFloor()!=currentFloor){
            return null;
        }
        elevatorStack[index-1] = null;
        index--;
        return elevator;
    }
    
    public boolean isEmpty(){
        for(int i =0;i<=4;i++){
            if(elevatorStack[i]!=null){
                return false;
            }
        }
        return true;
    }
    
    public boolean isFull(){
        return index-1 == 4;
    }
    
    public void orderStack(int currentFloor){
        for (int i = 0; i < index; i++){
            elevatorStack[i].tempOffIncrease();
            for (int j = i; j < index; j++){
                if(Math.abs(elevatorStack[i].getExitFloor()-currentFloor) < Math.abs(elevatorStack[j].getExitFloor()-currentFloor)){
                    Elevator elevator = this.elevatorStack[i];
                    this.elevatorStack[i] = this.elevatorStack[j];
                    this.elevatorStack[j] = elevator;
                }
            }
        }
    }
    
    public int calculateNextFloor(int currentFloor, int probableNextFloor){
        if(isEmpty()){
            return probableNextFloor;
        }
        int exitFloor = elevatorStack[index-1].getExitFloor();
        if(Math.abs(exitFloor-currentFloor)< Math.abs(probableNextFloor-currentFloor)){
            return exitFloor;
        }else if(Math.abs(elevatorStack[index-1].getExitFloor()-currentFloor)> Math.abs(probableNextFloor-currentFloor)){
            return probableNextFloor;
        }else{
            return exitFloor;
        }
    }
    
}

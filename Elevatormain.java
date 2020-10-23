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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Elevatormain {

   
    
    
   private static Elevator[] allPeoples = getDataFromFile();

    public static void main(String... args){
        ElevatorStack elevatorStack = new ElevatorStack();
        int index = 0;
        int empty = 0;
        int full = 0;
        int noOfPeopleRode = 0;
        int floor = 1;

        while(index < allPeoples.length){
            if(elevatorStack.isEmpty()){
                empty++;
                System.out.println("Elevator was Empty");
            }
            else{
                Elevator elevator = elevatorStack.pop(floor);
                while(elevator!=null){
                 System.out.println("Name: " + elevator.getName()+"\nNumber of Exits: " + elevator.getTempOff());
                 elevator = elevatorStack.pop(floor);
                }
            }
            while(index < allPeoples.length && floor == allPeoples[index].getEnterFloor()){
             if(!elevatorStack.isFull()){
                noOfPeopleRode++;
                elevatorStack.push(allPeoples[index]);
                 System.out.println(allPeoples[index]);    
              }else{
                  full++;
                  System.out.println("Sorry "+ allPeoples[index].getName() +", elevator was full");
              } 
             index++;
            }
            System.out.println("=============================================");
            elevatorStack.orderStack(floor);
            if(index!=allPeoples.length){
                floor = elevatorStack.calculateNextFloor(floor,allPeoples[index].getEnterFloor());
            }else{
                floor = elevatorStack.calculateNextFloor(floor,allPeoples[index-1].getExitFloor());
            }
        }
        
        System.out.println(noOfPeopleRode+ " people are able to use elevator");
        System.out.println(full+ " people are not able to use elevator");
        System.out.println(empty+ " times elevator was empty");
    }



    public static Elevator[] getDataFromFile(){
        Elevator[] elevators = null;
        List<Elevator> elevatorList = new ArrayList<>();
        try
        {

//file to be opened for reading
            
            
            FileInputStream inputFile=new FileInputStream("src/ElevatorData.txt");
            Scanner sc=new Scanner(inputFile);    //file to be scanned

//returns true if there is another line to read
            while(sc.hasNextLine())
            {
                String singleDataFromFile = sc.nextLine();
               String[] dataSplitted = singleDataFromFile.split("\\s");


               String name = dataSplitted[0];
               int enterFloor = Integer.valueOf(dataSplitted[1]);
               int exitFloor = Integer.valueOf(dataSplitted[2]);
               elevatorList.add(new Elevator(name,enterFloor,exitFloor));
            }

//converts the list to Array
            elevators = new Elevator[elevatorList.size()];
            for(int i = 0; i < elevatorList.size(); i++) elevators[i] = elevatorList.get(i);

            sc.close();     //closes the scanner
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return elevators;

    }
    
}

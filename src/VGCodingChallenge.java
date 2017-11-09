/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author sb
 */
public class VGCodingChallenge {
    /**
     * @param args the command line arguments
     */
    private int eventID;
    private int xCoord;
    private int yCoord;
    private final int gridX=21;
    private final int gridY=21;
    private Events[][] grid;
    private ArrayList<Events> eventList;
    private ArrayList<Events> shortList;
    
    public static void main(String[] args) {
        VGCodingChallenge challenge = new VGCodingChallenge();
        challenge.populateGrid(); // Populates the grid
        challenge.userInput(); // Take user input         
        System.out.println("Closest Events to ("+(challenge.getxCoord()-10)+","+(challenge.getyCoord()-10)+")");
        challenge.eventSort();
        challenge.printResults();
    }
    
    //Constructor
    private VGCodingChallenge(){
        eventID=1;
        grid = new Events[gridX][gridY];
        eventList = new ArrayList<>();
        shortList = new ArrayList<>();
    }

    
    //Method to populate the grid with random events.
    private void populateGrid(){
        for (int i=0;i<gridX;i++){
            for(int j=0;j<gridY;j++){
                boolean eventsOn=generateRandBool();
                if (eventsOn==true){
                    grid[i][j]=new Events(1,eventID,i,j);
                    eventList.add(grid[i][j]);
                    eventID++;
                }
            }
        }
    }
    
    //Takes user input
    private void userInput(){
        boolean validInput=false;
        while (validInput==false){
            validInput=true;
            System.out.println("Please Input Coordinates:"); //Request user for input        
            Scanner s = new Scanner(System.in); //Accept user input
            String input=s.nextLine();
            String[] coordinates = input.split(","); //Split input
            xCoord=Integer.parseInt(coordinates[0])+10; //Convert input into X integer
            yCoord=Integer.parseInt(coordinates[1])+10; //Convert input into Y integer
            //Validate inputs
            if (coordinates.length>2){
                System.out.println("Too many inputs!");
                validInput=false;
            }
            if(xCoord<0 || xCoord>20){
                System.out.println("Coordinates must be between -10 and 10");
                validInput=false;
            }
            if(yCoord<0 || yCoord>20){
                System.out.println("Coordinates must be between -10 and 10");
                validInput=false;
            }
        }
    }
    
    //50% chance of returning true, used to decide if grid section becomes populated.
    private boolean generateRandBool(){
        return Math.random() < 0.5;
    }
    
    //Sorts the list of events by manhattan distance
    private void eventSort(){
        PriorityQueue<Events> sortedEvents=new PriorityQueue<>(10, new Checker()); //Initialise priority queue
        //For each event location, calcualte manhattan distance and assign it to the object.
        for(Events event: eventList){
            int manDist = Math.abs(xCoord-event.getX()) + Math.abs(yCoord-event.getY());
            event.setDist(manDist);
            sortedEvents.add(event); //Add it to the sorted list of events
        }
        sortedEvents.remove(); //Remove top element (root node)
        //Store remaining top 5 elements.
        for(int i=0;i<6;i++){
            shortList.add(sortedEvents.poll());
        }
    }
    
    //Prints the results of the program
    private void printResults() {
        for(Events event: shortList){
            System.out.println("Event " + String.format("%03d", event.getID(0))+" - $"+String.format("%.2f", event.getCheapestTicket())+", Distance "+event.getDist());
        }
    }
    
    //Getter for grid.
    public Events[][] getGrid(){
        return grid;
    }
    
    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }    
}
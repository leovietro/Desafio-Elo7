/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leonardovietro.desafioelo7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author leonardo
 */
public class Main {
   public static void main(String[] args){
       Main main = new Main();
       Highland highland;
       Scanner sc = new Scanner(System.in);
       boolean collided = false;
       
       //Get highland area size.
       System.out.println("Enter the size of the X axis area to be explored: ");
       int height = sc.nextInt();
       System.out.println("Enter the size of the Y axis area to be explored: ");
       int width = sc.nextInt();
       
       //Creating the highland.
       highland = new Highland(height, width);
       
       //Print the highland.
       System.out.println("\n\nWelcome to the Mars Exploration Team!");
      
       //Get probes positioning on the grid.
       for(int i = 1; i < 3; i++){
           System.out.println("\nEnter the position of the probe no." + i + " on the X axis: ");
           int xPos = sc.nextInt();
           
           System.out.println("\nEnter the position of the probe no." + i + " on the Y axis: ");
           int yPos = sc.nextInt();
           
           System.out.println("\nEnter the direction which the probe no." + i + " is pointing (N,S,E,W): ");
           char dir = sc.next().charAt(0);
           
           boolean concluded = highland.positionProbe(xPos, yPos, dir);
           
           //Checks if the input is invalid.
           while(!concluded){
               System.out.println("\nINVALID INPUT!\nTry again!");
               
               System.out.println("\nEnter the position of the probe no." + i + " on the X axis: ");
               xPos = sc.nextInt();

               System.out.println("\nEnter the position of the probe no." + i + " on the Y axis: ");
               yPos = sc.nextInt();

                System.out.println("\nEnter the direction which the probe no." + i + " is pointing (N,S,E,W): ");
                dir = sc.next().charAt(0);

                concluded = highland.positionProbe(xPos, yPos, dir);
           }
       }
       
       
       //Get commands and update the probes.
       for(int i = 1; i < 3; i++){
           System.out.println("\nInsert the command to move the probe no." + i + ": ");
           String command = sc.next();
           command = command.toUpperCase();
           boolean validInput = highland.updatePosition((i-1), command);
           collided = highland.checkForCollision(i);
           if(collided){
               break;
           }
           
           //Checks if the probe is going out of bounds.
           while(validInput){
               System.out.println("\nYOU CAN'T GO OUT OF BOUNDS!\nTry again!");
               
               System.out.println("\nInsert the command to move the probe no." + i + ": ");
               command = sc.next();
               command = command.toUpperCase();
               validInput = highland.updatePosition((i-1), command);
           }
       }
              
       
       //Checks if the probes collided and end the game.
       if(collided == true){
           System.out.println("\nThe two probes collided and exploded!");
       }
       else{
           for(int i = 0; i < 2; i++){
               String info[] = highland.probeInfo(i);
               System.out.println("\nPosition of the probe no. " + (i+1) + ": " + info[0] + " " + info[1] + " " + info[2]);
           }
       }

   }

}

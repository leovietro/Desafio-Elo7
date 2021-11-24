/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leonardovietro.desafioelo7;
/**
 *
 * @author leonardo
 */

public class Probe {
    private int xPosition;
    private int yPosition;
    final private char[] directions = {'N', 'E', 'S', 'W'};
    private int direction;
    
    public Probe(int xPosition, int yPosition, char direction){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        
        switch(direction){
            case 'N':
                this.direction = 0;
                break;
            case 'E':
                this.direction = 1;
                break;
            case 'S':
                this.direction = 2;
                break;
            case 'W':
                this.direction = 3;
                break;
            default:
                this.direction = 0;
                break;
        }
    }
    
    private void turnL(){
        this.direction -= 1;
        if(this.direction < 0){
            this.direction = this.directions.length-1;
        }
    }
    
    private void turnR(){
        this.direction += 1;
        if(this.direction >= this.directions.length){
            this.direction = this.directions.length-1;
        }
    }
    
    public void turn(char direction){
        switch(direction){
            case 'L':
                this.turnL();
                break;
            case 'R':
                this.turnR();
                break;
        }
    }
    
    public void move(){
        switch(this.directions[this.direction]){
             case 'N':
                this.yPosition++;
                break;
            case 'E':
                this.xPosition++;
                break;
            case 'S':
                this.yPosition--;
                break;
            case 'W':
                this.xPosition--;
                break;
        }
    }
    
    public int[] getPosition(){
        int[] position = {xPosition, yPosition, direction};
        return position;
    }
    
    public int getXPos(){
        return this.xPosition;
    }
    
    public int getYPos(){
        return this.yPosition;
    }
    
    public String getDir(){
        String getDirection = "";
        switch(this.direction){
            case 0:
                getDirection = "N";
                break;
            case 1:
                getDirection = "E";
                break;
            case 2:
                getDirection = "S";
                break;
            case 3:
                getDirection = "W";
                break;
            default:
                this.direction = 0;
                break;
        }
        
        return getDirection;
    }
    
    public void setPosition(int xPos, int yPos, int dir){
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.direction = dir;
    }
    
    public void receiveCommand(String command){
        for(int i = 0; i < command.length(); i++){
            if(command.charAt(i) == 'M'){
                this.move();
            }
            else if(command.charAt(i) == 'L' || command.charAt(i) == 'R'){
                this.turn(command.charAt(i));
            }
        }
    }
    
}

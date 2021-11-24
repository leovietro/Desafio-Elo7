/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leonardovietro.desafioelo7;
import java.util.ArrayList;

/**
 *
 * @author leonardo
 */
public class Highland {
    private int height = 1;
    private int width = 1;
    private ArrayList<Probe> probes = new ArrayList<Probe>();
    final private String directions = "NESW";

    public Highland(int height, int width){
        if(height > 0 && width > 0){
            this.height = height;
            this.width = width;
        } else {
            //exception
        }
    }
    
    public boolean positionProbe(int xPosition, int yPosition, char direction){
        boolean concluded = true;
        
        if(xPosition >= 0 && xPosition <= width && yPosition >= 0 && yPosition <= height && this.directions.indexOf(direction) >= 0){
            Probe newProbe = new Probe(xPosition, yPosition, direction);
            this.probes.add(newProbe);
            concluded = true;
        } else {
            concluded = false;   
        }        
        
        return concluded;
    }
    
    public void turnProbe(int probeIndex, char direction){
        if(this.directions.indexOf(direction) >= 0){
            this.probes.get(probeIndex).turn(direction);
        } else {
            //
        }   
    }
    
    public boolean updatePosition(int probeIndex, String command){
        int [] oldPositions = this.probes.get(probeIndex).getPosition();
        
        this.probes.get(probeIndex).receiveCommand(command);
        
        int [] newPositions = this.probes.get(probeIndex).getPosition();
        boolean validInput = false;
        
        if(newPositions[0] < 0 || newPositions[0] > width || newPositions[1] < 0 || newPositions[1] > height){
            validInput = true;
            this.probes.get(probeIndex).setPositions(oldPositions[0], oldPositions[1], oldPositions[2]);
        }
        else{
            validInput = false;
        }
        
        return validInput;
    }
    
    public int[] getSize(){
        int sizes[] = new int[2];
        sizes[0] = this.width;
        sizes[1] = this.height;
        
        return sizes;
    }
    
    public String[] probeInfo(int index){
        String[] info = new String[3];
        info[0] = Integer.toString(this.probes.get(index).getXPos());
        info[1] = Integer.toString(this.probes.get(index).getYPos());
        info[2] = this.probes.get(index).getDir();
        
        return info;
    }
    
    public boolean checkForCollision(int probeIndex){
        boolean collision = false;
        
        if(probeIndex == 0){
            if(this.probes.get(probeIndex).getXPos() == this.probes.get(probeIndex + 1).getXPos() && this.probes.get(probeIndex).getYPos() == this.probes.get(probeIndex + 1).getYPos()){
                collision = true;
            }
            else{
                collision = false;
            }
        }       
        else if(probeIndex == 1){
            if(this.probes.get(probeIndex).getXPos() == this.probes.get(probeIndex - 1).getXPos() && this.probes.get(probeIndex).getYPos() == this.probes.get(probeIndex - 1).getYPos()){
                collision = true;
            }
            else{
                collision = false;
            }
        }  
        
        return collision;
    }
}

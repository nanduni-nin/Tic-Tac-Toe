package tictactoe;

/**
 *
 * @author Nands
 */
public class Box {
    private int number;
    int clicked;//clicked or not
    private int state; //crosss or circle cross1 circle 2
    
    public Box(int number){
        this.clicked = 0; //clicked
        this.state=-1;
        this.number = number; 
    }
    
    public void changeClicked(int state){//clicked/unclicked
            this.clicked = 1;
            if(state>0){
                this.state=state;
            }
            else{
                this.state=1;
            }            
           // System.out.println(number +"     "+  state);        
    }
    
    
    
    public int getState(){
        return this.state;
    }
}

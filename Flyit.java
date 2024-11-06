/*Austin Lindstrom
 * Instructor Paul Murray
 * 12/1/2019
 * 
 * Program that uses a JFrame GUI to simulate
 * an airplane flight with stars in the background
 * where the airplane moves along with user's mouse.*/







import javax.swing.*;

public class Flyit
{
  public static void main(String[] args)  //main method
  {
    JFrame frame=new JFrame("Flight Simulator");          //creates new JFrame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Plane flight = new Plane();  
    frame.getContentPane().add(flight);    
    frame.pack();
    frame.setVisible(true);
  }
}  




    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyListener;

  
public class Plane extends JPanel 
{
    String mph = new String("mph");
    int speed=212;
    
    
   int planespeed;
    boolean destroyed=false;
    boolean afterburners=false;
    int currentx=0;    //starting current x and y of the mouse cursor
    int currenty=0;    
    
    int starx=900;
    int stary=60;
    int starmove=0;
  JLabel label;
  
  public JLabel setLabel(){        //creates a new JLabel
    setSize(960, 960);
    setVisible(true);
    label = new JLabel("Speed");
    add(label);
    return label;
  }
    

    
  
  public Plane()       
  {      
    PolygonPanel listener = new PolygonPanel();  //create a polygon listener
    addMouseListener(listener);  //listen for mouse changes 
    addMouseMotionListener(listener);  //listen for mouse movement
    setBackground(Color.black);   
    setPreferredSize(new Dimension(1000,800)); //set default size of JFrame window 
  }
  
  
  public void paintComponent(Graphics page)     
  {
    super.paintComponent(page);
    
    page.setColor(Color.white);  //sets plane color to white
    
 if (!destroyed)    
   {
    
    int[] xloc_plane = {currentx+257,currentx+237,currentx+156,currentx+144,currentx+138,currentx+135,currentx+52,currentx+48,currentx+47,currentx+41,currentx+40,currentx+20,currentx+9,currentx+25,currentx+26,currentx+21,currentx+23,currentx+9,currentx+16,currentx+36,currentx+56,currentx+89,currentx+116,currentx+109,currentx+97,currentx+80,currentx+63,currentx+68,currentx+93,currentx+119,currentx+148,currentx+153,currentx+151,currentx+136,currentx+147,currentx+158,currentx+167,currentx+189,currentx+221,currentx+236,currentx+249,currentx+257,currentx+257};
    int[] yloc_plane = {currenty+84,currenty+72,currenty+73,currenty+46,currenty+45,currenty+75,currenty+77,currenty+72,currenty+67,currenty+66,currenty+67,currenty+52,currenty+52,currenty+78,currenty+80,currenty+84,currenty+90,currenty+100,currenty+101,currenty+94,currenty+98,currenty+101,currenty+103,currenty+113,currenty+122,currenty+135,currenty+148,currenty+150,currenty+136,currenty+121,currenty+125,currenty+121,currenty+112,currenty+111,currenty+104,currenty+102,currenty+100,currenty+99,currenty+98,currenty+97,currenty+94,currenty+89,currenty+85};
    page.fillPolygon(xloc_plane,yloc_plane,xloc_plane.length);     //draws the plane

    
    int[] xloc_star = {55+100,69+100,50+100,42+100,32+100,12+100,27+100,23+100,41+100,57+100,55+100};
    int[] yloc_star = {currenty+43,currenty+29,currenty+25,currenty+9,currenty+25,currenty+29,currenty+43,currenty+60,currenty+52,currenty+60,currenty+44};    
    page.setColor(Color.yellow);  //sets the stars to yellow
    page.fillPolygon(xloc_star,yloc_star,xloc_star.length);  //draws the star
    
    int[] xloc_star1 = {55+350,69+350,50+350,42+350,32+350,12+350,27+350,23+350,41+350,57+350,55+350};
    int[] yloc_star1 = {currenty+43,currenty+29,currenty+25,currenty+9,currenty+25,currenty+29,currenty+43,currenty+60,currenty+52,currenty+60,currenty+44};    
    page.fillPolygon(xloc_star1,yloc_star1,xloc_star1.length);  
    
    
    int[] xloc_star2 = {55+600,69+600,50+600,42+600,32+600,12+600,27+600,23+600,41+600,57+600,55+600};
    int[] yloc_star2 = {currenty+43,currenty+29,currenty+25,currenty+9,currenty+25,currenty+29,currenty+43,currenty+60,currenty+52,currenty+60,currenty+44};    
    page.fillPolygon(xloc_star2,yloc_star2,xloc_star2.length);  //draws the second star
    
    int[] xloc_star3 = {55+850,69+850,50+850,42+850,32+850,12+850,27+850,23+850,41+850,57+850,55+850};
    int[] yloc_star3 = {currenty+43,currenty+29,currenty+25,currenty+9,currenty+25,currenty+29,currenty+43,currenty+60,currenty+52,currenty+60,currenty+44};    
    page.fillPolygon(xloc_star3,yloc_star3,xloc_star3.length);  //draws the third star
   
    
   
    page.setColor(Color.black);  //sets windows to black

    int[] xloc_window = {currentx+249,currentx+241,currentx+235,currentx+235,currentx+240,currentx+246,currentx+249};
    int[] yloc_window = {currenty+81,currenty+87,currenty+87,currenty+82,currenty+80,currenty+77,currenty+80};
    page.fillPolygon(xloc_window,yloc_window,xloc_window.length);   //draws the windows
    
    
    int[] xloc_window1 = {currentx+217,currentx+210,currentx+211,currentx+213,currentx+216,currentx+218,currentx+219,currentx+218};
    int[] yloc_window1 = {currenty+87,currenty+87,currenty+82,currenty+81,currenty+81,currenty+82,currenty+86,currenty+87};
    page.fillPolygon(xloc_window1,yloc_window1,xloc_window1.length);
    
    int[] xloc_window2 = {currentx+217-10,currentx+210-10,currentx+211-10,currentx+213-10,currentx+216-10,currentx+218-10,currentx+219-10,currentx+218-10};
    int[] yloc_window2 = {currenty+87,currenty+87,currenty+82,currenty+81,currenty+81,currenty+82,currenty+86,currenty+87};
    page.fillPolygon(xloc_window2,yloc_window2,xloc_window2.length);
    
    int[] xloc_window3 = {currentx+217-20,currentx+210-20,currentx+211-20,currentx+213-20,currentx+216-20,currentx+218-20,currentx+219-20,currentx+218-20};
    int[] yloc_window3 = {currenty+87,currenty+87,currenty+82,currenty+81,currenty+81,currenty+82,currenty+86,currenty+87};
    page.fillPolygon(xloc_window3,yloc_window3,xloc_window3.length);
    
    int[] xloc_window4 = {currentx+217-30,currentx+210-30,currentx+211-30,currentx+213-30,currentx+216-30,currentx+218-30,currentx+219-30,currentx+218-30};
    int[] yloc_window4 = {currenty+87,currenty+87,currenty+82,currenty+81,currenty+81,currenty+82,currenty+86,currenty+87};
    page.fillPolygon(xloc_window4,yloc_window4,xloc_window4.length);
    
    int[] xloc_window5 = {currentx+217-40,currentx+210-40,currentx+211-40,currentx+213-40,currentx+216-40,currentx+218-40,currentx+219-40,currentx+218-40};
    int[] yloc_window5 = {currenty+87,currenty+87,currenty+82,currenty+81,currenty+81,currenty+82,currenty+86,currenty+87};
    page.fillPolygon(xloc_window5,yloc_window5,xloc_window5.length);
    
    int[] xloc_window6 = {currentx+217-100,currentx+210-100,currentx+211-100,currentx+213-100,currentx+216-100,currentx+218-100,currentx+219-100,currentx+218-100};
    int[] yloc_window6 = {currenty+87,currenty+87,currenty+82,currenty+81,currenty+81,currenty+82,currenty+86,currenty+87};
    page.fillPolygon(xloc_window6,yloc_window6,xloc_window6.length);
    
    int[] xloc_window7 = {currentx+217-110,currentx+210-110,currentx+211-110,currentx+213-110,currentx+216-110,currentx+218-110,currentx+219-110,currentx+218-110};
    int[] yloc_window7 = {currenty+87,currenty+87,currenty+82,currenty+81,currenty+81,currenty+82,currenty+86,currenty+87};
    page.fillPolygon(xloc_window7,yloc_window7,xloc_window7.length);
    
    int[] xloc_window8 = {currentx+217-120,currentx+210-120,currentx+211-120,currentx+213-120,currentx+216-120,currentx+218-120,currentx+219-120,currentx+218-120};
    int[] yloc_window8 = {currenty+87,currenty+87,currenty+82,currenty+81,currenty+81,currenty+82,currenty+86,currenty+87};
    page.fillPolygon(xloc_window8,yloc_window8,xloc_window8.length);
    
    int[] xloc_window9 = {currentx+217-130,currentx+210-130,currentx+211-130,currentx+213-130,currentx+216-130,currentx+218-130,currentx+219-130,currentx+218-130};
    int[] yloc_window9 = {currenty+87,currenty+87,currenty+82,currenty+81,currenty+81,currenty+82,currenty+86,currenty+87};
    page.fillPolygon(xloc_window9,yloc_window9,xloc_window9.length);
    
    int[] xloc_window10 = {currentx+217-140,currentx+210-140,currentx+211-140,currentx+213-140,currentx+216-140,currentx+218-140,currentx+219-140,currentx+218-140};
    int[] yloc_window10 = {currenty+87,currenty+87,currenty+82,currenty+81,currenty+81,currenty+82,currenty+86,currenty+87};
    page.fillPolygon(xloc_window10,yloc_window10,xloc_window10.length);
    
    page.setColor(Color.gray); //sets the turbine to the color gray
    int[] xloc_turbine = {currentx+150,currentx+147,currentx+148,currentx+150,currentx+153,currentx+153,currentx+151};
    int[] yloc_turbine = {currenty+123,currenty+121,currenty+114,currenty+111,currenty+115,currenty+120,currenty+123};
    page.fillPolygon(xloc_turbine,yloc_turbine,xloc_turbine.length); //draws the turbine
    
    

    page.setColor(Color.white); //sets the color back to white
   
  
    repaint(); //redraws the entire thing 

   }     
  } //end paintComponent
 
  
  private class PolygonPanel implements MouseListener, MouseMotionListener
  {
    public void mousePressed(MouseEvent event){
    if (event.getButton() == MouseEvent.BUTTON1)         //if left mouse button gets clicked afterburners turn on and speed is set to 1687
    afterburners=true;
    speed=1687;
      System.out.print("Afterburners on! " + speed);}
    public void mouseReleased(MouseEvent event){}//unused event
    public void mouseDragged(MouseEvent event){
    }   //unused event
    
    
  /* public void keyTyped(KeyEvent event) {        
    int keyCode = event.getKeyCode;
    switch(keyCode) {
      case KeyEvent.VK_UP:
       speed+=5;
      System.out.print(speed);
      break;
      case KeyEvent.VK_DOWN:
      speed-=9;
      System.out.print(speed);
      break;
    }
   }*/
  
     
    
 
    public void mouseClicked(MouseEvent event){
      if (event.getButton() == MouseEvent.BUTTON1){
         afterburners=true;
         speed=1687;}

      
    
    } //end mouseClicked

      //unused event
    public void mouseEntered(MouseEvent event) {}   //unused event
    public void mouseExited(MouseEvent event) {}    //unused event
   
   
    public void mouseMoved(MouseEvent event) 
    {
      if (starmove+starx>2)
       starmove-=2;  
      else
       starmove=500;  

      
      int planespeed=event.getPoint().x/4;  //retrieve the x location of the mouse and use it to calculate a speed
     

       currentx=event.getPoint().x; 
       repaint();  //redraw the image  
      
    } //end mouseMoved
   
  }  //end PolygonPanel
}  
      
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

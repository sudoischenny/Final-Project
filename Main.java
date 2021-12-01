//@Group 10
//Carson Hurst, Andy Chen, Mahathi Venkatesh, & Anisha Mainali
//Date: November 30, 2021. 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Main {
  public static void main(String args[]) {
   SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        new Game();
     }
   });
 }
}
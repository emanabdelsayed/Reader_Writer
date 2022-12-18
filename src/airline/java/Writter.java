/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.java;

/**
 *
 * @author dell
 */

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Writter extends Thread {
    String name;
   public static dataBase DB = new dataBase();

    public Writter(String name) {
        this.name = name;
        this.setName(name);
    }

 

    @Override
    public void run() {

      ReaderWriterGUI.DB.statrtWrite();
      
        ReaderWriterGUI.DB.write("Number of seats: ");
     
        
             ReaderWriterGUI.jTextArea1.append("seats Updates by Customer : " + this.name + "  the number of seats now:   " + DB.getTicket() + "\n");
       
             
        
       
        ReaderWriterGUI.DB.stopWriting();

    }

    @Override


        public String toString () {


            return "seats Updates by Customer : " + name + "  the number of seats now: " + DB.getTicket();

        }

    
}

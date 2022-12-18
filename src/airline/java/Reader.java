/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.java;

/**
 *
 * @author dell
 */

public class Reader extends Thread {
    public static dataBase DB = new dataBase();
    String name;
    public Reader(String name){
        this.name=name;
        this.setName(name);
    }

   


    @Override
    public void run() {
           ReaderWriterGUI.DB.startReading();
           
           ReaderWriterGUI.jTextArea1.append("Seats Viewed by Customer" + this.name + "    Seats now is:   " + DB.getTicket() +"\n");
          // MainFrame.c.read();
          //System.out.println("Balance Viewed by Thread" + Thread.currentThread().getName() + " Balance now is " + MainFrame.c.getBalance());
           ReaderWriterGUI.DB.stopReading();

    }

    @Override
    public String toString() {
        return  "Seats Viewed by Customer" + name + " Seats now is " +ReaderWriterGUI.DB.getTicket();
    }
    
    
}

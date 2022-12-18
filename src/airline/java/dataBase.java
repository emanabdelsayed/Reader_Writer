/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.java;

/**
 *
 * @author dell
 */

public class dataBase {
    public   static int  seats = 100 ;
    boolean writing = false  ;
    int waitingWriters =0 ,readers =0 ;
    private boolean readersTurn =false;
    
    

    public  synchronized void statrtWrite() {

        while(writing || readers>0){
            waitingWriters++;
            try{
               wait(); }
            catch(InterruptedException ex){
                waitingWriters--;
            }
        }

        waitingWriters--;
        writing=true;
    }

    public static synchronized void write(String s){
       
          if(seats>0)
              seats = seats-1 ;
          
    }
    public  synchronized void stopWriting(){
        writing = false;
        readersTurn =true;
        notifyAll();
    }


    public synchronized void startReading() {

        while(writing || waitingWriters > 0 && !readersTurn ){
            try{
                wait();
            }catch(InterruptedException ex){
            }

        } readers++;
    }
//    public void read() {
//        //MainFrame.Balance.setText(b+"");
//
//    }

    public synchronized void stopReading(){
        --readers;
        readersTurn = false;
        if(readers==0){
            notifyAll();
        }
    }
    public int getTicket(){
        
              return seats;
             
    }
}

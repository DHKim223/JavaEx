package javaProject;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
public class StopWatch {
	public static void main(String[] args) {
	    Timer t = new Timer();
	    TimerTask task = new TimerTask() {
	      int i=1;
	      public void run() {
	        System.out.println("Timer executed at :" + new Date());
	        if(i==5)
	          t.cancel();
	        i=i+1;
	      }
	    };
	    
	    System.out.println("Current time: " + new Date());
	    t.schedule(task, new Date(), 2000);
	  }
}
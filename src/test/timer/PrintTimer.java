package test.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class PrintTimer {

	 public static void main(String[] args) {
	      ScheduledJob job = new ScheduledJob();
	      Timer jobScheduler = new Timer();
	      jobScheduler.scheduleAtFixedRate(job, 1000, 1000);
	      //jobScheduler.schedule(job, 1000, 3000);
	      
	     
	  /*    try {
	    	  System.out.println("ddd");
		         Thread.sleep(20000);
	    	  while(true)
		      {
		    	  Thread.sleep(20000);
		      }
	    	 
	      } catch(InterruptedException ex) {
	         //
	      }
	      jobScheduler.cancel();*/
	   }

}


class ScheduledJob extends TimerTask {
	   
	   public void run() {
	      System.out.println(new Date());
	      try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	}
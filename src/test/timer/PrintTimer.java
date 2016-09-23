package test.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class PrintTimer {

	 public static void main(String[] args) throws Exception {
	      ScheduledJob job = new ScheduledJob();
	      Timer jobScheduler = new Timer();
	      jobScheduler.scheduleAtFixedRate(job, 1000, 1000);
	      //jobScheduler.schedule(job, 1000, 3000);
	    
	      
	     /* while(true){
	    	  System.out.println("1111");
	    	  Thread.sleep(10000);
	      }*/
	    		 
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
	long aa=System.currentTimeMillis();
	
	   public void run() {
	      System.out.println(new Date());
	      
	      if(System.currentTimeMillis()-aa>3000){
	    	  try {
				throw new Exception("time out");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  //System.out.println("time out");
	      }
	      /*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	   }
	}
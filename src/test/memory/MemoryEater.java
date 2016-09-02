package test.memory;

import java.util.Vector;

import util.StringUtil;

public class MemoryEater {

	/**
	 * usage : add "-Xms128m -Xmx256m" into vm argument in run configuration before run
	 * @param args
	 * 2016. 6. 17. ¿ÀÈÄ 4:09:08
	 */
	public static void main(String[] args) {
		Vector v = new Vector();

		while (true) { 
			byte b[] = new byte[1048576];
			v.add(b);
			Runtime rt = Runtime.getRuntime();
			System.out.println("free memory: " + StringUtil.getComma(rt.freeMemory()));
			
			// memory info
			int mb = 1024*1024;
					
			System.out.println("** Used Memory:  " + (rt.totalMemory() - rt.freeMemory()) / mb);
			System.out.println("** Free Memory:  " + rt.freeMemory() / mb);
			System.out.println("** Total Memory: " + rt.totalMemory() / mb);
			System.out.println("** Max Memory:   " + rt.maxMemory() / mb);
		}
	}

}

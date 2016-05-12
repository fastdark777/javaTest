package test.annotation;

import java.lang.reflect.Method;

public class MyhelloExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyHello hello = new MyHello();
		
		try{
			Method method = hello.getClass().getDeclaredMethod("h3ello");
            System.out.println(method.getName());
        if(method.isAnnotationPresent(Count100.class)){
                for(int i = 0; i < 100; i++){
                    hello.hello();
                }
            }else{
            	hello.hello();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }       

	}

}

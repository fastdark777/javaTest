package designPattern.factory;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

	public void test(){
		System.out.println("test");
	}
}

package designPattern.builder;

public class Bottle implements Packing {

	@Override
	public String pack() {
		System.out.println("from rep");
		return "Bottle";
	}

}

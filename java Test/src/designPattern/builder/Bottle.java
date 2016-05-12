package designPattern.builder;

public class Bottle implements Packing {

	@Override
	public String pack() {
		System.out.println("from1 rep");
		return "Bottle";
	}

}

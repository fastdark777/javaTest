package designPattern.factory;

public class ShapeFactory extends AbstractFactory{

	// use getShape method to get object of type shape
	Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();

		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();

		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}

		return null;
	}

	@Override
	Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

}

package robot.commands;

public class Collect extends ConveyWithCollector {

	// Do not raise to 1! This prevents high amper consumption.
	private static final double maxSpeed = 0.7;

	public Collect() {
		super(maxSpeed);
	}
}
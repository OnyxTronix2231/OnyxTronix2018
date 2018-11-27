package robot.commands;

/**
 *
 */
public class Eject extends ConveyWithCollector {

	private static final double maxSpeed = -0.5;

	public Eject() {
		super(maxSpeed);
	}
}

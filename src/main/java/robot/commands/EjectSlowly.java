package robot.commands;

/**
 *
 */
public class EjectSlowly extends ConveyWithCollector {

	private static final double maxSpeed = -0.4;

	public EjectSlowly() {
		super(maxSpeed);
	}
}

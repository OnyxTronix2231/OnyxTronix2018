package robot.commands;

/**
 *
 */
public class Raise extends ChangeCubeElevation {
	public static final double maxSpeed = 0.7;

    public Raise() {
        super(maxSpeed);
    }
}
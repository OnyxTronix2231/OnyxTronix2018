package robot.commands;

/**
 *
 */
public class Lower extends ChangeCubeElevation {
	public static final double maxSpeed = -0.5;

    public Lower() {
        super(maxSpeed);
    }
}

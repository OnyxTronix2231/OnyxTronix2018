package robot.commands;

/**
 *
 */
public class KeepClimberInPlace extends ChangeCubeElevation {
	public static final double maxSpeed = 0.2;

    public KeepClimberInPlace() {
        super(maxSpeed);
    }
    
}

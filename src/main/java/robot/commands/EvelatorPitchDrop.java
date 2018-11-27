package robot.commands;

import robot.Robot;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class EvelatorPitchDrop extends TimedCommand {
	private static final double SPEED = 0.4;

    public EvelatorPitchDrop() {
		super(0.5);
	}



    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_elevatorPitch.setSpeed(SPEED);    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_elevatorPitch.stop();
    }

    // Called when another command which requires one or more of the same
    // robot.subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

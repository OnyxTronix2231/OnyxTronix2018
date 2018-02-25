package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class EvelatorPitchDrop extends TimedCommand {
	private static final double SPEED = 0.3;

    public EvelatorPitchDrop() {
		super(0.5);
	}



    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.m_elevatorPitch.setSpeed(SPEED);    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_elevatorPitch.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

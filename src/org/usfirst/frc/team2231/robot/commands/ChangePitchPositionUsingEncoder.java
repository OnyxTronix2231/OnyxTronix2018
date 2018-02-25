package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangePitchPositionUsingEncoder extends Command {
	double m_setpoint;

    public ChangePitchPositionUsingEncoder(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	m_setpoint = setpoint;
    	requires(Robot.m_elevatorPitch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.m_elevatorPitch.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_elevatorPitch.setPitchSetpoint(m_setpoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.m_elevatorPitch.isPositionOnPoint();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

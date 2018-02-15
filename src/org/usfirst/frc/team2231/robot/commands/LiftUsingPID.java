package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftUsingPID extends Command {
	double m_setpoint;
	
    public LiftUsingPID(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	m_setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.m_elevator.setSetpoint(m_setpoint);
    	Robot.m_elevator.enablePIDController();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.m_elevator.isEleveatorPIDOnPoint();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_elevator.disablePIDController();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

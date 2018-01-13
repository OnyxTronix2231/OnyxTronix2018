package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateByPID extends Command {
	double setpoint;

    public RotateByPID(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.m_driveTrain.resetAHRSGyro();
    	Robot.m_driveTrain.setRotationSetpoint(setpoint);
    	Robot.m_driveTrain.enableRotationPIDControllers();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.m_driveTrain.isRotationPIDOnPoint();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_driveTrain.disableRotationPIDControllers();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

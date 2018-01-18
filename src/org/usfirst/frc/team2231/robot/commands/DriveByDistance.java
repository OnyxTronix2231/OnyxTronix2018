package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByDistance extends Command {
	double setPointRight;
	double setPointLeft;
	double v;
    public DriveByDistance(double setPointRight, double SetPointLeft) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_driveTrain);
    	this.setPointRight = setPointRight;
    	this.setPointLeft = SetPointLeft;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.m_driveTrain.stopByEncoder(setPointRight, setPointLeft);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_driveTrain.driveByProportion(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

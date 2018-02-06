package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveInCircle extends Command {
	double m_setpointRight;
	double m_setpointLeft;
	
    public DriveInCircle(double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_driveTrain);
    	this.m_setpointRight = setPoint;
    	this.m_setpointLeft = setPoint;
    	//change to wheels cycles
    	this.m_setpointRight /= Math.PI * 6;
    	this.m_setpointLeft /= Math.PI * 6;
    }
    
    public DriveInCircle(double setPointRight, double setPointLeft) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_driveTrain);
    	this.m_setpointRight = setPointRight;
    	this.m_setpointLeft = setPointLeft;
    	//change to wheels cycles
    	this.m_setpointRight /= Math.PI * 6;
    	this.m_setpointLeft /= Math.PI * 6;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.m_driveTrain.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_driveTrain.driveInCircleByEncoder(m_setpointRight, m_setpointLeft);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.m_driveTrain.getPositionError();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

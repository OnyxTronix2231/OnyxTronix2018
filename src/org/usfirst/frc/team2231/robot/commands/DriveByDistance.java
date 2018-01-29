package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import com.sun.management.jmx.Trace;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByDistance extends Command {
	double setPointRight;
	double setPointLeft;
	double distanceFinalRight;
	double distanceFinalLeft;
	double v;
    public DriveByDistance(double setPointRight, double setPointLeft) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_driveTrain);
    	this.setPointRight = setPointRight;
    	this.setPointLeft = setPointLeft;
    	this.distanceFinalRight = setPointRight + Robot.m_driveTrain.getDistanceFinalRightByEncoder();
    	this.distanceFinalLeft = setPointLeft + Robot.m_driveTrain.getDistanceFinalLeftByEncoder();
    	System.out.println(this.distanceFinalRight + ", " + this.distanceFinalLeft);
    }
    public DriveByDistance(double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_driveTrain);
    	this.setPointRight = setPoint;
    	this.setPointLeft = setPoint;
    	this.distanceFinalRight = setPoint + Robot.m_driveTrain.getDistanceFinalRightByEncoder();
    	this.distanceFinalLeft = setPoint + Robot.m_driveTrain.getDistanceFinalLeftByEncoder();
    	System.out.println(this.distanceFinalRight + ", " + this.distanceFinalLeft);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("2");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_driveTrain.driveByEncoder(setPointRight, setPointLeft, distanceFinalRight, distanceFinalLeft);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.m_driveTrain.areMotorsStopped();
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

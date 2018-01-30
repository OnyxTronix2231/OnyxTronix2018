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
    	this.distanceFinalRight = setPointRight - Robot.m_driveTrain.getDistanceFinalRightByEncoder() * Robot.m_driveTrain.wheelsRadius * Math.PI;
    	this.distanceFinalLeft = setPointLeft + Robot.m_driveTrain.getDistanceFinalLeftByEncoder() * Robot.m_driveTrain.wheelsRadius * Math.PI;
    	System.out.println("distanceFinalRight"+this.distanceFinalRight + ", distanceFinalRight " + this.distanceFinalLeft);
    }
    public DriveByDistance(double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_driveTrain);
    	System.out.println("1");
    	this.setPointRight = setPoint;
    	this.setPointLeft = setPoint;
    	this.distanceFinalRight = setPoint - Robot.m_driveTrain.getDistanceFinalRightByEncoder() * Robot.m_driveTrain.wheelsRadius * Math.PI;
    	this.distanceFinalLeft = setPoint + Robot.m_driveTrain.getDistanceFinalLeftByEncoder() * Robot.m_driveTrain.wheelsRadius * Math.PI;    	
    	System.out.println("distanceFinalRight"+ Robot.m_driveTrain.getDistanceFinalRightByEncoder() + ", distanceFinalRight " + Robot.m_driveTrain.getDistanceFinalLeftByEncoder());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println(this.setPointRight +", "+ this.setPointLeft +", "+ this.distanceFinalRight +", "+ this.distanceFinalLeft);
    	System.out.println("2");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(this.setPointRight +", "+ this.setPointLeft);
    	System.out.println(this.distanceFinalRight + ", " + this.distanceFinalLeft);
    	System.out.println("distanceFinalRight"+ Robot.m_driveTrain.getDistanceFinalRightByEncoder() + ", distanceFinalRight " + Robot.m_driveTrain.getDistanceFinalLeftByEncoder());
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

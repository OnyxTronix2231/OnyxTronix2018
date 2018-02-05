package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByJoystick extends Command {

    public DriveByJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_driveTrain.arcadeDrive(Robot.m_oi.getDriveStick());
    	System.out.println("FirstLeft: " + Robot.m_driveTrain.firstLeft.get());
    	System.out.println("FirstRight: " + Robot.m_driveTrain.firstRight.get());
    	System.out.println("SecondLeft: " + Robot.m_driveTrain.secondLeft.get());
    	System.out.println("SecondRight: " + Robot.m_driveTrain.secondRight.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

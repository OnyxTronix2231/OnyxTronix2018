package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightWithPID extends Command {

    public DriveStraightWithPID() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.m_driveTrain.resetAHRSGyro();
    	Robot.m_driveTrain.setRotationSetpoint(0);
    	Robot.m_driveTrain.setOutputRange();
    	Robot.m_driveTrain.enableRotationPIDControllers();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_driveTrain.setF2(-Robot.m_oi.getDriveStick().getRawAxis(1));
    	System.out.println("Angle: " + Robot.m_driveTrain.getAngle());
    	System.out.println("Controller: " + RobotMap.driveTrainLeftRotationPIDController.get());
    	System.out.println("Talons: " + RobotMap.driveTrainleftTalons.get());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
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

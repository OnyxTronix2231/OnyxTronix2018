package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByEncoder extends Command {
	double m_setpoint;

    public DriveByEncoder(double setpoint) {
        m_setpoint = setpoint;
    	requires(Robot.m_driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.m_driveTrain.resetEncoder();
    	Robot.m_driveTrain.setPositionOutputRange();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_driveTrain.setPositionSetpoint(m_setpoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	return Robot.m_driveTrain.getPositionError();
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_driveTrain.resetPositionOutputRange();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

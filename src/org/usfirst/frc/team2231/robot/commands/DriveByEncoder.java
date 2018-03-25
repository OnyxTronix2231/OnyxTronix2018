package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VelocityMeasPeriod;

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
		Robot.m_robotMap.driveTrainFirstLeft.setNeutralMode(NeutralMode.Brake);
		Robot.m_robotMap.driveTrainFirstRight.setNeutralMode(NeutralMode.Brake);
		Robot.m_robotMap.driveTrainSecondRight.setNeutralMode(NeutralMode.Brake);
		Robot.m_robotMap.driveTrainSecondLeft.setNeutralMode(NeutralMode.Brake);
		Robot.m_driveTrain.setPositionOutputRange();
		Robot.m_driveTrain.setPositionSetpoint(m_setpoint);
//		try {
//			Thread.sleep(150);
//		} catch (InterruptedException e) {
//		}
		System.out.println("1");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.m_driveTrain.setPositionSetpoint(m_setpoint);
		System.out.println(Robot.m_driveTrain.firstRight.get());
		System.out.println(Robot.m_driveTrain.firstLeft.get());
		System.out.println("2");
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		System.out.println("3");
		return Robot.m_driveTrain.getPositionError();
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("4");
		Robot.m_driveTrain.resetPositionOutputRange();
		Robot.m_driveTrain.setSpeed(-0.1);
		Robot.m_robotMap.driveTrainSecondRight.setNeutralMode(NeutralMode.Coast);
		Robot.m_robotMap.driveTrainSecondLeft.setNeutralMode(NeutralMode.Coast);
		System.out.println("Left Stop " + Robot.m_driveTrain.firstLeft.getSensorCollection().getQuadraturePosition());
		System.out.println("Right Stop" + Robot.m_driveTrain.firstRight.getSensorCollection().getQuadraturePosition());
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}

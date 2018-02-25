package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.commands.DriveByJoystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	public static final WPI_TalonSRX firstLeft = Robot.m_robotMap.driveTrainFirstLeft;
	public static final WPI_TalonSRX secondLeft = Robot.m_robotMap.driveTrainSecondLeft;
	public static final WPI_TalonSRX thirdLeft = Robot.m_robotMap.driveTrainThirdLeft;
	public static final WPI_TalonSRX firstRight = Robot.m_robotMap.driveTrainFirstRight;
	public static final WPI_TalonSRX secondRight = Robot.m_robotMap.driveTrainSecondRight;
	public static final WPI_TalonSRX thirdRight = Robot.m_robotMap.driveTrainThirdRight;
	public static final DifferentialDrive robotDrive = Robot.m_robotMap.driveTrainRobotDrive;
	public static final SpeedControllerGroup leftTalons = Robot.m_robotMap.driveTrainleftTalons;
	public static final SpeedControllerGroup rightTalons = Robot.m_robotMap.driveTrainRightTalons;
	public static final AHRS m_navX = Robot.m_robotMap.driveTrainNavX;
	public static final PIDController leftRotationPIDController = Robot.m_robotMap.driveTrainLeftRotationPIDController;
	public static final PIDController rightRotationPIDController = Robot.m_robotMap.driveTrainRightRotationPIDController;
	public final double m_rotation_Absolute_Tolerence = 1;
	public final double wheelRadius = 2;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveByJoystick());
	}

	public void arcadeDrive(final Joystick stick) {
		robotDrive.arcadeDrive(-stick.getRawAxis(1), stick.getRawAxis(4) * 0.7);
	}

	public void resetAHRSGyro() {
		m_navX.reset();
	}

	public double getAngle() {
		return m_navX.getAngle();
	}

	public void setRotationSetpoint(final double setpoint) {
		rightRotationPIDController.setSetpoint(setpoint);
		leftRotationPIDController.setSetpoint(setpoint);
	}

	public void enableRotationPIDControllers() {
		rightRotationPIDController.enable();
		leftRotationPIDController.enable();
	}

	public void setRotationTolerance() {
		leftRotationPIDController.setAbsoluteTolerance(m_rotation_Absolute_Tolerence);
		rightRotationPIDController.setAbsoluteTolerance(m_rotation_Absolute_Tolerence);
	}

	public boolean isRotationPIDOnPoint() {
		return rightRotationPIDController.onTarget() && leftRotationPIDController.onTarget() && leftTalons.get() < 0.05;
	}

	public void stop() {
		leftTalons.stopMotor();
		rightTalons.stopMotor();
	}

	public void disableRotationPIDControllers() {
		leftRotationPIDController.disable();
		rightRotationPIDController.disable();
	}

	public void setOutputRange() {
		leftRotationPIDController.setOutputRange(-1, 1);
		rightRotationPIDController.setOutputRange(-1, 1);
	}

	public void resetEncoder() {
		firstLeft.getSensorCollection().setQuadraturePosition(0, 0);
		firstRight.getSensorCollection().setQuadraturePosition(0, 0);
	}

	public void setPositionOutputRange() {
		firstLeft.configPeakOutputForward(0.50, 0);
		firstLeft.configPeakOutputReverse(-0.50, 0);
		firstRight.configPeakOutputForward(0.50, 0);
		firstRight.configPeakOutputReverse(-0.50, 0);

	}

	public void resetPositionOutputRange() {
		firstLeft.configPeakOutputForward(1, 0);
		firstLeft.configPeakOutputReverse(-1, 0);
		firstRight.configPeakOutputForward(1, 0);
		firstRight.configPeakOutputReverse(-1, 0);
	}

	public void setPositionSetpoint(double setpoint) {
		setpoint = convertToEncoderValue(setpoint);
		firstLeft.set(ControlMode.Position, setpoint);
		firstRight.set(ControlMode.Position, -setpoint);
		secondLeft.set(ControlMode.Follower, firstLeft.getDeviceID());
		secondRight.set(ControlMode.Follower, firstRight.getDeviceID());
	}

	public boolean getPositionError() {
		return Math.abs(firstLeft.getClosedLoopError(0)) < 40 && Math.abs(firstRight.getClosedLoopError(0)) < 40;
	}

	public double convertToEncoderValue(double distanceInCentimeters) {
		distanceInCentimeters /= 2 * Math.PI * wheelRadius;
		distanceInCentimeters *= 281.847;
		return distanceInCentimeters;
	}
}

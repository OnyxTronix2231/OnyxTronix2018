package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.commands.DriveByJoystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
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
	public static final WPI_TalonSRX firstRight = Robot.m_robotMap.driveTrainFirstRight;
	public static final WPI_TalonSRX secondRight = Robot.m_robotMap.driveTrainSecondRight;
	public static final DifferentialDrive robotDrive = Robot.m_robotMap.driveTrainRobotDrive;
	public static final SpeedControllerGroup leftTalons = Robot.m_robotMap.driveTrainleftTalons;
	public static final SpeedControllerGroup rightTalons = Robot.m_robotMap.driveTrainRightTalons;
	public static PIDController driveTrainLeftRotationPIDController = Robot.m_robotMap.driveTrainLeftRotationPIDController;
	public static PIDController driveTrainRightRotationPIDController = Robot.m_robotMap.driveTrainRightRotationPIDController;
	public static AHRS driveTrainNavX = Robot.m_robotMap.driveTrainNavX;
	public static final double driveTrainDistanceP = Robot.m_robotMap.driveTrainDistanceP;
	public static final double driveTrainDistanceI = Robot.m_robotMap.driveTrainDistanceI;
	public static final double driveTrainDistanceD = Robot.m_robotMap.driveTrainDistanceD;
	public static double driveTrainRightTalonsP;
	public static double driveTrainLeftTalonsP;
	public static double tolerance = Robot.m_robotMap.tolerance;
	public static double toleranceRight;
	public static double toleranceLeft;
	public static final double wheelsRadius = 6;

	public static final AHRS m_navX = Robot.m_robotMap.driveTrainNavX;
	public static final PIDController leftRotationPIDController = Robot.m_robotMap.driveTrainLeftRotationPIDController;
	public static final PIDController rightRotationPIDController = Robot.m_robotMap.driveTrainRightRotationPIDController;
	public final double rotation_Absolute_Tolerence = 1;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveByJoystick());
	}

	public void initPID() {
		firstLeft.set(ControlMode.Velocity, 3);
		firstLeft.set(4);
	}

	public void arcadeDrive(Joystick stick) {
		robotDrive.arcadeDrive(-stick.getRawAxis(1), stick.getRawAxis(4));
	}
	
	public void initPid() {
		firstRight.set(ControlMode.Position, 0);
		firstLeft.set(ControlMode.Position, 0);
		secondRight.set(ControlMode.Follower, 2);
		secondLeft.set(ControlMode.Follower, 0);
	}

	public void driveByProportion(double right, double left) {
		leftTalons.set(left);
		rightTalons.set(right);
	}

	public void setPsitionSetpoint(double setpointRight, double setpointLeft) {
		firstRight.set(-setpointRight);
		firstLeft.set(setpointLeft);
	}

	public double getDistanceFinalRightByEncoder() {
		return firstRight.getSensorCollection().getQuadraturePosition();
	}

	public double getDistanceFinalLeftByEncoder() {
		return firstLeft.getSensorCollection().getQuadraturePosition();
	}

	public void driveByEncoder(double distanceRight, double distanceLeft, double distanceFinalRight,double DistanceFinalLeft) {
		double v, dRight, dLeft;
		dRight = distanceFinalRight + firstRight.getSensorCollection().getQuadraturePosition();
		dLeft = DistanceFinalLeft - firstLeft.getSensorCollection().getQuadraturePosition();
		if (distanceRight > distanceLeft) {
			v = distanceLeft / distanceRight;
			driveTrainRightTalonsP = driveTrainDistanceP * (1 - ((1-v) / 2));
			driveTrainLeftTalonsP = driveTrainDistanceP * (1 + ((1-v) / 2));
		} 
		else {
			v = distanceRight / distanceLeft;
			driveTrainRightTalonsP = driveTrainDistanceP * (0.5 + ((1-v) / 2));
			driveTrainLeftTalonsP = driveTrainDistanceP * (1.5 - ((1-v) / 2));
		}
		System.out.println("the lower speed: " + v);
		System.out.println("distance left in the right side" + dRight);
		System.out.println("distance left in the left side" + dLeft);
		System.out.println("P from PID right: " + driveTrainRightTalonsP);
		System.out.println("P from PID left: " + driveTrainLeftTalonsP);
		firstLeft.config_kP(0, driveTrainDistanceP, 0);
		firstLeft.config_kI(0, driveTrainDistanceI, 0);
		firstLeft.config_kD(0, driveTrainDistanceD, 0);
		firstRight.config_kP(0, driveTrainDistanceP, 0);
		firstRight.config_kI(0, driveTrainDistanceI, 0);
		firstRight.config_kD(0, driveTrainDistanceD, 0);
		setPsitionSetpoint(dRight, dLeft);
	}

	public boolean areMotorsStopped() {
		boolean check = leftTalons.get() == 0 && rightTalons.get() == 0;
		System.out.println(check);
		return check;
	}

	public void resetAHRSGyro() {
		m_navX.reset();
	}

	public double getAngle() {
		return m_navX.getAngle();
	}

	public void setRotationSetpoint(double setpoint) {
		rightRotationPIDController.setSetpoint(setpoint);
		leftRotationPIDController.setSetpoint(setpoint);
	}

	public void enableRotationPIDControllers() {
		rightRotationPIDController.enable();
		leftRotationPIDController.enable();
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
}

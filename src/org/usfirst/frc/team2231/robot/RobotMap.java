/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2231.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;


import OnyxTronix.LineTracker;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static WPI_TalonSRX driveTrainFirstLeft;
	public static WPI_TalonSRX driveTrainSecondLeft;
//	public static WPI_TalonSRX driveTrainThirdLeft;
	public static WPI_TalonSRX driveTrainFirstRight;
	public static WPI_TalonSRX driveTrainSecondRight;
//	public static WPI_TalonSRX driveTrainThirdRight;
	public static DifferentialDrive driveTrainRobotDrive;
	public static SpeedControllerGroup driveTrainleftTalons;
	public static SpeedControllerGroup driveTrainRightTalons;
	public static WPI_TalonSRX collectorLeftWheel;
	public static WPI_TalonSRX collectorRightWheel;
	public static AHRS driveTrainNavX;
	public static PIDController driveTrainLeftRotationPIDController;
	public static PIDController driveTrainRightRotationPIDController;
	public SpeedControllerGroup collectorWheels;
	public DigitalInput collectorMicroSwitch;
	private WPI_TalonSRX elevatorLeftMotor;
	private WPI_TalonSRX elevatorRightMotor;
	public LineTracker collectorLineTracker;
	public SpeedControllerGroup elevatorWheels;
	public WPI_TalonSRX elevatorPitchMotor;
	public DoubleSolenoid collectorHolderPiston;

	public RobotMap() {
		driveTrainFirstLeft = new WPI_TalonSRX(0);
		driveTrainSecondLeft = new WPI_TalonSRX(1);
		driveTrainleftTalons = new SpeedControllerGroup(driveTrainFirstLeft, driveTrainSecondLeft);

		driveTrainFirstRight = new WPI_TalonSRX(2);
		driveTrainSecondRight = new WPI_TalonSRX(3);
		driveTrainRightTalons = new SpeedControllerGroup(driveTrainFirstRight, driveTrainSecondRight);
		driveTrainRobotDrive = new DifferentialDrive(driveTrainleftTalons, driveTrainRightTalons);
		

		driveTrainNavX = new AHRS(SPI.Port.kMXP);	
		
		driveTrainLeftRotationPIDController = new PIDController(0.0425, 0, 0.1, driveTrainNavX, driveTrainleftTalons);
		driveTrainRightRotationPIDController = new PIDController(0.0425, 0, 0.1, driveTrainNavX, driveTrainRightTalons);
		driveTrainFirstLeft.config_kP(0, 1, 0);
		driveTrainFirstLeft.config_kI(0, 0, 0);
		driveTrainFirstLeft.config_kD(0, 0, 0);
		driveTrainFirstRight.config_kP(0, 1, 0);
		driveTrainFirstRight.config_kI(0, 0, 0);
		driveTrainFirstRight.config_kD(0, 0, 0);
		driveTrainFirstLeft.configAllowableClosedloopError(0, 3, 0);
		collectorLeftWheel = new WPI_TalonSRX(4);
		collectorRightWheel = new WPI_TalonSRX(5);
		collectorWheels = new SpeedControllerGroup(collectorLeftWheel, collectorRightWheel);
		collectorHolderPiston = new DoubleSolenoid(0, 1);

		elevatorLeftMotor = new WPI_TalonSRX(6);
		elevatorRightMotor = new WPI_TalonSRX(7);
		elevatorWheels = new SpeedControllerGroup(elevatorLeftMotor, elevatorRightMotor);
		
		elevatorPitchMotor = new WPI_TalonSRX(8);

		collectorLineTracker = new LineTracker(2, 4);
	}
}

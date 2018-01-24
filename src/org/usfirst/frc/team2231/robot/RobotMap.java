/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2231.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS.SerialDataType;
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
	public static WPI_TalonSRX elevatorFirstMotor;
	public static WPI_TalonSRX elevatorSecondMotor;
	public static AHRS driveTrainAhrs;
	public static PIDController driveTrainLeftRotationPIDController;
	public static PIDController driveTrainRightRotationPIDController;
	
	public RobotMap() {
		//DriveTrain
		driveTrainFirstLeft = new WPI_TalonSRX(0);
		driveTrainSecondLeft = new WPI_TalonSRX(1);
		driveTrainleftTalons = new SpeedControllerGroup(driveTrainFirstLeft, driveTrainSecondLeft);
		
		driveTrainFirstRight= new WPI_TalonSRX(2);
		driveTrainSecondRight = new WPI_TalonSRX(3);
		driveTrainRightTalons = new SpeedControllerGroup(driveTrainFirstRight, driveTrainSecondRight);
		
		driveTrainRobotDrive = new DifferentialDrive(driveTrainleftTalons, driveTrainRightTalons);
		
		driveTrainAhrs = new AHRS(SPI.Port.kMXP);	
		
		driveTrainLeftRotationPIDController = new PIDController(1, 0, 0.2, driveTrainAhrs, driveTrainleftTalons);
		driveTrainRightRotationPIDController = new PIDController(1, 0, 0.2, driveTrainAhrs, driveTrainRightTalons);
    	driveTrainLeftRotationPIDController.setAbsoluteTolerance(Robot.m_driveTrain.rotation_Absolute_Tolerence);
    	driveTrainRightRotationPIDController.setAbsoluteTolerance(Robot.m_driveTrain.rotation_Absolute_Tolerence);
		
		//collectorLeftWheel = new WPI_TalonSRX(/);
		//collectorRightWheel = new WPI_TalonSRX(/);
	}
}

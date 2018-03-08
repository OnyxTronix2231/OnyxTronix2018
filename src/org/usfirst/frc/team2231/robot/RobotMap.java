/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2231.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import OnyxTronix.LineTracker;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
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
	public WPI_TalonSRX driveTrainFirstLeft;
	public WPI_TalonSRX driveTrainSecondLeft;
	public WPI_TalonSRX driveTrainThirdLeft;
	public WPI_TalonSRX driveTrainFirstRight;
	public WPI_TalonSRX driveTrainSecondRight;
	public DifferentialDrive driveTrainRobotDrive;
	public WPI_TalonSRX driveTrainThirdRight;
	public SpeedControllerGroup driveTrainleftTalons;
	public SpeedControllerGroup driveTrainRightTalons;
	public WPI_VictorSPX collectorLeftWheel;
	public WPI_VictorSPX collectorRightWheel;
	public AHRS driveTrainNavX;
	public PIDController driveTrainLeftRotationPIDController;
	public PIDController driveTrainRightRotationPIDController;
	public SpeedControllerGroup collectorWheels;
	public WPI_TalonSRX elevatorFirstMotor;
	public WPI_VictorSPX elevatorSecondMotor;
	public WPI_VictorSPX elevatorThirdMotor;
	public WPI_VictorSPX elevatorFourthMotor;
	public LineTracker collectorLineTracker;
	public SpeedControllerGroup elevatorWheels;
	public WPI_TalonSRX elevatorPitchMotor;
	public DoubleSolenoid collectorHolderPistonLeft;
	public DoubleSolenoid collectorHolderPistonRight;
	private final PIDCalibrationHolder rotationRugRobotA = new PIDCalibrationHolder(0.05, 0, 0.1);
	private final PIDCalibrationHolder rotationRugRobotB = new PIDCalibrationHolder(0.0425, 0, 0.1);
	private final PIDCalibrationHolder rotationFloorRobotB = new PIDCalibrationHolder(0.19, 0, 0.035);
	public Compressor compressor;

	public RobotMap() {
		driveTrainFirstLeft = new WPI_TalonSRX(0);
		driveTrainSecondLeft = new WPI_TalonSRX(1);
		driveTrainThirdLeft = new WPI_TalonSRX(2);

		driveTrainleftTalons = new SpeedControllerGroup(driveTrainFirstLeft, driveTrainSecondLeft);

		driveTrainFirstRight = new WPI_TalonSRX(3);
		driveTrainSecondRight = new WPI_TalonSRX(4);
		driveTrainThirdRight = new WPI_TalonSRX(5);
		driveTrainRightTalons = new SpeedControllerGroup(driveTrainFirstRight, driveTrainSecondRight);
		driveTrainRobotDrive = new DifferentialDrive(driveTrainleftTalons, driveTrainRightTalons);

		driveTrainNavX = new AHRS(SPI.Port.kMXP);

		driveTrainLeftRotationPIDController = new PIDController(rotationRugRobotA.getP(), rotationRugRobotA.getI(),
				rotationRugRobotA.getD(), driveTrainNavX, driveTrainleftTalons);
		driveTrainRightRotationPIDController = new PIDController(rotationRugRobotA.getP(), rotationRugRobotA.getI(),
				rotationRugRobotA.getD(), driveTrainNavX, driveTrainRightTalons);
		driveTrainSecondLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		driveTrainFirstRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		driveTrainFirstLeft.config_kP(0, 0.3, 0);
		driveTrainFirstLeft.config_kI(0, 0, 0);
		driveTrainFirstLeft.config_kD(0, 0, 0);
		driveTrainFirstRight.config_kP(0, 1, 0);
		driveTrainFirstRight.config_kI(0, 0, 0);
		driveTrainFirstRight.config_kD(0, 0, 0);
		driveTrainFirstLeft.configAllowableClosedloopError(0, 3, 0);
		driveTrainFirstRight.configAllowableClosedloopError(0, 3, 0);
		
		
		collectorLeftWheel = new WPI_VictorSPX(6);
		collectorRightWheel = new WPI_VictorSPX(7);
		collectorRightWheel.setInverted(true);
		
		collectorWheels = new SpeedControllerGroup(collectorLeftWheel, collectorRightWheel);
		collectorHolderPistonLeft = new DoubleSolenoid(0,7);
		collectorHolderPistonRight = new DoubleSolenoid(2, 3);

		elevatorFirstMotor = new WPI_TalonSRX(8);
		elevatorSecondMotor = new WPI_VictorSPX(9);
		elevatorThirdMotor = new WPI_VictorSPX(10);
		elevatorFourthMotor = new WPI_VictorSPX(11);
		elevatorWheels = new SpeedControllerGroup(elevatorFirstMotor, elevatorSecondMotor, elevatorThirdMotor,
				elevatorFourthMotor);
		elevatorFirstMotor.setInverted(true);
		elevatorSecondMotor.setInverted(true);
		elevatorThirdMotor.setInverted(true);
		elevatorFourthMotor.setInverted(true);

		elevatorPitchMotor = new WPI_TalonSRX(12);

		collectorLineTracker = new LineTracker(2, 4);
		
		compressor = new Compressor();
		compressor.setClosedLoopControl(true);
		driveTrainFirstLeft.configPeakOutputForward(1, 0);
		driveTrainFirstLeft.configPeakOutputReverse(-1, 0);
		driveTrainSecondLeft.configPeakOutputForward(1, 0);
		driveTrainSecondLeft.configPeakOutputReverse(-1, 0);
		driveTrainFirstRight.configPeakOutputForward(1, 0);
		driveTrainFirstRight.configPeakOutputReverse(-1, 0);
		driveTrainSecondRight.configPeakOutputForward(1, 0);
		driveTrainSecondRight.configPeakOutputReverse(-1, 0);
		
		driveTrainFirstLeft.enableCurrentLimit(false);
		driveTrainSecondLeft.enableCurrentLimit(false);
		driveTrainFirstRight.enableCurrentLimit(false);
		driveTrainSecondRight.enableCurrentLimit(false);
	}
}

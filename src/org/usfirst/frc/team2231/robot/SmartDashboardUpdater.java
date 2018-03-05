package org.usfirst.frc.team2231.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilderImpl;

public class SmartDashboardUpdater {

	private static final double height = 0;
	private NetworkTableEntry upperMicroswitch;
	private NetworkTableEntry lowerMicroswitch;
	private NetworkTableEntry cubeCollected;
	private NetworkTableEntry leftEncoderPosition;
	private NetworkTableEntry rightEncoderPosition;

	private NetworkTableEntry pidEncoders;
	private NetworkTableEntry errorGraphEncoders;
	private NetworkTableEntry leftEncoder;
	private NetworkTableEntry rightEncoder;

	private NetworkTableEntry pidRotation;
	private NetworkTableEntry gyro;
	private NetworkTableEntry navXErrorGraph;

	private NetworkTableEntry pidElevator;
	private NetworkTableEntry elevatorHeight;
	private NetworkTableEntry errorGraphElevator;

	private NetworkTableEntry pidPitch;
	private NetworkTableEntry errorGraphElevatorPitch;
	private NetworkTableEntry angle;

	private NetworkTableEntry pdp;
	private NetworkTableEntry driveTrainFirstLeft;
	private NetworkTableEntry driveTrainSecondLeft;
	private NetworkTableEntry driveTrainFirstRight;
	private NetworkTableEntry driveTrainSecondRight;
	private NetworkTableEntry elevatorFirst;
	private NetworkTableEntry elevatorSecond;
	private NetworkTableEntry elevatorThird;
	private NetworkTableEntry elevatorFourth;
	private NetworkTableEntry elevatorPitch;
	private NetworkTableEntry collectorRight;
	private NetworkTableEntry collectorLeft;

	private static SendableBuilderImpl m_sendableBuilder;

	public SmartDashboardUpdater() {
		NetworkTableInstance defaultInst = NetworkTableInstance.getDefault();
		NetworkTable driversTable = defaultInst.getTable("Drivers");
		upperMicroswitch = driversTable.getEntry("upperMicroSwitch");
		lowerMicroswitch = driversTable.getEntry("lowerMicroSwitch");
		cubeCollected = driversTable.getEntry("is cube collected");
		leftEncoderPosition = driversTable.getEntry("Left Encoder Position");
		rightEncoderPosition = driversTable.getEntry("Right Encoder Position");

		NetworkTable pidDriveEncoders = defaultInst.getTable("PID Encoders");
		pidEncoders = pidDriveEncoders.getEntry("PID");
		errorGraphEncoders = pidDriveEncoders.getEntry("Error Graph");
		leftEncoder = pidDriveEncoders.getEntry("Left Encoder");
		rightEncoder = pidDriveEncoders.getEntry("Right Encoder");

		NetworkTable navXPidRotation = defaultInst.getTable("PID Rotation");
		pidRotation = navXPidRotation.getEntry("PID");
		gyro = navXPidRotation.getEntry("Gyro");
		navXErrorGraph = navXPidRotation.getEntry("Error Graph");

		NetworkTable pidElevatorHeight = defaultInst.getTable("PID Elevator Height");
		pidElevator = pidElevatorHeight.getEntry("PID");
		elevatorHeight = pidElevatorHeight.getEntry("Elevator's Height");
		errorGraphElevator = pidElevatorHeight.getEntry("Error Graph");

		NetworkTable pidElevatorPitch = defaultInst.getTable("PID Elevator Pitch");
		pidPitch = pidElevatorPitch.getEntry("PID");
		errorGraphElevatorPitch = pidElevatorPitch.getEntry("Error Graph");
		angle = pidElevatorPitch.getEntry("Angle");

		NetworkTable electronicTable = defaultInst.getTable("Electronic");
		pdp = electronicTable.getEntry("PDP");
		driveTrainFirstLeft = electronicTable.getEntry("Drive Train First Left ID-0");
		driveTrainSecondLeft = electronicTable.getEntry("Drive Train Second Left ID-1");
		driveTrainFirstRight = electronicTable.getEntry("Drive Train First Right ID-3");
		elevatorFirst = electronicTable.getEntry("Elevator First ID-8");
		elevatorSecond = electronicTable.getEntry("Elevator Second ID-9");
		elevatorThird = electronicTable.getEntry("Elevator Third ID-10");
		elevatorFourth = electronicTable.getEntry("Elevator Fourth ID-11");
		elevatorPitch = electronicTable.getEntry("Elevator Pitch ID-12");
		collectorRight = electronicTable.getEntry("Collector Right ID-7");
		collectorLeft = electronicTable.getEntry("Collector Left ID-6");

		m_sendableBuilder = new SendableBuilderImpl();
	}

	public void updateDashboard() {
		// upperMicroswitch.setBoolean();
		// lowerMicroswitch.setBoolean();
		putData(pidRotation.getName(), Robot.m_robotMap.driveTrainLeftRotationPIDController,
				pidRotation.getInstance().getTable("PID Rotation"));
		cubeCollected.setBoolean(Robot.m_collector.isCubeCollected());
		leftEncoderPosition.setDouble(Robot.m_driveTrain.getLeftEncoderPosition());
		rightEncoderPosition.setDouble(Robot.m_driveTrain.getRightEncoderPosition());

		// pidEncoders.set
		// errorGraphEncoders.setDouble();
		leftEncoder.setDouble(Robot.m_driveTrain.getLeftEncoderPosition());
		rightEncoder.setDouble(Robot.m_driveTrain.getRightEncoderPosition());

		gyro.setDouble(Robot.m_driveTrain.getAngle());
		navXErrorGraph.setDouble(Robot.m_driveTrain.getAngle());

		putData(pidElevator.getName(), Robot.m_robotMap.elevatorFirstMotor, pidElevator.getInstance().getTable("PID"));
		elevatorHeight.setDouble(Potentiometer.getFixedVoltage(height));
		// errorGraphElevator.setDouble();

		putData(pidPitch.getName(), Robot.m_robotMap.elevatorPitchMotor, pidPitch.getInstance().getTable("PID"));
		// errorGraphElevatorPitch.setDouble();
		// angle.setDouble();

		// pdp.set
		if (!Robot.m_robotMap.driveTrainFirstLeft.isAlive())
			driveTrainFirstLeft.setBoolean(false);
		if (!Robot.m_robotMap.driveTrainSecondLeft.isAlive())
			driveTrainSecondLeft.setBoolean(false);
		if (!Robot.m_robotMap.driveTrainFirstRight.isAlive())
			driveTrainFirstRight.setBoolean(false);
		if (!Robot.m_robotMap.driveTrainSecondRight.isAlive())
			driveTrainSecondRight.setBoolean(false);
		if (!Robot.m_robotMap.elevatorFirstMotor.isAlive())
			elevatorFirst.setBoolean(false);
		if (!Robot.m_robotMap.elevatorSecondMotor.isAlive())
			elevatorSecond.setBoolean(false);
		if (!Robot.m_robotMap.elevatorThirdMotor.isAlive())
			elevatorThird.setBoolean(false);
		if (!Robot.m_robotMap.elevatorFourthMotor.isAlive())
			elevatorFourth.setBoolean(false);
		if (!Robot.m_robotMap.elevatorPitchMotor.isAlive())
			elevatorPitch.setBoolean(false);
		if (!Robot.m_robotMap.collectorRightWheel.isAlive())
			collectorRight.setBoolean(false);
		if (!Robot.m_robotMap.collectorLeftWheel.isAlive())
			collectorLeft.setBoolean(false);
	}

	public static synchronized void putData(String key, Sendable data, NetworkTable table) {
		System.out.println("getting subtable" + table.getPath() + " and key " + key);
		System.out.println("entry path is " + table.getPath());
		m_sendableBuilder.setTable(table);
		data.initSendable(m_sendableBuilder);
		m_sendableBuilder.updateTable();
		m_sendableBuilder.startListeners();
		table.getEntry(".name").setString(key);
	}
}
package org.usfirst.frc.team2231.robot;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
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
	private NetworkTableEntry errorGraphEncodersLeft;
	private NetworkTableEntry errorGraphEncodersRight;
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
	
	private NetworkTableEntry holderPistons;

	private static SendableBuilderImpl m_sendableBuilder;
	private static Map<String, Data> tablesToData;

	public SmartDashboardUpdater() {
		NetworkTableInstance defaultInst = NetworkTableInstance.getDefault();
		NetworkTable driversTable = defaultInst.getTable("Drivers");
		upperMicroswitch = driversTable.getEntry("upperMicroSwitch");
		lowerMicroswitch = driversTable.getEntry("lowerMicroSwitch");
		cubeCollected = driversTable.getEntry("is cube collected");
		leftEncoderPosition = driversTable.getEntry("Left Encoder Position");
		rightEncoderPosition = driversTable.getEntry("Right Encoder Position");
		holderPistons = driversTable.getEntry("Holder Pistons");

		NetworkTable pidDriveEncoders = defaultInst.getTable("PID Encoders");
		pidEncoders = pidDriveEncoders.getEntry("PID");
		errorGraphEncodersLeft = pidDriveEncoders.getEntry("Left Error Graph");
		errorGraphEncodersRight = pidDriveEncoders.getEntry("Right Error Graph");
		
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
		
		tablesToData = new HashMap<>();
	}

	public void updateDashboard() {
		upperMicroswitch.setBoolean(Robot.m_elevator.firstMotor.getSensorCollection().isFwdLimitSwitchClosed());
		lowerMicroswitch.setBoolean(Robot.m_elevator.firstMotor.getSensorCollection().isRevLimitSwitchClosed());
		cubeCollected.setBoolean(Robot.m_collector.isCubeCollected());
		leftEncoderPosition.setDouble(Robot.m_driveTrain.getLeftEncoderPosition());
		rightEncoderPosition.setDouble(Robot.m_driveTrain.getRightEncoderPosition());
//		holderPistons.setBoolean(Robot.m_robotMap.switchPiston.get());

//		putData(pidEncoders.getName(), );
		errorGraphEncodersLeft.setNumber(Robot.m_driveTrain.firstLeft.getClosedLoopError(0));
		errorGraphEncodersRight.setNumber(Robot.m_driveTrain.firstRight.getClosedLoopError(0));
		leftEncoder.setDouble(Robot.m_driveTrain.getLeftEncoderPosition());
		rightEncoder.setDouble(Robot.m_driveTrain.getRightEncoderPosition());

		gyro.setDouble(Robot.m_driveTrain.getAngle());
		navXErrorGraph.setDouble(Robot.m_driveTrain.getAngle());
		putDataTest("PID", Robot.m_robotMap.driveTrainLeftRotationPIDController,
				pidRotation.getInstance().getTable("PID Rotation"));

		putDataTest("PID", Robot.m_robotMap.elevatorPIDController, pidElevator.getInstance().getTable("PID Elevator Height"));
		errorGraphElevator.setNumber(Robot.m_elevator.firstMotor.getClosedLoopError(0));
		elevatorHeight.setDouble(Potentiometer.getFixedVoltage(height));
		

//		putDataTest("PID", Robot.m_robotMap.elevatorPitchPIDController, pidPitch.getInstance().getTable("PID Elevator Pitch"));
		errorGraphElevatorPitch.setNumber(Robot.m_robotMap.elevatorPitchMotor.getClosedLoopError(0));
		angle.setDouble(Robot.m_robotMap.elevatorPitchMotor.getSensorCollection().getQuadraturePosition());

		putDataTest("PDPModule", Robot.m_robotMap.pdpModule, pdp.getInstance().getTable("Electronic"));
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
		m_sendableBuilder.setTable(table);
		data.initSendable(m_sendableBuilder);
		m_sendableBuilder.updateTable();
		m_sendableBuilder.startListeners();
		table.getEntry(".name").setString(key);
	}
	public static synchronized void putDataTest(String key, Sendable data, NetworkTable table) {
	    Data sddata = tablesToData.get(key);
	    if (sddata == null || sddata.m_sendable != data) {
	      if (sddata != null) {
	        sddata.m_builder.stopListeners();
	      }
	      sddata = new Data(data);
	      tablesToData.put(key, sddata);
	      NetworkTable dataTable = table.getSubTable(key);
	      sddata.m_builder.setTable(dataTable);
	      data.initSendable(sddata.m_builder);
	      sddata.m_builder.updateTable();
	      sddata.m_builder.startListeners();
	      dataTable.getEntry(".name").setString(key);
	    }
	  }

	  private static class Data {
	    Data(Sendable sendable) {
	      m_sendable = sendable;
	    }

	    final Sendable m_sendable;
	    final SendableBuilderImpl m_builder = new SendableBuilderImpl();
	  }
	  
}
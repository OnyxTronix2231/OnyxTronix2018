package org.usfirst.frc.team2231.robot;

import java.util.HashMap;
import java.util.Map;

import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilderImpl;

public class SmartDashboardUpdater {

	private static final double height = 0;
	private final NetworkTableEntry upperMicroswitch;
	private final NetworkTableEntry lowerMicroswitch;
	private final NetworkTableEntry cubeCollected;
	private final NetworkTableEntry leftEncoderPosition;
	private final NetworkTableEntry rightEncoderPosition;

	private final NetworkTableEntry pidEncoders;
	private final NetworkTableEntry errorGraphEncodersLeft;
	private final NetworkTableEntry errorGraphEncodersRight;
	private final NetworkTableEntry leftEncoder;
	private final NetworkTableEntry rightEncoder;

	private final NetworkTableEntry pidRotation;
	private final NetworkTableEntry gyro;
	private final NetworkTableEntry navXErrorGraph;

	private final NetworkTableEntry pidElevator;
	private final NetworkTableEntry elevatorHeight;
	private final NetworkTableEntry errorGraphElevator;

	private final NetworkTableEntry pidPitch;
	private final NetworkTableEntry errorGraphElevatorPitch;
	private final NetworkTableEntry angle;

	private final NetworkTableEntry pdp;
	private final NetworkTableEntry driveTrainFirstLeft;
	private final NetworkTableEntry driveTrainSecondLeft;
	private final NetworkTableEntry driveTrainFirstRight;
	private NetworkTableEntry driveTrainSecondRight;
	private final NetworkTableEntry elevatorFirst;
	private final NetworkTableEntry elevatorSecond;
	private final NetworkTableEntry elevatorThird;
	private final NetworkTableEntry elevatorFourth;
	private final NetworkTableEntry elevatorPitch;
	private final NetworkTableEntry collectorRight;
	private final NetworkTableEntry collectorLeft;

	private final NetworkTableEntry holderPistons;
	
	private final NetworkTableEntry p;
	private final NetworkTableEntry i;
	private final NetworkTableEntry d;
	private final NetworkTableEntry f;
	private final NetworkTableEntry enabled;
	private final NetworkTableEntry setpoint;
	private final NetworkTableEntry name;
	private final NetworkTableEntry type;

	private static SendableBuilderImpl m_sendableBuilder;
	private static Map<String, Data> tablesToData;

	public SmartDashboardUpdater() {
		final NetworkTableInstance defaultInst = NetworkTableInstance.getDefault();
		final NetworkTable driversTable = defaultInst.getTable("Drivers");
		upperMicroswitch = driversTable.getEntry("upperMicroSwitch");
		lowerMicroswitch = driversTable.getEntry("lowerMicroSwitch");
		cubeCollected = driversTable.getEntry("is cube collected");
		leftEncoderPosition = driversTable.getEntry("Left Encoder Position");
		rightEncoderPosition = driversTable.getEntry("Right Encoder Position");
		holderPistons = driversTable.getEntry("Holder Pistons");
		
		final NetworkTable pidDriveEncoders = defaultInst.getTable("PID Encoders");
		pidEncoders = pidDriveEncoders.getEntry("PID");
		errorGraphEncodersLeft = pidDriveEncoders.getEntry("Left Error Graph");
		errorGraphEncodersRight = pidDriveEncoders.getEntry("Right Error Graph");
		p = pidDriveEncoders.getEntry("PID/p");
		i = pidDriveEncoders.getEntry("PID/i");
		d = pidDriveEncoders.getEntry("PID/d");
		f = pidDriveEncoders.getEntry("PID/f");
		setpoint = pidDriveEncoders.getEntry("PID/setpoint");
		enabled = pidDriveEncoders.getEntry("PID/enabled");
		name = pidDriveEncoders.getEntry("PID/.name");
		type = pidDriveEncoders.getEntry("PID/.type");

		leftEncoder = pidDriveEncoders.getEntry("Left Encoder");
		rightEncoder = pidDriveEncoders.getEntry("Right Encoder");

		final NetworkTable navXPidRotation = defaultInst.getTable("PID Rotation");
		pidRotation = navXPidRotation.getEntry("PID");
		gyro = navXPidRotation.getEntry("Gyro");
		navXErrorGraph = navXPidRotation.getEntry("Error Graph");

		final NetworkTable pidElevatorHeight = defaultInst.getTable("PID Elevator Height");
		pidElevator = pidElevatorHeight.getEntry("PID");
		elevatorHeight = pidElevatorHeight.getEntry("Elevator's Height");
		errorGraphElevator = pidElevatorHeight.getEntry("Error Graph");

		final NetworkTable pidElevatorPitch = defaultInst.getTable("PID Elevator Pitch");
		pidPitch = pidElevatorPitch.getEntry("PID");
		errorGraphElevatorPitch = pidElevatorPitch.getEntry("Error Graph");
		angle = pidElevatorPitch.getEntry("Angle");

		final NetworkTable electronicTable = defaultInst.getTable("Electronic");
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
		// holderPistons.setBoolean(Robot.m_robotMap.switchPiston.get());

		FillPIDController(Robot.m_driveTrain.firstLeft, p, i, d, f, setpoint, enabled, name, type);
		errorGraphEncodersLeft.setNumber(DriveTrain.firstLeft.getClosedLoopError(0));
		errorGraphEncodersRight.setNumber(DriveTrain.firstRight.getClosedLoopError(0));
		leftEncoder.setDouble(Robot.m_driveTrain.getLeftEncoderPosition());
		rightEncoder.setDouble(Robot.m_driveTrain.getRightEncoderPosition());

		gyro.setDouble(Robot.m_driveTrain.getAngle());
		navXErrorGraph.setDouble(Robot.m_driveTrain.getAngle());
		putDataTest("PID", Robot.m_robotMap.driveTrainLeftRotationPIDController,
				pidRotation.getInstance().getTable("PID Rotation"));

		putDataTest("PID", Robot.m_robotMap.elevatorPIDController,
				pidElevator.getInstance().getTable("PID Elevator Height"));
		errorGraphElevator.setNumber(Robot.m_elevator.firstMotor.getClosedLoopError(0));
		elevatorHeight.setDouble(Potentiometer.getFixedVoltage(height));

		
		// pidPitch.getInstance().getTable("PID Elevator Pitch"));
		errorGraphElevatorPitch.setNumber(Robot.m_robotMap.elevatorPitchMotor.getClosedLoopError(0));
		angle.setDouble(Robot.m_robotMap.elevatorPitchMotor.getSensorCollection().getQuadraturePosition());

		putDataTest("PDPModule", Robot.m_robotMap.pdpModule, pdp.getInstance().getTable("Electronic"));
		if (!Robot.m_robotMap.driveTrainFirstLeft.isAlive()) {
			driveTrainFirstLeft.setBoolean(false);
		}
		if (!Robot.m_robotMap.driveTrainSecondLeft.isAlive()) {
			driveTrainSecondLeft.setBoolean(false);
		}
		if (!Robot.m_robotMap.driveTrainFirstRight.isAlive()) {
			driveTrainFirstRight.setBoolean(false);
		}
		if (!Robot.m_robotMap.driveTrainSecondRight.isAlive()) {
			driveTrainSecondRight.setBoolean(false);
		}
		if (!Robot.m_robotMap.elevatorFirstMotor.isAlive()) {
			elevatorFirst.setBoolean(false);
		}
		if (!Robot.m_robotMap.elevatorSecondMotor.isAlive()) {
			elevatorSecond.setBoolean(false);
		}
		if (!Robot.m_robotMap.elevatorThirdMotor.isAlive()) {
			elevatorThird.setBoolean(false);
		}
		if (!Robot.m_robotMap.elevatorFourthMotor.isAlive()) {
			elevatorFourth.setBoolean(false);
		}
		if (!Robot.m_robotMap.elevatorPitchMotor.isAlive()) {
			elevatorPitch.setBoolean(false);
		}
		if (!Robot.m_robotMap.collectorRightWheel.isAlive()) {
			collectorRight.setBoolean(false);
		}
		if (!Robot.m_robotMap.collectorLeftWheel.isAlive()) {
			collectorLeft.setBoolean(false);
		}
	}

	public static synchronized void putData(final String key, final Sendable data, final NetworkTable table) {
		m_sendableBuilder.setTable(table);
		data.initSendable(m_sendableBuilder);
		m_sendableBuilder.updateTable();
		m_sendableBuilder.startListeners();
		table.getEntry(".name").setString(key);
	}

	public static synchronized void putDataTest(final String key, final Sendable data, final NetworkTable table) {
		Data sddata = tablesToData.get(key);
		if (sddata == null || sddata.m_sendable != data) {
			if (sddata != null) {
				sddata.m_builder.stopListeners();
			}
			sddata = new Data(data);
			tablesToData.put(key, sddata);
			final NetworkTable dataTable = table.getSubTable(key);
			sddata.m_builder.setTable(dataTable);
			data.initSendable(sddata.m_builder);
			sddata.m_builder.updateTable();
			sddata.m_builder.startListeners();
			dataTable.getEntry(".name").setString(key);
		}
	}

	private static class Data {
		Data(final Sendable sendable) {
			m_sendable = sendable;
		}

		final Sendable m_sendable;
		final SendableBuilderImpl m_builder = new SendableBuilderImpl();
	}

	public static void FillPIDController(final BaseMotorController talon, final NetworkTableEntry p,
			final NetworkTableEntry i, final NetworkTableEntry d, final NetworkTableEntry f, final NetworkTableEntry setpoint,
			final NetworkTableEntry enabled, final NetworkTableEntry name, final NetworkTableEntry type ) {
		p.setNumber(talon.configGetParameter(ParamEnum.eProfileParamSlot_P, 0, 0));
		i.setNumber(talon.configGetParameter(ParamEnum.eProfileParamSlot_I, 0, 0));
		d.setNumber(talon.configGetParameter(ParamEnum.eProfileParamSlot_D,0, 0));
		f.setNumber(talon.configGetParameter(ParamEnum.eProfileParamSlot_F,0 ,0));
		setpoint.setNumber(talon.getClosedLoopTarget(0));
		enabled.setBoolean(talon.getControlMode()==ControlMode.Position);
		name.setString("PID");
		type.setString("PIDController");
	}
}
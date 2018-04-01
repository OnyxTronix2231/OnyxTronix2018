/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2231.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2231.robot.subsystems.Collector;
import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2231.robot.subsystems.Elevator;
import org.usfirst.frc.team2231.robot.subsystems.ElevatorPitch;

import Configuration.CameraConfiguration;

import org.usfirst.frc.team2231.robot.OI;
import org.usfirst.frc.team2231.robot.commands.AutonomousLeft;
import org.usfirst.frc.team2231.robot.commands.AutonomousMiddle;
import org.usfirst.frc.team2231.robot.commands.AutonomousRight;
import org.usfirst.frc.team2231.robot.commands.DriveFromMiddleToLeftSwitch;
import org.usfirst.frc.team2231.robot.commands.DriveFromMiddleToRightSwitch;
import org.usfirst.frc.team2231.robot.commands.DriveToLeftScaleFromTheLeft;
import org.usfirst.frc.team2231.robot.commands.DriveToLeftSwitchFromTheLeft;
import org.usfirst.frc.team2231.robot.commands.DriveToRightScaleFromTheRight;
import org.usfirst.frc.team2231.robot.commands.DriveToRightSwitchFromTheRight;
import org.usfirst.frc.team2231.robot.commands.GetFieldPosition;
import org.usfirst.frc.team2231.robot.commands.KeepPitchInPlace;
import org.usfirst.frc.team2231.robot.commands.PassAutoLineFromLeft;
import org.usfirst.frc.team2231.robot.commands.PassAutoLineFromMiddle;
import org.usfirst.frc.team2231.robot.commands.PassAutoLineFromRight;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	public static DriveTrain m_driveTrain;
	public static Collector m_collector;
	public static RobotMap m_robotMap;
	public static OI m_oi;
	public static Elevator m_elevator;
	public static ElevatorPitch m_elevatorPitch;
	public static FieldPositions m_fieldPositions;
//	public static SmartDashboardUpdater m_smartDashboardUpdater;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	Command getFieldPosition;
	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_robotMap = new RobotMap();
		m_driveTrain = new DriveTrain();
		m_collector = new Collector();
		m_elevator = new Elevator();
		m_elevatorPitch = new ElevatorPitch();
		m_oi = new OI();
//		m_smartDashboardUpdater = new SmartDashboardUpdater();
		CameraServer.getInstance().startAutomaticCapture().setResolution(10, 5);
		CameraServer.getInstance().startAutomaticCapture(1).setResolution(10, 5);
		// chooser.addObject("My Auto", new MyAutoCommand());
		m_chooser.addDefault("Default", new PassAutoLineFromMiddle());
		m_chooser.addObject("Left", new AutonomousLeft());
		m_chooser.addObject("Middle", new AutonomousMiddle());
		m_chooser.addObject("Right", new AutonomousRight());
		SmartDashboard.putData("Autonomous chooser", m_chooser);
		
//		m_smartDashboardUpdater.updateDashboard();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
    }

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		getFieldPosition = new GetFieldPosition();
		getFieldPosition.start();
		m_autonomousCommand = m_chooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		
		KeepPitchInPlace.isCubePicked = false;
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();	
//		System.out.println("FirstCube- " + KeepPitchInPlace.isFirstCube);
//		System.out.println("Pitch - " + KeepPitchInPlace.isCubePicked);
//		System.out.println("Bumper - " + Robot.m_elevatorPitch.isPressed());
//		m_smartDashboardUpdater.updateDashboard();
		}
	

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
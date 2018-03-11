/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2231.robot;

import org.usfirst.frc.team2231.robot.commands.OpenCollector;
import org.usfirst.frc.team2231.robot.commands.RotateByNavX; 
import org.usfirst.frc.team2231.robot.commands.Collect;
import org.usfirst.frc.team2231.robot.commands.CollectCube;
import org.usfirst.frc.team2231.robot.commands.DriveByEncoder;
import org.usfirst.frc.team2231.robot.commands.DriveFromMiddleToRightSwitch;
import org.usfirst.frc.team2231.robot.commands.Eject;
import org.usfirst.frc.team2231.robot.commands.EjectSlowly;
import org.usfirst.frc.team2231.robot.commands.ElevatorPitchDrop;
import org.usfirst.frc.team2231.robot.commands.ElevatorPitchRaise;
import org.usfirst.frc.team2231.robot.commands.KeepClimberInPlace;
import org.usfirst.frc.team2231.robot.commands.Lower;
import org.usfirst.frc.team2231.robot.commands.LowerNeutral;
import org.usfirst.frc.team2231.robot.commands.CloseCollector;
import org.usfirst.frc.team2231.robot.commands.Raise;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	
	private Joystick driveStick;
	private Joystick buttonStick;

	public JoystickButton raiseElevator;
	public JoystickButton lowerElevator;
	public JoystickButton collect;
	public JoystickButton ejectCube;
	public JoystickButton elevatorPitchLower;
	public JoystickButton keepClimberInPlace;
	private JoystickButton openCollector;
	private JoystickButton closeCollector;
	private JoystickButton operatorOpenCollector;
	private JoystickButton elevatorPitchRaise;
	private JoystickButton ejectCubeSlowly;

	public OI() {
		driveStick = new Joystick(0);
		buttonStick = new Joystick(1);
		
		raiseElevator = new JoystickButton(buttonStick, 4);
		raiseElevator.whileHeld(new Raise());
		lowerElevator = new JoystickButton(buttonStick, 1);
		lowerElevator.whileHeld(new Lower());
		
		collect = new JoystickButton(buttonStick, 2);
		collect.whileHeld(new Collect());
		ejectCube = new JoystickButton(buttonStick, 3);
		ejectCube.whileHeld(new Eject());
		ejectCubeSlowly = new JoystickButton(driveStick, 2);
		ejectCubeSlowly.whileHeld(new EjectSlowly());
				
		elevatorPitchLower = new JoystickButton(buttonStick, 7);
		elevatorPitchLower.whileHeld(new ElevatorPitchDrop());
		elevatorPitchRaise = new JoystickButton(buttonStick, 8);
		elevatorPitchRaise.whileHeld(new ElevatorPitchRaise());
		
		openCollector = new JoystickButton(driveStick, 6);
		openCollector.whenPressed(new OpenCollector());
		closeCollector = new JoystickButton(driveStick, 5);
		closeCollector.whenPressed(new CloseCollector());
		operatorOpenCollector = new JoystickButton(buttonStick, 6);
		operatorOpenCollector.whenPressed(new OpenCollector());
		keepClimberInPlace = new JoystickButton(driveStick, 8);
		keepClimberInPlace.whenPressed(new KeepClimberInPlace());
		
//		collectCube = new JoystickButton(buttonStick, 8);
//		collectCube.whileHeld(new CollectCube());
		
		}


	public Joystick getDriveStick() {
		return driveStick;
	}
	
	public Joystick getButtonStick() {
		return buttonStick;
	}
}

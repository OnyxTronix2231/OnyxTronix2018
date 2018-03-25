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
import org.usfirst.frc.team2231.robot.commands.DriveToLeftScaleFromTheLeft;
import org.usfirst.frc.team2231.robot.commands.Eject;
import org.usfirst.frc.team2231.robot.commands.EjectSlowly;
import org.usfirst.frc.team2231.robot.commands.EvelatorPitchDrop;
import org.usfirst.frc.team2231.robot.commands.EvelatorPitchRaise;
import org.usfirst.frc.team2231.robot.commands.KeepClimberInPlace;
import org.usfirst.frc.team2231.robot.commands.LiftToHighScale;
import org.usfirst.frc.team2231.robot.commands.LiftToLowScale;
import org.usfirst.frc.team2231.robot.commands.LiftToMidScale;
import org.usfirst.frc.team2231.robot.commands.LiftToSwitch;
import org.usfirst.frc.team2231.robot.commands.Lower;
import org.usfirst.frc.team2231.robot.commands.LowerNeutral;
import org.usfirst.frc.team2231.robot.commands.LowerToBottom;
import org.usfirst.frc.team2231.robot.commands.LowerToBottomWithoutCrashing;
import org.usfirst.frc.team2231.robot.commands.Climb;
import org.usfirst.frc.team2231.robot.commands.CloseAndCollect;
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
	private JoystickButton middleScaleRaise;
	private JoystickButton switchRaise;
	private JoystickButton lowerToBottom;
	private JoystickButton highScaleRaise;
	private JoystickButton climb;
	private JoystickButton driveByEncoder;

	public OI() {
		driveStick = new Joystick(0);
		buttonStick = new Joystick(1);
		
		raiseElevator = new JoystickButton(buttonStick, 4);
		raiseElevator.whileHeld(new Raise());
		lowerElevator = new JoystickButton(buttonStick, 1);
		lowerElevator.whileHeld(new Lower());
		
		collect = new JoystickButton(buttonStick, 2);
		collect.whileHeld(new Collect());
//		ejectCube = new JoystickButton(buttonStick, 3);
//		ejectCube.whileHeld(new Eject());
		ejectCubeSlowly = new JoystickButton(driveStick, 2);
		ejectCubeSlowly.whileHeld(new EjectSlowly());
				
		elevatorPitchLower = new JoystickButton(buttonStick, 7);
		elevatorPitchLower.whileHeld(new EvelatorPitchDrop());
		elevatorPitchRaise = new JoystickButton(buttonStick, 8);
		elevatorPitchRaise.whileHeld(new EvelatorPitchRaise());
		
		openCollector = new JoystickButton(driveStick, 5);
		openCollector.whenPressed(new OpenCollector());
		closeCollector = new JoystickButton(driveStick, 6);
		closeCollector.whenPressed(new CloseCollector());
		
//		collectCube = new JoystickButton(buttonStick, 8);
//		collectCube.whileHeld(new CollectCube());
		
		middleScaleRaise = new JoystickButton(buttonStick, 9);
		middleScaleRaise.whenPressed(new LiftToMidScale());
		
		switchRaise = new JoystickButton(buttonStick, 10);
		switchRaise.whenPressed(new LiftToSwitch());
		
		lowerToBottom = new JoystickButton(buttonStick, 5);
		lowerToBottom.whenPressed(new LowerToBottomWithoutCrashing());
		highScaleRaise = new JoystickButton(buttonStick, 6);
		highScaleRaise.whenPressed(new LiftToHighScale());
		
		climb = new JoystickButton(buttonStick, 3);
		climb.whenPressed(new KeepClimberInPlace());
		
		driveByEncoder = new JoystickButton(driveStick, 7);
		driveByEncoder.whenPressed(new DriveByEncoder(50)); // Under 150 give -20, 590 + 10
		}


	public Joystick getDriveStick() {
		return driveStick;
	}
	
	public Joystick getButtonStick() {
		return buttonStick;
	}
}

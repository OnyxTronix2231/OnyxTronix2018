/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2231.robot;

import org.usfirst.frc.team2231.robot.commands.RotateByPID; 
import org.usfirst.frc.team2231.robot.commands.Collect;
import org.usfirst.frc.team2231.robot.commands.DriveByDistance;
import org.usfirst.frc.team2231.robot.commands.DriveToLeftScale;
import org.usfirst.frc.team2231.robot.commands.Eject;
import org.usfirst.frc.team2231.robot.commands.Lower;
import org.usfirst.frc.team2231.robot.commands.Raise;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

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
	public JoystickButton collectCube;
	public JoystickButton ejectCube;
	public JoystickButton rotateByNinteyDegrees;

	public OI() {
		driveStick = new Joystick(0);
		
//		buttonStick = new Joystick(1);
//		
//		raiseElevator = new JoystickButton(buttonStick, 1);
//		raiseElevator.whileHeld(new Raise());
//		lowerElevator = new JoystickButton(buttonStick, 4);
//		lowerElevator.whileHeld(new Lower());
//		
//		collectCube = new JoystickButton(buttonStick, 2);
//		collectCube.whileHeld(new Collect());
//		ejectCube = new JoystickButton(buttonStick, 3);
//		ejectCube.whileHeld(new Eject());
    
		rotateByNinteyDegrees = new JoystickButton(driveStick, 5);
		rotateByNinteyDegrees.whenPressed(new DriveByDistance(193));
		}


	public Joystick getDriveStick() {
		return driveStick;
	}
	
	public Joystick getButtonStick() {
		return buttonStick;
	}
}

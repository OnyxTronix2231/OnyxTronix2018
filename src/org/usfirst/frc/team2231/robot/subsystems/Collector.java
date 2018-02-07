// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.commands.CollectWhenMicroSwitchIsNotPressed;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
	private boolean isCubeCollected = false;
	private static final double SPEED = 1;
	private final SpeedControllerGroup wheels = Robot.m_robotMap.collectorWheels;
	private final DigitalInput microSwitch = Robot.m_robotMap.collectorMicroSwitch;
	private final DoubleSolenoid holderPiston = Robot.m_robotMap.collectorHolderPiston;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CollectWhenMicroSwitchIsNotPressed());

	}

	public void setSpeed(final double speed) {
		if (isMicoSwitchPressed() && speed > 0) {
			stop();
		} else {
			wheels.set(speed);
		}
	}

	public void stop() {
		wheels.set(0);
	}

	public boolean isCollecting() {
		return wheels.get() != 0;

	}
	
	public boolean isMicoSwitchPressed() {
		return !microSwitch.get();
	}

	public void changeHolderPistonPosition(final DoubleSolenoid.Value value) {
		holderPiston.set(value);
	}

	public boolean isCubeCollected() {
		return isCubeCollected;
	}

	public void setCubeCollected(boolean isCubeCollected) {
		this.isCubeCollected = isCubeCollected;
		System.out.println(isCubeCollected);
	}
}

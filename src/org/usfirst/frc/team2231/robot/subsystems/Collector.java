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
import OnyxTronix.LineTracker;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
	private boolean m_isCubeCollected = false;
	private final SpeedControllerGroup wheels = Robot.m_robotMap.collectorWheels;
	private final LineTracker lineTracker = Robot.m_robotMap.collectorLineTracker;
	private final DoubleSolenoid holderPistonLeft = Robot.m_robotMap.collectorHolderPistonLeft;
	private final DoubleSolenoid holderPistonRight = Robot.m_robotMap.collectorHolderPistonRight;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CollectWhenMicroSwitchIsNotPressed());
	}

	public void setSpeed(final double speed) {
<<<<<<< HEAD
//		if (isMicroSwitchPressed() && speed > 0) {
//			stop();
//		} else {
			wheels.set(speed);
//		}
=======
			wheels.set(speed);
>>>>>>> origin/Feature/WhiteNightManualChanges
	}

	public void stop() {
		wheels.set(0);
	}

	public boolean isCollecting() {
		return wheels.get() != 0;

	}
	
	public boolean isMicroSwitchPressed() {
		return lineTracker.isPressed();
	}

	public void changeHolderPistonPosition(final DoubleSolenoid.Value value) {
		holderPistonLeft.set(value);
		holderPistonRight.set(value);
	}

	public boolean isCubeCollected() {
		return m_isCubeCollected;
	}

	public void setCubeCollected(boolean isCubeCollected) {
		this.m_isCubeCollected = isCubeCollected;
		System.out.println(isCubeCollected);
	}
}

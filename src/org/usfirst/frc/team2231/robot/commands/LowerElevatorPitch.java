package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerElevatorPitch extends ChangePitchElevation {

	public static final double maxSpeed = 0.3;
    public LowerElevatorPitch() {
    	super(maxSpeed);
    }
}
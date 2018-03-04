package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseElevatorPitch extends ChangePitchElevation {

	public static final double maxSpeed = 0.3;
    public RaiseElevatorPitch() {
    	super(maxSpeed);
    }
}

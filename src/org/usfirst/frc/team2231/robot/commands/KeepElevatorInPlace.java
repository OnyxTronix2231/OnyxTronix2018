package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class KeepElevatorInPlace extends ChangeCubeElevation {
	public static final double stuckSpeed = 0.07;

    public KeepElevatorInPlace() {
    	super(stuckSpeed);
    }
}


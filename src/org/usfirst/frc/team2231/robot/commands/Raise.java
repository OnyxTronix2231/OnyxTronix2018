package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Raise extends ChangeCubeElevation {
	public static final int maxSpeed = 1;

    public Raise() {
        super(maxSpeed);
    }
    
}

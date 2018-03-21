package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

/**
 *
 */
public class Eject extends ConveyWithCollector {

	private static final double maxSpeed = -0.5;

	public Eject() {
		super(maxSpeed);
	}
}

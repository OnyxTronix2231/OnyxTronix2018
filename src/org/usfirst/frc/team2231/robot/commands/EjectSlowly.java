package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

/**
 *
 */
public class EjectSlowly extends ConveyWithCollector {

	private static final double maxSpeed = -0.4;

	public EjectSlowly() {
		super(maxSpeed);
	}
}

package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

/**
 *
 */
public class Eject extends ConveyWithCollector {

	private static final int maxSpeed = -1;

	public Eject() {
		super(maxSpeed);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		super.interrupted();
		Robot.m_collector.setCubeCollected(Robot.m_collector.isMicroSwitchPressed());
	}
}

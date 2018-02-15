package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

public class Collect extends ConveyWithCollector {

	private static final int maxSpeed = 1;

	public Collect() {
		super(maxSpeed);
	}

	@Override
	protected boolean isFinished() {
		return Robot.m_collector.isMicroSwitchPressed();
	}

	@Override
	protected void end() {
		super.end();
		Robot.m_collector.setCubeCollected(Robot.m_collector.isMicroSwitchPressed());
	}
}
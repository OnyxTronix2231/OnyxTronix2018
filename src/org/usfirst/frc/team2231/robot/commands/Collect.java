package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

/**
 *
 */
public class Collect extends ConveyWithCollector {
	

	private static final int maxSpeed = 1;

	public Collect() {
		super(maxSpeed);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		System.out.println(Robot.m_collector.microSwitch.get());
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.m_collector.isCubeCollected();
	}
}
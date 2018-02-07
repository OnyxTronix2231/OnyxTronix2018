package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

public class Collect extends ConveyWithCollector {

	private static final int maxSpeed = 1;

	public Collect() {
		super(maxSpeed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		System.out.println(Robot.m_collector.isMicoSwitchPressed());
		return Robot.m_collector.isMicoSwitchPressed();
	}

	@Override
	protected void end() {
		super.end();
		// TODO Auto-generated method stub
		System.out.println("Collect.end()");
		Robot.m_collector.setCubeCollected(Robot.m_collector.isMicoSwitchPressed());
	}
}
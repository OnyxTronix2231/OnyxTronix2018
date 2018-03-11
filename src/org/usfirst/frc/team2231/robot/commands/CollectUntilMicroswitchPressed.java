package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

public class CollectUntilMicroswitchPressed extends Collect {
	
	@Override
	protected boolean isFinished() {
		return Robot.m_collector.isMicroSwitchPressed(); 
	}
}

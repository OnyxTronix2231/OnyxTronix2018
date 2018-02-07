package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class CollectWhenMicroSwitchIsNotPressed extends ConditionalCommand {

	public CollectWhenMicroSwitchIsNotPressed() {
		super(new Collect());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		System.out.println("CollectWhenMicroSwitchIsNotPressed.condition()");
		System.out.println(Robot.m_collector.isMicoSwitchPressed());
		return Robot.m_collector.isCubeCollected() && !Robot.m_collector.isMicoSwitchPressed();
	}
}

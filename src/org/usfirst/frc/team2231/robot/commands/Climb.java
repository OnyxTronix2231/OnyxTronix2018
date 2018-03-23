package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class Climb extends ConditionalCommand {

	public Climb() {
		super(new LowerBySpeed(-0.4), new KeepClimberInPlace());
	}
	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		return Robot.m_oi.getButtonStick().getRawButton(3);
	}

}

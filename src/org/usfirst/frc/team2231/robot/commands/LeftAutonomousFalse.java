package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Position;
import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class LeftAutonomousFalse extends ConditionalCommand {
	
	public LeftAutonomousFalse() {
		super(new DriveToLeftScaleFromTheLeft(), new PassAutoLineFromLeft());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		return Robot.m_fieldPositions.getScalePosition().equals(Position.Left);
	}

}

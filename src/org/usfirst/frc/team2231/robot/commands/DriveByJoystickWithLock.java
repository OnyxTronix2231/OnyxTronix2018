package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class DriveByJoystickWithLock extends ConditionalCommand {

	
	public DriveByJoystickWithLock() {
		super(new DriveByJoystick(), new LockDriveTrain());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub	
		return Math.abs(Robot.m_oi.getLeftStick(Robot.m_oi.getDriveStick())) > 0.2
				|| Math.abs(Robot.m_oi.getRightStick(Robot.m_oi.getDriveStick())) > 0.2;
	}

}

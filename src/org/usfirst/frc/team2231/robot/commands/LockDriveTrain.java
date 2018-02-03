package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

public class LockDriveTrain extends RotateByPID {

	public LockDriveTrain() {
		// TODO Auto-generated constructor stub
		super(0);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Math.abs(Robot.m_oi.getLeftStick(Robot.m_oi.getDriveStick())) > 0.2
				|| Math.abs(Robot.m_oi.getRightStick(Robot.m_oi.getDriveStick())) > 0.2;
	}
}

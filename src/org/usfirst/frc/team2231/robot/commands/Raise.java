package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

/**
 *
 */
public class Raise extends ChangeCubeElevation {
	public static final double maxSpeed = 0.3;

    public Raise() {
        super(maxSpeed);
    }
<<<<<<< HEAD
    
    @Override
    protected boolean isFinished() {
    	// TODO Auto-generated method stub
    	return Robot.m_elevator.firstMotor.getSensorCollection().isFwdLimitSwitchClosed();
    }
=======
>>>>>>> origin/Feature/WhiteNightManualChanges
}
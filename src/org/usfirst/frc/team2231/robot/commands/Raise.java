package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

/**
 *
 */
public class Raise extends ChangeCubeElevation {
	public static final double maxSpeed = 0.7; //previously 0.7

    public Raise() {
        super(maxSpeed);
    }
    
    @Override
    protected void execute() {
    	// TODO Auto-generated method stub
    	super.execute();
    }
}
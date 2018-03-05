package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

/**
 *
 */
public class Eject extends ConveyWithCollector {

	private static final double maxSpeed = -0.2;

	public Eject() {
		super(maxSpeed);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
		System.out.println("Need to eject here");
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		super.execute();
		System.out.println("Ejecting");
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		super.end();
		System.out.println("Ejected");
	}
}

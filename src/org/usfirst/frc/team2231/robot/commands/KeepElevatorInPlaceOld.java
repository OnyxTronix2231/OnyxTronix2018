package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class KeepElevatorInPlaceOld extends Command {

    public KeepElevatorInPlaceOld() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_elevator);
    }
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.m_elevator.setSpeed(0.08);
	}
	
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }
    
    @Override
    protected void end() {
    	Robot.m_elevator.disablePIDController();
    }
    
    @Override
    protected void interrupted() {
    	end();
    }
}

package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class KeepElevatorInPlace extends Command {

    public KeepElevatorInPlace() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_elevator);
    }
	
	@Override
	protected void initialize() {
    	Robot.m_elevator.setHeight(Robot.m_elevator.getHeight());
		Robot.m_elevator.enablePIDController();
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
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

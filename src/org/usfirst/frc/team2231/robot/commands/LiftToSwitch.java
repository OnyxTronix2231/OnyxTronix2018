package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftToSwitch extends Command {
    // Called just before this Command runs the first time

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_elevator.setHeight(Robot.m_robotMap.switchHeight);
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
}

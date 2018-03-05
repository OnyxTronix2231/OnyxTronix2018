package org.usfirst.frc.team2231.robot.commands;

import java.text.FieldPosition;

import org.usfirst.frc.team2231.robot.FieldPositions;
import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GetFieldPosition extends Command {
	private String gamedata;

    public GetFieldPosition() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gamedata = DriverStation.getInstance().getGameSpecificMessage();
//    	gamedata = "LLL";
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !gamedata.equals(null);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_fieldPositions = FieldPositions.createFieldPositions(gamedata);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

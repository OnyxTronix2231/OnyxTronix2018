package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.FieldPositions;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CheckFieldPositions extends Command {

    private FieldPositions m_fieldPositions;

	public CheckFieldPositions() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
		m_fieldPositions = FieldPositions.createFieldPositions(gameData);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return m_fieldPositions.equals(null);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

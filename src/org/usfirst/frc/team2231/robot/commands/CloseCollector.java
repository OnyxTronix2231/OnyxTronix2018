package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CloseCollector extends InstantCommand {

    public CloseCollector() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    @Override
	protected void initialize() {
    	Robot.m_collector.changeHolderPistonPosition(Value.kReverse);
    }

}

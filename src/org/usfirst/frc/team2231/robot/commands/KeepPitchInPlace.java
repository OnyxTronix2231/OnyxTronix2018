package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class KeepPitchInPlace extends Command {
	public static boolean isCubePicked;
	public static boolean isFirstCube;
	
    public KeepPitchInPlace() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_elevatorPitch);
    }
	
    @Override
    protected void initialize() {
    	// TODO Auto-generated method stub
    }
    
	@Override
	protected void execute() {
		if (Robot.m_elevatorPitch.pitchMotor.getSensorCollection().isRevLimitSwitchClosed()) {
			isCubePicked = true;
		}
		
		if (!Robot.m_elevatorPitch.isPressed() && !this.isCubePicked) {	
			Robot.m_elevatorPitch.setSpeed(-1);
		}
		else {		
			Robot.m_elevatorPitch.setSpeed(-0.1);
		}
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }
    
    @Override
    protected void end() {
    }
    
    @Override
    protected void interrupted() {
    	end();
    }
}

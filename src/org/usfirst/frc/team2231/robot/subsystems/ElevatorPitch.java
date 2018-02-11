package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorPitch extends Subsystem {
    private final WPI_TalonSRX pitchMotor = Robot.m_robotMap.elevatorPitchMotor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed(final double speed){
    	pitchMotor.set(speed);
    }
    
    public void stop() {
    	pitchMotor.set(0);
    }
}


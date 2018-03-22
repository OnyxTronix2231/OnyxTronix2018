package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.commands.KeepPitchInPlace;
import org.usfirst.frc.team2231.robot.commands.KeepPitchInPlaceWithEncoder;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorPitch extends Subsystem {
    public final WPI_TalonSRX pitchMotor = Robot.m_robotMap.elevatorPitchMotor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new KeepPitchInPlace());
    }
    
    public void setSetpoint(double setpoint) {
    	pitchMotor.set(ControlMode.Position, setpoint);
    }
    
    public void setSpeed(final double speed){
    	pitchMotor.set(speed);
    }
    
    public void stop() {
    	pitchMotor.set(0);
    }
}


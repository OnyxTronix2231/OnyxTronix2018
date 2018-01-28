package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.commands.DriveByJoystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	public static final WPI_TalonSRX firstLeft = Robot.m_robotMap.driveTrainFirstLeft;
	public static final WPI_TalonSRX secondLeft = Robot.m_robotMap.driveTrainSecondLeft;
	public static final WPI_TalonSRX firstRight= Robot.m_robotMap.driveTrainFirstRight;
	public static final WPI_TalonSRX secondRight = Robot.m_robotMap.driveTrainSecondRight;
	public static final DifferentialDrive robotDrive = Robot.m_robotMap.driveTrainRobotDrive;
	public static final SpeedControllerGroup leftTalons = Robot.m_robotMap.driveTrainleftTalons;
	public static final SpeedControllerGroup rightTalons = Robot.m_robotMap.driveTrainRightTalons;
	public static final Encoder encoderRight = Robot.m_robotMap.encoderRight;
	public static final Encoder encoderLeft = Robot.m_robotMap.encoderLeft;
	public static final double wheelsRadius = 4;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveByJoystick());
    }
    
    public void initPID() {
    	firstLeft.set(ControlMode.Velocity, 3 );
    	firstLeft.set(4);
    }
    
    public void arcadeDrive(Joystick stick) {
    	robotDrive.arcadeDrive(-stick.getRawAxis(1) * 2, stick.getRawAxis(4) * 2);
    }
    
    public void driveByProportion(double right, double left) {
    	leftTalons.set(left);
    	rightTalons.set(right);
    }
    
    public void setPsitionSetpoint(double setpointRight, double setpointLeft) {
    	firstRight.set(ControlMode.Position, setpointRight);
    	firstLeft.set(ControlMode.Position, setpointLeft);
    	secondRight.set(ControlMode.Follower, 2);
    	secondLeft.set(ControlMode.Follower, 0);
    }
    
    public boolean stopByEncoder(double distanceRight, double distanceLeft) {
    	double v;
    	if(firstRight.get()*wheelsRadius*3.14 < distanceRight) {
    		if(distanceRight>distanceLeft) {
    			
        		v = distanceLeft/distanceRight;
        		Robot.m_driveTrain.driveByProportion(1,v);
        	}
    		else {
    			v = distanceRight/distanceLeft;
    			Robot.m_driveTrain.driveByProportion(v,1);
    		}
    		return false;
    	}
    	else
    		return true;
    }
}


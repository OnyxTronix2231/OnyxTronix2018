package org.usfirst.frc.team2231.robot;

import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;

import com.ctre.phoenix.motorcontrol.IMotorController;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardUpdater {

	int counter;
	int maxCounter = 100;
	public void UpdateDashboard() {
		SmartDashboard.putBoolean("Cube collected", Robot.m_collector.isMicroSwitchPressed());
		SmartDashboard.putBoolean("Upper MicroSwitch", Robot.m_robotMap.elevatorFirstMotor.getSensorCollection().isFwdLimitSwitchClosed());
		SmartDashboard.putBoolean("Lower MicroSwitch", Robot.m_robotMap.elevatorFirstMotor.getSensorCollection().isRevLimitSwitchClosed());
//        SmartDashboard.putNumber("Elevator Position", Robot.m_robotMap.potentiometer.getVoltage());
		SmartDashboard.putNumber("Left encoder position", Robot.m_robotMap.driveTrainFirstLeft.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("Right encoder position", Robot.m_robotMap.driveTrainFirstRight.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putData("NAVX" ,Robot.m_robotMap.driveTrainNavX);
		Robot.m_robotMap.driveTrainRobotDrive.setName("DriveTrain", "Drive train");
		if(counter >= maxCounter) {
			counter = 0;
			return;
		} 
		counter++;
		if (!Robot.m_robotMap.driveTrainFirstLeft.isAlive()){
			SmartDashboard.putBoolean("Talon DriveTrain First Left with ID:" + Robot.m_robotMap.driveTrainFirstLeft.getBaseID() + " disconected", false);
		}
		
		if (Robot.m_robotMap.driveTrainSecondLeft.isAlive()) {
			SmartDashboard.putBoolean("Talon Second Left with ID:" + Robot.m_robotMap.driveTrainSecondLeft.getBaseID() + " disconected", false);
		}
		
		if (Robot.m_robotMap.driveTrainSecondRight.isAlive()) {
			SmartDashboard.putBoolean("Talon Second Right with ID:" + Robot.m_robotMap.driveTrainSecondRight.getBaseID() + " disconected", false);
		}
		
		if (Robot.m_robotMap.elevatorFirstMotor.isAlive()) {
			SmartDashboard.putBoolean("Talon Elevator First Motor with ID:" + Robot.m_robotMap.elevatorFirstMotor.getBaseID() + " disconected", false);
		}

		if (Robot.m_robotMap.elevatorSecondMotor.isAlive()) {
			SmartDashboard.putBoolean("Talon Elevator Second Motor with ID:" + Robot.m_robotMap.elevatorSecondMotor.getBaseID() + " disconected", false);
		}
		
		if (Robot.m_robotMap.elevatorThirdMotor.isAlive()) {
			SmartDashboard.putBoolean("Talon Elevator Third Motor with ID:" + Robot.m_robotMap.elevatorThirdMotor.getBaseID() + " disconected", false);
		}
		
		if (Robot.m_robotMap.elevatorFourthMotor.isAlive()) {
			SmartDashboard.putBoolean("Talon Elevator Fourth Motor with ID:" + Robot.m_robotMap.elevatorFourthMotor.getBaseID()  + " disconected", false);
		}
		
		if (Robot.m_robotMap.elevatorPitchMotor.isAlive()) {
			SmartDashboard.putBoolean("Talon Elevator Pitch Motor with ID:" + Robot.m_robotMap.elevatorPitchMotor.getBaseID()  + " disconected", false);
		}
		
		if (Robot.m_robotMap.collectorRightWheel.isAlive()) {
			SmartDashboard.putBoolean("Talon Collector Right Wheel with ID:" + Robot.m_robotMap.collectorRightWheel.getBaseID()  + " disconected", false);
		}
		
		if (Robot.m_robotMap.collectorLeftWheel.isAlive()) {
			SmartDashboard.putBoolean("Talon Collector Left Wheel with ID:" + Robot.m_robotMap.collectorLeftWheel.getBaseID() + " disconected", false);
		}

	}
} 
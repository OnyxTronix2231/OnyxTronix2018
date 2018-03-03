package org.usfirst.frc.team2231.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class Potentionmeter extends AnalogInput{
	public final double minimunPotentiometerVoltage = 0.004882812;
	public final double maxinumPotentionmeterVoltage = 4.874267079;
	
	public Potentionmeter(int port) {
		super(port);
	}

	public double getAngle() {
		double potentionmeterDgree = ((Robot.m_robotMap.potentionmeter.getVoltage() - minimunPotentiometerVoltage)
				/ ((maxinumPotentionmeterVoltage - minimunPotentiometerVoltage) / 3600));
		return potentionmeterDgree;

	}
}

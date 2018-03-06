package org.usfirst.frc.team2231.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class Potentiometer implements PIDSource {
	// public final double minimunPotentiometerVoltage = 0.004882812;
	// public final double maxinumPotentiometerVoltage = 4.874267079;
	public AnalogInput m_potentiometer;
	public double m_minimumPotentionmeter;
	public double m_maximumPotentionmeter;
	public double m_minimumHeight;
	public double m_maxmumHeight;
	public double potentiometerFixedVoltage;

	public Potentiometer(int port, double minimumPotentiometer, double maximumPotentiometer, double minimumHeight,
			double maximumHeight) {
		m_potentiometer = new AnalogInput(port);
		m_minimumPotentionmeter = minimumPotentiometer;
		m_maximumPotentionmeter = maximumPotentiometer;
		m_minimumHeight = minimumHeight;
		m_maxmumHeight = maximumHeight;
	}

	public static double getFixedVoltage(double height) {
		// double potentionmeterDgree = ((Robot.m_robotMap.potentionmeter.getVoltage() -
		// minimunPotentiometerVoltage)
		// / ((maxinumPotentiometerVoltage - minimunPotentiometerVoltage) / 3600));
		// return potentionmeterDgree;
		double voltage;
		return voltage = 131 * height + 21;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		m_potentiometer.setPIDSourceType(pidSource);
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return m_potentiometer.getPIDSourceType();
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return 0;
	}
}

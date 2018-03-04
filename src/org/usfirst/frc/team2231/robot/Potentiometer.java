package org.usfirst.frc.team2231.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class Potentiometer extends AnalogInput implements PIDSource {
	// public final double minimunPotentiometerVoltage = 0.004882812;
	// public final double maxinumPotentiometerVoltage = 4.874267079;
	
	public AnalogInput m_potentiometer = Robot.m_robotMap.potentiometer;
	public double m_minimumPotentionmeter;
	public double m_maximumPotentionmeter;
	public double m_minimumHeight;
	public double m_maxmumHeight;
	public double potentiometerHeight;

	public Potentiometer(int port, double minimumPotentiometer, double maximumPotentiometer, double minimumHeight,
			double maximumHeight) {
		super(port);
		m_minimumPotentionmeter = minimumPotentiometer;
		m_maximumPotentionmeter = maximumPotentiometer;
		m_minimumHeight = minimumHeight;
		m_maxmumHeight = maximumHeight;
	}

	public double getHeight() {
		// double potentionmeterDgree = ((Robot.m_robotMap.potentionmeter.getVoltage() -
		// minimunPotentiometerVoltage)
		// / ((maxinumPotentiometerVoltage - minimunPotentiometerVoltage) / 3600));
		// return potentionmeterDgree;
		return potentiometerHeight = 130.8581862 * m_potentiometer.getVoltage() + 21.21059038;
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
		return getHeight();
	}
}

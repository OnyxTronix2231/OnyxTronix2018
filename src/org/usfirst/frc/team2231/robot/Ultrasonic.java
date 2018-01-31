package org.usfirst.frc.team2231.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class Ultrasonic implements PIDSource {
	private AnalogInput m_analogInput;

	public Ultrasonic(AnalogInput analogInput) {
		m_analogInput = analogInput;
	}

	public double getDistance() {
		m_analogInput = new AnalogInput(0);
		final double roboRIOVoltageOutput = 5.0;
		final double voltageOutputToCM = roboRIOVoltageOutput / 512; // Measured voltage scaled to cms
		final double vm = m_analogInput.getVoltage();
		final double rc = vm / voltageOutputToCM; // rc = the resulting value
		return getFixedDistance(rc);
	}

	private double getFixedDistance(final double rc) {
		return 1.0473 * rc - 1.1167;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		 m_analogInput.setPIDSourceType(pidSource);
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		 return m_analogInput.getPIDSourceType();
	}

	@Override
	public double pidGet() {
		return getDistance();
	}

}

package robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class Potentiometer implements PIDSource {

	public AnalogInput m_potentiometer;
	public double m_minimumPotentionmeter;
	public double m_maximumPotentionmeter;
	public double m_minimumHeight;
	public double m_maximumHeight;

	public Potentiometer(AnalogInput potentiometer, double minimumPotentiometer, double maximumPotentiometer,
			double minimumHeight, double maximumHeight) {
		m_potentiometer = potentiometer;
		m_minimumPotentionmeter = minimumPotentiometer;
		m_maximumPotentionmeter = maximumPotentiometer;
		m_minimumHeight = minimumHeight;
		m_maximumHeight = maximumHeight;
	}

	public double mapRange(double firstMinimalValue, double firstMaximalValue, double secondMinimalValue,
			double secondMaximalValue, double value) {
		return secondMinimalValue + ((value - firstMinimalValue) * (secondMaximalValue - secondMinimalValue))
				/ (firstMaximalValue - firstMinimalValue);
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		m_potentiometer.setPIDSourceType(pidSource);
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return m_potentiometer.getPIDSourceType();
	}

	private double getHeightFromVoltage(double voltage) {
		return mapRange(m_minimumPotentionmeter, m_maximumPotentionmeter, m_minimumHeight, m_maximumHeight, voltage);
	}

	public double getHeight() {
		return getHeightFromVoltage(m_potentiometer.getVoltage());
	}

	@Override
	public double pidGet() {
		return getHeight();
	}
}

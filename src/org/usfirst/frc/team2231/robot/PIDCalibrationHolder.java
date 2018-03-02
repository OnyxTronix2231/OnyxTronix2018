package org.usfirst.frc.team2231.robot;

public class PIDCalibrationHolder {
	private double m_p;
	private double m_i;
	private double m_d;

	public PIDCalibrationHolder(double p, double i, double d) {
		this.m_p = p;
		this.m_i = i;
		this.m_d = d;
	}

	public double getP() {
		return m_p;
	}

	public double getI() {
		return m_i;
	}

	public double getD() {
		return m_d;
	}

}

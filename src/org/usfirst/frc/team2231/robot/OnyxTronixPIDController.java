package org.usfirst.frc.team2231.robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

public class OnyxTronixPIDController extends PIDController {
	protected double Kf2;

	public OnyxTronixPIDController(double Kp, double Ki, double Kd, double Kf2, PIDSource source, PIDOutput output) {
		super(Kp, Ki, Kd, source, output);
		this.Kf2 = Kf2;
	}
	
	@Override
	protected double calculateFeedForward() {
		// TODO Auto-generated method stub
		return Kf2;
	}
	
	public void setKf2(double f2) {
		Kf2 = f2;
	}
	
}

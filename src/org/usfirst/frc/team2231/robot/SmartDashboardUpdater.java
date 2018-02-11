package org.usfirst.frc.team2231.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardUpdater {

	public void UpdateDashboard() {
		SmartDashboard.putBoolean("Cube collected", Robot.m_collector.isMicroSwitchPressed());
	}
}

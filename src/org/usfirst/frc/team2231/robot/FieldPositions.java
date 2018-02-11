package org.usfirst.frc.team2231.robot;

public class FieldPositions {

	private Position m_closeSwitch;
	private Position m_scale;
	private Position m_distantSwitch;
	
	public FieldPositions(Position closeSwitch, Position scale, Position distantSwitch) {
		this.m_closeSwitch = closeSwitch;
		this.m_scale = scale;
		this.m_distantSwitch = distantSwitch;
	}	
}

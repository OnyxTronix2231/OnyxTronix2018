package robot.commands;

import robot.Position;
import robot.Robot;

import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class AutonomousRight extends ConditionalCommand {
	
	public AutonomousRight() {
		super(new DriveToRightSwitchFromTheRight(), new PassAutoLineFromRight());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		return Robot.m_fieldPositions.getCloseSwitchPosition().equals(Position.Right);
	}

}

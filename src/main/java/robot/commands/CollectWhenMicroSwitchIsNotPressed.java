package robot.commands;

import robot.Robot;

import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class CollectWhenMicroSwitchIsNotPressed extends ConditionalCommand {

	public CollectWhenMicroSwitchIsNotPressed() {
		super(new Collect());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		return Robot.m_collector.isCubeCollected() && !Robot.m_collector.isMicroSwitchPressed();
	}
}

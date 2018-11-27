package robot;

public class FieldPositions {
	private Position m_closeSwitch;
	private Position m_scale;
	private Position m_distantSwitch;
	
	public FieldPositions(Position closeSwitch, Position scale, Position distantSwitch) {
		this.m_closeSwitch = closeSwitch;
		this.m_scale = scale;
		this.m_distantSwitch = distantSwitch;
	}
	public static FieldPositions createFieldPositions(String gameData) {
		switch (gameData) {
		case "LLL":
			return new FieldPositions(Position.Left, Position.Left, Position.Left);
		case "RRR":
			return new FieldPositions(Position.Right, Position.Right, Position.Right);
		case "LRL":
			return new FieldPositions(Position.Left, Position.Right, Position.Left);
		case "RLR":
			return new FieldPositions(Position.Right, Position.Left, Position.Right);
			default:
				return null;
		}
	}

	public Position getCloseSwitchPosition() {
		return m_closeSwitch;
	}

	public Position getScalePosition() {
		return m_scale;
	}

	public Position getDistantSwitchPosition() {
		return m_distantSwitch;
	}

}

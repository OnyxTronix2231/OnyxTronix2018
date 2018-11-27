package robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PassAutoLineFromLeft extends CommandGroup {

    public PassAutoLineFromLeft() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple robot.commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the robot.subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DriveBySpeed(0.45), 4);
    	addSequential(new RotateByNavX(80));
    }
}

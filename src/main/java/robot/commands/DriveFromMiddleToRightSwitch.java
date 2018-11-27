package robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveFromMiddleToRightSwitch extends CommandGroup {

    public DriveFromMiddleToRightSwitch() {
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
    	
    	addSequential(new DriveBySpeed(0.5), 0.5);
    	addSequential(new DriveBySpeed(0), 0.1);
    	addSequential(new RotateByNavX(39), 0.5);
    	addParallel(new RaiseBySpeed(0.7), 0.9);
//    	addParallel(new LiftToSwitch());
    	addParallel(new EvelatorPitchDrop(), 1);
    	addSequential(new DriveBySpeed(0.4), 4);
    	addParallel(new KeepElevatorInPlace());
    	addSequential(new EjectSlowly(), 4);
    	addSequential(new OpenCollector());
//    	addSequential(new RotateByNavX(90));
//    	addSequential(new DriveByEncoder(-130));
//    	addSequential(new DriveByEncoder(-130));
//    	addSequential(new RotateByNavX(90));
//    	addSequential(new DriveByEncoder(-50));
//    	addSequential(new DriveByEncoder(-50));
//    	addSequential(new DriveBySpeed(-0.5), 0.2);
//    	addSequential(new Lower(), 4);	
    }
}

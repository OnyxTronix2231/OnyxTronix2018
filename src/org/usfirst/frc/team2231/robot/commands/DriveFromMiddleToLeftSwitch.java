package org.usfirst.frc.team2231.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveFromMiddleToLeftSwitch extends CommandGroup {

    public DriveFromMiddleToLeftSwitch() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DriveByEncoder(20));
    	addSequential(new DriveByEncoder(20));
    	addSequential(new RotateByNavX(90));
    	addParallel(new Raise(), 3);
    	addParallel(new EvelatorPitchDrop());
    	addSequential(new DriveByEncoder(123));
    	addSequential(new DriveByEncoder(123));
    	addSequential(new RotateByNavX(-90));
    	addSequential(new DriveByEncoder(326));
    	addSequential(new DriveByEncoder(326));
    	addSequential(new Eject(), 1.5);
    	addParallel(new OpenCollector());
    	addSequential(new RotateByNavX(-90));
    	addSequential(new DriveByEncoder(-130));
    	addSequential(new DriveByEncoder(-130));
    	addSequential(new RotateByNavX(-90));
    	addSequential(new DriveByEncoder(-50));
    	addSequential(new DriveByEncoder(-50));
    	addParallel(new Lower(), 4);
    }
}

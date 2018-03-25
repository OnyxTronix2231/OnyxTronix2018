package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.subsystems.ElevatorPitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToLeftScaleFromTheLeft extends CommandGroup {

    public DriveToLeftScaleFromTheLeft() {
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
    	addSequential(new DriveByEncoder(550));
//    	addSequential(new DriveByEncoder(400));
    	addSequential(new RotateByNavX(25), 1.5);
//    	addSequential(new DriveByEncoder(200));
//    	addSequential(new DriveByEncoder(100));
    	addSequential(new LiftToMidScale(), 1.5);
    	addParallel(new KeepElevatorInPlace());
    	addParallel(new EvelatorPitchRaise(), 2);
    	addSequential(new DriveByEncoder(80));
//    	addSequential(new DriveByEncoder(80));
    	addSequential(new Eject(), 2);
    	addSequential(new OpenCollector());
    	addSequential(new DriveBySpeed(-0.2), 2);
    }
}

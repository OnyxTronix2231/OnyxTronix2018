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
    	addParallel(new Raise(), 3);
    	addParallel(new EvelatorPitchDrop());
    	addSequential(new DriveByEncoder(822));
    	addSequential(new DriveByEncoder(822));
    	addSequential(new RotateByNavX(-90));
    	addSequential(new DriveByEncoder(15));
    	addSequential(new DriveByEncoder(15));
    	addSequential(new Eject());
    	addParallel(new OpenCollector());
    	addParallel(new Lower(), 4);
    	addSequential(new DriveByEncoder(-30));
    	addSequential(new DriveByEncoder(-30));
    	addSequential(new RotateByNavX(-60));
    	addSequential(new DriveByEncoder(150));
    	addSequential(new DriveByEncoder(150));
    }
}

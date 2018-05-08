package org.usfirst.frc.team2231.robot.commands;

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
    	
    	addSequential(new DriveBySpeed(0.75), 0.35);
    	addSequential(new DriveBySpeed(0), 0.1);
    	addSequential(new RotateByNavX(36), 0.5);
    	addSequential(new LiftToSwitch());
    	addParallel(new KeepElevatorInPlace());
    	addParallel(new EvelatorPitchDrop(), 2);
    	addSequential(new DriveBySpeed(0.5), 2.4);
    	addParallel(new KeepElevatorInPlace());
    	addSequential(new EjectSlowly(), 0.5);
    	addSequential(new OpenCollector());
    	
    	// Collect and put second cube
    	addSequential(new DriveBySpeed(-0.4), 1);
    	addSequential(new LowerToBottom());
    	addSequential(new RotateByNavX(-58), 0.6);
    	addParallel(new Collect(), 1.3);
    	addSequential(new DriveBySpeed(0.5), 1.5);
    	addSequential(new CloseCollector());
    	addParallel(new Collect(), 1);
    	addSequential(new DriveBySpeed(-0.5), 1.3);
    	addSequential(new RotateByNavX(59), 0.8);
    	addSequential(new LiftToSwitch());
    	addParallel(new KeepElevatorInPlace());
    	addSequential(new DriveBySpeed(0.5), 1.5);
    	addSequential(new EjectSlowly(), 0.5);
    	addParallel(new OpenCollector());
    	
    	// Collect third cube
    	addSequential(new DriveBySpeed(-0.3), 1);
    	addSequential(new LowerToBottom());
    	addSequential(new RotateByNavX(-44), 0.6);
    	addParallel(new Collect(), 1);
    	addSequential(new DriveBySpeed(0.5), 1.45);
    	addSequential(new CloseCollector());
    	addParallel(new Collect(), 1);
    	addSequential(new DriveBySpeed(-0.7), 0.5);
    	
    }
}

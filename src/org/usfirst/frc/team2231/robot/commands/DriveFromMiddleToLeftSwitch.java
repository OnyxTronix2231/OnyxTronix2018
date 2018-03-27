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

        // 	To run multiple commands at the same time,
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
//    	addParallel(new RaiseBySpeed(0.7), 0);
    	addSequential(new LiftToSwitch());
    	addParallel(new KeepElevatorInPlace());
    	addParallel(new EvelatorPitchDrop(), 1);
    	addSequential(new DriveBySpeed(0.5), 2.2);
    	addParallel(new KeepElevatorInPlace());
    	addSequential(new EjectSlowly(), 0.5);
    	addSequential(new OpenCollector());
    	//collect and put second cube
    	addSequential(new DriveBySpeed(-0.3), 1.2);
    	addSequential(new LowerToBottom());
    	addSequential(new RotateByNavX(-57), 0.6);
    	addParallel(new Collect(), 1.3);
    	addSequential(new DriveBySpeed(0.5), 1.3);
    	addSequential(new CloseCollector());
    	addParallel(new Collect(), 1);
    	addSequential(new DriveBySpeed(-0.5), 1.3);
//    	addParallel(new EvelatorPitchRaise(), 1);
    	addSequential(new RotateByNavX(60), 0.8);
    	addSequential(new LiftToSwitch());
    	addParallel(new KeepElevatorInPlace());
    	addSequential(new DriveBySpeed(0.7), 1);
//    	addSequential(new EjectSlowly(), 0.3);
    	addParallel(new OpenCollector());
    	//collect third cube
    	addSequential(new DriveBySpeed(-0.3), 1);
    	addSequential(new LowerToBottom());
    	addSequential(new RotateByNavX(-53), 0.6);
    	addParallel(new Collect(), 1);
    	addSequential(new DriveBySpeed(0.5), 1.3);
    	addSequential(new CloseCollector());
    	addParallel(new Collect(), 1);
    	addSequential(new DriveBySpeed(-0.7), 0.5);
    }
}

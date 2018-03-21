package org.usfirst.frc.team2231.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToRightSwitchFromTheRight extends CommandGroup {

    public DriveToRightSwitchFromTheRight() {
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
    	addParallel(new RaiseBySpeed(0.7), 0.8);
    	addParallel(new EvelatorPitchDrop(), 1);
    	addSequential(new DriveBySpeed(0.4), 2.8);
    	addSequential(new DriveBySpeed(0), 0.1);
    	addParallel(new KeepElevatorInPlace());
    	addSequential(new RotateByNavX(-85), 0.7);
    	addParallel(new KeepElevatorInPlace());
    	addSequential(new DriveBySpeed(0.4), 2.4);
    	addSequential(new EjectSlowly(), 4);
    	
    }
}

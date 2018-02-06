package org.usfirst.frc.team2231.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToLeftScale extends CommandGroup {

    public DriveToLeftScale() {
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
    	
    	addSequential(new DriveInCircle(10));
    	//addSequential(new ElevatorPitchDrop());
    	//addSequential(new Collect());
    	//addSequential(new DriveInCircle(193));
    	//addSequential(new ElevatorPitchRaise());
    	addSequential(new DriveInCircle(86.5, 58.5));
    	//addSequential(new DriveInCircle(133.47));
    	//addSequential(new DriveInCircle(70,98));
    	//addSequential(new DriveInCircle(-30.6, 30.6));
    	//addSequential(new Raise());
    	//addSequential(new ElevatorPitchDrop());
    	addSequential(new Eject());

    }
}

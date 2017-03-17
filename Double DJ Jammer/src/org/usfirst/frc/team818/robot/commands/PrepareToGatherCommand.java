package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class PrepareToGatherCommand extends CommandGroup {
	
    public  PrepareToGatherCommand() {
    	
    	addParallel(new GathererOpenCommand(true));
    	addSequential(new ExtenderExtendCommand());
    	
    }
}

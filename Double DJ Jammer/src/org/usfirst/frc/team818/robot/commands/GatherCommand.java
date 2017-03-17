package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.unused.DriveStraightCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class GatherCommand extends CommandGroup {
	
    public  GatherCommand() {
    	
    	addParallel(new DriveStraightCommand(0.5, 1.0));
    	addParallel(new GathererCloseCommand(true));
    	addSequential(new GathererCollectCommand(true));
    	
    	addSequential(new TowerBottomCommand());
    	
    	addSequential(new TowerUpCommand(true));
    	
    }
}

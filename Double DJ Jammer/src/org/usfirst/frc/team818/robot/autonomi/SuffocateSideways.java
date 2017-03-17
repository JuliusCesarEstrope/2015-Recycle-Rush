package org.usfirst.frc.team818.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team818.robot.commands.GathererCollectCommand;
import org.usfirst.frc.team818.robot.commands.GathererOpenCommand;
import org.usfirst.frc.team818.robot.unused.DriveStraightCommand;


public class SuffocateSideways extends CommandGroup {
	
	public  SuffocateSideways() {
		
		addSequential(new GathererOpenCommand(true));
		
		addParallel(new GathererCollectCommand(true));
		addSequential(new DriveStraightCommand(-0.8, 0, 1.0));
		
	}
}

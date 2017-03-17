package org.usfirst.frc.team818.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team818.robot.commands.GathererCloseCommand;
import org.usfirst.frc.team818.robot.unused.DriveStraightCommand;


public class OpenForward extends CommandGroup {
	
	public  OpenForward() {
		
		addSequential(new GathererCloseCommand(true));
		addSequential(new DriveStraightCommand(0.8, 1.0));
		
	}
}

package org.usfirst.frc.team818.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team818.robot.unused.DriveStraightCommand;


public class MoveForward extends CommandGroup {
	
	public  MoveForward() {
		
		addSequential(new DriveStraightCommand(0.8, 1.0));
		
	}
}

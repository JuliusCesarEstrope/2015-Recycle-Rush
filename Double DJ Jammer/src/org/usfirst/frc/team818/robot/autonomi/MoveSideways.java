package org.usfirst.frc.team818.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team818.robot.unused.DriveStraightCommand;


public class MoveSideways extends CommandGroup {
	
	public  MoveSideways() {
		
		addSequential(new DriveStraightCommand(-0.8, 0, 1.0));
		
	}
}

package org.usfirst.frc.team818.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team818.robot.commands.GathererCloseCommand;
import org.usfirst.frc.team818.robot.commands.GathererCollectCommand;
import org.usfirst.frc.team818.robot.commands.GathererOpenCommand;
import org.usfirst.frc.team818.robot.commands.TowerDownCommand;
import org.usfirst.frc.team818.robot.commands.TowerHomeCommand;
import org.usfirst.frc.team818.robot.commands.TowerUpCommand;
import org.usfirst.frc.team818.robot.unused.DriveStraightCommand;


public class OneBackLeft extends CommandGroup {
	
	public  OneBackLeft() {
		
		addParallel(new GathererCloseCommand(true));
		addParallel(new TowerHomeCommand());
		addSequential(new DriveStraightCommand(0.8, 0, 0.3));
		
		addSequential(new GathererOpenCommand(true));
		
		addParallel(new GathererCollectCommand(true));
		addSequential(new DriveStraightCommand(0.8, 0.3));
		
		addSequential(new TowerDownCommand(true));
		addSequential(new TowerUpCommand(true));
		
		//addSequential(new DriveForTime(0.8, -0.8, 0.5));
		addSequential(new DriveStraightCommand(0.8, 1.0));
		
	}
}

package org.usfirst.frc.team818.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team818.robot.commands.DriveTimed;
import org.usfirst.frc.team818.robot.commands.GathererCloseCommand;


public class Auton1 extends CommandGroup {
	
	public  Auton1() {
		
		addSequential(new GathererCloseCommand(true));
		addSequential(new DriveTimed(SmartDashboard.getNumber("Number 2"), SmartDashboard.getNumber("Number 3"), SmartDashboard.getNumber("Number 4"), SmartDashboard.getNumber("Number 5")));
		
	}
}

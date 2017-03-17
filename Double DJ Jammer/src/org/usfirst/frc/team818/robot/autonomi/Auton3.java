package org.usfirst.frc.team818.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.usfirst.frc.team818.robot.commands.DriveTimed;
//import org.usfirst.frc.team818.robot.commands.TowerDownCommand;
import org.usfirst.frc.team818.robot.commands.TowerUpCommand;


public class Auton3 extends CommandGroup {
	
	public  Auton3() {
		
		addSequential(new TowerUpCommand(true, SmartDashboard.getNumber("Number 6")));
		
	}
}
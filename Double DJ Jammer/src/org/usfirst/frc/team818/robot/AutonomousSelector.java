package org.usfirst.frc.team818.robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.autonomi.*;


public class AutonomousSelector {
	
	public static CommandGroup getSelectedAutonomous() {
		
		int autonomousIndex;
		CommandGroup autonomous;
		
		try {
			autonomousIndex = (int)SmartDashboard.getNumber("Autonomous");
			RobotLog.putMessage("Found autonomous index: " + autonomousIndex);
		} catch (Exception exc) {
			autonomousIndex = 0;
			RobotLog.putMessage(exc.toString());
			RobotLog.putMessage("No autonomous index found; defaulting to nothing");
		}
		
		try {
			autonomous = (CommandGroup)Class.forName("org.usfirst.frc.team818.robot.autonomi." + Constants.autonomi[autonomousIndex]).newInstance();
			RobotLog.putMessage("Initialized autonomous group: " + Constants.autonomi[autonomousIndex]);
		} catch (Exception exc) {
			autonomous = new DoNothing();
			RobotLog.putMessage(exc.toString());
			RobotLog.putMessage("Failed to initialize autonomous group");
		}
		
		return autonomous;
		
	}
}

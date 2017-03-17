package org.usfirst.frc.team818.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team818.robot.commands.CommandBase;


public class RobotMain extends IterativeRobot {
	
	CommandGroup autoCommand;
	
	public void robotInit() {
		
		RobotLog.init();
		RobotLog.putMessage("This is the Double DJ Jammer beginning execution. Over.");
		CommandBase.init();
		
	}

	public void autonomousInit() {
		autoCommand = AutonomousSelector.getSelectedAutonomous();
		autoCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void testInit() {
		
	}
	
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public void disabledInit(){
		CommandBase.disable();
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
}

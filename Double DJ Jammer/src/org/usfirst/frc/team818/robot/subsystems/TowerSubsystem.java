package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team818.robot.RobotLog;


public class TowerSubsystem extends Subsystem {
	
	private final double SPEED = 1;
	
	private boolean enabled;
	
	private Talon motor;
	
	public TowerSubsystem(int motorPort, boolean enabled) {
		
		this.enabled = enabled;
		
		if (enabled) {
			
			RobotLog.putMessage("Initializing tower");
			
			motor = new Talon(9);
			
			RobotLog.putMessage("Successfully initialized the tower");
			
		}
	}

	public void initDefaultCommand() {
	}
	
	public void up() {
		if (enabled) {
			motor.set(SPEED);
		}
	}
	
	public void down() {
		if (enabled) {
			motor.set(-SPEED);
		}
	}
	
	public void setSpeed(double speed) {
		if (enabled) {
			motor.set(-speed);
		}
	}
	
	public void stop() {
		if (enabled) {
			motor.set(0);
		}
	}
}

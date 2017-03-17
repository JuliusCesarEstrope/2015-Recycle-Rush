package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team818.robot.RobotLog;


public class ExtenderSubsystem extends Subsystem {
	
	private final double SPEED = 1;
	
	private boolean enabled;
	
	private Talon motor;
	//private DigitalInput limitOuter;
	private DigitalInput limitInner;

	public ExtenderSubsystem(int motorPort, int[] limitPorts, boolean enabled) {
		
		this.enabled = enabled;
		
		if (enabled) {
			
			RobotLog.putMessage("Initializing extender");
			
			motor = new Talon(motorPort);
			//limitOuter = new DigitalInput(limitPorts[0]);
			limitInner = new DigitalInput(limitPorts[1]);
			
			RobotLog.putMessage("Successfully initialized the extender");
			
		}
	}
	
	public void initDefaultCommand() {
	}
	
	public void extend() {
		if (enabled) {
			motor.set(-SPEED);
		}
	}
	
	public void retract() {
		if (enabled) {
			motor.set(SPEED);
		}
	}
	
	public void setSpeed(double speed) {
		if (enabled) {
			motor.set(speed);
		}
	}
	
	public void stop() {
		if (enabled) {
			motor.set(0);
		}
	}
	
	public boolean outerLimit() {
		return false;
		/*if (enabled) {
			return limitOuter.get();
		} else {
			return false;
		}*/
	}
	
	public boolean innerLimit() {
		if (enabled) {
			return !limitInner.get();
		} else {
			return false;
		}
	}
}

package org.usfirst.frc.team818.robot.subsystems;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team818.robot.RobotLog;


public class GathererWheelSubsystem extends Subsystem {
	
	private final double WHEEL_SPEED = 0.8;
	
	private boolean enabled;
	
	private Talon[] motorsWheel = new Talon[2];
	//private DigitalInput[] limitsOuter = new DigitalInput[2];
	//private DigitalInput[] limitsInner = new DigitalInput[2];

	public GathererWheelSubsystem(int[] motorPorts, int[] limitPorts, boolean enabled) {
		
		this.enabled = enabled;
		
		if (enabled) {
			
			RobotLog.putMessage("Initializing gatherer");
			
			for (int i = 0; i < 2; i++) {
				motorsWheel[i] = new Talon(motorPorts[i]);
			}
			
			for (int i = 0; i < 2; i++) {
				//limitsOuter[i] = new DigitalInput(limitPorts[i]);
				//limitsInner[i] = new DigitalInput(limitPorts[i + 2]);
			}
			
			RobotLog.putMessage("Successfully initialized the gatherer");
			
		}
	}
	
	public void initDefaultCommand() {
	}
	
	public void collect() {
		if (enabled) {
			motorsWheel[0].set(-WHEEL_SPEED);
			motorsWheel[1].set(WHEEL_SPEED);
		}
	}
	
	public void dispense() {
		if (enabled) {
			motorsWheel[0].set(WHEEL_SPEED);
			motorsWheel[1].set(-WHEEL_SPEED);
		}
	}
	
	public void stopWheels() {
		if (enabled) {
			motorsWheel[0].set(0);
			motorsWheel[1].set(0);
		}
	}
	
	public boolean leftOuterLimit() {
		return false;
		/*if (enabled) {
			return limitsOuter[0].get();
		} else {
			return true;
		}*/
	}
	
	public boolean rightOuterLimit() {
		return false;
		/*if (enabled) {
			return limitsOuter[1].get();
		} else {
			return true;
		}*/
	}
	
	public boolean leftInnerLimit() {
		return false;
		/*if (enabled) {
			return limitsInner[0].get();
		} else {
			return true;
		}*/
	}
	
	public boolean rightInnerLimit() {
		return false;
		/*if (enabled) {
			return limitsInner[1].get();
		} else {
			return true;
		}*/
	}
}

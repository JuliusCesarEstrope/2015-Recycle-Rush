package org.usfirst.frc.team818.robot.subsystems;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team818.robot.RobotLog;


public class GathererArmSubsystem extends Subsystem {
	
	private double ARM_SPEED1 = 0.3;
	private final double ARM_SPEED2 = 0.3;
	
	private boolean enabled;
	
	private Talon[] motorsArm = new Talon[2];
	//private DigitalInput[] limitsOuter = new DigitalInput[2];
	//private DigitalInput[] limitsInner = new DigitalInput[2];

	public GathererArmSubsystem(int[] motorPorts, int[] limitPorts, boolean enabled) {
		
		this.enabled = enabled;
		
		if (enabled) {
			
			RobotLog.putMessage("Initializing gatherer arms");
			
			for (int i = 0; i < 2; i++) {
				motorsArm[i] = new Talon(motorPorts[i + 2]);
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
	
	public void open() {
		if (enabled) {
			motorsArm[0].set(ARM_SPEED1);
			motorsArm[1].set(-ARM_SPEED2);
		}
	}
	
	public void close() {
		if (enabled) {
			motorsArm[0].set(-ARM_SPEED1);
			motorsArm[1].set(ARM_SPEED2);
		}
	}
	
	public void stopArms() {
		if (enabled) {
			motorsArm[0].set(0);
			motorsArm[1].set(0);
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

package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Subsystem;

//import org.usfirst.frc.team818.robot.commands.TowerPositioningCommand;


public class TowerPositioningSubsystem extends Subsystem {
	
	private boolean enabled;
	private int homeDirection;
	private int towerMoving;
	
	//private DigitalInput thingie;
	//private DigitalInput upperLimit;
	private DigitalInput lowerLimit;
	
	//private Trigger updateTrigger;
	
	public TowerPositioningSubsystem(int thingiePort, int[] limitPorts, boolean enabled) {
		
		this.enabled = enabled;
		
		if (enabled) {
			
			//thingie = new DigitalInput(thingiePort);
			//upperLimit = new DigitalInput(limitPorts[0]);
			lowerLimit = new DigitalInput(limitPorts[1]);
			
			/*updateTrigger = new Trigger() {
				public boolean get() {
					return atHome();
				}
			};
			
			updateTrigger.whenInactive(new TowerPositioningCommand());*/
			
		}
	}

	public void initDefaultCommand() {
	}
	
	public int homeDirection() {
		return homeDirection;
	}
	
	public void setHomeDirection(int direction) {
		homeDirection = direction;
	}
	
	public int towerMovingDirection() {
		return towerMoving;
	}
	
	public void towerMoving(int direction) {
		if (Math.abs(direction) <= 1) {
			towerMoving = direction;
		}
	}
	
	public boolean upperLimit() {
		return false;
		/*if (enabled) {
			return upperLimit.get();
		} else {
			return false;
		}*/
	}
	
	public boolean atHome() {
		return false;
		/*if (enabled) {
			return !thingie.get();
		} else {
			return false;
		}*/
	}
	
	public boolean lowerLimit() {
		if (enabled) {
			return !lowerLimit.get();
		} else {
			return false;
		}
	}
	
}

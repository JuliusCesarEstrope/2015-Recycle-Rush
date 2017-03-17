package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;


public class CameraServoSubsystem extends Subsystem {
	
	private boolean enabled;
	
	private Servo servoX;
	private Servo servoY;
	
	public CameraServoSubsystem(int portX, int portY, boolean enabled) {
		
		this.enabled = enabled;
		
		if (enabled) {
			servoX = new Servo(portX);
			servoY = new Servo(portY);
			servoX.set(0.454);
			servoY.set(0.85);
		}
	}

	public void initDefaultCommand() {
	}
	
	public void right() {
		if (enabled) {
			double position = servoX.get();
			setXPosition(position + 0.01);
		}
	}
	
	public void left() {
		if (enabled) {
			double position = servoX.get();
			setXPosition(position - 0.01);
		}
	}
		
	public void up() {
		if (enabled) {
			double position = servoY.get();
			setYPosition(position + 0.01);
		}
	}
		
	public void down() {
		if (enabled) {
			double position = servoY.get();
			setYPosition(position - 0.01);
		}
	}
	
	public void setPosition(double positionX, double positionY) {
		if (enabled) {
			if (positionX >= 0 && positionX <= 1) servoX.set(positionX);
			if (positionY >= 0 && positionY <= 1) servoY.set(positionY);
		}
	}
	
	public void setXPosition(double positionX) {
		if (enabled) {
			double positionY = servoY.get();
			setPosition(positionX, positionY);
		}
	}
	
	public void setYPosition(double positionY) {
		if (enabled) {
			double positionX = servoX.get();
			setPosition(positionX, positionY);
		}
	}
}

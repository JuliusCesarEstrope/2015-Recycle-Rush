package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.commands.DriveAligned;


public class DriveSubsystem extends Subsystem {
	
	private boolean testBot;
	private boolean gyroEnabled;
	
	private Talon[] motorsLeft;
	private Talon[] motorsRight;
	private Talon motorCenter;
	
	private AnalogGyro gyro;
	
	public DriveSubsystem(int[] motorPorts, int gyroPort, boolean testBot, boolean gyroEnabled) {
		
		this.testBot = testBot;
		this.gyroEnabled = gyroEnabled;
		
		if (testBot) {
			RobotLog.putMessage("Initializing the robot as testbot with" + (gyroEnabled ? "" : "out") + " the gyro");
			motorsLeft = new Talon[2];
			motorsRight = new Talon[2];
			if (motorPorts.length == 4) {
				for (int i = 0; i < 2; i++) {
					motorsLeft[i] = new Talon(motorPorts[i]);
					motorsRight[i] = new Talon(motorPorts[i + 2]);
				}
			} else {
				RobotLog.putMessage("The drive motor ports do not match the testbot");
			}
		} else {
			RobotLog.putMessage("Initializing the robot with" + (gyroEnabled ? "" : "out") + " the gyro");
			motorsLeft = new Talon[1];
			motorsRight = new Talon[1];
			if (motorPorts.length == 3) {
				motorsLeft[0] = new Talon(motorPorts[0]);
				motorCenter = new Talon(motorPorts[1]);
				motorsRight[0] = new Talon(motorPorts[2]);
			} else {
				RobotLog.putMessage("The drive motor ports do not match the robot");
			}
		}
		
		if (gyroEnabled) {
			gyro = new AnalogGyro(gyroPort);
			gyro.initGyro();
		}
		
		RobotLog.putMessage("Successfully initialized the drive");
		
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveAligned());
	}
	
	public void setLeft(double speed) {
		if (!(Math.abs(speed) <= 1)) speed = 0;
		for (int i = 0; i < motorsLeft.length; i++) {
			motorsLeft[i].set(speed);
		}
	}
	
	public void setCenter(double speed) {
		if (!testBot) {
			if (!(Math.abs(speed) <= 1)) speed = 0;
			motorCenter.set(speed);
		}
	}
	
	public void setRight(double speed) {
		if (!(Math.abs(speed) <= 1)) speed = 0;
		for (int i = 0; i < motorsRight.length; i++) {
			motorsRight[i].set(-speed);
		}
	}
	
	public void setMotors(double speedLeft, double speedCenter, double speedRight) {
		setLeft(speedLeft);
		setCenter(speedCenter);
		setRight(speedRight);
	}
	
	public void setMotors(double speedLeft, double speedRight) {
		setMotors(speedLeft, 0, speedRight);
	}
	
	public double gyroAngle() {
		if (gyroEnabled) {
			return gyro.getAngle();
		} else {
			return 0;
		}
	}
	
	public void resetGyro() {
		if (gyroEnabled) {
			gyro.reset();
		}
	}
	
}

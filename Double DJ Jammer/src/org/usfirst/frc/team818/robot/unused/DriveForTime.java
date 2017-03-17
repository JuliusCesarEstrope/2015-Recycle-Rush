package org.usfirst.frc.team818.robot.unused;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.commands.CommandBase;


public class DriveForTime extends CommandBase {
	
	private Timer timer;
	
	//private double speedLeft;
	//private double speedFront;
	//private double speedBack;
	//private double speedRight;
	private double time;
	
	public DriveForTime(double speedLeft, double speedFront, double speedBack, double speedRight, double time) {
		
		requires(drive);
		
		timer = new Timer();
		
		//this.speedLeft = speedLeft;
		//this.speedFront = speedFront;
		//this.speedBack = speedBack;
		//this.speedRight = speedRight;
		this.time = time;
		
	}
	
	public DriveForTime(double speedLeft, double speedCenter, double speedRight, double time) {
		this(speedLeft, speedCenter, speedCenter, speedRight, time);
	}
	
	public DriveForTime(double speedLeft, double speedRight, double time) {
		this(speedLeft, 0, 0, speedRight, time);
	}

	protected void initialize() {
		RobotLog.putMessage("Driving automatically for time: " + time);
		timer.start();
		//drive.setMotors(speedLeft, speedFront, speedBack, speedRight);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return timer.hasPeriodPassed(time);
	}

	protected void end() {
		drive.setMotors(0, 0);
	}

	protected void interrupted() {
		drive.setMotors(0, 0);
	}
}

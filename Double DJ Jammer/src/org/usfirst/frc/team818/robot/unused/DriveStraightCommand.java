package org.usfirst.frc.team818.robot.unused;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.RobotUtilities;
import org.usfirst.frc.team818.robot.commands.CommandBase;


public class DriveStraightCommand extends CommandBase {
	
	private final double CORRECTION = 0.03;
	
	private Timer timer;
	
	private int direction;
	private boolean timed;
	private double speedX;
	private double speedY;
	private double time;
	
	private double angle;
	private double speedLeft;
	private double speedRight;
	private double speedFront;
	private double speedBack;
	private double slowConstant;
	
	public DriveStraightCommand() {
		this(0);
	}
	
	public DriveStraightCommand(int direction) {
		requires(drive);
		timed = false;
		slowConstant = Constants.slowConstant;
		this.direction = direction;
	}
	
	public DriveStraightCommand(double speedY, double time) {
		this(0, speedY, time);
	}
	
	public DriveStraightCommand(double speedX, double speedY, double time) {
		
		requires(drive);
		
		timer = new Timer();
		timed = true;
		this.speedX = speedX;
		this.speedY = speedY;
		this.time = time;
		this.direction = 0;
		slowConstant = Constants.slowConstant;
		
	}

	protected void initialize() {
		
		if (timed) {
			RobotLog.putMessage("Driving super-straight for time: " + time);
		} else {
			RobotLog.putMessage("Enabling super-straight drive");
			SmartDashboard.putString("Drive Type", "Robot in Perfect Alignment");
		}
		
		angle = 0;
		speedLeft = 0;
		speedRight = 0;
		speedFront = 0;
		speedBack = 0;
		
		drive.resetGyro();
		
		if (timed) timer.start();
		
	}

	protected void execute() {
		
		angle = drive.gyroAngle();
		
		if (direction >= 0) {
			speedLeft = timed ? speedY : (0.7 * oi.leftY());
			speedRight = timed ? speedY : (0.8 * oi.leftY());
		}
		if (direction <= 0) {
			speedFront = timed ? speedX : (0.8 * oi.leftX());
			speedBack = timed ? speedX : (0.7 * oi.leftX());
		}
		
		speedLeft = RobotUtilities.floorSmall(speedLeft);
		speedRight = RobotUtilities.floorSmall(speedRight);
		speedFront = RobotUtilities.floorSmall(speedFront);
		speedBack = RobotUtilities.floorSmall(speedBack);
		
		if (speedLeft != 0) speedLeft -= CORRECTION * angle;
		if (speedBack != 0) speedBack -= CORRECTION * angle;
		
		if (Math.abs(speedLeft) > 1) speedLeft = (speedLeft > 1) ? 1 : -1;
		if (Math.abs(speedBack) > 1) speedBack = (speedBack > 1) ? 1 : -1;
		
		if (oi.driveSlow()) {
			speedLeft *= slowConstant;
			speedRight *= slowConstant;
			speedFront *= slowConstant;
			speedBack *= slowConstant;
		}
		
		//drive.setMotors(speedLeft, speedFront, speedBack, speedRight);
		
	}

	protected boolean isFinished() {
		return (timed) ? timer.hasPeriodPassed(time) : false;
	}

	protected void end() {
		//drive.setMotors(0, 0, 0, 0);
	}

	protected void interrupted() {
		//drive.setMotors(0, 0, 0, 0);
	}
}

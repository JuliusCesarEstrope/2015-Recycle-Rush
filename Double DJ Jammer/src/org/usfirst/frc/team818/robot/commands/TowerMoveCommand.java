package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team818.robot.RobotLog;


public class TowerMoveCommand extends CommandBase{
	
	private Timer timer;
	
	private boolean timed;
	private double time;
	private double axisValue;
	private double speed;
	
	public TowerMoveCommand() {
		requires(tower);
		timed = false;
	}
	
	public TowerMoveCommand(double speed, double time) {
		
		requires(tower);
		
		timer = new Timer();
		timed = true;

		this.speed = speed;
		this.time = time;
		
	}

	protected void initialize() {
		
		RobotLog.putMessage("Moving the tower variably");
		speed = 0;
		
		if (timed) timer.start();
		
	}

	protected void execute() {
		axisValue = oi.towerAxis();
		if (!timed) speed = (axisValue > 0) ? ((axisValue - 0.65) / 0.35) : ((axisValue + 0.65) / 0.35);
		towerPositioning.towerMoving((speed > 0) ? 1 : -1);
		if (!((towerPositioning.upperLimit() && speed < 0) || (towerPositioning.lowerLimit() && speed > 0))) {
			tower.setSpeed(speed);
		} else {
			tower.stop();
		}
	}

	protected boolean isFinished() {
		return (timed) ? timer.hasPeriodPassed(time) : false;
	}

	protected void end() {
		towerPositioning.towerMoving(0);
		tower.stop();
	}

	protected void interrupted() {
		towerPositioning.towerMoving(0);
		tower.stop();
	}
	
}

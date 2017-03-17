package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team818.robot.RobotLog;


public class TowerUpCommand extends CommandBase {
	
	private Timer timer;
	
	private boolean timed;
	private double time;
	
	public TowerUpCommand(boolean timed, double time) {
		requires(tower);
		this.timed = timed;
		this.time = time;
	}
	
	public TowerUpCommand(boolean timed) {
		this(timed, 0);
	}

	protected void initialize() {
		towerPositioning.towerMoving(1);
		if (!towerPositioning.upperLimit()) {
			if (timed) {
				RobotLog.putMessage("Upscaling tower in a timely manner");
				timer = new Timer();
				timer.start();
			} else {
				RobotLog.putMessage("Upscaling tower");
			}
			tower.up();
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		if (timed) {
			return (timer.hasPeriodPassed(time) || towerPositioning.upperLimit());
		} else {
			return towerPositioning.upperLimit();
		}
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

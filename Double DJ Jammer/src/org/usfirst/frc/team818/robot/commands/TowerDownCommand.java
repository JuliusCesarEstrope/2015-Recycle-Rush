package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team818.robot.RobotLog;


public class TowerDownCommand extends CommandBase {
	
	private Timer timer;
	
	private boolean timed;
	private double time;
	
	public TowerDownCommand(boolean timed, double time) {
		requires(tower);
		this.timed = timed;
		this.time = time;
	}
	
	public TowerDownCommand(boolean timed) {
		this(timed, 0);
	}

	protected void initialize() {
		towerPositioning.towerMoving(-1);
		if (!towerPositioning.lowerLimit()) {
			if (timed) {
				RobotLog.putMessage("Downscaling tower in a timely manner");
				timer = new Timer();
				timer.start();
			} else {
				RobotLog.putMessage("Downscaling tower");
			}
			tower.down();
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		if (timed) {
			return (timer.hasPeriodPassed(time) || towerPositioning.lowerLimit());
		} else {
			return towerPositioning.lowerLimit();
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

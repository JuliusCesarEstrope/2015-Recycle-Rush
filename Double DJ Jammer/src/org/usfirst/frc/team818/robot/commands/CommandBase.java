package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.OI;
import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.subsystems.*;


public abstract class CommandBase extends Command {
	
	public static OI oi;
	
	public static CameraServoSubsystem cameraServo = new CameraServoSubsystem(Constants.cameraServoX, Constants.cameraServoY, Constants.cameraServoEnabled);
	public static CameraSubsystem camera = new CameraSubsystem(Constants.cameraName, Constants.cameraEnabled);
	public static DriveSubsystem drive = new DriveSubsystem(Constants.driveMotorPorts, Constants.gyroPort, Constants.testBot, Constants.gyroEnabled);
	public static ExtenderSubsystem extender = new ExtenderSubsystem(Constants.extenderMotorPort, Constants.extenderLimitPorts, Constants.extenderEnabled);
	public static GathererArmSubsystem gathererArms = new GathererArmSubsystem(Constants.gathererMotorPorts, Constants.gathererLimitPorts, Constants.gathererEnabled);
	public static GathererWheelSubsystem gathererWheels = new GathererWheelSubsystem(Constants.gathererMotorPorts, Constants.gathererLimitPorts, Constants.gathererEnabled);
	public static TowerPositioningSubsystem towerPositioning = new TowerPositioningSubsystem(Constants.towerThingiePort, Constants.towerLimitPorts, Constants.towerEnabled);
	public static TowerSubsystem tower = new TowerSubsystem(Constants.towerMotorPort, Constants.towerEnabled);
	
	public static void init() {
		oi = new OI();
		RobotLog.putMessage("Everything initialized correctly");
	}
	
	public static void disable() {
		cameraServo.setPosition(0.454, 0.85);
		drive.setMotors(0, 0, 0);
		extender.stop();
		gathererArms.stopArms();
		gathererWheels.stopWheels();
		tower.stop();
	}
	
	public CommandBase(String name) {
		super(name);
	}
	
	public CommandBase() {
		super();
	}
}

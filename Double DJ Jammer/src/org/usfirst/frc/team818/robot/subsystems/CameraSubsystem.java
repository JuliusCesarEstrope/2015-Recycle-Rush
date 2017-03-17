package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;


public class CameraSubsystem extends Subsystem {
	
	public USBCamera usbCamera;
	private CameraServer server;
	
	public CameraSubsystem(String cameraName, boolean enabled) {
		if (enabled) {
			usbCamera = new USBCamera(cameraName);
			server = CameraServer.getInstance();
	        server.setQuality(50);
	        server.startAutomaticCapture(usbCamera);
		}
	}

	public void initDefaultCommand() {
	}
}

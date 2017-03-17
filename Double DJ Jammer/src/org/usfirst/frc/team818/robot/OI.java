package org.usfirst.frc.team818.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team818.robot.commands.DriveTankish;
import org.usfirst.frc.team818.robot.commands.DriveTurning;
import org.usfirst.frc.team818.robot.commands.DriveStrafeCommand;
import org.usfirst.frc.team818.robot.commands.ExtenderExtendCommand;
import org.usfirst.frc.team818.robot.commands.ExtenderMoveCommand;
import org.usfirst.frc.team818.robot.commands.ExtenderRetractCommand;
//import org.usfirst.frc.team818.robot.commands.GatherCombineCommand;
import org.usfirst.frc.team818.robot.commands.GathererCloseCommand;
import org.usfirst.frc.team818.robot.commands.GathererCollectCommand;
import org.usfirst.frc.team818.robot.commands.GathererDispenseCommand;
import org.usfirst.frc.team818.robot.commands.GathererOpenCommand;
import org.usfirst.frc.team818.robot.commands.ResetGyroCommand;
import org.usfirst.frc.team818.robot.commands.TowerBottomCommand;
import org.usfirst.frc.team818.robot.commands.TowerDownCommand;
import org.usfirst.frc.team818.robot.commands.TowerHomeCommand;
import org.usfirst.frc.team818.robot.commands.TowerMoveCommand;
import org.usfirst.frc.team818.robot.commands.TowerTopCommand;
import org.usfirst.frc.team818.robot.unused.DriveStraightCommand;


public class OI {
	
	public boolean tankishEnabled;
	
	private Joystick driver, operator;
	
	private JoystickButton slowDriveButton;
	private JoystickButton gathererOpenButton;
	private JoystickButton strafeLeftButton, strafeRightButton;
	private JoystickButton towerTopButton, towerHomeButton, towerBottomButton, towerDownButton;
	
	private Trigger turnTrigger, resetGyroTrigger, tankishTrigger;
	private Trigger driveStraightTrigger, driveSideTrigger;
	private Trigger gathererCloseTrigger, gathererCollectTrigger, gathererDispenseTrigger/*, gatherButton*/;
	private Trigger towerTrigger;
	private Trigger extenderTrigger, extenderExtendTrigger, extenderRetractTrigger;
	
	public OI() {
		
		tankishEnabled = false;
		
		driver = new Joystick(Constants.driverControllerPort);
		operator = new Joystick(Constants.operatorControllerPort);
		
		slowDriveButton = new JoystickButton(driver, 3);
		gathererOpenButton = new JoystickButton(operator, 7);
		strafeLeftButton = new JoystickButton(driver, 5);
		strafeRightButton = new JoystickButton(driver, 6);
		towerTopButton = new JoystickButton(operator, 4);
		towerHomeButton = new JoystickButton(operator, 3);
		towerBottomButton = new JoystickButton(operator, 2);
		towerDownButton = new JoystickButton(operator, 1);
		
		tankishTrigger = new Trigger() {
			public boolean get() {
				return (driver.getRawButton(9) && driver.getRawButton(10));
			}
		};
		turnTrigger = new Trigger() {
			public boolean get() {
				return ((Math.abs(driver.getRawAxis(2)) > 0.1) && !tankishEnabled);
			}
		};
		resetGyroTrigger = new Trigger() {
			public boolean get() {
				return (Math.abs(driver.getRawAxis(0)) > 0.1 && Math.abs(driver.getRawAxis(1)) > 0.1);
			}
		};
		driveStraightTrigger = new Trigger() {
			public boolean get() {
				return (driver.getRawButton(2) || driver.getRawButton(4));
			}
		};
		driveSideTrigger = new Trigger() {
			public boolean get() {
				return (driver.getRawButton(1) || driver.getRawButton(3));
			}
		};

		gathererCloseTrigger = new Trigger() {
			public boolean get() {
				return (operator.getRawButton(5));
			}
		};
		gathererCollectTrigger = new Trigger() {
			public boolean get() {
				return (driver.getRawButton(7) || operator.getRawButton(6));
			}
		};
		gathererDispenseTrigger = new Trigger() {
			public boolean get() {
				return (driver.getRawButton(8) || operator.getRawButton(8));
			}
		};
		towerTrigger = new Trigger() {
			public boolean get() {
				return (Math.abs(operator.getRawAxis(1)) > 0.7);
			}
		};
		extenderTrigger = new Trigger() {
			public boolean get() {
				return (Math.abs(operator.getRawAxis(2)) > 0.7);
			}
		};
		extenderExtendTrigger = new Trigger() {
			public boolean get() {
				return (operator.getPOV() == 0 || operator.getPOV() == 270);
			}
		};
		extenderRetractTrigger = new Trigger() {
			public boolean get() {
				return (operator.getPOV() == 90 || operator.getPOV() == 180);
			}
		};
		/*gatherButton = new Trigger() {
			public boolean get(){
				return (operator.getRawButton(6) && operator.getRawButton(5));
			}
		};*/
		
		gathererOpenButton.whileHeld(new GathererOpenCommand(false));
		strafeLeftButton.whileHeld(new DriveStrafeCommand(-0.4));
		strafeRightButton.whileHeld(new DriveStrafeCommand(0.4));
		towerTopButton.whileHeld(new TowerTopCommand()); //towerTopButton.whenPressed(new TowerTopCommand());
		towerHomeButton.whileHeld(new TowerHomeCommand()); //towerHomeButton.whenPressed(new TowerHomeCommand());
		towerBottomButton.whileHeld(new TowerBottomCommand()); //towerBottomButton.whenPressed(new TowerBottomCommand());
		towerDownButton.whenPressed(new TowerDownCommand(true));
		
		tankishTrigger.toggleWhenActive(new DriveTankish());
		turnTrigger.whileActive(new DriveTurning());
		resetGyroTrigger.whenActive(new ResetGyroCommand());
		driveStraightTrigger.whileActive(new DriveStraightCommand(1));
		driveSideTrigger.whileActive(new DriveStraightCommand(-1));
		gathererCloseTrigger.whileActive(new GathererCloseCommand(false));
		gathererCollectTrigger.whileActive(new GathererCollectCommand(false));
		gathererDispenseTrigger.whileActive(new GathererDispenseCommand());
		//gatherButton.whileActive(new GatherCombineCommand(false));
		towerTrigger.whileActive(new TowerMoveCommand());
		extenderTrigger.whileActive(new ExtenderMoveCommand());
		extenderExtendTrigger.whileActive(new ExtenderExtendCommand());
		extenderRetractTrigger.whileActive(new ExtenderRetractCommand());
		
	}
	
	public double leftX() {
		return driver.getRawAxis(0);
	}
	
	public double leftY() {
		return -driver.getRawAxis(1);
	}
	
	public double rightX() {
		return -driver.getRawAxis(2);
	}
	
	public double rightY() {
		return -driver.getRawAxis(3);
	}
	
	public double extenderAxis() {
		return operator.getRawAxis(2);
	}
	
	public double towerAxis() {
		return operator.getRawAxis(1);
	}
	
	public boolean driveSlow() {
		return slowDriveButton.get();
	}
}

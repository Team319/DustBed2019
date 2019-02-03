/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team319.robot;

import org.usfirst.frc.team319.robot.subsystems.Drivetrain;
import org.usfirst.frc.team319.robot.subsystems.Limelight;
import org.usfirst.frc.team319.robot.subsystems.Pneumatics;
import org.usfirst.frc.team319.robot.subsystems.SparkMax;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	Command autonomousCommand;
	SendableChooser<String> autoChooser;

	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Limelight limelight = new Limelight();
	public static final SparkMax sparkmax = new SparkMax();

	public static OI oi;

	// SendableChooser<Command> m_chooser = new SendableChooser<>();

	@Override
	public void robotInit() {

		oi = new OI();
		Robot.drivetrain.setDrivetrainPositionToZero();

	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
	/*	Scheduler.getInstance().run();
		SmartDashboard.putNumber("Driver Left Trigger", Robot.oi.driverController.triggers.getLeft());
		SmartDashboard.putNumber("Operator Left Stick Y", Robot.oi.operatorController.leftStick.getY());
*/	
		
	}

	@Override
	public void autonomousInit() {

		}

	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
	}

	@Override
	public void teleopInit() {

		
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	 
	@Override
	public void teleopPeriodic() {

		Scheduler.getInstance().run();
		SmartDashboard.putNumber("x",Robot.limelight.getX());
		SmartDashboard.putNumber("y",Robot.limelight.getY());
		SmartDashboard.putNumber("area",Robot.limelight.getArea());
		SmartDashboard.putNumber("Thor",Robot.limelight.getThor());
		SmartDashboard.putNumber("Vert",Robot.limelight.getVert());
		SmartDashboard.putNumber("hor",Robot.limelight.getVert());



	}

	@Override
	public void testPeriodic() {
	}

}

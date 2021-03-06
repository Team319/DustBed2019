/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team319.robot;

import org.usfirst.frc.team319.controllers.BobXboxController;
import org.usfirst.frc.team319.robot.commands.LimelightCommands.CalculateDistanceFromArea;
import org.usfirst.frc.team319.robot.commands.LimelightCommands.DriveThenExtend;
import org.usfirst.frc.team319.robot.commands.LimelightCommands.LimelightPistonExtend;
import org.usfirst.frc.team319.robot.commands.LimelightCommands.LimelightPistonRetract;
import org.usfirst.frc.team319.robot.commands.drivetrain.VisionDrive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public BobXboxController driverController;
	public BobXboxController operatorController;

	public OI() {

		driverController = new BobXboxController(0, 0.20, 0.03);

		driverController.leftTriggerButton.configureThreshold(0.075);

		driverController.bButton.whileHeld(new VisionDrive());
		driverController.xButton.whenPressed(new DriveThenExtend());

		// driverController.aButton.whileHeld(new SparkMaxRun());
		// driverController.yButton.whileHeld(new SparkMaxRunBackwards());
		driverController.yButton.whileHeld(new CalculateDistanceFromArea());

		driverController.startButton.whenPressed(new LimelightPistonRetract());
		driverController.selectButton.whenPressed(new LimelightPistonExtend());

	}
}

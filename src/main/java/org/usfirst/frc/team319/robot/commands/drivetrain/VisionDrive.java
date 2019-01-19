
package org.usfirst.frc.team319.robot.commands.drivetrain;


import org.usfirst.frc.team319.models.DriveSignal;
import org.usfirst.frc.team319.robot.Robot;
import org.usfirst.frc.team319.utils.BobDriveHelper;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionDrive extends Command {

	BobDriveHelper helper;
	private double quickTurnThreshold = 0.2;

	public VisionDrive() {
    requires(Robot.drivetrain);
		helper = new BobDriveHelper();
	}

	protected void initialize() {
	}

	protected void execute() {

    double x = Robot.limelight.getX();
    	
    double moveValue = Robot.limelight.track();

	double rotateValue = x * 0.03;
	//double rotateValue = Robot.oi.driverController.rightStick.getX();
    

   	boolean quickTurn = (moveValue < quickTurnThreshold && moveValue > -quickTurnThreshold);
		DriveSignal driveSignal = helper.cheesyDrive(-moveValue, rotateValue, quickTurn, false);
		Robot.drivetrain.drive(ControlMode.PercentOutput, driveSignal);
      
    	
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}

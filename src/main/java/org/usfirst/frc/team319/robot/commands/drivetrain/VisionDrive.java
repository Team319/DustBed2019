
package org.usfirst.frc.team319.robot.commands.drivetrain;


import org.usfirst.frc.team319.models.DriveSignal;
import org.usfirst.frc.team319.robot.Robot;
import org.usfirst.frc.team319.utils.BobDriveHelper;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionDrive extends Command {

	BobDriveHelper helper;
	//private double quickTurnThreshold = 3.0;

	public VisionDrive() {
    requires(Robot.drivetrain);
		helper = new BobDriveHelper();
	}

	protected void initialize() {
		Robot.limelight.setSetpoints(3.0,0.0);
		Robot.limelight.execute();
	}

	protected void execute() {

	double moveValue = Robot.limelight.trackDrive();
	double rotateValue = Robot.limelight.trackRotate();

	SmartDashboard.putNumber("Rotate Value", rotateValue);
	SmartDashboard.putNumber("Move Value", moveValue);


	//boolean quickTurn = (moveValue < quickTurnThreshold && moveValue > -quickTurnThreshold);
	   
	DriveSignal driveSignal = helper.cheesyDrive(-moveValue, rotateValue, false, false);
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


package org.usfirst.frc.team319.robot.commands.LimelightCommands;

import org.usfirst.frc.team319.models.DriveSignal;
import org.usfirst.frc.team319.robot.Robot;
import org.usfirst.frc.team319.utils.BobDriveHelper;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LimelightDrive extends Command {

	BobDriveHelper helper;
	private double quickTurnThreshold = 0.2;
	//private double threshold = 2.3;
	private double threshold;

	public LimelightDrive(double threshold) {

		requires(Robot.drivetrain);
		helper = new BobDriveHelper();
	
	}

	protected void initialize() {
	}

	protected void execute() {

		double moveValue = Robot.limelight.track();

		double rotateValue = Robot.oi.driverController.rightStick.getX();

		boolean quickTurn = (moveValue < quickTurnThreshold && moveValue > -quickTurnThreshold);
		DriveSignal driveSignal = helper.cheesyDrive(-moveValue, rotateValue, quickTurn, false);
		Robot.drivetrain.drive(ControlMode.PercentOutput, driveSignal);

	}

	protected boolean isFinished() {
		if (Robot.limelight.getArea() > threshold) {
			return true;
		} else {
			return false;
		}
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}

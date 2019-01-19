
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
	//private double quickTurnThreshold = 0.2;
	//private double threshold = 2.3;
	public double threshold = 0.0;
	
	public LimelightDrive(double threshold) {

		requires(Robot.drivetrain);
		helper = new BobDriveHelper();
		this.threshold = threshold;
	
	}

	protected void initialize() {
	}

	protected void execute() {

		double moveValue = Robot.limelight.trackDrive();

		double rotateValue = Robot.oi.driverController.rightStick.getX();

		//boolean quickTurn = (moveValue < quickTurnThreshold && moveValue > -quickTurnThreshold);
		DriveSignal driveSignal = helper.cheesyDrive(-moveValue, rotateValue, false, false);
		Robot.drivetrain.drive(ControlMode.PercentOutput, driveSignal);

	}

	protected void end() {
	}

	protected void interrupted() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}

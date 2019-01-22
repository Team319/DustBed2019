
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
	public double finishedThreshold = 0.0;
	public double area = Robot.limelight.getArea();


	public LimelightDrive(double finishedThreshold) {

		requires(Robot.drivetrain);
		helper = new BobDriveHelper();
		this.finishedThreshold = finishedThreshold;
	
	}

	protected void initialize() {
		Robot.limelight.setSetpoints(5.0,0.0);
		Robot.limelight.execute();
	}

	protected void execute() {

		double moveValue = Robot.limelight.trackDrive();
		double rotateValue = Robot.limelight.trackRotate();

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
		if (area >= 5.0){
			return true;
			
		}else{
			return false;
		}
	}
}

package org.usfirst.frc.team319.robot.subsystems;

import java.awt.Robot;

import org.usfirst.frc.team319.robot.commands.LimelightCommands.DriveToTarget;
import org.usfirst.frc.team319.robot.commands.LimelightCommands.RotateToTarget;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class Limelight {

   NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
   NetworkTableEntry tx = table.getEntry("tx");
   NetworkTableEntry ty = table.getEntry("ty");
   NetworkTableEntry ta = table.getEntry("ta");

   double moveValue = 0.0;
   double rotateValue = 0.0;

   double kPD = 0.07;
   double kID = 0.0;
   double kDD = 0.09;//0.05
   DriveToTarget pidD_ = new DriveToTarget(kPD, kID, kDD);

   double kPR = 0.05;
   double kIR = 0.0;
   double kDR = 0.07;
   RotateToTarget pidR_ = new RotateToTarget(kPR, kIR, kDR);

   public void execute(){
      pidD_.start();
      pidR_.start();
   }

   public void setSetpoints(double drive_setpoint, double rotate_setpoint){
      pidD_.setSetpoint(drive_setpoint);
      pidR_.setSetpoint(rotate_setpoint);
   }

   /*
    * // read values periodically double x = tx.getDouble(0.0); double y =
    * ty.getDouble(0.0); double area = ta.getDouble(0.0);
    */
   public double getX() {
      return tx.getDouble(0.0);
   }

   public double getY() {
      return ty.getDouble(0.0);
   }

   public double getArea() {
      return ta.getDouble(0.0);
   }

   public void trackPIDD(double output){
      moveValue = -output;
   }

   public void trackPIDR(double output){
      rotateValue = output;
   }

   public void stopRobot(){
      moveValue = 0.0;
     // rotateValue = 0.0;
   }

   public double trackDrive(){
      return moveValue;
   }
   public double trackRotate(){
      return rotateValue;
   }
}

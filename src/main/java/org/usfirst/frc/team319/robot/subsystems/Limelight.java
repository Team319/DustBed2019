package org.usfirst.frc.team319.robot.subsystems;


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

   public double track() {
      double moveValue;
      if (getArea() < 2.4 && getArea() > 0.4) {
         moveValue = -0.2 / getArea();
      } else {
         moveValue = 0.0;
      }
      return moveValue;
   }
}

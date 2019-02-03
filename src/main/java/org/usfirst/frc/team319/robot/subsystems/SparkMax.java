/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team319.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.usfirst.frc.team319.robot.commands.sparkmax.StopSparkMax;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SparkMax extends Subsystem {

  public CANSparkMax spark = new CANSparkMax(5, MotorType.kBrushless);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new StopSparkMax());
  }

  public void runSparkMax(double speed) {
    spark.set(speed);

  }

  public void stopSparkMax() {
    spark.set(0.0);

  }

}

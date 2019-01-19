package org.usfirst.frc.team319.robot.commands.LimelightCommands;

import org.usfirst.frc.team319.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LimelightPistonRetract extends Command {
  public LimelightPistonRetract() {
    requires(Robot.pneumatics);
  }

  @Override
  protected void initialize() {

    Robot.pneumatics.LimelightPistonRetract();

  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}

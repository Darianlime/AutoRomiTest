// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OnBoardIO;

public class FlashYellow extends CommandBase {
  private final OnBoardIO s_borad;
  private final Timer timer = new Timer();
  /** Creates a new FlashYellow. */
  public FlashYellow(OnBoardIO s_borad) {
    this.s_borad = s_borad;
    addRequirements(s_borad);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get() % 2 >= 1)
    {
      s_borad.flashingYellowLight(true);
    } else {
      s_borad.flashingYellowLight(false);
    }
    System.out.println(timer.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_borad.flashingYellowLight(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() > 15;
  }
}

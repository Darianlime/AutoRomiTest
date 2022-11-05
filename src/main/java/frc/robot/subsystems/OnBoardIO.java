// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OnBoardIO extends SubsystemBase {
  private final DigitalOutput yellowLed = new DigitalOutput(3);
  /** Creates a new OnBoardIO. */
  public OnBoardIO() {}

  public void flashingYellowLight(boolean state)
  {
    yellowLed.set(state);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GIOPort extends SubsystemBase {
  private final DigitalInput button = new DigitalInput(8);
  BooleanSupplier digitalInput = () -> !button.get();
  private final DigitalOutput redLed = new DigitalOutput(2);
  /** Creates a new GIOPort. */
  public GIOPort() {}

  public void redLedOn(boolean state) {
    redLed.set(state);
  }
  public BooleanSupplier getButtonPress(){
    return digitalInput;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

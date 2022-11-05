// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.BackSpin;
import frc.robot.commands.BackUp;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FlashYellow;
import frc.robot.commands.Spin;
import frc.robot.commands.TestRun;
import frc.robot.subsystems.GIOPort;
import frc.robot.subsystems.OnBoardIO;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();
  private final OnBoardIO m_board = new OnBoardIO();
  private final GIOPort m_port = new GIOPort();
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_romiDrivetrain);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_chooser.setDefaultOption("test run", new FlashYellow(m_board).alongWith(new TestRun(m_romiDrivetrain,m_port)).until(m_port.getButtonPress()).andThen(new BackSpin(m_romiDrivetrain)));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_chooser.getSelected();
  }
}

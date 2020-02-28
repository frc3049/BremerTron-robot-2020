/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Launcher;

public class ShootBall extends WaitCommand {
  RobotContainer m_robotContainer;
  Launcher m_launcher;
  /**
   * Creates a new ShootBall.
   */
  public ShootBall(RobotContainer robotContainer) {
    // Use addRequirements() here to declare subsystem dependencies.
    super(0.32);
    m_robotContainer = robotContainer;
    m_launcher = m_robotContainer.m_launcher;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    super.initialize();
    m_launcher.feedBall();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_launcher.stopFeedBall();
  }

}

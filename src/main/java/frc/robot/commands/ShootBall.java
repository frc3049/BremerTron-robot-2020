/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
// import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Launcher;

public class ShootBall extends CommandBase {
  RobotContainer m_robotContainer;
  Launcher m_launcher;
  protected Timer m_timer = new Timer();
  private double m_duration;
  /**
   * Creates a new ShootBall.
   */
  public ShootBall(RobotContainer robotContainer) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_robotContainer = robotContainer;
    m_launcher = m_robotContainer.m_launcher;
    if (m_launcher.ballPresent()){
      m_duration = (0.32);
    }else {
      m_duration  = (0.6);
    }
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
    m_launcher.feedBall();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_timer.stop();
    m_launcher.stopFeedBall();
  }

  @Override
  public boolean isFinished() {
    return m_timer.hasPeriodPassed(m_duration);
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDriveCommand extends CommandBase {

  private RobotContainer m_robotContainer;
  private Drivetrain m_drivetrain;
  /**
   * Creates a new ArcadeDriveCommand.
   */
  public ArcadeDriveCommand(RobotContainer robotContainer) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_robotContainer = robotContainer;
    m_drivetrain = m_robotContainer.m_drivetrain;
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.jdrive(m_robotContainer.joy);
    // System.out.println("ArcadeDriveCommand is running");

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

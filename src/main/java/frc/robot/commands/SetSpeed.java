/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SetSpeed extends CommandBase {

  RobotContainer m_robotContainer;
  boolean launcherState;

  /**
   * Creates a new SetSpeed.
   */
  public SetSpeed(RobotContainer robotContainer) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(robotContainer.m_launcher);
    m_robotContainer = robotContainer;
    launcherState = true;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_robotContainer.m_launcher.setDisabled(false);
    m_robotContainer.m_launcher.setTargetVelocity(800);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if (m_robotContainer.joy.getRawButtonPressed(4) && launcherState){
    //   m_robotContainer.m_launcher.setTargetVelocity(700);// inches/ second Maximun (1400 inches/second)
    //   launcherState = false;
    // }else if (m_robotContainer.joy.getRawButtonPressed(4) && !launcherState){
    //   m_robotContainer.m_launcher.setTargetVelocity(0);
    //   launcherState = true;
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_robotContainer.m_launcher.setTargetVelocity(0);
    m_robotContainer.m_launcher.setDisabled(true);
    m_robotContainer.m_launcher.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;

public class CollectBalls extends CommandBase {
  private RobotContainer m_robotContainer;
  private Intake m_intake;

  public CollectBalls(RobotContainer robotContainer ) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    m_robotContainer = robotContainer;
    m_intake = m_robotContainer.m_intake;
    super.addRequirements(m_intake);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_intake.deploy();  
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    m_intake.turnOnIntake();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    m_intake.turnOffIntake();
  }

}

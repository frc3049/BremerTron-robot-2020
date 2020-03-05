/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ControlArmMovement;
import frc.robot.subsystems.ControlStationManipulator;
import frc.robot.subsystems.Drivetrain;

public class MoveControlWheel extends CommandBase {
  private RobotContainer m_robotContainer;
  private ControlArmMovement m_caMovement;
  private ControlStationManipulator m_csManipulator;
  private Drivetrain m_drivetrain;
  private ColorMatchResult previousColor;
  private ColorMatchResult currentColor;
  private double revolutions;
  private boolean inPosition;
  private boolean initPrevColor;

  public MoveControlWheel(RobotContainer robotContainer) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    m_robotContainer = robotContainer;
    m_caMovement = m_robotContainer.m_controlarm;
    m_csManipulator = m_robotContainer.m_csManipulator;
    m_drivetrain = m_robotContainer.m_drivetrain;
    addRequirements(m_caMovement, m_csManipulator, m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    // m_caMovement.deploy();
    // previousColor = m_csManipulator.getColor();
    inPosition = false;
    initPrevColor = true;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    // m_caMovement.spin();
    if (!inPosition){
    if(m_csManipulator.getDistance() < 5.25){
      m_drivetrain.drive(-0.3, 0);
    }else if (m_csManipulator.getDistance() > 7.25){
      m_drivetrain.drive(0.3, 0);
    }else{
      inPosition = true;
    }
  }else {
    if (initPrevColor){
      previousColor = m_csManipulator.getColor();
      initPrevColor = false;
    }
      m_caMovement.deploy();
      m_caMovement.spin();
    }
  }
  @Override
  public void end(boolean interuppted){
    m_caMovement.stop();
    m_caMovement.retract();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    if(inPosition){
      currentColor = m_csManipulator.getColor();
      if (previousColor != currentColor){
        revolutions = revolutions + 0.125;
      }
      if (revolutions >= 3){
      return true;
      }else {
      previousColor = currentColor;
      return false;
      }
  }else{
    return false;
  }
}

}
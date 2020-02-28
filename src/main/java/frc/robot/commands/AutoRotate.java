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

public class AutoRotate extends CommandBase {
  private RobotContainer m_robotContainer;
  private Drivetrain m_drivetrain;
  private double m_speed;
  private double m_angle;
  private double m_desired = 6;

  /**
   * Creates a new AutoRotate.
   */
  public AutoRotate(RobotContainer robotContainer, double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_robotContainer = robotContainer;
    m_drivetrain = m_robotContainer.m_drivetrain;
    addRequirements(m_drivetrain);
    m_angle = angle;
    if(m_angle > 0){
      m_speed = m_desired/m_robotContainer.m_pdp.getVoltage();
    }else if(m_angle < 0){
      m_speed = -m_desired/m_robotContainer.m_pdp.getVoltage();
    }
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.resetAngle();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.drive(0, m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(m_drivetrain.getAngle()) >= Math.abs(m_angle)){
      return true;
    }else{
      return false;
    }
  }
}

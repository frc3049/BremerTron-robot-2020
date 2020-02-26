/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TestRetractIntake extends InstantCommand {
  private RobotContainer m_robotContainer;
  private Intake m_intake;
  public TestRetractIntake(RobotContainer robotContainer) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_robotContainer = robotContainer;
    m_intake = m_robotContainer.m_intake;
    addRequirements(m_intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intake.retract();
  }
}

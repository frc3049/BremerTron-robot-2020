/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ControlArmMovement;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TestDeployContArm extends InstantCommand {
  private RobotContainer m_robotContainer;
  private ControlArmMovement m_controlArm;
  
  public TestDeployContArm(RobotContainer robotContainer) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_robotContainer = robotContainer;
    m_controlArm = m_robotContainer.m_controlarm;
    addRequirements(m_controlArm);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_controlArm.deploy();
  }
}

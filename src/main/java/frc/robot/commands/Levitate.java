/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

/**
 * Add your docs here.
 */
public class Levitate extends InstantCommand {
  /**
   * Add your docs here.
   */
  public Levitate() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_climber);
  }

  public void requires(Climber m_climber) {
  }

  // Called once when the command executes
  @Override
  public void initialize() {
    Robot.m_climber.climberUp();
  }

}

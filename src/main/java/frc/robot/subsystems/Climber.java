/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/**
 * Add your docs here.
 */
public class Climber extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  DoubleSolenoid climberSoleniod = null;
  RobotContainer m_robotContainer;

  public Climber(RobotContainer robotContainer) {
    climberSoleniod = new DoubleSolenoid(1, Constants.ClimberSolenoidFor, Constants.ClimberSolenoidRev);
    m_robotContainer = robotContainer;
  }
  
  public void climberUp() {
    climberSoleniod.set(Value.kForward);
  }
  
  public void climberDown() {
    climberSoleniod.set(Value.kReverse);
  }
}

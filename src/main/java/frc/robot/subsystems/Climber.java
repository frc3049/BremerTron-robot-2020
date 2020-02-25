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

/**
 * Add your docs here.
 */
public class Climber extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  DoubleSolenoid climberSoleniod = null;

  public Climber() {
    climberSoleniod = new DoubleSolenoid(1, Constants.CLIMBER_SOLENOID_DEPLOY, Constants.CLIMBER_SOLENOID_RETRACT);
  }
  
  public void climberUp() {
    climberSoleniod.set(Value.kForward);
  }
  
  public void climberDown() {
    climberSoleniod.set(Value.kForward);
  }
}

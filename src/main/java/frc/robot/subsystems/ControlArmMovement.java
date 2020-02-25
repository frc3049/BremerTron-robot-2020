/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class ControlArmMovement extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  VictorSP spinWheelVictor = null;

  public ControlArmMovement(){
    spinWheelVictor = new VictorSP(Constants.CONTROL_PANEL_VICTOR);
  }

  
}
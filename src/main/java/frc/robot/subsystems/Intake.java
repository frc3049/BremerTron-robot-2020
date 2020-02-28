/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class Intake extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  VictorSP bottomIntakeVictor = null;
  VictorSP topIntakeVictor = null;
  DoubleSolenoid intakeSolenoid = null;

  public Intake() {
    bottomIntakeVictor = new VictorSP(Constants.INTAKE_BOTTOM_VICTOR);
    topIntakeVictor = new VictorSP(Constants.INTAKE_TOP_INTAKE_VICTOR);
    intakeSolenoid = new DoubleSolenoid(1, Constants.IntakeSolenoidFor, Constants.IntakeSolenoidRev);
  }

  public void turnOnIntake(){

    bottomIntakeVictor.set(-0.6);
    topIntakeVictor.set(-1);

  }

  public void turnOffIntake(){

    bottomIntakeVictor.set(0);
    topIntakeVictor.set(0);

  }

  public void reverseIntake(){

    bottomIntakeVictor.set(0.6);
    topIntakeVictor.set(1);

  }

  public void deploy(){
    intakeSolenoid.set(Value.kForward);
  }

  public void retract(){
    intakeSolenoid.set(Value.kReverse);
  }
}

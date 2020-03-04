/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.DataLogger;
import frc.robot.RobotContainer;

/**
 * Add your docs here.
 */
public class Intake extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  VictorSP bottomIntakeVictor = null;
  VictorSP topIntakeVictor = null;
  DoubleSolenoid intakeSolenoid = null;
  DataLogger m_intakeLogger;
  PowerDistributionPanel m_pdp;
  RobotContainer m_robotContainer;

  public Intake(RobotContainer robotContainer) {
    bottomIntakeVictor = new VictorSP(Constants.INTAKE_BOTTOM_VICTOR);
    topIntakeVictor = new VictorSP(Constants.INTAKE_TOP_INTAKE_VICTOR);
    intakeSolenoid = new DoubleSolenoid(1, Constants.IntakeSolenoidFor, Constants.IntakeSolenoidRev);
    m_intakeLogger = new DataLogger("IntakeMotorData");
    m_robotContainer = robotContainer;
    m_pdp = m_robotContainer.m_pdp;

    m_intakeLogger.add("Intake Lower Motor Current", ()->m_pdp.getCurrent(2));
    m_intakeLogger.add("Battery Voltage", ()->m_pdp.getVoltage());
    // m_dLogger.add("Launcher Expected Velocity", ()->m_controller.y_est.get(0, 0)*wheelRadius);
    // m_dLogger.add("Launcher Motor Current", ()->m_pdp.getCurrent(1));
    // m_dLogger.add("Launcher Motor Voltage", ()->m_controller.u.get(0,0));
  }

  public void turnOnIntake(){

    bottomIntakeVictor.set(-1);
    topIntakeVictor.set(-1);

  }

  public void turnOffIntake(){

    bottomIntakeVictor.set(0);
    topIntakeVictor.set(0);

  }

  public void reverseIntake(){

    bottomIntakeVictor.set(1);
    topIntakeVictor.set(1);

  }

  public void deploy(){
    intakeSolenoid.set(Value.kForward);
  }

  public void retract(){
    intakeSolenoid.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
      m_intakeLogger.log();
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.DataLogger;
import frc.robot.RobotContainer;
import frc.robot.StateSpaceController;


public class Launcher extends SubsystemBase {
  StateSpaceController m_controller;
  public SpeedController m_motor;
  Encoder m_encoder;
  PowerDistributionPanel m_pdp;
  Notifier notifier;
  DoubleSolenoid feedSolenoid;
  AnalogInput UlSensor;
  DataLogger m_dLogger;
  RobotContainer m_robotContainer;

  double wheelRadius = Constants.LauncherWheelDiameter/2; // Radius in inches
  boolean isDisabled = true;
  double targetVelocity = 0;


  /**
   * Creates a new Launcher.
   */
  public Launcher(PowerDistributionPanel pdp) {
    initStateSpace();
    m_motor = new VictorSP(Constants.LauncherMotor);
    m_encoder = new Encoder(Constants.LauncherEncoderA, Constants.LauncherEncoderB, Constants.LauncherEncoderI);
    // m_robotContainer = robotContainer;
    // m_pdp = m_robotContainer.m_pdp;
    m_pdp = pdp;
    m_dLogger = new DataLogger("launchervelocity");
    feedSolenoid = new DoubleSolenoid(1,Constants.BallStopSolenoidFor, Constants.BallStopSolenoidRev);
    UlSensor = new AnalogInput(Constants.UltraSonicSensorLauncher);
    m_encoder.setDistancePerPulse(((2*Math.PI)*wheelRadius));
    notifier = new Notifier(new Runnable() {
      @Override
      public void run() {
        calculate();
      }
    });
    notifier.startPeriodic(0.02);
    m_dLogger.add("Launcher Actual Velocity", ()->this.getVelocity());
    m_dLogger.add("Launcher Target Velocity", ()->this.getTargetVelocity());
    m_dLogger.add("Launcher Expected Velocity", ()->m_controller.y_est.get(0, 0)*wheelRadius);
    m_dLogger.add("Launcher Motor Current", ()->m_pdp.getCurrent(1));
    m_dLogger.add("Launcher Motor Voltage", ()->m_controller.u.get(0,0));

  }

  /**
   * @return target tangential velocity in inches per second
   */
  public synchronized double getTargetVelocity() {
    return this.targetVelocity;
  }

  /**
   * @return actual tangential target velocity in inches per second
   */
  public double getVelocity() {
    double tangentialVelocity = this.m_encoder.getRate();
    return tangentialVelocity;
  }

  public void calculate() {
    if (m_controller == null) {
      System.out.println("m_controller is null");
    }
    if (!isDisabled()) {
      m_controller.update();
      m_controller.setInput((r) -> {
        // Target velocity (rad/second)
        r.set(0, 0, getTargetVelocity()/wheelRadius);
      });
      double voltage = m_controller.u.get(0, 0);

      double availableVolt = m_pdp.getVoltage();
      double percentVolt = voltage / availableVolt;
      m_motor.set(percentVolt);

      m_controller.setOutput((y) -> {
        // velocity in rad  /second
        y.set(0, 0, getVelocity()/wheelRadius);
      });
      m_controller.predict();
    }
  }

  /**
   * @param vel tangential target velocity in inches per second
   */
  public synchronized void setTargetVelocity(double vel) {
    if (vel > Constants.LauncherMaximunSpeed){
      vel = Constants.LauncherMaximunSpeed;
    }
    this.targetVelocity = vel;
  }
  
  public synchronized boolean isDisabled() {
    return this.isDisabled;
  }

  public void initStateSpace() {
    m_controller = new StateSpaceController();
    m_controller.init(1, 1, 1);
    double[][] a = new double[][] { { 0.9677824137332905 } };
    double[][] a_inv = new double[][] { { 1.0 } };
    double[][] b = new double[][] { { 1.7431391679380992 } };
    double[][] c = new double[][] { { 1.0 } };
    double[][] k = new double[][] { { 0.5480670230517881 } };
    double[][] kff = new double[][] { { 0.5662237539107275 } };
    double[][] L = new double[][] { { 0.9999000193613423 } };
    // Ks is 0
    // Kv is 0.018482509520349136
    // Ka is 0.011287719359999997

    StateSpaceController.assign(m_controller.A, a);
    StateSpaceController.assign(m_controller.A_inv, a_inv);
    StateSpaceController.assign(m_controller.B, b);
    StateSpaceController.assign(m_controller.C, c);
    StateSpaceController.assign(m_controller.K, k);
    StateSpaceController.assign(m_controller.Kff, kff);
    StateSpaceController.assign(m_controller.L, L);
    m_controller.u_min.set(0, 0, -12);
    m_controller.u_max.set(0, 0, 12);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(!isDisabled()){
      m_dLogger.log();
    }
  }

  public synchronized void setDisabled(boolean isDisabled) {
    this.isDisabled = isDisabled;
  }

  public StateSpaceController getStateSpaceController() {
    return m_controller;
  }

  public double getWheelRadius() {
    return wheelRadius;
  }

  public void feedBall(){
    feedSolenoid.set(Value.kForward);
  }
  public void stopFeedBall(){
    feedSolenoid.set(Value.kReverse);
  }
  public void stop(){
   m_motor.stopMotor();   
  }
  public boolean ballPresent(){
    if(UlSensor.getValue()*0.125< 8){
      return true;
    } else{
      return false;
    }
  }
  public double getDistance(){
    return UlSensor.getValue()*0.125;
  }
}



/*----------------------------------------------------------------------------*/
/* Copyright (c) 2202020019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  
  public DifferentialDrive m_drivetrain;
  
  private static SpeedController m_forePort = new VictorSP(Constants.PortMotor1);
  private static SpeedController m_aftPort = new VictorSP(Constants.PortMotor2);
  private static SpeedControllerGroup m_port = new SpeedControllerGroup(m_forePort, m_aftPort);

  private static SpeedController m_foreStarboard = new VictorSP(Constants.StarboardMotor1);
  private static SpeedController m_aftStarboard = new VictorSP(Constants.StarboardMotor2);
  private static SpeedControllerGroup m_starboard = new SpeedControllerGroup(m_foreStarboard, m_aftStarboard);

  private static Encoder m_portEncoder = new Encoder(Constants.PortEncoderA, Constants.PortEncoderB, Constants.PortEncoderI);
  private static Encoder m_starboardEncoder = new Encoder(Constants.StarboardEncoderA, Constants.StarboardEncoderB, Constants.StarboardEncoderI);

  private static Gyro m_gyro = new ADXRS450_Gyro();

  private double m_distance;


  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    m_drivetrain = new DifferentialDrive(m_port, m_starboard);
    m_portEncoder.setDistancePerPulse((Constants.DriveWheelDiameter*Math.PI));
    m_starboardEncoder.setDistancePerPulse((Constants.DriveWheelDiameter*Math.PI));
  }


  public void drive(double speed, double rotation){
    m_drivetrain.arcadeDrive(speed, rotation);
  }

  public void jdrive(Joystick joystick){
    m_drivetrain.arcadeDrive(Math.pow(joystick.getRawAxis(Constants.axisY), 3), joystick.getRawAxis(Constants.axisX)/2);
  }

  public double getAngle(){
    return m_gyro.getAngle();
  }

  public void resetAngle(){
    m_gyro.reset();
  }

  public void resetDistance(){
    m_portEncoder.reset();
    m_starboardEncoder.reset();
    m_distance = 0;
  }

  public double getDistance(){
    if (Math.abs(m_portEncoder.getDistance() - m_starboardEncoder.getDistance()) >= 2){
      // Sys\tem.out.println("Warning: Encoder discrepancy > 2 in");
    }
    m_distance = m_portEncoder.getDistance();
    return m_distance;
  }

  public void stop() {
    m_drivetrain.stopMotor();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

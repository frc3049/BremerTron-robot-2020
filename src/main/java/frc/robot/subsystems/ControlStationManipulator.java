/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
public class ControlStationManipulator extends SubsystemBase {
  private final I2C.Port i2cPort = I2C.Port.kOnboard; 
  public final ColorSensorV3 m_colorSensor;
  public final AnalogInput m_UlSensor;
  
  private final ColorMatch m_colorMatcher;
  private static double kValuetoInches = 0.125;

  private final Color kBlueTarget = ColorMatch.makeColor(0.13, 0.43, 0.43);
  private final Color kGreenTarget = ColorMatch.makeColor(0.17, 0.58, 0.25);
  private final Color kRedTarget = ColorMatch.makeColor(0.50, 0.35, 0.14);
  private final Color kYellowTarget = ColorMatch.makeColor(0.317, 0.5674, 0.108);
  /**
   * Creates a new ControlStationManipulator.
   */
  
  public ControlStationManipulator() {
    m_colorSensor = new ColorSensorV3(i2cPort);
    m_colorMatcher = new ColorMatch();
    m_UlSensor = new AnalogInput(Constants.UltraSonicSensor);
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
  }

  public  void readColor(){
    Color detectedColor = m_colorSensor.getColor();
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the 
     * sensor.
     */
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
    // System.out.println("Reading Color");
  }

  public ColorMatchResult getColor(){
    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    return match;
  }

  public double getDistance(){
    return m_UlSensor.getValue()*kValuetoInches-26;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

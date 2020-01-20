/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GetColorObjective extends CommandBase {
  String gameData;
  boolean m_finished = false;
  
  /**
   * Creates a new GetColorObjective.
   */
  public GetColorObjective() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    m_finished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(gameData.length() > 0)
{
  switch (gameData.charAt(0))
  {
    case 'B' :
      //Blue case code
      SmartDashboard.putString("Color Goal", "Blue");
      break;
    case 'G' :
      //Green case code
      SmartDashboard.putString("Color Goal", "Green");
      break;
    case 'R' :
      //Red case code
      SmartDashboard.putString("Color Goal", "Red");
      break;
    case 'Y' :
      //Yellow case code
      SmartDashboard.putString("Color Goal", "Yellow");
      break;
    default :
      //This is corrupt data
      System.out.println("Corrupt GameData: Unrecognized character");
      break;
  }
} else {
  //Code for no data received yet
  SmartDashboard.putString("Color Goal", "Not Assigned");
}
  m_finished = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_finished;
  }
}

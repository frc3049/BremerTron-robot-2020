/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

// import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Launcher;

public class LowGoal extends CommandBase {
  private RobotContainer m_robotContainer;
  private Launcher m_launcher;
  // private double targetVelocity = 200;
  // private double tol = 30;
  private int ballMoved = 0;
  /**
   * Creates a new LowGoal.
   */
  public LowGoal(RobotContainer robotContainer) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_robotContainer = robotContainer;
    m_launcher = m_robotContainer.m_launcher;
    addRequirements(m_launcher);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ballMoved = 0;
    m_launcher.setDisabled(true);
    // m_launcher.setTargetVelocity(targetVelocity);
    m_launcher.m_motor.set(0.25);
    System.out.println("released");
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if(Math.abs(targetVelocity - m_launcher.getVelocity()) < tol){
    //   m_launcher.feedBall();
    //   ballMoved = 1;
    // }
    m_launcher.m_motor.set(3.5/m_robotContainer.m_pdp.getVoltage());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  //   Timer.delay(1);
  //   m_launcher.stopFeedBall();
  //   m_launcher.setTargetVelocity(0);
    m_launcher.setDisabled(true);
  //   m_launcher.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (ballMoved == 1);
  }
}

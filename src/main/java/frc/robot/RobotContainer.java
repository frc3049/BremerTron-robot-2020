/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.CollectBalls;
import frc.robot.commands.GetColorObjective;
// import frc.robot.commands.LowGoal;
import frc.robot.commands.MoveControlWheel;
import frc.robot.commands.SetSpeed;
import frc.robot.commands.ShootBall;
import frc.robot.commands.TestClimb;
import frc.robot.commands.TestDeployContArm;
import frc.robot.commands.DeployIntake;
// import frc.robot.commands.TestFeedBall;
import frc.robot.commands.TestRetractContArm;
import frc.robot.commands.RetractIntake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.ControlArmMovement;
import frc.robot.subsystems.ControlStationManipulator;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final ControlStationManipulator m_csManipulator;
  public final Launcher m_launcher;
  public final Intake m_intake;
  public final PowerDistributionPanel m_pdp;
  private final GetColorObjective m_autoCommand;
  public final Drivetrain m_drivetrain;
  public final Compressor m_compressor;
  public final ControlArmMovement m_controlarm;
  public final Climber m_climber;

  public final Joystick joy; // Drive Joystick
  public final Joystick aux; // Auxilary Joystick

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_pdp = new PowerDistributionPanel();
    m_compressor = new Compressor(1);
    m_csManipulator = new ControlStationManipulator(this);
    m_controlarm = new ControlArmMovement(this);
    m_autoCommand = new GetColorObjective();
    m_launcher = new Launcher(m_pdp);
    m_intake = new Intake(this);
    m_climber = new Climber(this);
    joy = new Joystick(1);
    aux = new Joystick(0);

    // aux = new Joystick(0);
    m_drivetrain = new Drivetrain();

    // Configure the button bindings
    configureButtonBindings();
    setDefaultCommands();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // //Drive Stick Button Mapping
    // JoystickButton button1 = new JoystickButton(joy, 1);
    JoystickButton button2 = new JoystickButton(joy, 2);
    JoystickButton button3 = new JoystickButton(joy, 3);
    JoystickButton button4 = new JoystickButton(joy, 4);
    JoystickButton button5 = new JoystickButton(joy, 5);
    JoystickButton button6 = new JoystickButton(joy, 6);
    JoystickButton button7 = new JoystickButton(joy, 7);
    JoystickButton button8 = new JoystickButton(joy, 8);
    // JoystickButton button9 = new JoystickButton(joy, 9);
    JoystickButton button10 = new JoystickButton(joy, 10);
    JoystickButton button11 = new JoystickButton(joy, 11);

    // //Auxilary Stick Button Mapping
    // JoystickButton buttonAux1 = new JoystickButton(aux, 1);
    JoystickButton buttonAux2 = new JoystickButton(aux, 2);
    JoystickButton buttonAux3 = new JoystickButton(aux, 3);
    JoystickButton buttonAux4 = new JoystickButton(aux, 4);
    JoystickButton buttonAux5 = new JoystickButton(aux, 5);
    // JoystickButton buttonAux6 = new JoystickButton(aux, 6);
    JoystickButton buttonAux7 = new JoystickButton(aux, 7);
    // JoystickButton buttonAux8 = new JoystickButton(aux, 8);
    // JoystickButton buttonAux9 = new JoystickButton(aux, 9);
    JoystickButton buttonAux10 = new JoystickButton(aux, 10);
    // JoystickButton buttonAux11 = new JoystickButton(aux, 11);
    // button1.whenPressed(new LowGoal(this));
    button2.whenPressed(new ShootBall(this));
    button3.toggleWhenPressed(new CollectBalls(this));
    button4.toggleWhenPressed(new SetSpeed(this, 1000));
    button5.whenPressed(new MoveControlWheel(this));
    button6.whenPressed(new DeployIntake(this));
    button7.whenPressed(new RetractIntake(this));
    button8.toggleWhenPressed(new TestClimb(this));
    button11.whenPressed(new TestDeployContArm(this));
    button10.whenPressed(new TestRetractContArm(this));

    buttonAux2.whenPressed(new ShootBall(this));
    buttonAux3.toggleWhenPressed(new CollectBalls(this));
    buttonAux7.whenPressed(new RetractIntake(this));
    buttonAux4.toggleWhenPressed(new SetSpeed(this, 1000));
    buttonAux5.toggleWhenPressed(new SetSpeed(this, 1200));
    buttonAux10.whenPressed(new MoveControlWheel(this));
  }

  private void setDefaultCommands(){
    m_drivetrain.setDefaultCommand(new ArcadeDriveCommand(this));
    // m_launcher.setDefaultCommand(new SetSpeed(this));
    // m_intake.setDefaultCommand(new CollectBalls(this));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}

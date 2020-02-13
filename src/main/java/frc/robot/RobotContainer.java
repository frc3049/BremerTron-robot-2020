/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.CollectBalls;
// import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.GetColorObjective;
import frc.robot.subsystems.ControlStationManipulator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final ControlStationManipulator m_csManipulator;
  public final Launcher m_launcher;
  public final Intake m_intake;
  public final PowerDistributionPanel m_pdp;
  public final CollectBalls m_CollectBalls;
  private final GetColorObjective m_autoCommand;

  

  public final Joystick joy; // Drive Joystick

	// //Drive Stick Button Mapping
	// JoystickButton button1 = new JoystickButton(joy, 1);
	// JoystickButton button2 = new JoystickButton(joy, 2);
	// JoystickButton button3 = new JoystickButton(joy, 3);
	// JoystickButton button4 = new JoystickButton(joy, 4);
	// JoystickButton button5 = new JoystickButton(joy, 5);
	// JoystickButton button6 = new JoystickButton(joy, 6);
	// JoystickButton button7 = new JoystickButton(joy, 7);
	// JoystickButton button8 = new JoystickButton(joy, 8);
	// JoystickButton button9 = new JoystickButton(joy, 9);
	// JoystickButton button10 = new JoystickButton(joy, 10);
	// JoystickButton button11 = new JoystickButton(joy, 11);


	public final Joystick aux; // Auxilary Joystick

	// //Auxilary Stick Button Mapping
	//JoystickButton buttonAux1 = new JoystickButton(aux, 1);
	// JoystickButton buttonAux2 = new JoystickButton(aux, 2);
	// JoystickButton buttonAux3 = new JoystickButton(aux, 3);
	// JoystickButton buttonAux4 = new JoystickButton(aux, 4);
	// JoystickButton buttonAux5 = new JoystickButton(aux, 5);
	// JoystickButton buttonAux6 = new JoystickButton(aux, 6);
	// JoystickButton buttonAux7 = new JoystickButton(aux, 7);
	// JoystickButton buttonAux8 = new JoystickButton(aux, 8);
	// JoystickButton buttonAux9 = new JoystickButton(aux, 9);
	// JoystickButton buttonAux10 = new JoystickButton(aux, 10);
	// JoystickButton buttonAux11 = new JoystickButton(aux, 11);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_pdp = new PowerDistributionPanel();
    m_csManipulator = new ControlStationManipulator();
    m_autoCommand = new GetColorObjective();
    m_launcher = new Launcher(m_pdp);
    m_intake = new Intake();
    joy = new Joystick(1);
     m_CollectBalls = new CollectBalls(this,m_intake);
    aux = new Joystick(0);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
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

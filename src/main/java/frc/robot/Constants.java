/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Drive Motor Assignment
    public static int PortMotor1 = 0;
    public static int PortMotor2 = 1;
    public static int StarboardMotor1 = 3;
    public static int StarboardMotor2 = 4;


    // Other Motor Assignments
    public static int LauncherMotor = 9;
    public static int INTAKE_TOP_INTAKE_VICTOR = 7;
	public static int INTAKE_BOTTOM_VICTOR = 5;
    public static final int CONTROL_PANEL_VICTOR = 6;
    //Solenoid Ports
    public static int IntakeSolenoidFor = 7;
    public static int IntakeSolenoidRev = 0;
    public static int ColWheelSolenoidFor = 6;
    public static int ColWheelSolenoidRev = 1;
    public static int BallStopSolenoidFor = 4;
    public static int BallStopSolenoidRev = 3;
    public static int ClimberSolenoidFor = 5;
    public static int ClimberSolenoidRev = 2;
    

    //Joystick Axis
    public static int axisX = 0;
	public static int axisY = 1;
    public static int axisZ = 2;
    //Digital Input/Ouput Assignment
    public static int PortEncoderA = 6;
    public static int PortEncoderB =7;
    public static int PortEncoderI = 8;
    public static int StarboardEncoderA = 3;
    public static int StarboardEncoderB =4;
    public static int StarboardEncoderI = 5;
    public static int LauncherEncoderA = 0;
    public static int LauncherEncoderB = 1;
    public static int LauncherEncoderI = 2;

    //Miscellanous Variables
    public static double LauncherWheelDiameter = 6;
    public static double LauncherMaximunSpeed = 1460; //inches/ second
    public static double DriveWheelDiameter = 6;
    
}

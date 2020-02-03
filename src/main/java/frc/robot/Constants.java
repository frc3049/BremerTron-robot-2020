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
    public static int StarboardMotor1 = 2;
    public static int StarboardMotor2 =3;

    // Other Motor Assignments
    public static int LauncherMotor = 4;

    //Joystick Axis
    public static int axisX = 0;
	public static int axisY = 1;
    public static int axisZ = 2;
    //Digital Input/Ouput Assignment
    public static int PortEncoderA = 0;
    public static int PortEncoderB =1;
    public static int StarboardEncoderA = 2;
    public static int StarboardEncoderB =3;
    public static int LauncherEncoderA = 4;
    public static int LauncherEncoderB = 5;

    //Miscellanous Variables
    public static double WheelDiameter = 6;
   
}

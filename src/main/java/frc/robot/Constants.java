// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
// number is for PWM Spark is plugged into
	public static final int LEFT_FRONT = 5;
	public static final int RIGHT_FRONT = 6;
	public static final int LEFT_BACK = 7;
    public static final int RIGHT_BACK = 8;
    public static final int SHOOTER = 4;
    public static final int INTAKE = 3;
    //Analog inputs
    public static final int RANGE_FINDER = 0;

    //use drive station to verify port numbers for controller
	public static final int XBOX_LEFT_Y_AXIS = 1;
    public static final int XBOX_LEFT_X_AXIS = 0;
    public static final int RIGHT_TRIGGER = 3;
    //For tuning overall speed of base
    public static final double DRIVETRAINSPEED = 0.7;
    
    //Autonomous basic 
	public static final double DRIVE_FORWARD_TIME = 3.0;
	public static final double AUTONOMOUS_SPEED = 0.4;
	
    //Frc drive station gives the number for controller
    public static final int JOYSTICK_NUMBER = 0;
    //speed for subsystems
	public static final double SHOOTER_SPEED = 0.5;
    public static final double INTAKE_SPEED = 0.5;
    public static final double AUTO_SHOOT_TIME = 2.0;
    //camera res
	public static final int CAMERA_RES_X = 320;
	public static final int CAMERA_RES_Y = 240;
    // Rangefinder target point
    public static final double SETPOINT_FORWARD = 1.5;
	
	
	
	
	
}




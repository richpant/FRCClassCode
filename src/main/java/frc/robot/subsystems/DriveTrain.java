// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PWMSparkMax;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
 
    PWMSparkMax leftFront;
    PWMSparkMax leftBack;
    PWMSparkMax rightFront;
    PWMSparkMax rightBack;
    SpeedControllerGroup leftMotors;
    SpeedControllerGroup rightMotors;
    DifferentialDrive drive;
    private final AnalogInput rangeFinder;

    public DriveTrain(){
      //check inversion and then comment out for single motor test
      leftFront = new PWMSparkMax(Constants.LEFT_FRONT);
     leftFront.setInverted(false);
      rightFront = new PWMSparkMax(Constants.RIGHT_FRONT);
      rightFront.setInverted(false);
      leftBack = new PWMSparkMax(Constants.LEFT_BACK);
      leftBack.setInverted(false);
      rightBack = new PWMSparkMax(Constants.RIGHT_BACK);
      rightBack.setInverted(false);

      leftMotors = new SpeedControllerGroup(leftFront, leftBack);
      rightMotors = new SpeedControllerGroup(rightFront, rightBack);
      drive = new DifferentialDrive(leftMotors, rightMotors);
      rangeFinder = new AnalogInput(Constants.RANGE_FINDER);


    }
  

  @Override
  public void periodic() {
    // driveForward(0.7);
  }
  
  public void drivewithJoysicks(XboxController controller, double speed){
    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*speed);
  }

  public void driveForward(double speed){
    drive.tankDrive(speed, speed);
  }

  public boolean driveToDistance(double setPointDistance, double speed){
    while(rangeFinder.getAverageVoltage()> setPointDistance){
      driveForward(speed);
    }
    return true;
  }

  public void stop()
  {
    drive.stopMotor();
  }
}

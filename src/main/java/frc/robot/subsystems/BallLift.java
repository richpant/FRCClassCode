// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallLift extends SubsystemBase {
  PWMSparkMax ballLift;

  /** Creates a new Intake. */
  public BallLift() {
    ballLift = new PWMSparkMax(Constants.BALL_LIFT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void ballLift(double speed)
  {
    //check the axis in drive station for right trigger 
    ballLift.set(speed);
  }
  public void stop()
  {
    ballLift.set(0);
  }
  
}


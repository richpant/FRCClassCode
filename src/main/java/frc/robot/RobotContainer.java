// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.AutonomosOne;
import frc.robot.commands.AutonomousTwo;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveToDistance;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.ShootBall;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 

    //DriveTrain declare
    private final DriveTrain driveTrain;
    private final DriveWithJoystick driveWithJoystick;
    private final DriveForwardTimed driveForwardTimed;
    private final DriveToDistance driveToDistance;
    public static XboxController driverJoystick;
    //Shooter Declare
    private final Shooter shooter;
    private final ShootBall shootBall;
    private final AutoShoot autoShoot;
    //Intake declare
    private final Intake intake;
    private final IntakeBall intakeBall;
    //auto Command groupI CAN NOT SPELL
    private final AutonomosOne autonomosOne;
    private final AutonomousTwo autonomousTwo;
    // Sendable chooser for smart dashboard
    SendableChooser<Command> chooser = new SendableChooser<>();
    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
      driveTrain = new DriveTrain();
      driveWithJoystick = new DriveWithJoystick(driveTrain);
      driveWithJoystick.addRequirements(driveTrain);
      driveTrain.setDefaultCommand(driveWithJoystick);

      //Autonomous 
      driveForwardTimed = new DriveForwardTimed(driveTrain);
      driveForwardTimed.addRequirements(driveTrain);

      driveToDistance = new DriveToDistance(driveTrain);
      driveToDistance.addRequirements(driveTrain);

      //joystick
      driverJoystick = new XboxController(Constants.JOYSTICK_NUMBER);

     //shooter 
      shooter = new Shooter();
      shootBall = new ShootBall(shooter);
      shootBall.addRequirements(shooter);

        //auto shooter
      autoShoot = new AutoShoot(shooter);
      autoShoot.addRequirements(shooter);
      //intake
      intake = new Intake();
      intakeBall = new IntakeBall(intake);
      intakeBall.addRequirements(intake);
      intake.setDefaultCommand(intakeBall);

      //Auto Command group
      autonomosOne = new AutonomosOne(driveTrain, shooter);
      autonomousTwo = new AutonomousTwo(driveTrain, shooter);
      //for chooser for Smart Dashboard

      // Add choices as option here: you can add as many as you want
      chooser.addOption("AutonomousTwo", autonomousTwo);
      // Default option
      chooser.setDefaultOption("AutonomosOne", autonomosOne);
      //Add to Choices in Smart Dashboard
      SmartDashboard.putData("Autonomous", chooser);

      //intiailze camera
      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
      camera.setResolution(Constants.CAMERA_RES_X, Constants.CAMERA_RES_Y);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //sets joystick right bumper to turn on shooter
    JoystickButton shootButton = new JoystickButton(driverJoystick, XboxController.Button.kBumperRight.value);
    shootButton.whileHeld(new ShootBall(shooter));
    //add button for auto shoot
    JoystickButton autoShootButton = new JoystickButton(driverJoystick, XboxController.Button.kBumperLeft.value);
    autoShootButton.whileHeld(new AutoShoot(shooter));
    // add button for drive to distance
    JoystickButton aButton = new JoystickButton(driverJoystick, XboxController.Button.kA.value);
    aButton.whenPressed(new DriveToDistance(driveTrain));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
   // this will run basic move forward: return driveForwardTimed;
   return chooser.getSelected();
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  // Instance Variables
  private CommandXboxController controller;
  private CANSparkMax spark;

  /**
   * Initializes a robot controller instance
   */
  public RobotContainer() {
    // Initializes a new controller on the controller port
    this.controller = new CommandXboxController(Constants.ControllerConstants.CONTROLLER_ID);

    // Initalizes the CANSparkMax motor to an ID and to Brushless
    this.spark = new CANSparkMax(Constants.SparkConstants.SPARK_MAX_CONSTANT, MotorType.kBrushless);

    configureBindings();
  }

  /**
   * Configures the button bindings to the controller
   */
  private void configureBindings() {
    if (controller == null) {
      return;
    }
    // binds the a button to set the spark motor to a speed of 1 when down, and
    // speed of 0 when released
    this.controller.a().whileTrue(Commands.startEnd(() -> spark.set(1), () -> spark.set(0)));
  }

}

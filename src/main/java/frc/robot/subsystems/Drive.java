// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drive extends SubsystemBase {
  SwerveModule FrontLeft = new SwerveModule(DriveConstants.FrontLeftDriveMotorID, DriveConstants.FrontLeftTrunMotorID, DriveConstants.FrontLeftAbsoluteEncoderID,  DriveConstants.FrontLeftDriveReversed,  DriveConstants.FrontLeftTurnReversed,  DriveConstants.FrontLeftAbsoluteEncoderReversed,  DriveConstants.FrontLeftAbsoluteEncoderRadOffset);
  SwerveModule BackLeft = new SwerveModule(DriveConstants.BackLeftDriveMotorID, DriveConstants.BackLeftTrunMotorID, DriveConstants.BackLeftAbsoluteEncoderID, DriveConstants.BackLeftDriveReversed, DriveConstants.BackLeftTurnReversed, DriveConstants.BackLeftAbsoluteEncoderReversed, DriveConstants.BackLeftAbsoluteEncoderRadOffset);
  SwerveModule FrontRight = new SwerveModule(DriveConstants.FrontRightDriveMotorID, DriveConstants.FrontRightTrunMotorID, DriveConstants.FrontRightAbsoluteEncoderID, DriveConstants.FrontRightDriveReversed, DriveConstants.FrontRightTurnReversed, DriveConstants.FrontRightAbsoluteEncoderReversed, DriveConstants.FrontRightAbsoluteEncoderRadOffset);
  SwerveModule BackRight = new SwerveModule(DriveConstants.FrontRightDriveMotorID, DriveConstants.BackRightTrunMotorID, DriveConstants.BackRightAbsoluteEncoderID, DriveConstants.BackRightDriveReversed, DriveConstants.BackRightTurnReversed, DriveConstants.BackRightAbsoluteEncoderReversed, DriveConstants.BackRightAbsoluteEncoderRadOffset);
  
  
  /** Creates a new Drive. */
  public Drive() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

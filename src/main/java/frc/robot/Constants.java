// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

public final class Constants {
    public static final class ModuleConstants{
        public static final double WheelDiameterMeters = 0;

        public static final double DriveGearRatio = 0;
        public static final double DriveEncoderRotToMeters = DriveGearRatio * Math.PI * WheelDiameterMeters;
        public static final double DriveEncoderRPMToMetersPerSecond = DriveEncoderRotToMeters/60;

        public static final double TurnGearRatio = 0;
        public static final double TurnEncoderRotToMeters = TurnGearRatio * 2 * Math.PI;
        public static final double TurnEncoderRPMToMetersPerSecond = TurnEncoderRotToMeters/60;
        public static final double kPTurning = 0.5;
    }
    public static final class DriveConstants {
        public static final double WheelWidth = 23.75; /**Distance between the left and right wheels */
        public static final double WheelLength = 23.75; /**Distance between the front and back wheels */
        public static final SwerveDriveKinematics DriveKinematics = new SwerveDriveKinematics(
            new Translation2d(WheelWidth/2 , WheelLength/2),/**front left */
            new Translation2d(-WheelWidth/2 , WheelLength/2),/** back left */
            new Translation2d(WheelWidth/2 , -WheelLength/2),/**front right */
            new Translation2d(-WheelWidth/2 , -WheelLength/2)/**back right */
        );
        public static final int FrontLeftDriveMotorID = 0;
        public static final int FrontLeftTrunMotorID = 0;

        public static final int BackLeftDriveMotorID = 0;
        public static final int BackLeftTrunMotorID = 0;

        public static final int FrontRightDriveMotorID = 0;
        public static final int FrontRightTrunMotorID = 0;

        public static final int BackRightDriveMotorID = 0;
        public static final int BackRightTrunMotorID = 0;

        public static final double MaxMetersPerSecond = 0;
    }
}
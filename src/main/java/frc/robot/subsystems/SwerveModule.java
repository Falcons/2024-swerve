// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ModuleConstants;

public class SwerveModule extends SubsystemBase {
  private final CANSparkMax driveMotor;
  private final CANSparkMax turnMotor;

  private final RelativeEncoder driveEncoder;
  private final RelativeEncoder turnEncoder;

  private final PIDController turningPID;

  private final AnalogInput absoluteEncoder;
  private final boolean absoluteEncoderReversed;
  private final double absoluteEncoderRadOfset;

  /** Creates a new SwerveModule. */
  public SwerveModule(int driveMotorID, int turnMotorID, int absoluteEncoderID, boolean driveMotorReversed, boolean turnMotorReversed, boolean absoluteEncoderReversed, double absoluteEncoderRadOfset) {
    driveMotor = new CANSparkMax(driveMotorID, MotorType.kBrushless); 
    driveMotor.setInverted(driveMotorReversed);
    driveEncoder = driveMotor.getEncoder();
    driveEncoder.setPositionConversionFactor(ModuleConstants.DriveEncoderRotToMeters);
    driveEncoder.setVelocityConversionFactor(ModuleConstants.DriveEncoderRPMToMetersPerSecond);

    turnMotor = new CANSparkMax(turnMotorID, MotorType.kBrushless);
    turnMotor.setInverted(turnMotorReversed);
    turnEncoder = turnMotor.getEncoder();
    turnEncoder.setPositionConversionFactor(ModuleConstants.TurnEncoderRotToMeters);
    turnEncoder.setVelocityConversionFactor(ModuleConstants.TurnEncoderRPMToMetersPerSecond);
    turningPID = new PIDController(ModuleConstants.kPTurning, 0, 0);
    turningPID.enableContinuousInput(-Math.PI, Math.PI);
    
    absoluteEncoder = new AnalogInput(absoluteEncoderID);
    this.absoluteEncoderReversed = absoluteEncoderReversed;
    this.absoluteEncoderRadOfset = absoluteEncoderRadOfset;

    resetEncoders();
  }

  public double getDrivePosition() {
    return driveEncoder.getPosition();
  }
  public double getDriveVelocity(){
    return driveEncoder.getVelocity();
  }
  public double getTurnPosition(){
    return turnEncoder.getPosition();
  }
  public double getTurnVelocity(){
    return turnEncoder.getVelocity();
  }
  // public getAbsoluteEncoderRad() {} //depends on type on encoder
  public void resetEncoders(){
    driveEncoder.setPosition(0);
    turnEncoder.setPosition(0); //set to abosolu encoder when added
  }

  public SwerveModuleState getState(){
    return new SwerveModuleState(getDriveVelocity(), new Rotation2d(getTurnPosition()));
  }
  public void setState(SwerveModuleState state){
    state = SwerveModuleState.optimize(state, new Rotation2d(getTurnPosition()));
    driveMotor.set(state.speedMetersPerSecond);
    turnMotor.set(turningPID.calculate(getTurnPosition(),state.angle.getRadians()));
  }
  public void stop(){
    driveMotor.stopMotor();
    turnMotor.stopMotor();
  }
}

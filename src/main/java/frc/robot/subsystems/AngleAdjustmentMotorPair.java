// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.AngleAdjustmentConstants;

public class AngleAdjustmentMotorPair extends SubsystemBase {

  private SparkMax m_leftMotor;
  private SparkMax m_rightMotor;
  private final RelativeEncoder m_leftEncoder = m_leftMotor.getEncoder();
  private final RelativeEncoder m_rightEncoder = m_rightMotor.getEncoder();
  private SparkMaxConfig m_rightConfig;
  private final double kGearing = AngleAdjustmentConstants.kTotalRatio; //Here to save typing



  /** Creates a new AngleAdjustmentMotorPair. */
  public AngleAdjustmentMotorPair(int leftID, int rightID) {
    m_leftMotor = new SparkMax(leftID, MotorType.kBrushless);
    m_rightMotor = new SparkMax(rightID, MotorType.kBrushless);
    
    m_rightConfig.follow(leftID, AngleAdjustmentConstants.kMotorInverted);
    //TODO: I didn't know whether to use ResetSafeParameters and PersistParameters or not
    m_rightMotor.configure(m_rightConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
  }

  private double getLeftDegrees() {
    return Units.rotationsToDegrees(m_leftEncoder.getPosition() / kGearing);
  }

  private double getRightDegrees() {
    return Units.rotationsToDegrees(m_leftEncoder.getPosition() / kGearing);
  }

  /**
   * The degrees of tilt the axle has. Front going up is positive.
   * @return degrees from horizontal
   */
  public double getDegreesFromHorizontal() {
    return getLeftDegrees(); //Based on leader motor
  }



  private void setAngle(double degrees) {
    //TODO: add PID
    

    
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

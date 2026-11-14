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
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class CannonBatteryConstants {
    public static final int kPCMCANID = 0;
    public static final double kShotOpeningDuration = 0.5; //Time (seconds) to open valves to fire a cannon //TODO: fix placeholder value
  }

  public static class AngleAdjustmentConstants {
    public static final boolean kMotorInverted = false; //Is the right motor inverted from the left //TODO: fix placeholder value

    //Gearing on motors for angle adjustments
    //TODO: fix placeholder values
    public static final double kMotorGearRatio = 1; //Motor rotations : sprocket rotations
    public static final double kChainRatio = 1; //Sprocket rotations : axle rotations
    public static final double kTotalRatio = kMotorGearRatio * kChainRatio; //Motor rotations : axle rotations

  }
}

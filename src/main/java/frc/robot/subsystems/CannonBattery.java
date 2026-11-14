// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CannonBattery extends SubsystemBase {

  private PneumaticsControlModule m_PCM;
  private Solenoid[] m_CannonArray = new Solenoid[6];
  private int currentCannon = 0;


  /** Creates a new CannonBattery. */
  public CannonBattery(int PCMCANID) {
    //Creates the Pneumatics control module
    m_PCM = new PneumaticsControlModule(PCMCANID);


    //Creates all of the solenoids, at the PCM port corresponding to their index number, and sets the pulse length from constants
    for (int i = 0; i < m_CannonArray.length; i++) {
      m_CannonArray[i] = new Solenoid(PneumaticsModuleType.CTREPCM, i);
      m_CannonArray[i].setPulseDuration(Constants.CannonBatteryConstants.kShotOpeningDuration);
    }
  }

  /**
   * Fire a specific cannon for the pulse duration (Constants.CannonBatteryConstants.kShotOpeningDuration)
   * @param cannonIndex Which cannon to fire (0 through 5), corresponds to the port on the PCM
   */
  private void fireCannon(int cannonIndex) {
    m_CannonArray[cannonIndex].startPulse();
  }

  /**
   * The command to fire a specific cannon
   * @param cannonIndex Which cannon (0 through 5)
   * @return command that fires specified cannon
   */
  public Command fireCommand(int cannonIndex) {
    return runOnce(()->{fireCannon(cannonIndex);});
  }

  /**
   * Fires the current cannon in sequence. Starts at 0, then increments index for next sequential shot.
   */
  private void fireSequentialCannon() {
    fireCannon(currentCannon);
    currentCannon++;
  }

  /**
   * The command to fire the current cannon in the sequence, then increment to next cannon
   * @return command that fires the current cannon in sequence
   */
  public Command fireSequentialCommand() {
    return runOnce(()->{fireSequentialCannon();});
  }

  /**Fires cannons 0, 1, and 2, which comprises one of the barrels of three cannons */
  private void fireBarrelOne() {
    fireCannon(0);
    fireCannon(1);
    fireCannon(2);
  }

  /**
   * Fires one of the barrels of 3 cannons. (Index 0, 1, and 2)
   * @return command to fire barrel one
   */
  public Command fireBarrelOneCommand() {
    return runOnce(()->{fireBarrelOne();});
  }

  /**Fires cannons 3, 4, and 5, which comprises one of the barrels of three cannons */
  private void fireBarrelTwo() {
    fireCannon(3);
    fireCannon(4);
    fireCannon(5);
  }

  /**
   * Fires one of the barrels of 3 cannons. (Index 3, 4, and 5)
   * @return command to fire barrel one
   */
  public Command fireBarrelTwoCommand() {
    return runOnce(()->{fireBarrelTwo();});
  }

  /**
   * Fires all of the cannons at once
   */
  private void fireAllCannons() {
    for(int i = 0; i < m_CannonArray.length; i++) {
      fireCannon(i);
    }
  }

  /**
   * Command to fire all of the cannons at once.
   * Could be used to empty air out of the tanks, or to launch all of the t-shirts at the same time.
   * @return the command to fire all of the cannons
   */
  public Command fireAllCommand() {
    return runOnce(()->{fireAllCannons();});
  }

  /**
   * Sets the current cannon (for firing sequentially) to zero.
   */
  private void resetCannonIndex() {
    currentCannon = 0;
  }

  /**
   * Sets the current cannon for sequential firing to cannon zero.
   * @return command to reset the cannon index
   */
  public Command resetCannonIndexCommand() {
    return runOnce(()->{resetCannonIndex();});
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

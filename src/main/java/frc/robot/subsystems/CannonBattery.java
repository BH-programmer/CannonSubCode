// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CannonBattery extends SubsystemBase {

  private PneumaticsControlModule m_PCM;
  private Solenoid[] m_CannonArray = new Solenoid[6];

  /** Creates a new CannonBattery. */
  public CannonBattery(int PCMCANID) {
    //Creates the Pneumatics control module
    m_PCM = new PneumaticsControlModule(PCMCANID);


    //Creates all of the solenoids, at the PCM port corresponding to their number
    for (int i = 0; i < m_CannonArray.length; i++){
      m_CannonArray[i] = new Solenoid(PneumaticsModuleType.CTREPCM, i);
    }
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

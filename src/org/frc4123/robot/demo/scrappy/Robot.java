/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.frc4123.robot.demo.scrappy;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    
    
    //Drive
    Jaguar scFL = new Jaguar(1);
    Jaguar scBL = new Jaguar(2);
    Jaguar scFR = new Jaguar(3);
    Jaguar scBR = new Jaguar(4);
    Joystick joyDrive = new Joystick(1);
    SafeRobotDrive drive = new SafeRobotDrive(scFL, scBL, scFR, scBR);
    
    double mDriveForward = 0;
    double mDriveRotate = 0;
    
    //Safety constants
    final static double kSpeedmodDefault = 1;
    final static double kturnmoddefault= 1;

    
    
    
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        //TREVOR: Watchdog temproarily stops the robot if it doesn't get a response every 100ms. The line below disables that, so it'll make the robot less jerky, but it also gives it the potential to run off on its own, even after you disable it. Use at your own discretion.
        //drive.setSafetyEnabled(false);

        //These set which motors should be reversed. Set two on the same side to true.
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
        drive.setSpeedmodifier(kSpeedmodDefault);
        drive.setTurnmodifier(kturnmoddefault);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**   
     * 
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {       

     
        drive.setSpeedmodifier((-1*joyDrive.getRawAxis(3)+1)/2);
        
        drive.safeArcadeDrive(-1*joyDrive.getRawAxis(1), joyDrive.getRawAxis(2), true);
    }
    
    public void testInit(){
        drive.setSpeedmodifier(1);
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        drive.arcadeDrive(.35, 0);
    }
    
}

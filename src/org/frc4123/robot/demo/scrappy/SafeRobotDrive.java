/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc4123.robot.demo.scrappy;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author Adrian Campos? - frc4123
 */
public class SafeRobotDrive extends RobotDrive {
   
        private double speedmodifier = 1;
        private double turnmodifier = 1;
        
	public SafeRobotDrive(SpeedController FL, SpeedController BL, SpeedController FR, SpeedController BR) {
		super(FL, BL, FR, BR);
		
	}
	
	public void safeArcadeDrive(double moveValue, double rotateValue, boolean squaredinputs){
		super.arcadeDrive(this.speedmodifier*moveValue, this.turnmodifier*rotateValue, squaredinputs);
	}
	public void safeArcadeDrive(double moveValue, double rotateValue){
		super.arcadeDrive(this.speedmodifier*moveValue, this.turnmodifier*rotateValue);
	}
        
	public void setSpeedmodifier(double speedmodifier){
            this.speedmodifier = speedmodifier;
        }
        public double getSpeedmodifier(){
            return this.speedmodifier;
        }
        
        public void setTurnmodifier(double turnmodifier){
            this.turnmodifier = turnmodifier;
        }
	public double getTurnmodifier(){
            return this.turnmodifier;
        }
}



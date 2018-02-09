/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc4123.robot.demo.scrappy;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author 4123
 */
public class Climber {
    
    Jaguar l_climb;
    Jaguar r_climb;
    
    public Climber(Jaguar l_climb, Jaguar r_climb){
        this.l_climb = l_climb;
        this.r_climb = r_climb;
        
    }
    
    public void climbWithTrigger(double trigger_up, double trigger_dwn){
        if (trigger_up > 0.2){
            l_climb.set(trigger_up);
            r_climb.set(trigger_up);
        }
        else if (trigger_dwn > 0 && trigger_up <= 0.1){
            l_climb.set(-1*trigger_dwn);
            r_climb.set(-1*trigger_dwn);
        }
        else {
            l_climb.set(0);
            r_climb.set(0);
        }
        
        
    }
    /*
    public void getClimbSpeed(){
        controller;
    }
    **/
}

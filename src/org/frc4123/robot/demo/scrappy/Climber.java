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
    
    public void climbWithTrigger(double controller){
        l_climb.set(controller);
        r_climb.set(controller);
        
    }
    /*
    public void getClimbSpeed(){
        controller;
    }
    **/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication37;

import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class User {
    
    private String userName;
    private String userPassword;
    
    
    ArrayList<Run> runs=new ArrayList<Run>();
    
    
    public User(String userName, String userPassword){
        this.userName=userName;
        this.userPassword=userPassword;
        
        
        for (int i = 0; i < 10; i++) {
            runs.add(new Run(Math.random(),Math.random(),Math.random()));
        }
    }
    
    
    
    
    
    
    
    
    
    class Run{
        
        private double time;
        private double distance;
        private double altitude;
        
        private String Name;
        
        
        
        
        Run(double time,double distance,double altitude){
            this.time=time;
            this.distance=distance;
            this.altitude=altitude;
            this.Name=userName;
        }
        public double getTime(){
            return time;
        }
        
        public  String getName(){
            return Name;
        }
        double getDistance(){
            return distance;
        }
        public double getAltitude(){
            return altitude;
        }
        Run (){
            
        }
        
        
    }
    
    
    
}

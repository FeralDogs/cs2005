/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication37;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class User {

    private String userName;
    private String userPassword;

    ArrayList<Run> runs = new ArrayList<Run>();
    ArrayList<User> friends = new ArrayList<User>();

    ArrayList<String> fileNames = new ArrayList<>();

    public void setUser(String userName) {
        this.userName = userName;
    }

    public String getUser() {
        return userName;
    }

    
    
    public void createAccount(){
         CreateAccount.users.add(this);

                        Path currentRelativePath = Paths.get("");
                        String s = currentRelativePath.toAbsolutePath().toString();

                        File file = new File("C:\\Users\\Adrian\\Documents\\NewFolder\\JavaApplication37\\src\\javaapplication37\\UsersData\\" + this.getUser());
                        // check if the pathname already exists
                        // if not create it
                        if (!file.exists()) {
                            // create the full path name
                            boolean result = file.mkdirs();
                            if (result) {
                                System.out.println("Successfully created " + file.getAbsolutePath());
                            } else {
                                System.out.println("Failed creating " + file.getAbsolutePath());
                            }
                        } else {
                            System.out.println("Pathname already exists");
                        }
    }
    
    
    
    
    
    
    
    public User(String userName, String userPassword) {

        this.userName = userName;
        this.userPassword = userPassword;
        
        

        System.out.println("User Name :" + userName);

        Path currentRelativePath = Paths.get("");
        String relativePath = currentRelativePath.toAbsolutePath().toString();

        File dir = new File("C:\\Users\\Adrian\\Documents\\NewFolder\\JavaApplication37\\src\\javaapplication37\\UsersData\\" + this.userName);

        String[] filesInDir = dir.list();

        System.out.println("files in directory : " + filesInDir);

        if (filesInDir!=null) {
            for (int i = 0; i < filesInDir.length; i++) {

                File runFile = new File("C:\\Users\\Adrian\\Documents\\NewFolder\\JavaApplication37\\src\\javaapplication37\\UsersData\\" + this.userName + "\\" + filesInDir[i]);

                try {
                    Scanner s = new Scanner(runFile);

                    while (s.hasNext()) {

                        String line = s.next();
                        String[] values = line.split(",");
                    //System.out.println("line " + line);

                        runs.add(new Run(values[0], values[1], values[2], values[3]));

                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            System.out.println("Files for user :" + Arrays.toString(filesInDir));
        }
    }

    class Run {

        private String time;
        private String distance;
        private String altitude;

        private String date;
        private String Name;

        Run(String time, String distance, String altitude, String date) {
            this.time = time;
            this.distance = distance;
            this.altitude = altitude;
            this.Name = userName;
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public String getName() {
            return Name;
        }

        String getDistance() {
            return distance;
        }

        public String getAltitude() {
            return altitude;
        }

        public String getDate() {
            return date;
        }

        Run() {

        }

    }

}

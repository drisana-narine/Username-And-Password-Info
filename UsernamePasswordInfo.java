package com.PersonalProjects;
import java.io.*;
import java.util.Scanner;

public class UsernamePasswordInfo {
    public static void main(String[] args) {
        System.out.println("Enter \"save\" to save information and \"look\" to look for information: ");
        Scanner keyboard = new Scanner(System.in);
        if(keyboard.nextLine().equalsIgnoreCase("save")) {
            passwordInput();
        }
        else {
            passwordOutput();
        }
    }

    private static void passwordOutput(){
        String fileName = "info.txt";
        Scanner keyboard = new Scanner(System.in);
        String response="no";
        do {
            System.out.println("Site you are looking for: ");
            String answer = keyboard.nextLine();
            try {
                Scanner inputStream = new Scanner(new File(fileName));
                String line;
                boolean found=false;
                while (inputStream.hasNextLine()) {
                    line = inputStream.nextLine();
                    String[] ary = line.split(" ");
                    if (ary[0].equalsIgnoreCase(answer)) {
                        found=true;
                        System.out.println("Username: " + ary[1]);
                        System.out.println("Password: " + ary[2]);
                    }
                }
                if(!found){
                    System.out.println("No information found");
                }
                System.out.println("Looking for more information? ");
                response= keyboard.next();
                keyboard.nextLine();
                System.out.println("----------------------------------");

            } catch (FileNotFoundException e) {
                System.out.println("Cannot find file " + fileName);
            }
        }while(response.equalsIgnoreCase("yes"));
    }

    private static void passwordInput(){
        String fileName = "info.txt"; //name of file
        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter (new FileOutputStream(fileName,true));
        }
        catch (FileNotFoundException e)
        {
            System.out.println ("Error opening the file " + fileName);
            System.exit (0);
        }
        Scanner keyboard = new Scanner (System.in);
        String response;
        do
        {
            System.out.println("Site: ");
            String site = keyboard.next();
            System.out.println("Username: ");
            String username = keyboard.next();
            System.out.println("Password: ");
            String password = keyboard.next();
            outputStream.println (site+" "+username+" "+password);//prints to file
            keyboard.nextLine();
            System.out.println("More information?: ");
            response= keyboard.nextLine();
            System.out.println("----------------------------------");
        }while(response.equalsIgnoreCase("yes"));
        outputStream.close ();
        System.out.println ("Those lines were written to " + fileName);
    }
}

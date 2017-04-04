/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs480.project1.gradebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Phuoc
 */
public class GradeBook {
    
    public ArrayList<String> readTextFile(int value) {
        BufferedReader in = null;
        ArrayList<String> dataList = new ArrayList<String>();
        String courses = "";

        try {
            String line;
            in = new BufferedReader(new FileReader("course.txt"));
            
            while ((line = in.readLine()) != null) {
                String temp = line.split(",")[value].trim();
                if (!temp.isEmpty()) {
                    if (!courses.contains(temp)) {
                        courses = courses + temp + ",";
                    }
                }

            }
            for (String string : courses.split(",")) {

                dataList.add(string);

            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
            
        }
        return dataList;
    }
    
     public  ArrayList<String> readTextFile() {
        BufferedReader in = null;
        ArrayList<String> dataList = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        try {
            // destinationList.add("");
            String line;

            in = new BufferedReader(new FileReader("course.txt"));
            // String regexp = "[,]+";
            // System.out.println("*********** "+br.readLine());
            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");
                dataList.add(line);

            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
            
        }
        return dataList;
    }
     
     public static String writeToFile(StringBuilder data, String filename, boolean myBoo) {

        try {
            FileWriter fileWritter = new FileWriter(filename, myBoo);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(data.toString());
            // bufferWritter.newLine();
            bufferWritter.close();
            System.out.println("Done");
            return "Successfully Saved";
        } catch (IOException ioe) {
            return "IOException";

        } catch (Exception e) {
            return "Error Occured";

        }

    }
}


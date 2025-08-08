package ioexception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class filewriter {
    public static void main(String[] args) {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("appointment.txt"));

            writer.write("Appointment confirmed at 11:00 AM");

            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the writer: " + e.getMessage());
            }}}}


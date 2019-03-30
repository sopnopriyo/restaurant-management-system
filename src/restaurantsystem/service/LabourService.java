/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurantsystem.component.labour.AddLabour;
import restaurantsystem.component.labour.DeleteLabour;
import restaurantsystem.component.labour.UpdateLabour;
import restaurantsystem.model.Labour;

/**
 *
 * @author Sopnopriyo
 */
public class LabourService {

    public LabourService() {
    }

    public List<Labour> getAll() {
        List<Labour> labourList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("storage/labour.txt"))) {
            while (scanner.hasNextLine()) {

                String labourLine = scanner.nextLine();

                String labourInfo[] = labourLine.split(",");

                Labour labour = new Labour(labourInfo[0], labourInfo[1], Double.parseDouble(labourInfo[2]));

                labourList.add(labour);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DeleteLabour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return labourList;
    }

    public void create(Labour labour) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/labour.txt", true))) {
            pw.println(labour.getId() + "," + labour.getName() + "," + labour.getSalary());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddLabour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized boolean update(String sourceId, Labour updatedLabour) {
        // Read all the items
        List<Labour> labourList = getAll();

        int indexToUpdate = -1;
        for (int i = 0; i < labourList.size(); i++) {
            Labour labour = labourList.get(i);

            if (labour.getId().equalsIgnoreCase(sourceId)) {
                indexToUpdate = i;
            }
        }

        if (indexToUpdate == -1) {
           return false;
        }

        labourList.set(indexToUpdate, updatedLabour);

        try {
            Files.delete(Paths.get("storage/labour.txt"));
        } catch (IOException ex) {
            Logger.getLogger(UpdateLabour.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/labour.txt"))) {
            labourList.forEach(labour -> {
                pw.println(labour.getId() + "," + labour.getName() + "," + labour.getSalary());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UpdateLabour.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    public synchronized void delete(String labourID) {
        List<Labour> labourList = getAll();

        // find the labour to be deleted
        for (int i = 0; i < labourList.size(); i++) {

            Labour labour = labourList.get(i);

            if (labour.getId().equalsIgnoreCase(labourID)) {
                labourList.remove(labour);
            }
        }

        try {
            // Delete the entire file
            Files.delete(Paths.get("storage/labour.txt"));
        } catch (IOException ex) {
            Logger.getLogger(LabourService.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Create a new file and write new data into the file
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/labour.txt"))) {
            labourList.forEach(labour -> {
                pw.println(labour.getId() + "," + labour.getName() + "," + labour.getSalary());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LabourService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

package fr.epita.biostat.services;

import fr.epita.biostat.datamodel.BioStatEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVService {


    public static List<BioStatEntry> readEntries(String pathname) throws FileNotFoundException {
        File file = new File(pathname);
        List<BioStatEntry> entries = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        scanner.nextLine(); //skip first line = headers
        while (scanner.hasNext()){
            String currentLine = scanner.nextLine();
            System.out.println(currentLine);
            String[] parts = currentLine.split(",");
            BioStatEntry entry = new BioStatEntry(
                    parts[0].trim(),
                    parts[1].trim(),
                    Integer.parseInt(parts[2].trim()),
                    Integer.parseInt(parts[3].trim()),
                    Integer.parseInt(parts[4].trim())
            );
            entries.add(entry);
        }
        return entries;
    }
}

package pavyzdys;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

// this class name should be changed
public class FileReaderMain {

    public static void main(String[] args) throws IOException {

        //Reading words from files in a folder
        // traditionally, files are read from the '/resources/ dir, not from a random folder on the disk
        // I would include the input files in the git project (and maybe the output files too). You only included output files, they make no sense without inputs

        // does this variable declare a target or a source? :)
        // String target_dir = "C:/Program Files/Ampps/www/Tado_uzduotis/src/pavyzdys/filesWithEnglishWords";
        // you need 2 constants, i.e.:
        final String SOURCE_DIR = "resources/input/";
        final String TARGET_DIR = "resources/output/";
        File dir = new File(SOURCE_DIR);
        File[] files = dir.listFiles();
        // I would name this variable "allWords" or something similar. "list" is non-descriptive
        ArrayList<String> list = new ArrayList<>();

        for (File f : files) {
            if (f.isFile()) {
                BufferedReader inputStream = null;

                // this style of try-catch-finally is very old-school (pre-Java 7).
                // I would use try-with-resources: https://www.baeldung.com/java-try-with-resources
                try {
                    inputStream = new BufferedReader(
                            new FileReader(f));
                    // this variable is recreated on each loop cycle, I would declare it before I enter the loop
                    String line;

                    // do you split the line into separate words?
                    while ((line = inputStream.readLine()) != null) {
                        list.add(line);
                    }
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }

        //Creating Treemap for sorted keys
        Map<String, Integer> tm = new TreeMap<>();
        for (String i : list) {
            Integer j = tm.get(i);
            tm.put(i, (j == null) ? 1 : j + 1);
        }

        // displaying the occurrence of elements in the arraylist
        for (Map.Entry<String, Integer> val : tm.entrySet()) {
            System.out.println(val.getKey() + " : " + val.getValue());
        }

        // Writing words starting a - g in a file

        FileWriter fstream = new FileWriter("first.txt");
        BufferedWriter ag = new BufferedWriter(fstream);

        for (Map.Entry<String, Integer> entry : tm.entrySet()) {
            // here I get a "String index out of range: 0" exception when testing with my own input files from /resources/input dir, looks like I have some empty strings in the TreeMap, this case should be considered
            char first = entry.getKey().charAt(0);
            // what about words starting with upper case letters?
            if ((first >= 'a' && first <= 'g')) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                ag.write(entry.getKey() + ":" + entry.getValue());
                ag.newLine();
                System.out.println("Done");
                ag.flush();   // Flush the buffer and write all changes to the disk
            }
        }

        // you are repeating the same code 4 times and only change starting/ending letters + file name
        // you can either extract file writing into a separate method, or reuse the same loop with different inputs

        // Writing words starting h - n in a file
        FileWriter filestream = new FileWriter("second.txt");
        BufferedWriter hn = new BufferedWriter(filestream);

        for (Map.Entry<String, Integer> entry : tm.entrySet()) {
            char first = entry.getKey().charAt(0);
            if ((first >= 'h' && first <= 'n')) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                hn.write(entry.getKey() + ":" + entry.getValue());
                hn.newLine();
                System.out.println("Done");
                hn.flush();   // Flush the buffer and write all changes to the disk
            }
        }

        // Writing words starting o - u in a file
        FileWriter fil = new FileWriter("third.txt");
        BufferedWriter ou = new BufferedWriter(fil);

        for (Map.Entry<String, Integer> entry : tm.entrySet()) {
            char first = entry.getKey().charAt(0);
            if ((first >= 'o' && first <= 'u')) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                ou.write(entry.getKey() + ":" + entry.getValue());
                ou.newLine();
                System.out.println("Done");
                ou.flush();   // Flush the buffer and write all changes to the disk
            }
        }

        // Writing words starting v - z in a file
        FileWriter fsStream = new FileWriter("fourth.txt");
        BufferedWriter vz = new BufferedWriter(fsStream);

        for (Map.Entry<String, Integer> entry : tm.entrySet()) {
            char first = entry.getKey().charAt(0);
            if ((first >= 'v' && first <= 'z')) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                vz.write(entry.getKey() + ":" + entry.getValue());
                vz.newLine();
                System.out.println("Done");
                vz.flush();   // Flush the buffer and write all changes to the disk
            }
        }
    }
}




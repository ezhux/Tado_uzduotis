package pavyzdys;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class FileReaderMain {

    public static void main(String[] args) throws IOException {

        //Reading words from files in a folder
        String target_dir = "C:/Program Files/Ampps/www/Tado_uzduotis/src/pavyzdys/filesWithEnglishWords";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();
        ArrayList<String> list = new ArrayList<>();

        for (File f : files) {
            if (f.isFile()) {
                BufferedReader inputStream = null;

                try {
                    inputStream = new BufferedReader(
                            new FileReader(f));
                    String line;

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
            char first = entry.getKey().charAt(0);
            if ((first >= 'a' && first <= 'g')) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                ag.write(entry.getKey() + ":" + entry.getValue());
                ag.newLine();
                System.out.println("Done");
                ag.flush();   // Flush the buffer and write all changes to the disk
            }
        }

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




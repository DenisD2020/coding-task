package parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parser {

    public static void main(String[] args) throws Exception {
        new Parser().pars();
//        new Parser().process();
    }

    private void process() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String in = "c:\\Users\\rdv20\\Downloads\\Downloads_2023_09_08\\process1.log";
        String prevLine = "2023-09-05 09:16:39.146";
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(in))) {
            while ((line = br.readLine()) != null) {
                LocalDateTime prevDate = LocalDateTime.parse(prevLine.substring(0, 23), formatter);
                LocalDateTime date = LocalDateTime.parse(line.substring(0, 23), formatter);
                if (Duration.between(prevDate, date).getSeconds() > 1 && !prevLine.contains("end")) {
                    System.out.println(prevLine);
                    System.out.println(line);
                }
                prevLine = line;
            }
        }
    }

    private void pars() throws Exception {
        String out = "c:\\Users\\rdv20\\Downloads\\Downloads_2023_09_08\\process2.log";
        String in = "c:\\Users\\rdv20\\Downloads\\Downloads_2023_09_08\\mssan-scoring-callback-dc-1-vjg9t-mssan-scoring-callback (1).log";
        BufferedWriter writer = new BufferedWriter(new FileWriter(out));
        try (BufferedReader br = new BufferedReader(new FileReader(in))) {
            for (String line; (line = br.readLine()) != null; ) {
                if (line.contains("processing message applicationId")) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            writer.flush();
            writer.close();
        }
    }
}

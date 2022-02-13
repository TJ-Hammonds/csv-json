package mcis.jsu.edu;

import java.io.*;

public class Main {

public static void main(String[] args) {

ClassLoader loader = ClassLoader.getSystemClassLoader();



StringBuilder csvFile = new StringBuilder();

try {

BufferedReader reader = new BufferedReader(new InputStreamReader(loader.getResourceAsStream("resources" + File.separator + "grades.csv")));
String line;

while((line = reader.readLine()) != null) {
csvFile.append(line).append('\n');
}

}
catch(IOException e) { e.printStackTrace(); }

String csvFileString = csvFile.toString().trim();



StringBuilder jsonFile = new StringBuilder();

try {

BufferedReader reader = new BufferedReader(new InputStreamReader(loader.getResourceAsStream("resources" + File.separator + "grades.json")));
String line;

while((line = reader.readLine()) != null) {
jsonFile.append(line).append('\n');
}

}
catch(IOException e) { e.printStackTrace(); }

String jsonFileString = jsonFile.toString().trim();



System.out.println("CONVERSION RESULTS (CSV to JSON)");
System.out.println("================================");

String json = Converter.csvToJson(csvFileString);
System.out.println(json);



System.out.println("\nCONVERSION RESULTS (JSON to CSV)");
System.out.println("================================");

String csv = Converter.jsonToCsv(jsonFileString);
System.out.println(csv);

}

}
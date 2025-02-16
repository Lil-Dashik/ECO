package Module5.Eco;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;


public class EcoFriendlyUser {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Path filePath = Path.of("C:\\Users\\79372\\Desktop\\программки\\data.csv");

            if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
                throw new FileNotFoundException("The specified path is not a file.");
            }
            if (!filePath.toString().endsWith(".csv")) {
                throw new IllegalArgumentException("The file must be in CSV (.csv) format.");
            }

            double maxConsumption;
            try {
                maxConsumption = Double.parseDouble(reader.readLine());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("You need to enter a number");
            }
            UserReader readerCSV = new UserReaderCSV(filePath);
            UserParser userParseCSV = new UserParseCSV();
            PredicatesFilter predicatesFilter = new PredicatesFilter();
            UserFilter ecoMaxFilter = new EcoUserFilter(predicatesFilter.filterCondition(maxConsumption));
            FileDataWriter fileWriterCSV = new EcoFileWriterCSV(filePath);
            FileProcessor fileProcessor = new FileProcessor(readerCSV, userParseCSV, ecoMaxFilter, fileWriterCSV);
            fileProcessor.process();
        } catch (IOException e) {
            System.err.println("Input/Output error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error " + e.getMessage());
        }
    }
}

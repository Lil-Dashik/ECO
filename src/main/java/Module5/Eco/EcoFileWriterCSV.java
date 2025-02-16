package Module5.Eco;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EcoFileWriterCSV implements FileDataWriter {
    private final Path ecoUserFile;

    public EcoFileWriterCSV(Path filePath) throws IOException {
        Path parentDirectory = filePath.getParent();
        if (parentDirectory == null) {
            throw new IOException("The parent directory cannot be identified.");
        }


        this.ecoUserFile = parentDirectory.resolve("EcoUser.csv");
        if (!Files.exists(ecoUserFile)) {
            Files.createFile(ecoUserFile);
        }
    }

    public void writeFile(List<User> ecoUserNames) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(ecoUserFile)) {
            int count = 1;
            for (User user : ecoUserNames) {
                writer.write(count + ". " + user.getName());
                writer.newLine();
                count ++;
            }
        }
    }
}

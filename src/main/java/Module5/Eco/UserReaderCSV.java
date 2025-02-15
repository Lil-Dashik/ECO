package Module5.Eco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class UserReaderCSV implements UserReader {
    private final Path filePath;

    public UserReaderCSV(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readData() throws IOException {
        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            throw new IOException("File not found: " + filePath);
        }
        return Files.readAllLines(filePath);
    }

}

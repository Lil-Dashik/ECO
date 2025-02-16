package Module5.Eco;

import java.io.IOException;
import java.util.List;

public class FileProcessor {
    private final UserReader reader;
    private final UserParser parser;
    private final UserFilter filter;
    private final FileDataWriter writer;


    public FileProcessor(UserReader reader, UserParser parser, UserFilter filter, FileDataWriter writer) {
        this.reader = reader;
        this.parser = parser;
        this.filter = filter;
        this.writer = writer;
    }

    public void process() throws IOException {
        try {
            List<String> data = reader.readData();
            List<User> users = parser.parse(data);
            List<User> ecoUsers = filter.filterEcoUsers(users);
                writer.writeFile(ecoUsers);

        } catch (IOException e) {
            throw new IOException("File processing error", e);
        }
    }
}

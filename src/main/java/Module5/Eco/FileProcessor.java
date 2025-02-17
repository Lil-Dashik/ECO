package Module5.Eco;

import java.io.IOException;
import java.util.List;

public class FileProcessor {
    private final UserProvider reader;
    private final UserFilter filter;
    private final FileDataWriter writer;


    public FileProcessor(UserProvider reader, UserFilter filter, FileDataWriter writer) {
        this.reader = reader;
        this.filter = filter;
        this.writer = writer;
    }

    public void process() throws IOException {
        try {
            List<User> users = reader.readAndParse();
            List<User> ecoUsers = filter.filterEcoUsers(users);
                writer.writeFile(ecoUsers);

        } catch (IOException e) {
            throw new IOException("File processing error", e);
        }
    }
}

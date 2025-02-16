package Module5.Eco;

import java.io.IOException;
import java.util.List;

public class FileProcessor {
    private final UserReader reader;
    private final UserParser parser;
    private final PredicatesFilter predicatesFilter;
    private final UserFilter filter;
    private final FileDataWriter writer;


    public FileProcessor(UserReader reader, UserParser parser, PredicatesFilter predicatesFilter, UserFilter filter, FileDataWriter writer) {
        this.reader = reader;
        this.parser = parser;
        this.predicatesFilter = predicatesFilter;
        this.filter = filter;
        this.writer = writer;
    }

    public void process(double maxConsumption) throws IOException {
        try {
            List<String> data = reader.readData();
            List<User> users = parser.parse(data);
            if (maxConsumption == 0) {
                List<User> ecoUsers = filter.filterEcoUsers(users, predicatesFilter.gasGreaterThenElectricity());
                writer.writeFile(ecoUsers);
            } else {
                List<User> ecoUsers = filter.filterEcoUsers(users, predicatesFilter.filterCondition(maxConsumption));
                writer.writeFile(ecoUsers);
            }
        } catch (IOException e) {
            throw new IOException("File processing error", e);
        }
    }
}

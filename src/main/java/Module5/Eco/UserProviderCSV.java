package Module5.Eco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserProviderCSV implements UserProvider {
    private final Path filePath;

    public UserProviderCSV(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<User> readAndParse() throws IOException {
        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            throw new IOException("File not found: " + filePath);
        }
        List<String> list = Files.readAllLines(filePath);
        List<User> users = new ArrayList<>();
        for (int line = 1; line < list.size(); line++) {
            String[] parts = list.get(line).split("\\|");
            if (parts.length < 7) {
                continue;
            }
            try {
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int waterCountDay = Integer.parseInt(parts[2]);
                int waterCountNight = Integer.parseInt(parts[3]);
                int gasCount = Integer.parseInt(parts[4]);
                int electroCountDay = Integer.parseInt(parts[5]);
                int electroCountNight = Integer.parseInt(parts[6]);
                users.add(new User(id, name, waterCountDay, waterCountNight, gasCount, electroCountDay, electroCountNight));
            } catch (NumberFormatException e) {
                throw new RuntimeException();
            }
        }
        return users;
    }
}



package Module5.Eco;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class FileProcessor {
    public void fileProcessor(Path filePath, double maxConsumption) throws IOException {
        try {
            EcoFileWriter ecoFile = new EcoFileWriter(filePath);
            User user = new User();
            List<User> users = user.parseFileUsers(filePath);
            FindingEcoUsers findingEcoUsers = new FindingEcoUsers();
            List<User> ecoUsersName = findingEcoUsers.filterEcoUsers(users, maxConsumption);
            ecoFile.writeEcoUser(ecoUsersName);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }
}

package Module5.Eco;

import java.io.IOException;
import java.util.List;

public interface FileWriter {
    void writeFile(List<User> ecoUserNames) throws IOException;
}

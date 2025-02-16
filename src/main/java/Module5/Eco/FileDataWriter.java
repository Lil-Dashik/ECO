package Module5.Eco;

import java.io.IOException;
import java.util.List;

public interface FileDataWriter {
    void writeFile(List<User> ecoUserNames) throws IOException;
}

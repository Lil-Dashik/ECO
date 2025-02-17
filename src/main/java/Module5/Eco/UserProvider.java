package Module5.Eco;

import java.io.IOException;
import java.util.List;

public interface UserProvider {
     List<User> readAndParse() throws IOException;
}

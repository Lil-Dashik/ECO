package Module5.Eco;

import java.io.IOException;
import java.util.List;

public interface UserParser {
    List<User> parse(List<String> users) throws IOException;
}

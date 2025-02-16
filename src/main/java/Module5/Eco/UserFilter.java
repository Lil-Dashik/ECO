package Module5.Eco;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface UserFilter {
    List<User> filterEcoUsers(List<User> users);

}

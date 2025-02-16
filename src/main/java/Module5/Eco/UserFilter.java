package Module5.Eco;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserFilter {
    public List<User> filterEcoUsers(List<User> users, Predicate<User> filterCondition) {
        return users.stream()
                .filter(filterCondition)
                .collect(Collectors.toList());
    }
}

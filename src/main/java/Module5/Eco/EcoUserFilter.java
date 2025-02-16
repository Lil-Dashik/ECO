package Module5.Eco;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EcoUserFilter implements UserFilter {
    private final Predicate<User> condition;

    public EcoUserFilter(Predicate<User> condition) {
        this.condition = condition;
    }

    @Override
    public List<User> filterEcoUsers(List<User> users) {
        return users.stream().filter(condition).collect(Collectors.toList());
    }
}

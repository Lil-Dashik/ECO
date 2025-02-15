package Module5.Eco;

import java.util.List;
import java.util.stream.Collectors;

public class UserFilter {
    private boolean isEcoUser(User user, double maxConsumption) {
        return (user.getWaterCountDay() + user.getWaterCountNight()) < maxConsumption &&
                user.getGasCount() < maxConsumption &&
                (user.getElectroCountDay() + user.getElectroCountNight()) < maxConsumption;
    }

    public List<User> filterEcoUsers(List<User> users, double maxConsumption) {
        return users.stream()
                .filter(user -> isEcoUser(user, maxConsumption))
                .collect(Collectors.toList());
    }
}

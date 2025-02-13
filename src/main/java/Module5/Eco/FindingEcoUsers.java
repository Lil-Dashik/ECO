package Module5.Eco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindingEcoUsers {
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

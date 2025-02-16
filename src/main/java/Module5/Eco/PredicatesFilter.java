package Module5.Eco;

import java.util.function.Predicate;

public class PredicatesFilter {
    public Predicate<User> gasGreaterThenElectricity() {
        return user -> user.getGasCount() > (user.getElectroCountDay() + user.getElectroCountNight());
    }

    public Predicate<User> filterCondition(double maxConsumption) {
        return user -> (user.getGasCount() < maxConsumption &&
                (user.getWaterCountDay() + user.getWaterCountNight()) < maxConsumption &&
                (user.getElectroCountDay() + user.getElectroCountNight() < maxConsumption));
    }
}

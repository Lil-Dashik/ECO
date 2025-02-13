package Module5.Eco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private int waterCountDay;
    private int waterCountNight;
    private int gasCount;
    private int electroCountDay;
    private int electroCountNight;

    public User() {

    }

    public User(int id, String name, int waterCountDay, int waterCountNight, int gasCount, int electroCountDay, int electroCountNight) {
        this.id = id;
        this.name = name;
        this.waterCountDay = waterCountDay;
        this.waterCountNight = waterCountNight;
        this.gasCount = gasCount;
        this.electroCountDay = electroCountDay;
        this.electroCountNight = electroCountNight;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getWaterCountDay() {
        return waterCountDay;
    }


    public int getWaterCountNight() {
        return waterCountNight;
    }


    public int getGasCount() {
        return gasCount;
    }


    public int getElectroCountDay() {
        return electroCountDay;
    }


    public int getElectroCountNight() {
        return electroCountNight;
    }


    public List<User> parseFileUsers(Path filePath) throws IOException {
        List<String> lines = Files.readAllLines(filePath);
        if (lines.isEmpty()) {
            System.out.println("The file is empty.");
            return new ArrayList<>();
        }

        List<User> users = new ArrayList<>();
        for (int line = 1; line < lines.size(); line++) {
            String[] parts = lines.get(line).split("\\|");
            if (parts.length < 7) {
                continue;
            }
            try {
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int waterCountDay = Integer.parseInt(parts[2]);
                int waterCountNight = Integer.parseInt(parts[3]);
                int gasCount = Integer.parseInt(parts[4]);
                int electroCountDay = Integer.parseInt(parts[5]);
                int electroCountNight = Integer.parseInt(parts[6]);
                users.add(new User(id, name, waterCountDay, waterCountNight, gasCount, electroCountDay, electroCountNight));
            } catch (NumberFormatException e) {
                throw new RuntimeException();
            }
        }
        return users;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", waterCountDay=" + waterCountDay +
                ", waterCountNight=" + waterCountNight +
                ", gasCount=" + gasCount +
                ", electroCountDay=" + electroCountDay +
                ", electroCountNight=" + electroCountNight +
                '}';
    }
}

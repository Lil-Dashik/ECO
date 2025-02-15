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

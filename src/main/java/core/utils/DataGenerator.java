package core.utils;
import java.util.UUID;

public class DataGenerator {

    public static String getRandomName() {
        return "User_" + UUID.randomUUID().toString().substring(0,5);
    }
}
package www0abdb.oss.entivita;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Config {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private static final Path CONFIG_PATH =
            FabricLoader.getInstance()
                    .getConfigDir()
                    .resolve("entivita.json");

    private static Config INSTANCE = new Config();

    private boolean renderingEnabled = true;
    private boolean heartStackingEnabled = true;
    private int heartOffset = 0;

    public static boolean getRenderingEnabled() {
        return INSTANCE.renderingEnabled;
    }

    public static void setRenderingEnabled(boolean enabled) {
        INSTANCE.renderingEnabled = enabled;
        save();
    }

    public static boolean getHeartStackingEnabled() {
        return INSTANCE.heartStackingEnabled;
    }

    public static void setHeartStackingEnabled(boolean enabled) {
        INSTANCE.heartStackingEnabled = enabled;
        save();
    }

    public static int getHeartOffset() {
        return INSTANCE.heartOffset;
    }

    public static void setHeartOffset(int offset) {
        INSTANCE.heartOffset = offset;
        save();
    }

    public static void load() {
        if (!Files.exists(CONFIG_PATH)) {
            save();
            return;
        }

        try (var reader = Files.newBufferedReader(CONFIG_PATH)) {
            Config config = GSON.fromJson(reader, Config.class);

            if (config != null) {
                INSTANCE = config;
            }
        } catch (IOException | RuntimeException e) {
            System.err.println(
                    "Failed to load Health Indicators config: "
                            + e.getMessage()
            );
        }
    }

    public static void save() {
        try {
            Files.createDirectories(CONFIG_PATH.getParent());

            try (var writer = Files.newBufferedWriter(CONFIG_PATH)) {
                GSON.toJson(INSTANCE, writer);
            }
        } catch (IOException | RuntimeException e) {
            System.err.println(
                    "Failed to save Health Indicators config: "
                            + e.getMessage()
            );
        }
    }
}

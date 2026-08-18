package www0abdb.oss.entivita;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class EntivitaMod implements ClientModInitializer {

    public static final String MOD_ID = "entivita";
    public static final String CONFIG_FILE = "entivita.json";


    public static final KeyMapping.Category KEY_CATEGORY =
            KeyMapping.Category.register(Identifier.fromNamespaceAndPath(MOD_ID, "main"));

    public static final KeyMapping RENDERING_ENABLED_KEY_BINDING =
            new KeyMapping(
                    "key." + MOD_ID + ".renderingEnabled",
                    0,
                    KEY_CATEGORY
            );

    public static final KeyMapping HEART_STACKING_ENABLED_KEY_BINDING =
            new KeyMapping(
                    "key." + MOD_ID + ".heartStackingEnabled",
                    0,
                    KEY_CATEGORY
            );

    public static final KeyMapping INCREASE_HEART_OFFSET_KEY_BINDING =
            new KeyMapping(
                    "key." + MOD_ID + ".increaseHeartOffset",
                    0,
                    KEY_CATEGORY
            );

    public static final KeyMapping DECREASE_HEART_OFFSET_KEY_BINDING =
            new KeyMapping(
                    "key." + MOD_ID + ".decreaseHeartOffset",
                    0,
                    KEY_CATEGORY
            );

    @Override
    public void onInitializeClient() {
        Config.load();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            while (RENDERING_ENABLED_KEY_BINDING.consumeClick()) {
                Config.setRenderingEnabled(!Config.getRenderingEnabled());

                if (client.player != null) {
                    client.player.sendOverlayMessage(
                            Component.literal(
                                    (Config.getRenderingEnabled()
                                            ? "Enabled"
                                            : "Disabled")
                                            + " Health Indicators"
                            )
                    );
                }
            }

            while (HEART_STACKING_ENABLED_KEY_BINDING.consumeClick()) {
                Config.setHeartStackingEnabled(
                        !Config.getHeartStackingEnabled()
                );

                if (client.player != null) {
                    client.player.sendOverlayMessage(
                            Component.literal(
                                    (Config.getHeartStackingEnabled()
                                            ? "Enabled"
                                            : "Disabled")
                                            + " Heart Stacking"
                            )
                    );
                }
            }

            while (INCREASE_HEART_OFFSET_KEY_BINDING.consumeClick()) {
                Config.setHeartOffset(Config.getHeartOffset() + 1);

                if (client.player != null) {
                    client.player.sendOverlayMessage(
                            Component.literal(
                                    "Set heart offset to "
                                            + Config.getHeartOffset()
                            )
                    );
                }
            }

            while (DECREASE_HEART_OFFSET_KEY_BINDING.consumeClick()) {
                Config.setHeartOffset(Config.getHeartOffset() - 1);

                if (client.player != null) {
                    client.player.sendOverlayMessage(
                            Component.literal(
                                    "Set heart offset to "
                                            + Config.getHeartOffset()
                            )
                    );
                }
            }
        });
    }
}

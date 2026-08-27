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
            KeyMapping.Category.register(
                    Identifier.fromNamespaceAndPath(
                            MOD_ID,
                            "main"
                    )
            );

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

    public static final KeyMapping INCREASE_HEART_SCALE_KEY_BINDING =
            new KeyMapping(
                    "key." + MOD_ID + ".increaseHeartScale",
                    0,
                    KEY_CATEGORY
            );

    public static final KeyMapping DECREASE_HEART_SCALE_KEY_BINDING =
            new KeyMapping(
                    "key." + MOD_ID + ".decreaseHeartScale",
                    0,
                    KEY_CATEGORY
            );

    @Override
    public void onInitializeClient() {

        Config.load();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            /*
             * Toggle health indicator rendering.
             */
            while (RENDERING_ENABLED_KEY_BINDING.consumeClick()) {

                Config.setRenderingEnabled(
                        !Config.getRenderingEnabled()
                );

                if (client.player != null) {

                    client.player.sendOverlayMessage(
                            Component.literal(
                                    (
                                            Config.getRenderingEnabled()
                                                    ? "Enabled"
                                                    : "Disabled"
                                    )
                                            + " Health Indicators"
                            )
                    );
                }
            }

            /*
             * Toggle heart stacking.
             */
            while (HEART_STACKING_ENABLED_KEY_BINDING.consumeClick()) {

                Config.setHeartStackingEnabled(
                        !Config.getHeartStackingEnabled()
                );

                if (client.player != null) {

                    client.player.sendOverlayMessage(
                            Component.literal(
                                    (
                                            Config.getHeartStackingEnabled()
                                                    ? "Enabled"
                                                    : "Disabled"
                                    )
                                            + " Heart Stacking"
                            )
                    );
                }
            }

            /*
             * Increase heart height offset.
             */
            while (INCREASE_HEART_OFFSET_KEY_BINDING.consumeClick()) {

                Config.setHeartOffset(
                        Config.getHeartOffset() + 1
                );

                if (client.player != null) {

                    client.player.sendOverlayMessage(
                            Component.literal(
                                    "Set heart offset to "
                                            + Config.getHeartOffset()
                            )
                    );
                }
            }

            /*
             * Decrease heart height offset.
             */
            while (DECREASE_HEART_OFFSET_KEY_BINDING.consumeClick()) {

                Config.setHeartOffset(
                        Config.getHeartOffset() - 1
                );

                if (client.player != null) {

                    client.player.sendOverlayMessage(
                            Component.literal(
                                    "Set heart offset to "
                                            + Config.getHeartOffset()
                            )
                    );
                }
            }

            /*
             * Increase heart size.
             */
            while (INCREASE_HEART_SCALE_KEY_BINDING.consumeClick()) {

                Config.setHeartScale(
                        Config.getHeartScale() + 0.1F
                );

                if (client.player != null) {

                    client.player.sendOverlayMessage(
                            Component.literal(
                                    String.format(
                                            "Set heart size to %.1f",
                                            Config.getHeartScale()
                                    )
                            )
                    );
                }
            }

            /*
             * Decrease heart size.
             */
            while (DECREASE_HEART_SCALE_KEY_BINDING.consumeClick()) {

                Config.setHeartScale(
                        Config.getHeartScale() - 0.1F
                );

                if (client.player != null) {

                    client.player.sendOverlayMessage(
                            Component.literal(
                                    String.format(
                                            "Set heart size to %.1f",
                                            Config.getHeartScale()
                                    )
                            )
                    );
                }
            }
        });
    }
}
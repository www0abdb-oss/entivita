package www0abdb.oss.entivita.screen;

import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.gui.screens.Screen;
import www0abdb.oss.entivita.screen.EntivitaConfigScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import www0abdb.oss.entivita.Config;

public class EntivitaConfigScreen extends Screen {

    private final Screen parent;

    public EntivitaConfigScreen(Screen parent) {
        super(Component.literal("Entivita Settings"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;

        this.addRenderableWidget(
                CycleButton.onOffBuilder(
                                Config.getRenderingEnabled()
                        )
                        .create(
                                centerX - 100,
                                50,
                                200,
                                20,
                                Component.literal("Health Indicators"),
                                (button, value) -> {
                                    Config.setRenderingEnabled(value);
                                }
                        )
        );

        this.addRenderableWidget(
                CycleButton.onOffBuilder(
                                Config.getHeartStackingEnabled()
                        )
                        .create(
                                centerX - 100,
                                80,
                                200,
                                20,
                                Component.literal("Heart Stacking"),
                                (button, value) -> {
                                    Config.setHeartStackingEnabled(value);
                                }
                        )
        );

        this.addRenderableWidget(
                Button.builder(
                                Component.literal(
                                        "Heart Offset: "
                                                + Config.getHeartOffset()
                                ),
                                button -> {
                                    Config.setHeartOffset(
                                            Config.getHeartOffset() + 1
                                    );

                                    button.setMessage(
                                            Component.literal(
                                                    "Heart Offset: "
                                                            + Config.getHeartOffset()
                                            )
                                    );
                                }
                        )
                        .bounds(
                                centerX - 100,
                                110,
                                200,
                                20
                        )
                        .build()
        );

        this.addRenderableWidget(
                Button.builder(
                                Component.literal("Reset Offset"),
                                button -> {
                                    Config.setHeartOffset(0);
                                }
                        )
                        .bounds(
                                centerX - 100,
                                140,
                                200,
                                20
                        )
                        .build()
        );

        this.addRenderableWidget(
                Button.builder(
                                Component.literal("Done"),
                                button -> this.onClose()
                        )
                        .bounds(
                                centerX - 100,
                                180,
                                200,
                                20
                        )
                        .build()
        );
    }

    @Override
    public void onClose() {
        this.minecraft.setScreenAndShow(this.parent);
    }
}
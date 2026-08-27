package www0abdb.oss.entivita.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import www0abdb.oss.entivita.Config;
import www0abdb.oss.entivita.EntivitaHealthState;
import www0abdb.oss.entivita.HeartType;

@Mixin(LivingEntityRenderer.class)
public abstract class AvatarRendererMixin {

    private static final RenderType[] HEART_RENDER_TYPES;

    static {
        HeartType[] types = HeartType.values();
        HEART_RENDER_TYPES = new RenderType[types.length];

        for (int i = 0; i < types.length; i++) {
            HEART_RENDER_TYPES[i] =
                    RenderTypes.entityCutout(types[i].texture);
        }
    }

    @Inject(
            method = "submit(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V",
            at = @At("RETURN")
    )
    private void entivita$submitHealth(
            LivingEntityRenderState state,
            PoseStack poseStack,
            SubmitNodeCollector collector,
            CameraRenderState camera,
            CallbackInfo ci
    ) {
        if (!Config.getRenderingEnabled()) {
            return;
        }

        if (!(state instanceof EntivitaHealthState healthState)) {
            return;
        }

        Minecraft client = Minecraft.getInstance();

        if (client.level == null || client.player == null) {
            return;
        }

        if (state.isInvisibleToPlayer) {
            return;
        }

        float maxHealth = healthState.entivita$getMaxHealth();
        float health = healthState.entivita$getHealth();
        float absorption = healthState.entivita$getAbsorption();

        if (maxHealth <= 0.0F) {
            return;
        }

        int maxHealthPoints =
                Math.max(0, (int) Math.ceil(maxHealth));

        int healthPoints =
                Math.max(0, (int) Math.ceil(health));

        int absorptionPoints =
                Math.max(0, (int) Math.ceil(absorption));

        int normalHearts =
                (maxHealthPoints + 1) / 2;

        int redHearts =
                Math.min(
                        normalHearts,
                        (healthPoints + 1) / 2
                );

        int yellowHearts =
                (absorptionPoints + 1) / 2;

        int totalHearts =
                normalHearts + yellowHearts;

        if (totalHearts <= 0) {
            return;
        }

        int heartsPerRow =
                Config.getHeartStackingEnabled()
                        ? 10
                        : Math.min(totalHearts, 20);

        int rows =
                (totalHearts + heartsPerRow - 1)
                        / heartsPerRow;

        float rowSpacing = 9.0F;

        poseStack.pushPose();

/*
 * Automatically place the health HUD above each entity.
 * The base position follows the entity's actual height.
 * Extra rows receive a small additional lift.
 */
/*
 * Keep the HUD close to the entity while adapting to
 * different entity sizes.
 */
float entityHeight = Math.max(
        0.5F,
        state.boundingBoxHeight
);

float hudHeight =
        entityHeight
                + 0.05F
                + Math.max(0, rows - 1) * 0.12F
                + Config.getHeartOffset() * 0.05F;

poseStack.translate(
        0.0D,
        hudHeight,
        0.0D
);

        poseStack.mulPose(camera.orientation);

        poseStack.scale(
                -0.018F,
                0.018F,
                0.018F
        );

        for (int heart = 0; heart < totalHearts; heart++) {

            int row = heart / heartsPerRow;
            int column = heart % heartsPerRow;

            int heartsThisRow =
                    Math.min(
                            heartsPerRow,
                            totalHearts - row * heartsPerRow
                    );

            float startX =
                    ((heartsThisRow - 1) * 9.0F) / 2.0F;

            float x =
                    startX - column * 9.0F;

float y = row * rowSpacing;

            /*
             * Container
             */
            submitHeart(
                    collector,
                    poseStack,
                    x,
                    y,
                    0.0F,
                    HeartType.EMPTY,
                    state.lightCoords
            );

            HeartType type = HeartType.EMPTY;

            /*
             * Normal health
             */
            if (heart < normalHearts) {

                if (heart < redHearts) {

                    if (
                            heart == redHearts - 1
                                    && healthPoints % 2 != 0
                    ) {
                        type = HeartType.RED_HALF;
                    } else {
                        type = HeartType.RED_FULL;
                    }
                }
            }

            /*
             * Absorption
             */
            else {

                int absorptionIndex =
                        heart - normalHearts;

                if (absorptionIndex < yellowHearts) {

                    if (
                            absorptionIndex == yellowHearts - 1
                                    && absorptionPoints % 2 != 0
                    ) {
                        type = HeartType.YELLOW_HALF;
                    } else {
                        type = HeartType.YELLOW_FULL;
                    }
                }
            }

            if (type != HeartType.EMPTY) {

                submitHeart(
                        collector,
                        poseStack,
                        x,
                        y,
                        0.01F,
                        type,
                        state.lightCoords
                );
            }
        }

        poseStack.popPose();
    }

    private static void submitHeart(
            SubmitNodeCollector collector,
            PoseStack poseStack,
            float x,
            float y,
            float z,
            HeartType type,
            int light
    ) {
        RenderType renderType =
                HEART_RENDER_TYPES[type.ordinal()];

        Identifier texture =
                type.texture;

        collector.submitCustomGeometry(
                poseStack,
                renderType,
                (pose, vertices) -> {

                    Matrix4f matrix = pose.pose();

                    float size = 8.0F;

                    float x0 = x - size / 2.0F;
                    float x1 = x + size / 2.0F;

                    float y0 = y - size / 2.0F;
                    float y1 = y + size / 2.0F;

                    vertices.addVertex(
                            matrix,
                            x0,
                            y0,
                            z
                    )
                    .setColor(255, 255, 255, 255)
                    .setUv(0.0F, 1.0F)
                    .setUv1(0, 0)
                    .setUv2(
                            light & 0xFFFF,
                            light >> 16
                    )
                    .setNormal(
                            0.0F,
                            0.0F,
                            1.0F
                    );

                    vertices.addVertex(
                            matrix,
                            x1,
                            y0,
                            z
                    )
                    .setColor(255, 255, 255, 255)
                    .setUv(1.0F, 1.0F)
                    .setUv1(0, 0)
                    .setUv2(
                            light & 0xFFFF,
                            light >> 16
                    )
                    .setNormal(
                            0.0F,
                            0.0F,
                            1.0F
                    );

                    vertices.addVertex(
                            matrix,
                            x1,
                            y1,
                            z
                    )
                    .setColor(255, 255, 255, 255)
                    .setUv(1.0F, 0.0F)
                    .setUv1(0, 0)
                    .setUv2(
                            light & 0xFFFF,
                            light >> 16
                    )
                    .setNormal(
                            0.0F,
                            0.0F,
                            1.0F
                    );

                    vertices.addVertex(
                            matrix,
                            x0,
                            y1,
                            z
                    )
                    .setColor(255, 255, 255, 255)
                    .setUv(0.0F, 0.0F)
                    .setUv1(0, 0)
                    .setUv2(
                            light & 0xFFFF,
                            light >> 16
                    )
                    .setNormal(
                            0.0F,
                            0.0F,
                            1.0F
                    );
                }
        );
    }
}
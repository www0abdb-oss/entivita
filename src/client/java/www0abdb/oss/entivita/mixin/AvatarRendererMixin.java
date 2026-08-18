package www0abdb.oss.entivita.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import www0abdb.oss.entivita.Config;
import www0abdb.oss.entivita.HeartType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.resources.model.sprite.AtlasManager;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.data.AtlasIds;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class AvatarRendererMixin {

    private static final Identifier GUI_ATLAS = AtlasIds.GUI;

    @Inject(
        method = "submit(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V",
        at = @At("RETURN")
    )
    private void playerEntivita$submitHealth(
            net.minecraft.client.renderer.entity.state.LivingEntityRenderState state,
            PoseStack poseStack,
            SubmitNodeCollector collector,
            CameraRenderState camera,
            CallbackInfo ci
    ) {
        if (!Config.getRenderingEnabled()) {
            return;
        }

        if (!(state instanceof AvatarRenderState avatarState)) {
            return;
        }

        Minecraft client = Minecraft.getInstance();

        if (client.level == null || client.player == null) {
            return;
        }

        Entity entity = client.level.getEntity(avatarState.id);

        if (!(entity instanceof Player player)) {
            return;
        }

        if (player == client.player) {
            return;
        }

        if (player.isInvisibleTo(client.player)) {
            return;
        }

        int maxHealth = (int) Math.ceil(player.getMaxHealth());
        int health = (int) Math.ceil(player.getHealth());
        int absorption = (int) Math.ceil(player.getAbsorptionAmount());

        if (maxHealth <= 0) {
            return;
        }

        int normalHearts = (maxHealth + 1) / 2;
        int redHearts = (health + 1) / 2;
        int yellowHearts = (absorption + 1) / 2;

        int totalHearts = normalHearts + yellowHearts;

        if (totalHearts <= 0) {
            return;
        }

        int heartsPerRow = Config.getHeartStackingEnabled()
                ? 10
                : totalHearts;

        int rows = (totalHearts + heartsPerRow - 1) / heartsPerRow;

        float rowOffset = Math.max(10 - (rows - 2), 3);

        /*
         * The renderer's PoseStack is in entity/model space here.
         * Submit our geometry using the same pose.
         */
        poseStack.pushPose();

        poseStack.translate(
                0.0D,
                player.getBbHeight() + 0.55D + Config.getHeartOffset() * 0.025D,
                0.0D
        );

        // Face the camera.
        poseStack.mulPose(camera.orientation);

        // Match the old HUD-style quad orientation.
        poseStack.scale(-0.025F, 0.025F, 0.025F);

        AtlasManager atlasManager = client.getAtlasManager();

        for (int heart = 0; heart < totalHearts; heart++) {
            int row = heart / heartsPerRow;
            int col = heart % heartsPerRow;

            float x =
                    ((Math.min(totalHearts, heartsPerRow) - 1) * 8.0F)
                    / 2.0F
                    - col * 8.0F;

            float y = row * rowOffset;
            float z = row * 0.01F;

            HeartType type;

            // Container first.
            submitHeart(
                    collector,
                    poseStack,
                    atlasManager,
                    x,
                    y,
                    z,
                    HeartType.EMPTY,
                    avatarState.lightCoords
            );

            if (heart < redHearts) {
                type = HeartType.RED_FULL;

                if (heart == redHearts - 1 && (health & 1) != 0) {
                    type = HeartType.RED_HALF;
                }
            } else if (heart < normalHearts) {
                type = HeartType.EMPTY;
            } else {
                type = HeartType.YELLOW_FULL;

                if (heart == totalHearts - 1 && (absorption & 1) != 0) {
                    type = HeartType.YELLOW_HALF;
                }
            }

            if (type != HeartType.EMPTY) {
                submitHeart(
                        collector,
                        poseStack,
                        atlasManager,
                        x,
                        y,
                        z + 0.001F,
                        type,
                        avatarState.lightCoords
                );
            }
        }

        poseStack.popPose();
    }

    private static void submitHeart(
            SubmitNodeCollector collector,
            PoseStack poseStack,
            AtlasManager atlasManager,
            float x,
            float y,
            float z,
            HeartType type,
            int light
    ) {
        SpriteId spriteId = new SpriteId(
                GUI_ATLAS,
                type.texture
        );

        TextureAtlasSprite sprite = atlasManager.get(spriteId);

        RenderType renderType =
                spriteId.renderType(RenderTypes::entityCutout);

        collector.submitCustomGeometry(
                poseStack,
                renderType,
                (pose, vertices) -> {
                    Matrix4f matrix = pose.pose();

                    float size = 9.0F;

                    float x0 = x - size;
                    float x1 = x;
                    float y0 = y - size;
                    float y1 = y;

                    vertices.addVertex(matrix, x0, y0, z)
                            .setColor(255, 255, 255, 255)
                            .setUv(sprite.getU0(), sprite.getV1())
                            .setUv2(0, light);

                    vertices.addVertex(matrix, x1, y0, z)
                            .setColor(255, 255, 255, 255)
                            .setUv(sprite.getU1(), sprite.getV1())
                            .setUv2(0, light);

                    vertices.addVertex(matrix, x1, y1, z)
                            .setColor(255, 255, 255, 255)
                            .setUv(sprite.getU1(), sprite.getV0())
                            .setUv2(0, light);

                    vertices.addVertex(matrix, x0, y1, z)
                            .setColor(255, 255, 255, 255)
                            .setUv(sprite.getU0(), sprite.getV0())
                            .setUv2(0, light);
                }
        );
    }
}

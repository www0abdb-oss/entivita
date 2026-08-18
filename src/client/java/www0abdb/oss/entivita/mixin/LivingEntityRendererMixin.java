package www0abdb.oss.entivita.mixin;

import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin {

    @Inject(
        method = "extractNameTags",
        at = @At("TAIL")
    )
    private void entivita$addHealth(
        LivingEntity entity,
        LivingEntityRenderState state,
        float partialTick,
        CallbackInfo ci
    ) {
        if (state.nameTag == null) {
            return;
        }

        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();

        Component healthText = Component.literal(
            String.format("%.1f / %.1f", health, maxHealth)
        );

        state.nameTag = Component.empty()
            .append(state.nameTag)
            .append(Component.literal(" "))
            .append(healthText);
    }
}

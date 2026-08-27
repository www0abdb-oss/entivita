package www0abdb.oss.entivita.mixin;

import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import www0abdb.oss.entivita.EntivitaHealthState;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin {

    @Inject(
            method = "extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V",
            at = @At("TAIL")
    )
    private void entivita$extractHealth(
            LivingEntity entity,
            LivingEntityRenderState state,
            float partialTick,
            CallbackInfo ci
    ) {
        if (state instanceof EntivitaHealthState healthState) {
            healthState.entivita$setHealth(
                    entity.getHealth(),
                    entity.getMaxHealth(),
                    entity.getAbsorptionAmount()
            );
        }
    }
}

package www0abdb.oss.entivita.mixin;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import www0abdb.oss.entivita.EntivitaHealthState;

@Mixin(LivingEntityRenderState.class)
public abstract class EntivitaLivingEntityRenderState implements EntivitaHealthState {

    private float entivita$health;
    private float entivita$maxHealth;
    private float entivita$absorption;

    @Override
    public float entivita$getHealth() {
        return entivita$health;
    }

    @Override
    public float entivita$getMaxHealth() {
        return entivita$maxHealth;
    }

    @Override
    public float entivita$getAbsorption() {
        return entivita$absorption;
    }

    @Override
    public void entivita$setHealth(
            float health,
            float maxHealth,
            float absorption
    ) {
        this.entivita$health = health;
        this.entivita$maxHealth = maxHealth;
        this.entivita$absorption = absorption;
    }
}

package www0abdb.oss.entivita;

import net.minecraft.resources.Identifier;

public enum HeartType {
    EMPTY(Identifier.withDefaultNamespace("hud/heart/container")),
    RED_FULL(Identifier.withDefaultNamespace("hud/heart/full")),
    RED_HALF(Identifier.withDefaultNamespace("hud/heart/half")),
    YELLOW_FULL(Identifier.withDefaultNamespace("hud/heart/absorbing_full")),
    YELLOW_HALF(Identifier.withDefaultNamespace("hud/heart/absorbing_half"));

    public final Identifier texture;

    HeartType(Identifier texture) {
        this.texture = texture;
    }
}

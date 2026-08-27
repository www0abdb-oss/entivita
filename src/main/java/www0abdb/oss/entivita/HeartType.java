package www0abdb.oss.entivita;

import net.minecraft.resources.Identifier;

public enum HeartType {

    EMPTY(
            Identifier.fromNamespaceAndPath(
                    "entivita",
                    "textures/hud/heart/container.png"
            )
    ),

    RED_FULL(
            Identifier.fromNamespaceAndPath(
                    "entivita",
                    "textures/hud/heart/full.png"
            )
    ),

    RED_HALF(
            Identifier.fromNamespaceAndPath(
                    "entivita",
                    "textures/hud/heart/half.png"
            )
    ),

    YELLOW_FULL(
            Identifier.fromNamespaceAndPath(
                    "entivita",
                    "textures/hud/heart/absorbing_full.png"
            )
    ),

    YELLOW_HALF(
            Identifier.fromNamespaceAndPath(
                    "entivita",
                    "textures/hud/heart/absorbing_half.png"
            )
    );

    public final Identifier texture;

    HeartType(Identifier texture) {
        this.texture = texture;
    }
}
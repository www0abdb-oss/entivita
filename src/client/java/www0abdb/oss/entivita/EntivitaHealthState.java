package www0abdb.oss.entivita;

public interface EntivitaHealthState {

    float entivita$getHealth();

    float entivita$getMaxHealth();

    float entivita$getAbsorption();

    void entivita$setHealth(
            float health,
            float maxHealth,
            float absorption
    );
}

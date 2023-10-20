package com.example.animalwarbattle.compatibility.domain.entity;

import lombok.Getter;

@Getter
public enum CompatibilityEnum {
    DOG(false, true, false, false, false),
    BIRD(false, false, true, false, false),
    CAT(false, false, false, true, false),
    GLIRES(false, false, false, false, true),
    FISH(true, false, false, false, false);

    private final boolean advantageDog;
    private final boolean advantageBird;
    private final boolean advantageCat;
    private final boolean advantageMouse;
    private final boolean advantageFish;

    CompatibilityEnum(boolean advantageDog,
                      boolean advantageBird,
                      boolean advantageCat,
                      boolean advantageMouse,
                      boolean advantageFish) {
        this.advantageDog = advantageDog;
        this.advantageBird = advantageBird;
        this.advantageCat = advantageCat;
        this.advantageMouse = advantageMouse;
        this.advantageFish = advantageFish;
    }
}

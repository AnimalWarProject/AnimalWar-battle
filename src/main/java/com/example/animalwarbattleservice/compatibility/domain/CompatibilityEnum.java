package com.example.animalwarbattleservice.compatibility.domain;

import lombok.Getter;


// 동물별 상성 체크 (True일 경우 해당 동물에 강해짐)
@Getter
public enum CompatibilityEnum {
    DOG(false, true, false, false, false),

    BIRD(false, false, true, false, false),

    CAT(false, false, false, true, false),

    GLIRES(false, false, false, false, true),

    FISH(true, false, false, false, false),

    COMMON(false, false, false, false, false);

    private final boolean advantageDog;
    private final boolean advantageBird;
    private final boolean advantageCat;
    private final boolean advantageGLIRES;
    private final boolean advantageFish;

    CompatibilityEnum(boolean advantageDog,
                      boolean advantageBird,
                      boolean advantageCat,
                      boolean advantageGlires,
                      boolean advantageFish) {
        this.advantageDog = advantageDog;
        this.advantageBird = advantageBird;
        this.advantageCat = advantageCat;
        this.advantageGLIRES = advantageGlires;
        this.advantageFish = advantageFish;
    }
}

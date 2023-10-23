package com.example.animalwarbattle.compatibility.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public enum CompatibilityEnum {
    //개는 조류에 강함을 true로 설정
    DOG(false, true, false, false, false),

    //새는 고양이에 강함(true)
    BIRD(false, false, true, false, false),

    //고양이는 설치류에 강함(true)
    CAT(false, false, false, true, false),

    //설치류는 어류에 강함(true)
    GLIRES(false, false, false, false, true),

    //어류는 개에 강함(true)
    FISH(true, false, false, false, false);

    private final boolean advantageDog;
    private final boolean advantageBird;
    private final boolean advantageCat;
    private final boolean advantageGLIRES;
    private final boolean advantageFish;

    CompatibilityEnum(boolean advantageDog,
                      boolean advantageBird,
                      boolean advantageCat,
                      boolean advantageMouse,
                      boolean advantageFish) {
        this.advantageDog = advantageDog;
        this.advantageBird = advantageBird;
        this.advantageCat = advantageCat;
        this.advantageGLIRES = advantageMouse;
        this.advantageFish = advantageFish;
    }
}

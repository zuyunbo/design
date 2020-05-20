package com.example.builder;

/**
 * 武器
 */
public enum Weapon {

    DAGGER,SWORD,AXE,WARHAMMER,BOW;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}

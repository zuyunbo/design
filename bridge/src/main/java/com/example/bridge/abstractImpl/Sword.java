package com.example.bridge.abstractImpl;

import com.example.bridge.Enchantment;

public class Sword implements Weapon {

    private final Enchantment enchantment;

    public Sword(Enchantment enchantment) {
        this.enchantment = enchantment;
    }



    @Override
    public void wield() {
        System.out.println("持剑");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        System.out.println("挥舞着剑");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        System.out.println("剑渐渐消失了");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }
}

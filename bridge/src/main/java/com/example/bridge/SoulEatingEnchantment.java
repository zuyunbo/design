package com.example.bridge;

public class SoulEatingEnchantment implements Enchantment {
    @Override
    public void onActivate() {
        System.out.println("吸血属性");
    }

    @Override
    public void apply() {
        System.out.println("吞噬敌人的灵魂");
    }

    @Override
    public void onDeactivate() {
        System.out.println("嗜血慢慢消失");
    }


}

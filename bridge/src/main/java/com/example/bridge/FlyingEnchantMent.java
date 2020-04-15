package com.example.bridge;

public class FlyingEnchantMent implements  Enchantment{
    @Override
    public void onActivate() {
        System.out.println("飞行时慢慢的发光");
    }

    @Override
    public void apply() {
        System.out.println("飞行时击中了敌人");
    }

    @Override
    public void onDeactivate() {
        System.out.println("该项目辉光消失");
    }
}

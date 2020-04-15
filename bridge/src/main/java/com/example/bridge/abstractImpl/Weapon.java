package com.example.bridge.abstractImpl;

import com.example.bridge.Enchantment;

public interface Weapon {

    void wield();

    void swing();

    void unwield();

    Enchantment getEnchantment();


}

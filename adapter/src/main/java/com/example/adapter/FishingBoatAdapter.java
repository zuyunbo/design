package com.example.adapter;

import java.util.*;

public class FishingBoatAdapter implements RowingBoat {

    FishingBoat fishingBoat;

    public FishingBoatAdapter() {
        this.fishingBoat = new FishingBoat();
    }

    @Override
    public void row() {
        fishingBoat.sail();
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j <= n; j++){
                if (allUnique(s, i, j)){
                    ans = Math.max(ans, j - i);
                }
            }

        }
    }


    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

}

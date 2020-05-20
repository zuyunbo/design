package com.example.builder;

/**
 * 发型
 */
public enum  HairType {

    BALD("bald"), SHORT("short"), CURLY("curly"), LONG_STRAIGHT("long straight"), LONG_CURLY(
      "long curly");

    private final String title;

    HairType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}

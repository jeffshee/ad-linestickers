package io.github.jeffshee.discordlinestickers;


public class Sticker {
    private String name;
    private int id, count;

    Sticker(String s, int i, int c) {
        name = s;
        id = i;
        count = c;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    int getCount() {
        return count;
    }
}

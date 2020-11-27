package com.example.android3_lesson1.ui;

import android.os.Build;

import com.example.android3_lesson1.data.Card;
import com.example.android3_lesson1.data.Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EmojiGame {

    private final Game<String> game;

    public EmojiGame() {
        List<String> content = new ArrayList<>();
        content.add("❤️");
        content.add("☀️");
        content.add("\uD83C\uDF66");
        Collections.shuffle(content);
        game = new Game<>(content);
    }


    public void choose(Card<String> card) {
        game.choose(card);
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }
}

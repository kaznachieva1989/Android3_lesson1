package com.example.android3_lesson1.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game<CardContent> {

    private List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> contents) {  //при условии 1.4.7 -будет пара 1,4,7
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false, false, contents.get(i), i * 2));
            cards.add(new Card<>(false, false, contents.get(i), i * 2 + 1));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        checkPairs(card);
    }

    private void checkPairs(Card<CardContent> card) {
        for (Card<CardContent> anotherCard : cards) {
            if (anotherCard.isFaceUp() && anotherCard.getId() != card.getId()) {
                if (anotherCard.getContent() == card.getContent()) {
                    System.out.println("ura!");
                    card.setMatched(true);
                    anotherCard.setMatched(true);
                } else {
                    anotherCard.setFaceUp(!anotherCard.isFaceUp());
                }
            }
        }
        removePairs();
    }

    private void removePairs() {
        List<Card<CardContent>> newList = new ArrayList<>(cards);
        for (Card<CardContent> card : cards) {
            if (card.isMatched()) newList.remove(card);
        }
        cards.clear();
        cards.addAll(newList);
    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }
}

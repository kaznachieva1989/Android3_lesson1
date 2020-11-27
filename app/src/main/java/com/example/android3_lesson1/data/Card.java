package com.example.android3_lesson1.data;

import android.os.Build;

import java.util.Objects;

public class Card<T> {
    private int id;
    private boolean isFaceUp;
    private boolean isMatched;
    private T content;

    public Card(boolean isFaceUp, boolean isMatched, T content, int id) {
        this.isFaceUp = isFaceUp;
        this.isMatched = isMatched;
        this.content = content;
        this.id = id;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card<?> card = (Card<?>) o;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return id == card.id &&
                    isFaceUp == card.isFaceUp &&
                    isMatched == card.isMatched &&
                    Objects.equals(content, card.content);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return Objects.hash(id, isFaceUp, isMatched, content);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", isFaceUp=" + isFaceUp +
                ", isMatched=" + isMatched +
                ", content=" + content +
                '}';
    }
}

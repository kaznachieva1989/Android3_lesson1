package com.example.android3_lesson1.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.gesture.GestureOverlayView;
import android.os.Build;
import android.os.Bundle;

import com.example.android3_lesson1.R;
import com.example.android3_lesson1.data.Card;

public class MainActivity extends AppCompatActivity implements EmojiGameAdapter.CardCallBack {

    private RecyclerView emojiRecycler;
    private EmojiGameAdapter emojiGameAdapter;
    private EmojiGame emojiGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emojiRecycler = findViewById(R.id.rv_cards);
        emojiGame = new EmojiGame();
        emojiGameAdapter = new EmojiGameAdapter(emojiGame, this);
        emojiRecycler.setAdapter(emojiGameAdapter);
        emojiRecycler.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
    }

    @Override
    public void choose(Card<String> card) {
        emojiGame.choose(card);
        emojiGameAdapter.notifyDataSetChanged();
    }
}
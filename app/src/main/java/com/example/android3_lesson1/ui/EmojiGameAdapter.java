package com.example.android3_lesson1.ui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3_lesson1.R;
import com.example.android3_lesson1.data.Card;

public class EmojiGameAdapter extends RecyclerView.Adapter<EmojiGameAdapter.EmojiHolder> {

    private final EmojiGame game;
    private final CardCallBack cardCallBack;

    public EmojiGameAdapter(EmojiGame game, CardCallBack cardCallBack) {
        this.game = game;
        this.cardCallBack = cardCallBack;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emoji_card, parent, false);
        return new EmojiHolder(view, cardCallBack);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.bind(game.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }

    static class EmojiHolder extends RecyclerView.ViewHolder {

        private final TextView content;
        private CardCallBack cardCallBack;

        public EmojiHolder(@NonNull View itemView, CardCallBack cardCallBack) {
            super(itemView);
            content = itemView.findViewById(R.id.tv_card_emoji);
            this.cardCallBack = cardCallBack;
        }

        public void bind(Card<String> card) {
            itemView.setOnClickListener(v -> {
                cardCallBack.choose(card);
            });
            if (card.isFaceUp()) {
                content.setText(card.getContent());
                itemView.setBackgroundColor(Color.WHITE);
            } else {
                content.setText("");
                itemView.setBackgroundColor(Color.BLUE);
            }
        }
    }

    interface CardCallBack {
        void choose(Card<String> card);
    }
}

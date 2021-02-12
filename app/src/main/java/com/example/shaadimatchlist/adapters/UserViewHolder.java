package com.example.shaadimatchlist.adapters;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shaadimatchlist.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    CircleImageView userImageView;
    TextView userName;
    TextView location;
    TextView country;
    AppCompatButton acceptButton;
    AppCompatButton declineButton;
    OnButtonClickListener listener;
    String userId;

    public UserViewHolder(@NonNull View itemView, OnButtonClickListener mOnButtonClickListener) {
        super(itemView);
        userImageView = itemView.findViewById(R.id.user_image);
        userName = itemView.findViewById(R.id.name);
        location = itemView.findViewById(R.id.location);
        country = itemView.findViewById(R.id.country_name);
        acceptButton = itemView.findViewById(R.id.accept_button);
        declineButton = itemView.findViewById(R.id.decline_button);
        listener = mOnButtonClickListener;
        acceptButton.setOnClickListener(this);
        declineButton.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.accept_button:
                listener.onAcceptButtonClicked(userId);
                break;
            case R.id.decline_button:
                listener.onDeclineButtonClicked(userId);
                break;
        }
    }
}

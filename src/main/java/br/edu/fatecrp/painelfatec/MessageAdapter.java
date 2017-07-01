package br.edu.fatecrp.painelfatec;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lucas on 29/06/17.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    private ArrayList<Message> messageList;

    public MessageAdapter(ArrayList<Message> message) {
        messageList = message;
    }


    @Override
    public MessageAdapter.MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new MessageHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(MessageAdapter.MessageHolder holder, int position) {
        Message message = messageList.get(position);
        holder.title.setText(message.getTitle().toString());
        holder.message.setText(message.getMessage().toString());

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static class MessageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private TextView message;

        public MessageHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title);
            message = (TextView) v.findViewById(R.id.message);
        }

        @Override
        public void onClick(View v) {
            Log.d("RecyclerView", "CLICK!");
        }
    }
}

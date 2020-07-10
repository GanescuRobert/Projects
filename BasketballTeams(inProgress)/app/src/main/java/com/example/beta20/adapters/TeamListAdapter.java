package com.example.beta20.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.beta20.player.Player;
import com.example.beta20.R;

import java.util.List;
import java.util.Objects;

public class TeamListAdapter extends ArrayAdapter<Player> {


    private static final String TAG = "PlayerListAdapter";
    private Context mContext;
    private int mResource;

    public TeamListAdapter(Context context, int resource, List<Player> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        int id = Objects.requireNonNull(getItem(position)).getId();
        String name = Objects.requireNonNull(getItem(position)).getName();
        double value = Objects.requireNonNull(getItem(position)).getValue();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView textViewId = ( TextView)convertView.findViewById(R.id.idTextView);
        TextView textViewName = ( TextView)convertView.findViewById(R.id.nameTextView);
        TextView textViewValue = ( TextView)convertView.findViewById(R.id.valueTextView);

        textViewId.setText(String.valueOf(id));
        textViewName.setText(name);
        textViewValue.setText(String.valueOf(value));

        return  convertView;
    }


}

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

import java.util.ArrayList;
import java.util.Objects;

public class AllPlayersListAdapter extends ArrayAdapter<Player> {


    private static final String TAG = "AllPlayersListAdapter";
    private Context mContext;
    private int mResource;

    public AllPlayersListAdapter(Context context, int resource, ArrayList<Player> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @SuppressLint({"ViewHolder", "SetTextI18n"})
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        int id = Objects.requireNonNull(getItem(position)).getId();
        String name = Objects.requireNonNull(getItem(position)).getName();
        int experience=Objects.requireNonNull(getItem(position)).getExperience();
        int power=Objects.requireNonNull(getItem(position)).getPower();
        int height=Objects.requireNonNull(getItem(position)).getHeight();
        int agility=Objects.requireNonNull(getItem(position)).getAgility();
        int age=Objects.requireNonNull(getItem(position)).getAge();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView textViewId = ( TextView)convertView.findViewById(R.id.idTextView);
        TextView textViewName = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView textViewExperience = (TextView) convertView.findViewById(R.id.experienceTextView);
        TextView textViewPower = (TextView) convertView.findViewById(R.id.powerTextView);
        TextView textViewHeight= (TextView) convertView.findViewById(R.id.heightTextView);
        TextView textViewAgility = (TextView) convertView.findViewById(R.id.agilityTextView);
        TextView textViewAge= (TextView) convertView.findViewById(R.id.ageTextView);

        textViewId.setText(String.valueOf("Id: "+id));
        textViewName.setText("Name: "+name);
        textViewExperience.setText(String.valueOf("Experience: "+ experience));
        textViewPower.setText(String.valueOf("Power: "+power));
        textViewHeight.setText(String.valueOf("Height: "+height));
        textViewAgility.setText(String.valueOf("Agility: "+agility));
        textViewAge.setText(String.valueOf("Age: "+age));

        return convertView;
    }


}

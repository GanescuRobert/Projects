package com.example.beta20.player;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.beta20.R;
import com.example.beta20.activitys.PlayersActivity2;
import com.example.beta20.activitys.RemovePlayerActivity22;

public class RemovePlayer extends AppCompatActivity {
    public RemovePlayer(Context mContext) {
        EditText idET = (EditText) ((Activity) mContext).findViewById(R.id.idEditText);
        if(idET.getText().toString().isEmpty()) {
            Toast toast = new Toast(mContext);
            toast.setText("Write an id");
            toast.setGravity(Gravity.FILL_HORIZONTAL,0,0);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
        } else {
            RemovePlayerActivity22.Remove=true;
            final int id = Integer.parseInt(idET.getText().toString());
            int index = -1;
            for (Player obj : PlayersActivity2.allPlayers) {
                if (obj.getId() == id) {
                    index = PlayersActivity2.allPlayers.indexOf(obj);
                    break;
                }
            }
            if (index != -1) {
                PlayersActivity2.allPlayers.remove(index);

            }

        }
    }
}

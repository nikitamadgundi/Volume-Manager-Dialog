package com.example.myvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  TextView txtMedia,txtNotification,txtRingtone,txtAlarm;
    private Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setUpListener();
    }
    private void initViews(){
        btnLogin= findViewById(R.id.btnLogin);
        txtRingtone = findViewById(R.id.txtRingtone);
        txtAlarm = findViewById(R.id.txtAlarm);
        txtNotification = findViewById(R.id.txtNotification);
        txtMedia = findViewById(R.id.txtMedia);

    }

    private void setUpListener(){
     btnLogin.setOnClickListener(new BtnVolumeDialogClickListener());

    }
    private class BtnVolumeDialogClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            VolumeEditDialog volumeManagerDialog = new VolumeEditDialog(MainActivity.this,0,0,0,0);
            volumeManagerDialog.setOnSaveButtonClick(new VolumeEditorDialogInterface());
            volumeManagerDialog.show();
        }
    }

    private class VolumeEditorDialogInterface implements VolumeEditDialog.OnTextEditedListener{

        @Override
        public void MediaSeekbar(int MediaVolume) {
              txtMedia.setText(String.valueOf(MediaVolume));
        }

        @Override
        public void AlarmSeekbar(int AlarmVolume) {
            txtAlarm.setText(String.valueOf(AlarmVolume));


        }

        @Override
        public void NotificationSeekbar(int NotificationVolume) {
             txtNotification.setText(String.valueOf(NotificationVolume));
        }

        @Override
        public void RingtoneSeekbar(int RingtoneVolume) {
            txtRingtone.setText(String.valueOf(RingtoneVolume));

        }
    }
}
package com.example.myvolume;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class VolumeEditDialog extends Dialog {

    private TextView manage_volume, media_message, alarm_message, notification_message, ringtone_message;
    private SeekBar media_seekbar, alarm_seekbar, notification_seekbar, ringtone_seekbar;
    private Button btnSet;

    public interface OnTextEditedListener {
        void  MediaSeekbar (int n);
        void  AlarmSeekbar (int n);
        void  NotificationSeekbar (int n);
        void RingtoneSeekbar(int n);
    }

    private OnTextEditedListener onTextEditedListener;

    public void setOnSaveButtonClick(OnTextEditedListener onTextEditedListener) {
        this.onTextEditedListener = onTextEditedListener;
    }


    public VolumeEditDialog(Context context) {
        super(context);
        setContentView(R.layout.volume_edit_dialog);

        initView();

        setUpListener();


    }
    public VolumeEditDialog(Context context,int AlarmVolume,int MediaVolume,int NotificationVolume,int RingtoneVolume) {
        super(context);
        setContentView(R.layout.volume_edit_dialog);

        initView();

        setUpListener();

        alarm_seekbar.setProgress(AlarmVolume);
        media_seekbar.setProgress(MediaVolume);
        notification_seekbar.setProgress(NotificationVolume);
        ringtone_seekbar.setProgress(RingtoneVolume);
    }
    private void initView(){
        manage_volume = findViewById(R.id.manage_volume);
        media_message = findViewById(R.id.media_message);
        alarm_message = findViewById(R.id.alarm_message);
        notification_message = findViewById(R.id.notification_message);
        ringtone_message = findViewById(R.id.ringtone_message);
        media_seekbar = findViewById(R.id.media_seekbar);
        alarm_seekbar = findViewById(R.id.alarm_seekbar);
        notification_seekbar = findViewById(R.id.notification_seekbar);
        ringtone_seekbar = findViewById(R.id.ringtone_seekbar);
        btnSet = findViewById(R.id.btnSet);
    }

    private void setUpListener(){
       media_seekbar.setOnSeekBarChangeListener(new WhenChangesMadeInSeekbar());
        btnSet.setOnClickListener(new BtnSetOnClickListener());
    }
    private class WhenChangesMadeInSeekbar implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

//            switch (seekBar.getId()) {
//                case R.id.seekMedia:
//                    seekMediaValue = seekMedia.getProgress();
//                    break;
//                case R.id.seekCalls:
//                    seekCallsValue = seekCalls.getProgress();
//                    break;
//                case R.id.seekNotifications:
//                    seekNotificationValue = seekNotifications.getProgress();
//                    break;
//
//            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

    }


    private class BtnSetOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {


                    if (onTextEditedListener != null) {
                        onTextEditedListener.MediaSeekbar(media_seekbar.getProgress());
                        onTextEditedListener.AlarmSeekbar(alarm_seekbar.getProgress());
                        onTextEditedListener.NotificationSeekbar(notification_seekbar.getProgress());
                        onTextEditedListener.RingtoneSeekbar(ringtone_seekbar.getProgress());

                    }

            dismiss();
        }
    }


}

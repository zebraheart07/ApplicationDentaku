package com.example.myapplicationdentaku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.os.Bundle;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;



public class MainActivity extends AppCompatActivity {

    SoundPool soundPool;
    int mp3a;
    int mp3b;
    int mp3c;
    int mp3d;
    int mp3e;
    int mp3f;
    int mp3g;
    int mp3h;
    int mp3i;
    int mp3j;
    int mp3k;
    TextView textView;
    EditText editText;
    Button button;

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            recentOperator = R.id.button_equal;
            result = 0;
            isOperatorKeyPushed = false;

            textView.setText("");
            editText.setText("");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool(11, AudioManager.STREAM_MUSIC, 0);
        } else {
            AudioAttributes attr = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(attr)
                    .setMaxStreams(11)
                    .build();
        }

        textView = (TextView) findViewById(R.id.textview);
        editText = (EditText) findViewById(R.id.edittext);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(buttonListener);


        findViewById(R.id.button_1).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_2).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_3).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_4).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_5).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_6).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_7).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_8).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_9).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_0).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_dot).setOnClickListener(buttonNumberListener);

        findViewById(R.id.button_add).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_subtract).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_multiply).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_divide).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_equal).setOnClickListener(buttonOperatorListener);

        mp3a = soundPool.load(this, R.raw.a, 1);
        mp3b = soundPool.load(this, R.raw.b, 1);
        mp3c = soundPool.load(this, R.raw.c, 1);
        mp3d = soundPool.load(this, R.raw.d, 1);
        mp3e = soundPool.load(this, R.raw.e, 1);
        mp3f = soundPool.load(this, R.raw.f, 1);
        mp3g = soundPool.load(this, R.raw.g, 1);
        mp3h = soundPool.load(this, R.raw.h, 1);
        mp3i = soundPool.load(this, R.raw.i, 1);
        mp3j = soundPool.load(this, R.raw.j, 1);
        mp3k = soundPool.load(this, R.raw.k, 1);

    }


    View.OnClickListener buttonNumberListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;

            if(isOperatorKeyPushed == true) {
                editText.setText(button.getText());
            }else{
                editText.append(button.getText());
            }

            isOperatorKeyPushed = false;


        }

    };


    int recentOperator = R.id.button_equal; // 最近押された計算キー
    double result;  // 計算結果
    boolean isOperatorKeyPushed;    // 計算キーが押されたことを記憶

    public void button_1(View v){
        soundPool.play(mp3a,1f,1f,0,0,1f);
    }
    public void button_2(View v){
        soundPool.play(mp3b,1f,1f,0,0,1f);
    }
    public void button_3(View v){
        soundPool.play(mp3c,1f,1f,0,0,1f);
    }
    public void button_4(View v){
        soundPool.play(mp3d,1f,1f,0,0,1f);
    }
    public void button_5(View v){
        soundPool.play(mp3e,1f,1f,0,0,1f);
    }
    public void button_6(View v){
        soundPool.play(mp3f,1f,1f,0,0,1f);
    }
    public void button_7(View v){
        soundPool.play(mp3g,1f,1f,0,0,1f);
    }
    public void button_8(View v){
        soundPool.play(mp3h,1f,1f,0,0,1f);
    }
    public void button_9(View v){
        soundPool.play(mp3i,1f,1f,0,0,1f);
    }
    public void button_0(View v){
        soundPool.play(mp3j,1f,1f,0,0,1f);
    }
    public void button_dot(View v){
        soundPool.play(mp3k,1f,1f,0,0,1f);
    }

    View.OnClickListener buttonOperatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button operatorButton = (Button) view;
            double value = Double.parseDouble(editText.getText().toString());
            if (recentOperator == R.id.button_equal) {
                result = value;
            } else {
                result = calc(recentOperator, result, value);
                editText.setText(String.valueOf(result));
            }

            recentOperator = operatorButton.getId();
            textView.setText(operatorButton.getText());
            isOperatorKeyPushed = true;
        }
        double calc(int operator, double value1, double value2) {
            switch (operator) {
                case R.id.button_add:
                    return value1 + value2;
                case R.id.button_subtract:
                    return value1 - value2;
                case R.id.button_multiply:
                    return value1 * value2;
                case R.id.button_divide:
                    return value1 / value2;
                default:
                    return value1;
            }
        }

    };

}






package com.example.easy_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    TextView textView;
    ImageView imageView;
    int[] images = {R.drawable.cat, R.drawable.cat2, R.drawable.cat3};
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 참조 초기화
        btn1 = findViewById(R.id.textbtn); // 여기서 your_btn1_id는 XML 레이아웃 파일에서 btn1의 ID입니다.
        btn2 = findViewById(R.id.imgbtn); // 여기서 your_btn2_id는 XML 레이아웃 파일에서 btn2의 ID입니다.
        textView = findViewById(R.id.tv); // 여기서 your_textview_id는 XML 레이아웃 파일에서 textView의 ID입니다.
        imageView = findViewById(R.id.imgview); // 여기서 your_imageview_id는 XML 레이아웃 파일에서 imageView의 ID입니다.
        btn3 = findViewById(R.id.nextbtn); // 여기서 your_btn3_id는 XML 레이아웃 파일에서 btn3의 ID입니다.


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex >= images.length) {
                    currentIndex = 0; // 마지막 이미지에 도달하면 처음으로 되돌아갑니다.
                }
                imageView.setImageResource(images[currentIndex]);
            }
        });
    }
}
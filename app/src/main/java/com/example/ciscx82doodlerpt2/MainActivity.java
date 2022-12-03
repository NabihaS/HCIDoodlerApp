package com.example.ciscx82doodlerpt2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
//import top.defaults.colorpicker.ColorPickerPopup;

public class MainActivity extends AppCompatActivity {
    // change color
//    private Button mPickColorButton;
//    // view box to preview the selected color
//    private View mColorPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DoodleView doodleView=new DoodleView(this);
        setContentView(R.layout.activity_main);
        Button clearButton= findViewById(R.id.clearButton);
        Button colorButton=findViewById(R.id.colorButton);
//        clearButton.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Log.d("value", "Whussup World");
//                    }
//                }
//        );
//        colorButton.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                }
//        );
        //color picker
//        mColorPreview = findViewById(R.id.preview_selected_color);
    }
}
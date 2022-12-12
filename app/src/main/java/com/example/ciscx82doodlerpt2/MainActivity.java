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
        setContentView(R.layout.activity_main);
        DoodleView doodleView=findViewById(R.id.doodleView);
        Button undoButton= findViewById(R.id.undoButton);
        Button blueButton=findViewById(R.id.blueButton);
        Button yellowButton=findViewById(R.id.yellowButton);
        Button redButton=findViewById(R.id.redButton);
        Button colorButton=findViewById(R.id.colorButton);


        undoButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        doodleView.undo();
                    }
                }
        );
        blueButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        doodleView.changeColor(Color.BLUE);
                    }
                }
        );
        yellowButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        doodleView.changeColor(Color.YELLOW);
                    }
                }
        );
        redButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        doodleView.changeColor(Color.RED);
                    }
                }
        );
        //color picker
//        mColorPreview = findViewById(R.id.preview_selected_color);
    }
}
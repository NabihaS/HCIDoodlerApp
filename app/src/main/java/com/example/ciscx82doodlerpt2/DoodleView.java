package com.example.ciscx82doodlerpt2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DoodleView extends View{
    // define a class to create and hold objects that represent user Actions
    // contains a Path and a Paint
    private class Stroke{
        public Path path;
        public Paint brush;

        // constructor to initialize stroke
        public Stroke(Path path, Paint brush){
            this.path=path;
            this.brush=brush;
        }
    }
    // define array of users strokes
    private ArrayList<Stroke> paths=new ArrayList<>();
    private Path path= new Path();
    private Paint brush=new Paint();

    public DoodleView(Context context) {
        this(context,null);
    }
    public DoodleView(Context context, AttributeSet attrs){
        super(context, attrs);
        brush.setAntiAlias(true);
        brush.setColor(Color.BLACK);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(6f);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos=event.getX();
        float yPos=event.getY();

        // gotta know where to put the colour
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // doing this right? adding to paths
                Stroke p=new Stroke(path, brush);
                paths.add(p);
                path.moveTo(xPos, yPos);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPos, yPos);
                break;
            default:
                return false;
        }
        postInvalidate();
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // doing this right?
        for(Stroke path : paths){
            canvas.drawPath(path.path, path.brush);
        }
    }

    public void changeColor(int color) {
        brush= new Paint();
        brush.setColor(color);
        brush.setAntiAlias(true);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(6f);
        invalidate();
    }

    public void clear(){
        setBackgroundColor(0);
//        path.clear();
        invalidate();
    }

    // doing this right? defined at the bottom
    public void undo() {
        // check whether the List is empty or not
        // if empty, the remove method will return an error
        if (paths.size() != 0) {
            paths.remove(paths.size() - 1);
            invalidate();
        }
    }
}


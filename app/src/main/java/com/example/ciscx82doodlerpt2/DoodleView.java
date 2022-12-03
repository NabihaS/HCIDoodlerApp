package com.example.ciscx82doodlerpt2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DoodleView extends View{
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
        canvas.drawPath(path, brush);
    }

    public void clear(){
        setBackgroundColor(0);
        invalidate();
    }
//    public void changeColor(Color color){
//        brush.setColor(color);
//    }
}


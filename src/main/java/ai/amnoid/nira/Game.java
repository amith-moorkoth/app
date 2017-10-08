package ai.amnoid.nira;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Amith Moorkoth on 10/7/2017.
 */

class Game{
    private Resources resources;
    private Canvas canvas;

    int w,h;
    private int x = 0;
    private Paint paint;

    Context c;
    public Game(Resources res, Canvas cas,Context context) {
        resources = res;
        canvas = cas;
        c=context;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        w = metrics.widthPixels;
        h = metrics.heightPixels;

        paint = new Paint();
        paint.setTextSize(50);
    }

    public void Draw_outline(int window_pad,int cr){
        Paint line = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint circle = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint circle_small = new Paint(Paint.ANTI_ALIAS_FLAG);
        //circle_small.setShader(new LinearGradient(0, w, 0, h, Color.parseColor("#ef7197"), Color.parseColor("#0e8581"), Shader.TileMode.MIRROR));
        //line.setShadowLayer(20, 0, 0, Color.WHITE);
        circle.setColor(Color.parseColor("#FFFFFF"));
        circle.setStyle(Paint.Style.STROKE);
        circle.setStrokeWidth(50);
        line.setColor(Color.parseColor("#FFFFFF"));
        line.setStyle(Paint.Style.STROKE);
        line.setStrokeWidth(25);
        canvas.drawLine(w/2, window_pad, w/2, h-window_pad, line);
        canvas.drawLine(window_pad, h/2, w-window_pad, h/2, line);
        canvas.drawLine(window_pad+30, window_pad, w-window_pad-30, h-window_pad, line);
        canvas.drawLine(window_pad+30, h-window_pad, w-window_pad-30, window_pad, line);
        canvas.drawRect(window_pad, window_pad, w-window_pad, h-window_pad, line);
        /*1 st row*/
        canvas.drawCircle(window_pad, window_pad , cr, circle);
        canvas.drawCircle(window_pad, window_pad , cr, circle_small);
        canvas.drawCircle(w/2, window_pad , cr, circle);
        canvas.drawCircle(w/2, window_pad , cr, circle_small);
        canvas.drawCircle(w-window_pad, window_pad , cr, circle);
        canvas.drawCircle(w-window_pad, window_pad , cr, circle_small);
        /*2 nd row*/
        canvas.drawCircle(window_pad, h/2 , cr, circle);
        canvas.drawCircle(window_pad, h/2 , cr, circle_small);
        canvas.drawCircle(w/2, h/2 , cr, circle);
        canvas.drawCircle(w/2, h/2 , cr, circle_small);
        canvas.drawCircle(w-window_pad, h/2 , cr, circle);
        canvas.drawCircle(w-window_pad, h/2 , cr, circle_small);
        /*3 nd row*/
        canvas.drawCircle(window_pad, h-window_pad , cr, circle);
        canvas.drawCircle(window_pad, h-window_pad , cr, circle_small);
        canvas.drawCircle(w/2, h-window_pad , cr, circle);
        canvas.drawCircle(w/2, h-window_pad , cr, circle_small);
        canvas.drawCircle(w-window_pad, h-window_pad , cr, circle);
        canvas.drawCircle(w-window_pad, h-window_pad , cr, circle_small);
    }

    public void Draw() {
        canvas.drawColor(Color.parseColor("#000000"));
        Draw_outline(150,100);
    }

    public void Update() {

    }

    public void make_movement(int direction){
        String str = "";

        switch (direction) {

            case SimpleGestureFilter.SWIPE_RIGHT : str = "Swipe Right";
                break;
            case SimpleGestureFilter.SWIPE_LEFT :  str = "Swipe Left";
                break;
            case SimpleGestureFilter.SWIPE_DOWN :  str = "Swipe Down";
                break;
            case SimpleGestureFilter.SWIPE_UP :  str = "Swipe up";
                break;
            case SimpleGestureFilter.SWIPE_RIGHT_UP :    str = "Swipe right Up";
                break;
            case SimpleGestureFilter.SWIPE_RIGHT_DOWN :    str = "Swipe right down";
                break;
            case SimpleGestureFilter.SWIPE_LEFT_UP :    str = "Swipe left Up";
                break;
            case SimpleGestureFilter.SWIPE_LEFT_DOWN :    str = "Swipe left down";
                break;

        }
        Toast.makeText(c, str, Toast.LENGTH_SHORT).show();
    }
}
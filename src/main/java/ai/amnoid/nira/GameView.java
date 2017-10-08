package ai.amnoid.nira;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Amith Moorkoth on 10/7/2017.
 */

class GameView extends View{

    private GameLoop mainLoop;
    Bitmap gameBitmap;
    Canvas gameCanvas;
    Context c;

    private float x1,x2;
    static final int MIN_DISTANCE = 150;

    public GameView(Context context) {
        super(context);
        this.setDrawingCacheEnabled(true);
        c=context;
        gameCanvas = new Canvas();
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mainLoop = new GameLoop(getResources(), gameCanvas,context);
        mainLoop.start();
    }


     @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        gameBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

        gameCanvas.setBitmap(gameBitmap);

        setMeasuredDimension(w, h);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(gameBitmap, 0, 0, new Paint());
        invalidate();
    }

    /*on swipe*/
    public void make_movement(int direction){
        mainLoop.make_movement(direction);
    }

}
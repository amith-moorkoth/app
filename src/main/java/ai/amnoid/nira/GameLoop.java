package ai.amnoid.nira;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Amith Moorkoth on 10/7/2017.
 */

class GameLoop extends Thread {

    private float frameRate = Float.valueOf(String.valueOf((SystemClock.elapsedRealtime()-SystemClock.elapsedRealtime())+0.09));
    private float frameTime;

    private Game logicGame;
    private Resources gameResources;
    private Canvas gameCanvas;

    public GameLoop(Resources res, Canvas canvas,Context context) {
        logicGame = new Game(res, canvas,context);
    }

    @Override
    public void run()
    {
        while (true) {
            float startTime = System.currentTimeMillis();
            frameTime = 1000 / frameRate;

            logicGame.Update();
            logicGame.Draw();

            float endTime = System.currentTimeMillis();
            long deltaTime = (long) (frameTime - (endTime - startTime));
            frameRate=Float.valueOf(String.valueOf(((endTime - startTime))));
            try {
                Thread.sleep(deltaTime);
            } catch (InterruptedException e) {
            }
        }
    }

    public void make_movement(int direction){
        logicGame.make_movement(direction);
    }
}
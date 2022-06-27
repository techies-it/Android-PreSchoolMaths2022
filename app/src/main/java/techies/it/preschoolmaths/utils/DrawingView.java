package techies.it.preschoolmaths.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Taranjeet Singh on 30-11-2015.
 */
public class DrawingView extends View
{

    private static final String TAG = "DrawingView";

    private Paint mPaint;
    public int width;
    public int height;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    private Paint mBitmapPaint;
    Context context;
    private Paint circlePaint;
    private Path circlePath;
    private BtnEnableListener mBtnEnableListener;

    public DrawingView(Context c, Paint paint)
    {
        super(c);
        context = c;
        mPaint = paint;
        mPath = new Path();
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);
        circlePaint = new Paint();
        circlePath = new Path();
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.TRANSPARENT);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeJoin(Paint.Join.MITER);
        circlePaint.setStrokeWidth(4f);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w > 0 && h > 0)
        {
            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
        }
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        if (mBitmap == null || mCanvas == null)
        {
            mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
        }

        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
        mCanvas.drawPath(mPath, mPaint); // replace this with canvas.drawPath(mPath, mPaint); to set eraser default colour to black
        canvas.drawPath(circlePath, circlePaint);

    }

    private float mX, mY;
    private static final float TOUCH_TOLERANCE = 4;

    private void touch_start(float x, float y)
    {
        mPath.reset();
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    private void touch_move(float x, float y)
    {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE)
        {
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;

            circlePath.reset();
            circlePath.addCircle(mX, mY, 30, Path.Direction.CW);
        }
    }

    private void touch_up()
    {
        mPath.lineTo(mX, mY);
        circlePath.reset();
        // commit the path to our offscreen
        mCanvas.drawPath(mPath, mPaint);


        // kill this so we don't double draw
        mPath.reset();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if (mBtnEnableListener != null)
                {
                    Log.d(TAG, "onTouchEvent: ACTION_DOWN");

                    mBtnEnableListener.enableButton(false);
                }
                touch_start(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                touch_move(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                if (mBtnEnableListener != null)
                {
                    Log.d(TAG, "onTouchEvent: ACTION_UP");
                    mBtnEnableListener.enableButton(true);
                }
                touch_up();
                invalidate();
                break;

        }
        return true;
    }

    public void startNew()
    {
        mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    public void setButtonEnableListener(BtnEnableListener btnEnableListener)
    {
        mBtnEnableListener = btnEnableListener;
    }

    public interface BtnEnableListener
    {
        public void enableButton(boolean enable);
    }

}

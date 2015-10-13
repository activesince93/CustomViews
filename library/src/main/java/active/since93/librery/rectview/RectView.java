package active.since93.librery.rectview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import active.since93.librery.R;

/**
 * Created by darshan.parikh on 13-Oct-15.
 */
public class RectView extends View {

    Point point1, point2, point3, point4, startMovePoint;
    private ArrayList<EdgeBall> edgeBallArrayList;
    int groupId = 2;
    private int balID = 0;
    Paint paint;
    Canvas canvas;


    public RectView(Context context) {
        super(context);
        init(context);
    }

    public RectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        paint = new Paint();
        setFocusable(true);
        canvas = new Canvas();

        point1 = new Point();
        point1.x = 50;
        point1.y = 50;

        point2 = new Point();
        point2.x = 350;
        point2.y = 50;

        point3 = new Point();
        point3.x = 350;
        point3.y = 350;

        point4 = new Point();
        point4.x = 50;
        point4.y = 350;

        edgeBallArrayList = new ArrayList<>();
        edgeBallArrayList.add(0, new EdgeBall(context, R.drawable.gray_circle, point1, 0));
        edgeBallArrayList.add(1, new EdgeBall(context, R.drawable.gray_circle, point2, 1));
        edgeBallArrayList.add(2, new EdgeBall(context, R.drawable.gray_circle, point3, 2));
        edgeBallArrayList.add(3, new EdgeBall(context, R.drawable.gray_circle, point4, 3));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.parseColor("#55000000"));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(5);

        canvas.drawPaint(paint);
        paint.setColor(Color.parseColor("#55FFFFFF"));

        if(groupId == 1) {
            canvas.drawRect(point1.x + edgeBallArrayList.get(0).getWidthOfBall() / 2,
                    point3.y + edgeBallArrayList.get(0).getWidthOfBall() / 2,
                    point3.x + edgeBallArrayList.get(0).getWidthOfBall() / 2,
                    point1.y + edgeBallArrayList.get(0).getWidthOfBall() / 2, paint);
        } else {
            canvas.drawRect(point2.x + edgeBallArrayList.get(0).getWidthOfBall() / 2,
                    point4.y + edgeBallArrayList.get(0).getWidthOfBall() / 2,
                    point4.x + edgeBallArrayList.get(0).getWidthOfBall() / 2,
                    point2.y + edgeBallArrayList.get(0).getWidthOfBall() / 2, paint);
        }

        // draw the balls on the canvas
        for (EdgeBall ball : edgeBallArrayList) {
            canvas.drawBitmap(ball.getBitmap(), ball.getX(), ball.getY(), new Paint());
        }
    }

    // events when touching the screen
    public boolean onTouchEvent(MotionEvent event) {
        int eventAction = event.getAction();

        int X = (int) event.getX();
        int Y = (int) event.getY();

        switch (eventAction) {

            case MotionEvent.ACTION_DOWN: // touch down so check if the finger is on
                // a ball
                balID = -1;
                startMovePoint = new Point(X,Y);
                for (EdgeBall ball : edgeBallArrayList) {
                    // check if inside the bounds of the ball (circle)
                    // get the center for the ball
                    int centerX = ball.getX() + ball.getWidthOfBall();
                    int centerY = ball.getY() + ball.getHeightOfBall();
                    paint.setColor(Color.CYAN);
                    // calculate the radius from the touch to the center of the ball
                    double radCircle = Math.sqrt((double) (((centerX - X) * (centerX - X)) + (centerY - Y) * (centerY - Y)));

                    if (radCircle < ball.getWidthOfBall()) {

                        balID = ball.getID();
                        if (balID == 1 || balID == 3) {
                            groupId = 2;
                            canvas.drawRect(point1.x, point3.y, point3.x, point1.y, paint);
                        } else {
                            groupId = 1;
                            canvas.drawRect(point2.x, point4.y, point4.x, point2.y, paint);
                        }
                        invalidate();
                        break;
                    }
                    invalidate();
                }
                break;

            case MotionEvent.ACTION_MOVE: // touch drag with the ball
                // move the balls the same as the finger
                if (balID > -1) {
                    edgeBallArrayList.get(balID).setX(X);
                    edgeBallArrayList.get(balID).setY(Y);
                    paint.setColor(Color.CYAN);
                    if (groupId == 1) {
                        edgeBallArrayList.get(1).setX(edgeBallArrayList.get(0).getX());
                        edgeBallArrayList.get(1).setY(edgeBallArrayList.get(2).getY());
                        edgeBallArrayList.get(3).setX(edgeBallArrayList.get(2).getX());
                        edgeBallArrayList.get(3).setY(edgeBallArrayList.get(0).getY());
                        canvas.drawRect(point1.x, point3.y, point3.x, point1.y, paint);
                    } else {
                        edgeBallArrayList.get(0).setX(edgeBallArrayList.get(1).getX());
                        edgeBallArrayList.get(0).setY(edgeBallArrayList.get(3).getY());
                        edgeBallArrayList.get(2).setX(edgeBallArrayList.get(3).getX());
                        edgeBallArrayList.get(2).setY(edgeBallArrayList.get(1).getY());
                        canvas.drawRect(point2.x, point4.y, point4.x, point2.y, paint);
                    }
                    invalidate();
                } else {
                    if (startMovePoint!=null) {
                        paint.setColor(Color.CYAN);
                        int diffX = X - startMovePoint.x;
                        int diffY = Y - startMovePoint.y;
                        startMovePoint.x = X;
                        startMovePoint.y = Y;
                        edgeBallArrayList.get(0).addX(diffX);
                        edgeBallArrayList.get(1).addX(diffX);
                        edgeBallArrayList.get(2).addX(diffX);
                        edgeBallArrayList.get(3).addX(diffX);
                        edgeBallArrayList.get(0).addY(diffY);
                        edgeBallArrayList.get(1).addY(diffY);
                        edgeBallArrayList.get(2).addY(diffY);
                        edgeBallArrayList.get(3).addY(diffY);
                        if(groupId == 1)
                            canvas.drawRect(point1.x, point3.y, point3.x, point1.y, paint);
                        else
                            canvas.drawRect(point2.x, point4.y, point4.x, point2.y, paint);
                        invalidate();
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        // redraw the canvas
        invalidate();
        return true;
    }
}

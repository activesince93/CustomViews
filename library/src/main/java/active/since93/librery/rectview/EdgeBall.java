package active.since93.librery.rectview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by darshan.parikh on 13-Oct-15.
 */
public class EdgeBall {

    Bitmap bitmap;
    Point point;
    Context context;
    int id;

    public EdgeBall(Context context, int resourceId, Point point, int id) {
        this.id = id;
        bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        this.context = context;
        this.point = point;
    }

    public int getWidthOfBall() {
        return bitmap.getWidth();
    }

    public int getHeightOfBall() {
        return bitmap.getHeight();
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return point.x;
    }

    public int getY() {
        return point.y;
    }

    public int getID() {
        return id;
    }

    public void setX(int x) {
        point.x = x;
    }

    public void setY(int y) {
        point.y = y;
    }

    public void addY(int y){
        point.y = point.y + y;
    }

    public void addX(int x){
        point.x = point.x + x;
    }
}

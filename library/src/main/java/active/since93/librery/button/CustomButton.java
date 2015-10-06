package active.since93.librery.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;

import active.since93.librery.R;


/**
 * Created by darshan.parikh on 28-Sep-15.
 */
public class CustomButton extends Button {
    public CustomButton(Context context) {
        super(context);
        init(null);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomButton);
        String text = a.getString(R.styleable.CustomButton_text);
        int color = a.getColor(R.styleable.CustomButton_text_color, Color.BLACK);
        float size = a.getDimension(R.styleable.CustomButton_text_size, 15);
        setText(text);
        setTextSize(size);
        setTextColor(color);
        a.recycle();
    }
}

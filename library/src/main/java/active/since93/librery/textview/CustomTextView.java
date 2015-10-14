package active.since93.librery.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import active.since93.librery.R;

/**
 * Created by Darshan on 25-Sep-15.
 */
public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
        init(null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // passing xml attributes to method
        init(attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // passing xml attributes to method
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if(attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomTextView);
            // Setting custom typeface for edittext.
            String typeface = a.getString(R.styleable.CustomTextView_typeface);
            if (typeface != null) {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + typeface);
                setTypeface(myTypeface);
            }
            a.recycle();
        }
    }
}

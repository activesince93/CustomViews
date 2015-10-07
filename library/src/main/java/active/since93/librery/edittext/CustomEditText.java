package active.since93.librery.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import active.since93.librery.R;

/**
 * Created by darshan.parikh on 07-Oct-15.
 */
public class CustomEditText extends EditText {


    public CustomEditText(Context context) {
        super(context);
        init(null);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if(attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomTextView);
            String typeface = a.getString(R.styleable.CustomTextView_typeface);
            if(typeface != null) {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + typeface);
                setTypeface(myTypeface);
            }
            a.recycle();
        }
    }
}

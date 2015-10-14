package active.since93.librery.chipview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import active.since93.librery.R;

/**
 * Created by darshan.parikh on 08-Oct-15.
 */
public class ChipView extends LinearLayout {
    String chipText;
    boolean isCancelable;
    String typeface;
    int chipColor;

    public ChipView(Context context, String chipText, int chipColor, boolean isCancelable) {
        super(context);
        this.chipText = chipText;
        this.chipColor = chipColor;
        this.isCancelable = isCancelable;
        init(null);
    }

    public ChipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // passing xml attributes to method
        init(attrs);
    }

    public ChipView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // passing xml attributes to method
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        if(attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ChipView);
            chipText = a.getString(R.styleable.ChipView_chip_text);
            isCancelable = a.getBoolean(R.styleable.ChipView_show_image, true);
            typeface = a.getString(R.styleable.ChipView_typeface);
            chipColor = a.getColor(R.styleable.ChipView_background_color, getResources().getColor(android.R.color.holo_red_light));
            a.recycle();
        } else {
            chipText = getChipViewText();
            chipColor = getChipColor();
            isCancelable = getCancelable();
        }

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);

        int padding = getResources().getDimensionPixelOffset(R.dimen.chip_view_padding);
        int paddingLeftRight = getResources().getDimensionPixelOffset(R.dimen.chip_view_left_right);
        setPadding(paddingLeftRight, padding, paddingLeftRight, padding);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View chipView = inflater.inflate(R.layout.chip_view_raw, this, true);


        TextView chipTextView = (TextView) getChildAt(0);
        chipTextView.setText(chipText);
        if (typeface != null) {
            Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + typeface);
            chipTextView.setTypeface(myTypeface);
        }

        ImageView btnCancel = (ImageView) getChildAt(1);
        if(isCancelable) {
            btnCancel.setVisibility(View.VISIBLE);
        }

        chipView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                chipView.setVisibility(View.GONE);
            }
        });

        Drawable drawable = getBackgroundDesign(chipColor);
        chipView.setBackgroundDrawable(drawable);
    }

    /**
     * Add rounded edges to chipview background
     * @param color
     * @return
     */
    public Drawable getBackgroundDesign(int color) {
        GradientDrawable background = new GradientDrawable();
        background.setShape(GradientDrawable.RECTANGLE);
        background.setCornerRadius(100);
        background.setColor(color);

        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(StateSet.WILD_CARD, background);
        return stateListDrawable;
    }

    /**
     * Setting getter setter methods for adding chipview programatically
     */
    public void setChipText(String chipText) {
        this.chipText = chipText;
    }

    public String getChipViewText() {
        return chipText;
    }

    public boolean getCancelable() {
        return isCancelable;
    }

    public void setCancelable(boolean isCancelable) {
        this.isCancelable = isCancelable;
    }

    public int getChipColor() {
        return chipColor;
    }

    public void setChipColor(int chipColor) {
        this.chipColor = chipColor;
    }
}

package wict.wictphiladelphia.org.wict.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;

import wict.wictphiladelphia.org.wict.R;
import wict.wictphiladelphia.org.wict.utils.WictFontProvider;

public class WTextView extends AppCompatTextView {
    public WTextView(Context context) {
        this(context, null);
    }

    public WTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    /**
     * Constructor that is called from code/xml
     *
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {
        if (!isInEditMode()) {

            setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG | Paint.HINTING_ON);

            initializeFont(context, attrs);


            initAnimation(context, attrs);
        }
    }

    // boolean that regulates fade animation on setText
    boolean animate = false;

    /**
     * Method that reads XML properties and sets Animation state
     *
     * @param context
     * @param attrs
     */
    private void initAnimation(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext()
                    .obtainStyledAttributes(attrs,
                            R.styleable.WTextView);

            animate = a.getBoolean(R.styleable.WTextView_animateChanges,
                    false);

            a.recycle();


        }


    }

    /**
     * Overriden implementation of setText. Will enable a fade animation on the view.
     */
    @Override
    public void setText(CharSequence text, BufferType type) {
        if (animate) {
            setAlpha(0f);
            animate().alpha(1f).setInterpolator(new AccelerateInterpolator(1.f))
                    .setDuration(200L);
        }
        super.setText(text, type);
    }

    /**
     * Method that reads the XML and initializes font for the view. Default is XFINITY MEDIUM
     *
     * @param context
     * @param attrs
     */
    private void initializeFont(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext()
                    .obtainStyledAttributes(attrs,
                            R.styleable.WTextView);

            setTypeface(getFont(context.getApplicationContext(),
                    a.getInt(R.styleable.WTextView_typeface,
                            WictFontProvider.Companion.getBrandonRegular())));

            a.recycle();
        }

    }


    /**
     * Helper method that returns an instance of XFINITY font
     *
     * @param context
     * @param FONT_TYPEFACE
     * @return
     */
    private Typeface getFont(final Context context, final int FONT_TYPEFACE) {

        return WictFontProvider.Companion.getFont(context, FONT_TYPEFACE);

    }


}

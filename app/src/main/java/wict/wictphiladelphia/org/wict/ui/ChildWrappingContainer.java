package wict.wictphiladelphia.org.wict.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;

import wict.wictphiladelphia.org.wict.R;

public class ChildWrappingContainer extends LinearLayout {
    public ChildWrappingContainer(Context context, String title, ArrayList<Integer> children) {
        super(context);
        this.setOrientation(LinearLayout.VERTICAL);
        mInflater = LayoutInflater.from(context);
        mInflater.inflate(R.layout.sponsors_row, this, true);
        mCategoryTitle = this.findViewById(R.id.category_title);
        mChildContainer = this.findViewById(R.id.wrapped_children_container);
        mCategoryTitle.setText(title);
        for (int res: children){
            mChildContainer.addView(getChild(res));
        }

    }



    private TextView mCategoryTitle;
    private FlexboxLayout mChildContainer;
    private LayoutInflater mInflater;


    public void setTitle(final CharSequence title){
        mCategoryTitle.setText(title);
    }

    public void addChild(View child){
        mChildContainer.addView(child);
    }



    private View getChild(int imageRes){
        View child = mInflater.inflate(R.layout.logo_view, null, false);
        ImageView logo = child.findViewById(R.id.logo);
        logo.setImageResource(imageRes);

        return child;

    }
}

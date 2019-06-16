package org.wictphiladelphia.wict.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.flexbox.FlexboxLayout;

import org.wictphiladelphia.wict.R;

import java.util.ArrayList;


public class ChildWrappingContainer extends LinearLayout {
    private Context mContext;
    private LinearLayout.LayoutParams mParams;
    private static int index = 0;
    private int[] titleColors = new int[]{
            R.drawable.blue_pill,
            R.drawable.blue_pill,
            R.drawable.blue_pill,
            R.drawable.blue_pill
    };

    private int getTitleBkg(){
        int maxIndex = titleColors.length;
        int color = titleColors[index % maxIndex];
        index = index + 1;
        return color;
    }

    public ChildWrappingContainer(Context context, String title, ArrayList<Integer> children) {
        super(context);
        this.setOrientation(LinearLayout.VERTICAL);
        mInflater = LayoutInflater.from(context);
        mInflater.inflate(R.layout.sponsors_row, this, true);
        mChildren = children;

        mCategoryTitle = this.findViewById(R.id.category_title);
        mChildContainer = this.findViewById(R.id.wrapped_children_container);
        int sponsorLogoSize = (int)getResources().getDimension(R.dimen.sponsor_logo);
        int margin = (int)getResources().getDimension(R.dimen.sponsor_logo_margin);

        mParams = new LinearLayout.LayoutParams(sponsorLogoSize, sponsorLogoSize);
        mParams.setMargins(margin, margin, margin, margin);

        mCategoryTitle.setText(title);
        mCategoryTitle.setBackgroundResource(getTitleBkg());


        for (Integer res: children){
            mChildContainer.addView(getChild(res), mParams);
        }

    }



    private TextView mCategoryTitle;
    private FlexboxLayout mChildContainer;
    private LayoutInflater mInflater;
    private ArrayList<Integer> mChildren;


    public void setTitle(final CharSequence title){
        mCategoryTitle.setText(title);
    }

    public void addChild(View child){
        mChildContainer.addView(child);
    }



    public void lazyLoad(Context context){

        int count = mChildContainer.getChildCount();
        RequestManager glide = Glide.with(context);
        for (int i=0; i< count; i++){
            ImageView logo = (ImageView) mChildContainer.getChildAt(i);
            glide.load(mChildren.get(i)).into(logo);

        }
    }

    private View getChild(int imageRes){
        ImageView logoImageView = (ImageView) mInflater.inflate(R.layout.logo_view, null, false);
        logoImageView.setImageResource(imageRes);

        return logoImageView;
    }
}

package com.androidbull.mypronounce.ui.helper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidbull.mypronounce.data.model.Word;
import com.androidbull.mypronounce.util.HasAccuracy;

import java.util.List;

/**
 * Created by shobhan on 4/10/17.'
 * Edited by Hamza 7/4/20.'
 */

public class CirclePagerVerticalIndicatorDecoration extends RecyclerView.ItemDecoration {

    private List<HasAccuracy> itemList;

    private int colorAccurate = Color.parseColor("#FFC001");
    private int colorInAccurate = Color.parseColor("#C5C3C3");
    private int colorHighlight = Color.BLACK;

    private static final float DP = Resources.getSystem().getDisplayMetrics().density;

    /**
     * Height of the space the indicator takes up at the bottom of the view.
     */
    private final int mIndicatorHeight = (int) (DP * 14);

    /**
     * Indicator stroke width.
     */
    private final float mIndicatorStrokeWidth = DP * 2;

    /**
     * Indicator width.
     */
    private final float mIndicatorItemLength = DP * 14;
    /**
     * Padding between indicators.
     */
    private final float mIndicatorItemPadding = DP * 0;

    /**
     * Some more natural animation interpolation
     */
    private final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();

    private final Paint mPaint = new Paint();

    public CirclePagerVerticalIndicatorDecoration(List<HasAccuracy> itemList) {
        this.itemList = itemList;
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(mIndicatorStrokeWidth);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int itemCount = parent.getAdapter().getItemCount();

        // center horizontally, calculate width and subtract half from center
        float totalLength = mIndicatorItemLength * itemCount;
        float paddingBetweenItems = Math.max(0, itemCount - 1) * mIndicatorItemPadding;
        float indicatorTotalWidth = totalLength + paddingBetweenItems;
        float indicatorStartX = parent.getWidth() - mIndicatorHeight / 2F;

        // center vertically in the allotted space
        float indicatorPosY =  mIndicatorHeight / 2F;

//        drawInactiveIndicators(c, indicatorStartX, indicatorPosY, itemCount);

        drawIndicators(c, indicatorStartX, indicatorPosY, itemCount);


        // find active page (which should be highlighted)
        LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
        int activePosition = layoutManager.findFirstVisibleItemPosition();
        if (activePosition == RecyclerView.NO_POSITION) {
            return;
        }

        // find offset of active page (if the user is scrolling)
        final View activeChild = layoutManager.findViewByPosition(activePosition);
        int left = activeChild.getLeft();
        int width = activeChild.getWidth();

        // on swipe the active item will be positioned from [-width, 0]
        // interpolate offset for smooth animation
        float progress = mInterpolator.getInterpolation(left * -1 / (float) width);

        drawHighlights(c, indicatorStartX, indicatorPosY, activePosition, progress, itemCount);
    }


    private void drawIndicators(Canvas c, float indicatorStartX, float indicatorPosY, int itemCount) {

        // width of item indicator including padding
        final float itemWidth = mIndicatorItemLength + mIndicatorItemPadding;

        float start = indicatorPosY;
        for (int i = 0; i < itemCount; i++) {
            // draw the circle for every item

            if (itemList.get(i).isAccuratePronunciation()) {
                mPaint.setColor(colorAccurate);
                c.drawCircle(indicatorStartX, start + mIndicatorItemLength, itemWidth / 6, mPaint);
            } else {
                mPaint.setColor(colorInAccurate);
                c.drawCircle(indicatorStartX, start + mIndicatorItemLength, itemWidth / 6, mPaint);
            }

            //  c.drawLine(start, indicatorPosY, start + mIndicatorItemLength, indicatorPosY, mPaint);
            start += itemWidth;
        }
    }

    private void drawHighlights(Canvas c, float indicatorStartX, float indicatorPosY,
                                int highlightPosition, float progress, int itemCount) {
        mPaint.setColor(colorHighlight);

        // width of item indicator including padding
        final float itemWidth = mIndicatorItemLength + mIndicatorItemPadding;

        if (progress == 0F) {
            // no swipe, draw a normal indicator
            float highlightStart = indicatorPosY + itemWidth * highlightPosition;
         /*   c.drawLine(highlightStart, indicatorPosY,
                    highlightStart + mIndicatorItemLength, indicatorPosY, mPaint);
        */
            c.drawCircle(indicatorStartX, highlightStart, itemWidth / 6, mPaint);

        } else {
            float highlightStart = indicatorPosY + itemWidth * highlightPosition;
            // calculate partial highlight
            float partialLength = mIndicatorItemLength * progress;
            c.drawCircle(indicatorStartX , highlightStart + mIndicatorItemLength, itemWidth / 6, mPaint);

            // draw the cut off highlight
           /* c.drawLine(highlightStart + partialLength, indicatorPosY,
                    highlightStart + mIndicatorItemLength, indicatorPosY, mPaint);
*/
            // draw the highlight overlapping to the next item as well
           /* if (highlightPosition < itemCount - 1) {
                highlightStart += itemWidth;
                *//*c.drawLine(highlightStart, indicatorPosY,
                        highlightStart + partialLength, indicatorPosY, mPaint);*//*
                c.drawCircle(highlightStart ,indicatorPosY,itemWidth/4,mPaint);

            }*/
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = mIndicatorHeight;
    }
}
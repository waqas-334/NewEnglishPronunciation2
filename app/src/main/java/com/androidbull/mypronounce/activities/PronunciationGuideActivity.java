package com.androidbull.mypronounce.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.androidbull.mypronounce.AlbumsAdapter;
import com.androidbull.mypronounce.constant.Constants;
import com.androidbull.mypronounce.IAPPrefrences;
import com.androidbull.mypronounce.R;
import com.androidbull.mypronounce.RowItem;
import com.androidbull.mypronounce.ui.AdNetwork;
import com.androidbull.mypronounce.ui.BaseActivity;
import com.facebook.ads.InterstitialAd;
import com.google.android.material.appbar.MaterialToolbar;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class PronunciationGuideActivity extends BaseActivity implements
        AdapterView.OnItemClickListener {

    private AlbumsAdapter adapter;
    private List<RowItem> albumList;
    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerViewSetup();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_pronunciation_guide;
    }

    @Nullable
    @Override
    protected LinearLayout getBannerAdView() {
        return findViewById(R.id.llAdsBannerContainer);
    }

    @NonNull
    @Override
    protected String getBannerAdID() {
        if (super.getAdNetwork() == AdNetwork.FACEBOOK)
            return getString(R.string.pronunciation_guide_bottom_banner_ad);
        else
            return getString(R.string.admob_pronunciation_guide_bottom_banner_ad);
    }


    @Override
    protected void initViews() {
        setToolbar();
    }

    @Override
    protected void initActions() {

    }


    private void setToolbar() {
        MaterialToolbar tbHomophone = findViewById(R.id.tbPronunciationGuide);
        setSupportActionBar(tbHomophone);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle(getString(R.string.str_pronunciation_guide));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void recyclerViewSetup() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, this, albumList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(0), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareAlbums();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //you can get the clicked item from the adapter using its position
        //  RowItem item = adapter.getItem(position);
        Log.e("Item ", "Clicked Position: " + position);
        if (!IAPPrefrences.isPaid(Constants.PAID_STATE, this)) {
            if (interstitialAd!=null && interstitialAd.isAdLoaded()) {
                interstitialAd.show();
            }
        }
        callIntent(position);
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        List<String> lessonNames = new ArrayList<>();

        lessonNames.add("English Word Pronunciation");
        lessonNames.add("Word Stress and Syllables");
        lessonNames.add("Long E sound (meet, see)");
        lessonNames.add("Short I Sound (sit, hit)");
        lessonNames.add("UH Sound (put, foot)");
        lessonNames.add("OO Sound (moon, blue)");
        lessonNames.add("Short E sound (pen, bed)");
        lessonNames.add("Schwa Sound (the, about)");
        lessonNames.add("UR Sound (turn, learn)");
        lessonNames.add("OH Sound (four, store)");
        lessonNames.add("Short A Sound (cat, fat)");
        lessonNames.add("UH Sound (but, luck)");
        lessonNames.add("Soft A Sound");
        lessonNames.add("Long O Sound");
        lessonNames.add("Long A Sound");
        lessonNames.add("Short O Sound");
        lessonNames.add("Diphthong (a combination of two vowel sounds)");
        lessonNames.add("P and B sounds");
        lessonNames.add("The Nasal Sounds (M, N, NG)");
        lessonNames.add("The F and V Sounds");
        lessonNames.add("W Sound (wow, quit, where)");

        String Lesson = "lesson: ";
        for (int i = 0; i < 21; i++) {
            RowItem a = new RowItem(lessonNames.get(i), Lesson + Integer.valueOf(i + 1));
            albumList.add(a);
        }

        adapter.notifyDataSetChanged();
    }


    public void callIntent(Integer position) {
        position++;
        Bundle b = new Bundle();
        b.putString("pme1", position + "");
        Log.e("before ", "intent");
        Intent intent = new Intent(this, TutorialActivity.class);
        intent.putExtras(b);
        startActivity(intent);
        Log.e("after ", "intent");

//        Intent recharge = new Intent(this , ProductDetails.class);
//        recharge.putExtras(bundle);
//        startActivity(recharge);
    }

    @Override
    protected void hideAdRelatedViews() { }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing
                        - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right =
                        (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing
                        / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }

    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {

        Resources r = getResources();
        return Math
                .round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}

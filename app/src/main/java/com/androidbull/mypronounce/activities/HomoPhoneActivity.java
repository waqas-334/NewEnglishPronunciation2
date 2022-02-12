package com.androidbull.mypronounce.activities;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

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

import com.androidbull.mypronounce.R;
import com.androidbull.mypronounce.TestWords.AlbumsAdapter;
import com.androidbull.mypronounce.TestWords.RowItem;
import com.androidbull.mypronounce.ui.AdNetwork;
import com.androidbull.mypronounce.ui.BaseActivity;
import com.google.android.material.appbar.MaterialToolbar;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomoPhoneActivity extends BaseActivity implements
        AdapterView.OnItemClickListener {

    private AlbumsAdapter adapter;
    private List<RowItem> albumList;

    List<String> pronounceWord1 = new ArrayList<>();
    List<String> pronounceWord2 = new ArrayList<>();
    List<String> pronounceDummy = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerViewSetup();
    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_homophone;
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
            return getString(R.string.homophone_bottom_banner_ad);
        return getString(R.string.admob_homophone_bottom_banner_ad);

    }


    @Override
    protected void initViews() {
        setToolbar();
    }

    @Override
    protected void initActions() {

    }

    private void setToolbar() {
        MaterialToolbar tbHomophone = findViewById(R.id.tbHomophone);
        setSupportActionBar(tbHomophone);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle(getString(R.string.str_homophones));
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
        Log.e("Item ", "Clicked");

        callIntent(pronounceDummy.get(position));
//        callIntent(pronounceWord2.get(position));

    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {

        Log.e("New Step", "1");

        pronounceWord1.add("accessary");
        pronounceWord1.add("ad");
        pronounceWord1.add("ail");
        pronounceWord1.add("air");
        pronounceWord1.add("aisle");
        pronounceWord1.add("all");
        pronounceWord1.add("allowed");
        pronounceWord1.add("alms");
        pronounceWord1.add("altar");
        pronounceWord1.add("arc");
        pronounceWord1.add("aren't");
        pronounceWord1.add("ate");
        pronounceWord1.add("auger");
        pronounceWord1.add("auk");
        pronounceWord1.add("aural");
        pronounceWord1.add("away");
        pronounceWord1.add("awe");
        pronounceWord1.add("axel");
        pronounceWord1.add("aye");
        pronounceWord1.add("bail");
        pronounceWord1.add("bait");
        pronounceWord1.add("baize");
        pronounceWord1.add("bald");
        pronounceWord1.add("ball");
        pronounceWord1.add("band");
        pronounceWord1.add("bard");
        pronounceWord1.add("bare");
        pronounceWord1.add("bark");
        pronounceWord1.add("baron");
        pronounceWord1.add("base");
        pronounceWord1.add("bay");
        pronounceWord1.add("bazaar");
        pronounceWord1.add("be");
        pronounceWord1.add("beach");
        pronounceWord1.add("bean");
        pronounceWord1.add("beat");
        pronounceWord1.add("beau");
        pronounceWord1.add("beer");
        pronounceWord1.add("bel");
        pronounceWord1.add("berry");
        pronounceWord1.add("berth");
        pronounceWord1.add("bight");
        pronounceWord1.add("billed");
        pronounceWord1.add("bitten");
        pronounceWord1.add("blew");
        pronounceWord1.add("bloc");
        pronounceWord1.add("boar");
        pronounceWord1.add("board");
        pronounceWord1.add("boarder");
        pronounceWord1.add("bold");
        pronounceWord1.add("boos");
        pronounceWord1.add("born");
        pronounceWord1.add("bough");
        pronounceWord1.add("boy");
        pronounceWord1.add("brae");
        pronounceWord1.add("braid");
        pronounceWord1.add("braise");
        pronounceWord1.add("brake");
        pronounceWord1.add("bread");
        pronounceWord1.add("brews");
        pronounceWord1.add("bridal");
        pronounceWord1.add("broach");
        pronounceWord1.add("bur");
        pronounceWord1.add("but");
        pronounceWord1.add("buy");
        pronounceWord1.add("buyer");
        pronounceWord1.add("calendar");
        pronounceWord1.add("call");
        pronounceWord1.add("canvas");
        pronounceWord1.add("cast");
        pronounceWord1.add("caster");
        pronounceWord1.add("caught");
        pronounceWord1.add("caw");
        pronounceWord1.add("cede");
        pronounceWord1.add("ceiling");
        pronounceWord1.add("cell");
        pronounceWord1.add("censer");
        pronounceWord1.add("cent");
        pronounceWord1.add("cereal");
        pronounceWord1.add("cheap");
        pronounceWord1.add("check");
        pronounceWord1.add("choir");
        pronounceWord1.add("chord");
        pronounceWord1.add("cite");
        pronounceWord1.add("clack");
        pronounceWord1.add("clew");
        pronounceWord1.add("climb");
        pronounceWord1.add("close");
        pronounceWord1.add("coal");
        pronounceWord1.add("coarse");
        pronounceWord1.add("cooing");
        pronounceWord1.add("colonel");
        pronounceWord1.add("complacent");
        pronounceWord1.add("complement");
        pronounceWord1.add("coo");
        pronounceWord1.add("cops");
        pronounceWord1.add("council");
        pronounceWord1.add("cousin");
        pronounceWord1.add("creak");
        pronounceWord1.add("crews");
        pronounceWord1.add("cue");
        pronounceWord1.add("curb");
        pronounceWord1.add("currant");
        pronounceWord1.add("cymbal");
        pronounceWord1.add("dam");
        pronounceWord1.add("days");
        pronounceWord1.add("dear");
        pronounceWord1.add("descent");
        pronounceWord1.add("desert");
        pronounceWord1.add("deviser");

        pronounceWord2.add("accessory");
        pronounceWord2.add("add");
        pronounceWord2.add("ale");
        pronounceWord2.add("heir");
        pronounceWord2.add("I'll");
        pronounceWord2.add("awl");
        pronounceWord2.add("aloud");
        pronounceWord2.add("arms");
        pronounceWord2.add("alter");
        pronounceWord2.add("ark");
        pronounceWord2.add("aunt");
        pronounceWord2.add("eight");
        pronounceWord2.add("augur");
        pronounceWord2.add("orc");
        pronounceWord2.add("oral");
        pronounceWord2.add("aweigh");
        pronounceWord2.add("or");
        pronounceWord2.add("axle");
        pronounceWord2.add("eye");
        pronounceWord2.add("bale");
        pronounceWord2.add("bate");
        pronounceWord2.add("bays");
        pronounceWord2.add("bawled");
        pronounceWord2.add("ball");
        pronounceWord2.add("banned");
        pronounceWord2.add("barred");
        pronounceWord2.add("bear");
        pronounceWord2.add("barque");
        pronounceWord2.add("barren");
        pronounceWord2.add("bass");
        pronounceWord2.add("bey");
        pronounceWord2.add("bizarre");
        pronounceWord2.add("bee");
        pronounceWord2.add("beech");
        pronounceWord2.add("been");
        pronounceWord2.add("beet");
        pronounceWord2.add("bow");
        pronounceWord2.add("bier");
        pronounceWord2.add("belle");
        pronounceWord2.add("bury");
        pronounceWord2.add("birth");
        pronounceWord2.add("byte");
        pronounceWord2.add("build");
        pronounceWord2.add("bittern");
        pronounceWord2.add("blue");
        pronounceWord2.add("block");
        pronounceWord2.add("bore");
        pronounceWord2.add("bored");
        pronounceWord2.add("border");
        pronounceWord2.add("bowled");
        pronounceWord2.add("booze");
        pronounceWord2.add("borne");
        pronounceWord2.add("bow");
        pronounceWord2.add("buoy");
        pronounceWord2.add("bray");
        pronounceWord2.add("brayed");
        pronounceWord2.add("braze");
        pronounceWord2.add("break");
        pronounceWord2.add("bred");
        pronounceWord2.add("bruise");
        pronounceWord2.add("bridle");
        pronounceWord2.add("brooch");
        pronounceWord2.add("burr");
        pronounceWord2.add("butt");
        pronounceWord2.add("bye");
        pronounceWord2.add("byre");
        pronounceWord2.add("calender");
        pronounceWord2.add("call");
        pronounceWord2.add("canvas");
        pronounceWord2.add("caste");
        pronounceWord2.add("castor");
        pronounceWord2.add("court");
        pronounceWord2.add("corps");
        pronounceWord2.add("seed");
        pronounceWord2.add("sealing");
        pronounceWord2.add("sell");
        pronounceWord2.add("sensor");
        pronounceWord2.add("sent");
        pronounceWord2.add("serial");
        pronounceWord2.add("cheep");
        pronounceWord2.add("cheek");
        pronounceWord2.add("quire");
        pronounceWord2.add(",cord");
        pronounceWord2.add("site");
        pronounceWord2.add("claque");
        pronounceWord2.add("clue");
        pronounceWord2.add("clime");
        pronounceWord2.add("cloze");
        pronounceWord2.add("kohl");
        pronounceWord2.add("course");
        pronounceWord2.add("coin");
        pronounceWord2.add("kernel");
        pronounceWord2.add("complaisant");
        pronounceWord2.add("compliment");
        pronounceWord2.add("coup");
        pronounceWord2.add("copse");
        pronounceWord2.add("counsel");
        pronounceWord2.add("cozen");
        pronounceWord2.add("creek");
        pronounceWord2.add("cruise");
        pronounceWord2.add("queue");
        pronounceWord2.add("herb");
        pronounceWord2.add("current");
        pronounceWord2.add("symbol");
        pronounceWord2.add("damn");
        pronounceWord2.add("days");
        pronounceWord2.add("deer");
        pronounceWord2.add("dissent");
        pronounceWord2.add("dessert");
        pronounceWord2.add("divisor");

        pronounceDummy.add("accessary, accessory");
        pronounceDummy.add("ad, add");
        pronounceDummy.add("ail, ale)");
        pronounceDummy.add("air, heir");
        pronounceDummy.add("aisle, isle");
        pronounceDummy.add("all, awl");
        pronounceDummy.add("allowed, aloud");
        pronounceDummy.add("alms, arms");
        pronounceDummy.add("altar, alter");
        pronounceDummy.add("arc, ark");
        pronounceDummy.add("aren't, aunt");
        pronounceDummy.add("ate, eight");
        pronounceDummy.add("auger, augur");
        pronounceDummy.add("auk, orc");
        pronounceDummy.add("aural, oral");
        pronounceDummy.add("away, aweigh");
        pronounceDummy.add("awe, or");
        pronounceDummy.add("axel, axle");
        pronounceDummy.add("aye, eye");
        pronounceDummy.add("bail, bale");
        pronounceDummy.add("bait, bate");
        pronounceDummy.add("baize, bays");
        pronounceDummy.add("bald, bawled");
        pronounceDummy.add("ball, bawl");
        pronounceDummy.add("banned, band");
        pronounceDummy.add("bard, barred");
        pronounceDummy.add("bare, bear");
        pronounceDummy.add("bark, barque");
        pronounceDummy.add("baron, barren");
        pronounceDummy.add("base, bass");
        pronounceDummy.add("bay, bey");
        pronounceDummy.add("bazaar, bizarre");
        pronounceDummy.add("be, bee");
        pronounceDummy.add("beach, beech");
        pronounceDummy.add("bean, been");
        pronounceDummy.add("beat, beet");
        pronounceDummy.add("beau, bow");
        pronounceDummy.add("beer, bier");
        pronounceDummy.add("bel, bell, belle");
        pronounceDummy.add("berry, bury");
        pronounceDummy.add("berth, birth");
        pronounceDummy.add("bight, bite, byte");
        pronounceDummy.add("billed, build");
        pronounceDummy.add("bitten, bittern");
        pronounceDummy.add("blew, blue");
        pronounceDummy.add("bloc, block");
        pronounceDummy.add("boar, bore");
        pronounceDummy.add("board, bored");
        pronounceDummy.add("boarder, border");
        pronounceDummy.add("bold, bowled");
        pronounceDummy.add("boos, booze");
        pronounceDummy.add("born, borne");
        pronounceDummy.add("bough, bow");
        pronounceDummy.add("boy, buoy");
        pronounceDummy.add("brae, bray");
        pronounceDummy.add("braid, brayed");
        pronounceDummy.add("braise, brays, braze");
        pronounceDummy.add("brake, break");
        pronounceDummy.add("bread, bred");
        pronounceDummy.add("brews, bruise");
        pronounceDummy.add("bridal, bridle");
        pronounceDummy.add("broach, brooch");
        pronounceDummy.add("bur, burr");
        pronounceDummy.add("but, butt");
        pronounceDummy.add("buy, by, bye");
        pronounceDummy.add("buyer, byre");
        pronounceDummy.add("calendar, calender");
        pronounceDummy.add("call, caul");
        pronounceDummy.add("canvas, canvass");
        pronounceDummy.add("cast, caste");
        pronounceDummy.add("caster, castor");
        pronounceDummy.add("caught, court");
        pronounceDummy.add("caw, core, corps");
        pronounceDummy.add("cede, seed");
        pronounceDummy.add("ceiling, sealing");
        pronounceDummy.add("cell, sell");
        pronounceDummy.add("censer, censor, sensor");
        pronounceDummy.add("cent, scent, sent");
        pronounceDummy.add("cereal, serial");
        pronounceDummy.add("cheap, cheep");
        pronounceDummy.add("check, cheek");
        pronounceDummy.add("choir, quire");
        pronounceDummy.add("chord, cord");
        pronounceDummy.add("cite, sight, site");
        pronounceDummy.add("clack, claque");
        pronounceDummy.add("clew, clue");
        pronounceDummy.add("climb, clime");
        pronounceDummy.add("close, cloze");
        pronounceDummy.add("coal, kohl");
        pronounceDummy.add("coarse, course");
        pronounceDummy.add("cooing, coin");
        pronounceDummy.add("colonel, kernel");
        pronounceDummy.add("complacent, complaisant");
        pronounceDummy.add("complement, compliment");
        pronounceDummy.add("coo, coup");
        pronounceDummy.add("cops, copse");
        pronounceDummy.add("council, counsel");
        pronounceDummy.add("cousin, cozen");
        pronounceDummy.add("creak, creek");
        pronounceDummy.add("crews, cruise");
        pronounceDummy.add("cue, key, queue");
        pronounceDummy.add("curb, herb");
        pronounceDummy.add("currant, current");
        pronounceDummy.add("cymbal, symbol");
        pronounceDummy.add("dam, damn");
        pronounceDummy.add("days, daze");
        pronounceDummy.add("dear, deer");
        pronounceDummy.add("descent, dissent");
        pronounceDummy.add("desert, dessert");
        pronounceDummy.add("deviser, divisor");

        try {
            for (int i = 0; i < pronounceWord1.size(); i++) {
                RowItem a = new RowItem(pronounceWord1.get(i), pronounceWord2.get(i));
                albumList.add(a);
            }
        } catch (Exception ex) {
            Log.e("Khabees Exception", ex + "");
        }

        Log.e("New Step", "3");

        adapter.notifyDataSetChanged();
        Log.e("New Step", "4");
    }

    TextToSpeech tts;

    public void callIntent(final String msg) {
        tts = new TextToSpeech(HomoPhoneActivity.this, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.US);
                    if (result == TextToSpeech.LANG_MISSING_DATA ||
                            result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("error", "This Language is not supported");
                    } else {
                        ConvertTextToSpeech(msg);
                    }
                } else {
                    Log.e("error", "Initilization Failed!");
                }
            }
        });
    }

    private void ConvertTextToSpeech(String text) {
        if (text == null || "".equals(text)) {
            text = "Content Not Available";
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    protected void hideAdRelatedViews() {
    }


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

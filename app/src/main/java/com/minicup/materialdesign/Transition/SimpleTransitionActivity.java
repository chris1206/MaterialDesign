package com.minicup.materialdesign.Transition;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.View;

import com.minicup.materialdesign.R;

public class SimpleTransitionActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent mIntent;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_transition);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.tv_explode_transition).setOnClickListener(this);
        findViewById(R.id.perfect).setOnClickListener(this);
        findViewById(R.id.tv_slide_transition).setOnClickListener(this);
        findViewById(R.id.tv_fade_transition).setOnClickListener(this);
        findViewById(R.id.tv_share_elements).setOnClickListener(this);
        findViewById(R.id.tv_reveal).setOnClickListener(this);
        mIntent = new Intent();
        getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.slide));

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.perfect:
                getWindow().setExitTransition(TransitionInflater.from(SimpleTransitionActivity.this).inflateTransition(R.transition.fade));
                mIntent.setClass(this, TransitionActivity.class);
                mIntent.putExtra("transition", "perfect");
                startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.tv_explode_transition:
                mIntent.setClass(this, TransitionActivity.class);
                mIntent.putExtra("transition", "explode");
                startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.tv_slide_transition:
                mIntent.setClass(this, TransitionActivity.class);
                mIntent.putExtra("transition", "slide");
                startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.tv_fade_transition:
                mIntent.setClass(this, TransitionActivity.class);
                mIntent.putExtra("transition", "fade");
                getWindow().setExitTransition(TransitionInflater.from(SimpleTransitionActivity.this).inflateTransition(R.transition.fade));
                startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.tv_share_elements:
                mIntent.setClass(this, ShareElementsActivity.class);

                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(SimpleTransitionActivity.this, Pair.create(findViewById(R.id.img_share), "share"), Pair.create(findViewById(R.id.tv_share), "share_text"));
                //5.0以下兼容
                ActivityOptionsCompat activityOptionsCompat1 = ActivityOptionsCompat.makeSceneTransitionAnimation(SimpleTransitionActivity.this
                        , android.support.v4.util.Pair.create(findViewById(R.id.img_share), "share")
                        , android.support.v4.util.Pair.create(findViewById(R.id.tv_share), "share_text"));

                getWindow().setExitTransition(TransitionInflater.from(SimpleTransitionActivity.this).inflateTransition(R.transition.fade));
//                getWindow().setExitTransition(null);

                startActivity(mIntent, transitionActivityOptions.toBundle());
                break;
           /* case R.id.tv_reveal:
                mIntent.setClass(this, RevealActivity.class);
                ActivityOptions transitionActivityOptions2 = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, findViewById(R.id.img_reveal_share), "share");
                //5.0以下兼容
                //ActivityOptionsCompat activityOptionsCompat2 = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, findViewById(R.id.img_reveal_share), "share");
                startActivity(mIntent, transitionActivityOptions2.toBundle());
                break;*/
        }
    }
}

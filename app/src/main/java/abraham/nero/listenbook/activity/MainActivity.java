package abraham.nero.listenbook.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import abraham.nero.listenbook.R;
import abraham.nero.listenbook.adapter.MainPageAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mViewPager;
    private ProgressBar mProgressBar;
    private ImageView mMusicImage;
    private TextView mMusicTitle;
    private ImageButton mMusicSwitcher;
    private ImageButton mMusicNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_common);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // init view
        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        mProgressBar = (ProgressBar) findViewById(R.id.main_progress);
        mMusicImage = (ImageView) findViewById(R.id.music_image);
        mMusicTitle = (TextView) findViewById(R.id.music_title);
        mMusicSwitcher = (ImageButton) findViewById(R.id.music_switcher);
        mMusicNext = (ImageButton) findViewById(R.id.music_next);

        // init event
        mMusicSwitcher.setOnClickListener(this);
        mMusicNext.setOnClickListener(this);

        // init data
        MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(adapter.getCount());
    }

    /**
     * PLAY/PAUSE
     */
    private void musicSwitch(){
        if(Boolean.TRUE.equals(mMusicSwitcher.getTag())){
            // pause
            mMusicSwitcher.setImageResource(R.drawable.ic_play);
            mMusicSwitcher.setTag(Boolean.FALSE);
        }else{
            // play
            mMusicSwitcher.setImageResource(R.drawable.ic_pause);
            mMusicSwitcher.setTag(Boolean.TRUE);
        }
    }

    /**
     * NEXT
     */
    private void musicNext(){

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.music_switcher:
                musicSwitch();
                break;
            case R.id.music_next:
                musicNext();
                break;
        }
    }

}

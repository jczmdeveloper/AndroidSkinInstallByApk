package com.czm.myskindemo;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends Activity {

    private Button mButton;
    private Context mSkinContext;
    private int[] mResId;
    private int mCount = 0;
    private View mTopbar;
    private View mBottomBar;
    private List<View> mSkinWidgetList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSkinContext();
        setListener();
    }
    private void initSkinContext() {
        mResId = new int[]{
                R.drawable.bg_topbar0,
                R.drawable.bg_topbar1,
                R.drawable.bg_topbar2,
        };
        try {
            mSkinContext= this.getApplicationContext().createPackageContext("com.czm.myskin",
                    Context.CONTEXT_IGNORE_SECURITY | Context.CONTEXT_INCLUDE_CODE);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        mTopbar = findViewById(R.id.tv_topbar);
        mBottomBar = findViewById(R.id.tv_bottombar);
    }

    private void setListener() {
        mButton = (Button)findViewById(R.id.btn_install_skin);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable = mSkinContext.getResources().getDrawable(mResId[mCount]);
                mTopbar.setBackground(drawable);
                mBottomBar.setBackground(drawable);
                mCount++;
                if(mCount >2){
                    mCount = 0;
                }
            }
        });
    }
}

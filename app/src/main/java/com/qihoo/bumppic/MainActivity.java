package com.qihoo.bumppic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.qihoo.bumppic.login.ActivityLogin;
import com.qihoo.bumppic.login.ActivityRegister;

public class MainActivity extends Activity implements View.OnClickListener {

    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSliding();
        setListener();
    }

    private void setListener() {
        ((TextView)findViewById(R.id.home_title_social)).getPaint().setFakeBoldText(true);
        findViewById(R.id.home_linearlayout).setOnClickListener(this);
        findViewById(R.id.recommended_linearlayout).setOnClickListener(this);
        findViewById(R.id.toggle_sliding).setOnClickListener(this);
    }

    private void setSliding() {
        // configure the SlidingMenu
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
//        menu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeEnabled(true);
        menu.setFadeDegree(0.35f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.layout_left_menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_linearlayout:
                Intent intent = new Intent(this, ActivityLogin.class);
                startActivity(intent);
                break;
            case R.id.recommended_linearlayout:
                startActivity(new Intent(this, ActivityRegister.class));
                break;
            case R.id.toggle_sliding:
                menu.toggle();
                break;
        }
    }
}

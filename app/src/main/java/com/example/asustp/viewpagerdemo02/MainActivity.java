package com.example.asustp.viewpagerdemo02;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;

    private ViewPager viewPager;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private Toolbar toolbar;

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        init();

        setSupportActionBar(toolbar);       //将Toolbar实例传入

        //设置可以打开左侧的图标
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        }

        //



    }
//绑定控件
    private void init() {
        radioButton1 = findViewById(R.id.radiobtn1);
        radioButton2 = findViewById(R.id.radiobtn2);
        radioButton3 = findViewById(R.id.radiobtn3);
        radioButton4 = findViewById(R.id.radiobtn4);
        radioGroup = findViewById(R.id.radio_group);

        viewPager = findViewById(R.id.viewpaper);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);

        radioGroup.setOnCheckedChangeListener(this);

        toolbar = findViewById(R.id.toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);//左边导航栏
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

    }

    //实现按按钮也能切换fragment
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedid) {
        switch (checkedid) {
            case R.id.radiobtn1:
                viewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.radiobtn2:
                viewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.radiobtn3:
                viewPager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.radiobtn4:
                viewPager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    //-----------------------------------------------------------
    //viewPager页面切换的方法三个
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
    }


    /**
     * state 0表示什么都没动 1 表示滑动 2 表示滑动完毕
     *
     * @param state
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            switch (viewPager.getCurrentItem()) {
                case PAGE_ONE:
                    radioButton1.setChecked(true);
                    break;
                case PAGE_TWO:
                    radioButton2.setChecked(true);
                    break;
                case PAGE_THREE:
                    radioButton3.setChecked(true);
                    break;
                case PAGE_FOUR:
                    radioButton4.setChecked(true);
                    break;
            }

        }
    }
//--------------------------------------------------------------------------

    //------------------顶部菜单---------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {      //注意fragment布局在toolar下面，不然显示了按钮，但是点击没反应
        switch (item.getItemId()){
//            case R.id.backup:
//                Toast.makeText(this,"You clicked Backup",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.delete:
//                Toast.makeText(this,"You clicked Delete",Toast.LENGTH_SHORT).show();
//                break;
            case R.id.settings:
                Toast.makeText(this,"You clicked Settings",Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

    //--------------------------------------------------------------
}

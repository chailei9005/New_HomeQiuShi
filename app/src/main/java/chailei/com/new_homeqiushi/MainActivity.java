package chailei.com.new_homeqiushi;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import chailei.com.new_homeqiushi.fragments.FindFragment;
import chailei.com.new_homeqiushi.fragments.MessageFragment;
import chailei.com.new_homeqiushi.fragments.QiuShiFragment;
import chailei.com.new_homeqiushi.fragments.QiuYouQuanFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView menu;
    private ActionBarDrawerToggle toggle;
    private Fragment qiuShiFragment;
    private Fragment qiuYouFragment;
    private Fragment findFragment;
    private Fragment messageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("糗事");
        drawer = (DrawerLayout) findViewById(R.id.draw);
        menu = (NavigationView) findViewById(R.id.menu);

        qiuShiFragment = new QiuShiFragment();
        qiuYouFragment = new QiuYouQuanFragment();
        findFragment = new FindFragment();
        messageFragment = new MessageFragment();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this,drawer,0,0);
        toggle.syncState();
        drawer.setDrawerListener(toggle);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.contain, qiuShiFragment);
        transaction.commit();

        menu.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.item_qiushi:
                transaction.replace(R.id.contain,qiuShiFragment);
                setTitle("糗事");
                break;
            case R.id.item_qiuyou:
                transaction.replace(R.id.contain,qiuYouFragment);
                setTitle("糗友圈");
                break;
            case R.id.item_find:
                transaction.replace(R.id.contain,findFragment);
                setTitle("发现");
                break;
            case R.id.item_message:
                transaction.replace(R.id.contain,messageFragment);
                setTitle("小纸条");
                break;
        }

        drawer.closeDrawers();
        transaction.commit();
        return true;
    }
}

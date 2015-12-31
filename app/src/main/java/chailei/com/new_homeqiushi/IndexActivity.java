package chailei.com.new_homeqiushi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IndexActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        setTitle("糗事百科");
        Thread  thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try{
            Thread.sleep(2000);
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

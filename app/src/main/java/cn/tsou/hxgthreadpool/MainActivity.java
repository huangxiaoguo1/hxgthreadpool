package cn.tsou.hxgthreadpool;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import tsou.cn.lib_threadpool.ThreadUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 点击
     */
    private Button mBtn;
    /**
     * 点击结束
     */
    private Button mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                for (int i = 0; i < 10; i++) {
                    //不能超过最大队列缓存数，不然崩溃(我的ThreadPoolManager最大缓存队列为10)
                    final int m = i;
                    ThreadUtils.runOnLongBackThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("huangxiaoguo", "huangxiaoguo--runOnLongBackThread-" + m);
                            SystemClock.sleep(2000);
                        }
                    });
                }
                for (int i = 0; i < 10; i++) {
                    final int m = i;
                    ThreadUtils.runOnShortBackThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("huangxiaoguo", "huangxiaoguo--runOnShortBackThread-" + m);
                            SystemClock.sleep(2000);
                        }
                    });
                }
                break;
            case R.id.btn2:
                ThreadUtils.cancelLongBackThread();
                ThreadUtils.cancelShortThread();
                break;
        }
    }
}

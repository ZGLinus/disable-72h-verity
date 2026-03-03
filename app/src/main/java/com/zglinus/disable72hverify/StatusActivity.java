package com.zglinus.disable72hverify;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class StatusActivity extends Activity {
    private TextView tvStatus;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable refreshRunnable = new Runnable() {
        @Override
        public void run() {
            updateStatus();
            handler.postDelayed(this, 2000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        tvStatus = findViewById(R.id.tv_status);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.post(refreshRunnable);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(refreshRunnable);
    }

    private void updateStatus() {
        String status = SystemPropertiesHelper.get("sys.disable72h.status", "inactive");
        String displayText;
        if ("active".equals(status)) {
            displayText = "✅ Hook 已生效\n72小时验证已禁用";
        } else if ("failed".equals(status)) {
            displayText = "⚠️ Hook 失败\n请检查 Xposed 日志";
        } else {
            displayText = "❌ Hook 未生效\n模块未激活或未作用于系统框架";
        }
        tvStatus.setText(displayText);
    }
}

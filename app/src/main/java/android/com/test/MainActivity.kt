package android.com.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        StatService.start(this)
//        StatService.autoTrace(this)
//        StatService.setDebugOn(true);
//        StatService.setLogSenderDelayed(0)
//        StatService.autoTrace(this)
        // 获取测试设备ID
//        val testDeviceId = StatService.getTestDeviceId(this)
//        // 日志输出
//        Log.d("BaiduMobStat", "Test DeviceId : $testDeviceId")
//        one.setOnClickListener {
//            val attributes = HashMap<String, String>();
//            attributes.put("position", "2");
//            attributes.put("userId", "2");
//            StatService.onEvent(this@MainActivity, "1001", "测试自定义用户", 1, attributes);
//        }
//
//        two.setOnClickListener {
//            val attributes = HashMap<String, String>();
//            attributes.put("position", "1");
//            attributes.put("userId", "1");
//            StatService.onEvent(this@MainActivity, "1001", "测试自定义用户", 1, attributes);
//        }
//        one.setOnClickListener {
//            StatService.setUserId(this, "abcd");
//            val attributes = HashMap<String, String>();
//            attributes.put("userId", "abcd");
//            StatService.onEvent(this, "1001", "测试自定义用户", 1, attributes);
//        }
//
//        two.setOnClickListener {
//            StatService.setUserId(this, "abcdefg");
//            val attributes = HashMap<String, String>();
//            attributes.put("userId", "abcdefg");
//            StatService.onEvent(this, "1001", "测试自定义用户", 1, attributes);
//        }

    }
}

package com.alibaba.android.arouter.demo.module1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.millionplan.www.openservicemoudle.EventShopcartChange;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Route(path = "/module/product")
public class ProductModuleActivity extends Activity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_module);
        textView = (TextView) findViewById(R.id.tv_product);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/module/shopcart", "moudle").navigation();
            }
        });

        EventBus.getDefault().register(this);
    }


    @Subscribe
    public void onEvent(EventShopcartChange shopcartChange) {
        // 当购物车发消息出来时，我们修改我们文本的显示
        textView.setText(textView.getText().toString() + "Event get:" + shopcartChange.message);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

package com.millionplan.www.shopcartmoudle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.millionplan.www.openservicemoudle.ProductService;

@Route(path = "/module/shopcart", group = "moudle")
public class ShopcartModuleActivity extends AppCompatActivity {

    private View rl_container;
    private View tv_shopcart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_module2);
        rl_container = findViewById(R.id.rl_container);
        String productStr = ((ProductService) ARouter.getInstance().build("/service/productService").navigation()).getProductStr();
        Toast.makeText(this, productStr, Toast.LENGTH_SHORT).show();


        tv_shopcart = findViewById(R.id.tv_shopcart);
        tv_shopcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment fragment = (Fragment) ARouter.getInstance().build("/fragment/productFragment").navigation();
                Bundle bundle = new Bundle();
                bundle.putString("productId", "1234567890");
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.rl_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}

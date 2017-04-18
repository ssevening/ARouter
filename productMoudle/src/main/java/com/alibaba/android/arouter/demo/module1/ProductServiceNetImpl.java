package com.alibaba.android.arouter.demo.module1;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.millionplan.www.openservicemoudle.ProductService;

/**
 * Created by Pan on 2017/4/18.
 */
@Route(path = "/service/productService")
public class ProductServiceNetImpl implements ProductService {

    @Override
    public String getProductStr() {
        return "get product str from net!!!!";
    }

    @Override
    public void init(Context context) {

    }
}

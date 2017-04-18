package com.alibaba.android.arouter.demo.module1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by Pan on 2017/4/18.
 */

@Route(path = "/fragment/productFragment")
public class ProductFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.frag_product, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            String productId = getArguments().getString("productId");
            Toast.makeText(getActivity(), "productId is " + productId, Toast.LENGTH_SHORT).show();
        }
    }
}

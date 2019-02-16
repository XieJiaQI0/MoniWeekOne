package com.example.exam.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.exam.R;
import com.example.exam.SearchActivity;
import com.example.exam.adapter.MyAdapter;
import com.example.exam.api.ApiUsers;
import com.example.exam.api.Apis;
import com.example.exam.bean.Bean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShouYeFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.btn_saomiao)
    Button btnSaomiao;
    @BindView(R.id.edit_find)
    EditText editFind;
    @BindView(R.id.rec)
    RecyclerView rec;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.layout_shouye, null);
        unbinder = ButterKnife.bind(this, view);
        //网格布局
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        rec.setLayoutManager(gridLayoutManager);
        //创建retrofit管理器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUsers.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //实现接口
        Apis apis = retrofit.create(Apis.class);
        //添加属性值？
        Call<Bean> beanCall = apis.shou("板鞋", 2, 6);
        //第四步，请求
        beanCall.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean body = response.body();
                Log.e("+++++", body.toString());
                if (body != null) {
                    MyAdapter myAdapter = new MyAdapter(getActivity(), body);
                    rec.setAdapter(myAdapter);
                }
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {

            }


        });


        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.btn_saomiao, R.id.edit_find})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_saomiao:

                break;
            case R.id.edit_find:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);

                break;
        }
    }


}

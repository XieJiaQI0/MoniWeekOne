package com.example.exam;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.zhy.view.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {


    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.edit_search)
    EditText editSearch;
    @BindView(R.id.search_text)
    TextView searchText;
    @BindView(R.id.flow_layout)
    FlowLayout flowLayout;
    private List<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        Drawable right=getResources().getDrawable(R.drawable.cam);
        right.setBounds(0,0,38,38);//必须设置图片的大小否则没有作用
        editSearch.setCompoundDrawables(null,null ,right,null);//设置图片left这里如果是右边就放到第二个参数里面依次对应



        stringList = new ArrayList<>();
        stringList.add("小米3是一代机王");
        stringList.add("华为");
        stringList.add("华为5g");
        stringList.add("华为");
        stringList.add("百度ai");
        stringList.add("小米ai是产业链的一个布局产品");
        stringList.add("虚拟于现实");
        stringList.add("小米");

        searchClick();

    }

    private void searchClick() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,5,10,5);
        if (flowLayout!=null){
            flowLayout.removeAllViews();
        }
        for (int i = 0; i < stringList.size(); i++) {
            TextView textView = new TextView(this);
            textView.setPadding(28,10,28,10);
            textView.setText(stringList.get(i));
            textView.setMaxEms(10);
            textView.setSingleLine();
            textView.setLayoutParams(layoutParams);
            flowLayout.addView(textView, layoutParams);
        }

    }

    @OnClick({R.id.back_img, R.id.search_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.search_text:
                String string = editSearch.getText().toString();
                if (string.equals("")){
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    stringList.add(string);
                    searchClick();
                    break;
                }
        }
    }





}

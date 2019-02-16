package com.example.exam.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exam.MainActivity;
import com.example.exam.R;
import com.example.exam.bean.Bean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    Bean bean;
    private View view;

    public MyAdapter(Context context, Bean bean) {
        this.context = context;
        this.bean = bean;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        view = View.inflate(context, R.layout.recy_layout, null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        //Uri uri = Uri.parse(bean.getResult().get(i).getMasterPic())
        viewHolder.name.setText(bean.getResult().get(i).getCommodityName());
        viewHolder.price.setText(bean.getResult().get(i).getPrice());
        GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(context.getResources())
                .setRoundingParams(RoundingParams.fromCornersRadius(20))
                .build();
        viewHolder.img.setHierarchy(hierarchy);

        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(bean.getResult().get(i).getMasterPic())
                .setTapToRetryEnabled(true)
                .build();

        viewHolder.img.setController(build);


    }

    @Override
    public int getItemCount() {
        return bean.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView img;
        private final TextView name;
        private final TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}

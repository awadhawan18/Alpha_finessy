package com.example.abhi.alpha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Tab2 extends Fragment {
    public int[] fieldsId = {R.id.news,R.id.resume,
            R.id.lor,R.id.skills,
            R.id.universities
    };
    public String[] fieldsName = {"News","Resume","L.O.R","Skills","Universities"};
    public int[] sampleImages = {R.drawable.news,R.drawable.resume,
            R.drawable.lor,R.drawable.skills,
            R.drawable.university
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab2,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //adds the fields like news, resume etc to the profile tab
        for(int i=0;i<fieldsName.length;i++){
            CardView cardView = (CardView)getView().findViewById(fieldsId[i]);
            TextView tv = (TextView)cardView.findViewById(R.id.field_name);
            tv.setText(fieldsName[i]);
            ImageView img = (ImageView)cardView.findViewById(R.id.image_icon);
            img.setImageResource(sampleImages[i]);
        }


    }


}

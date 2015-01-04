package com.example.kris.customdrawer;

import android.app.Fragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainInfoFragment extends Fragment {

    ImageView ivIcon;
    TextView tvItemName;

    public static final String IMAGE_RESOURCE_ID = "iconResourceID";
    public static final String ITEM_NAME = "itemName";

    public MainInfoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_info, container,
                false);

        ivIcon = (ImageView) view.findViewById(R.id.frag1_icon);
//        tvItemName = (TextView) view.findViewById(R.id.frag1_text);

//        tvItemName.setText(getArguments().getString(ITEM_NAME));
        ivIcon.setImageDrawable(view.getResources().getDrawable(
                getArguments().getInt(IMAGE_RESOURCE_ID)));


        ImageView roundedImg = (ImageView) view.findViewById(R.id.frag1_icon);
        RoundedAvatarDrawable myAvatar = new RoundedAvatarDrawable(BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.avatar));
        roundedImg.setImageDrawable(myAvatar);

        return view;
    }

}
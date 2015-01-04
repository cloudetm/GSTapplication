package com.example.kris.customdrawer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class ProjectsFragment extends Fragment {

    ImageView ivIcon;
    TextView tvItemName;
    private WebView webView;


    public static final String IMAGE_RESOURCE_ID = "iconResourceID";
    public static final String ITEM_NAME = "itemName";

    public ProjectsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_projects, container,
                false);

        LaunchBrowserDialogFragment dialog = new LaunchBrowserDialogFragment();
        dialog.show(getFragmentManager(), "DIALOG");


        return view;
    }



}
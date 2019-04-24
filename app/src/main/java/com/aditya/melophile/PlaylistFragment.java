package com.aditya.melophile;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dalvik.system.PathClassLoader;

public class PlaylistFragment extends Fragment {

    private static final int MY_PERMISSION_REQUEST = 1;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    String[] items;
    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.fragment_playlist, container, false);
        recyclerView = (RecyclerView) RootView.findViewById(R.id.recyclerView);

        runTimePermission();
        initRecyclerView();
        display();

        //   recyclerView = (RecyclerView) RootView.findViewById(R.id.recyclerView);
        // recyclerView.hasFixedSize();
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //      adapter = new SongsAdapter(listItems , getActivity());
//        recyclerView.setAdapter(adapter);
        return RootView;

    }

    private void initRecyclerView() {

        recyclerView.hasFixedSize();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new SongsAdapter(listItems, getActivity());
        recyclerView.setAdapter(adapter);

    }

    public void runTimePermission() {
        Dexter.withActivity(getActivity())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        display();

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                        token.continuePermissionRequest();
                    }
                }).check();
    }

    public ArrayList<File> findSong(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();
        for (File singleFile : files) {

            if (singleFile.isDirectory() && singleFile.isHidden()) {
                arrayList.addAll(findSong(singleFile));
            } else {
                if (singleFile.getName().endsWith(".mp3") ||
                        singleFile.getName().endsWith(".wav")) {
                    arrayList.add(singleFile);

                }
            }

        }
        return arrayList;
    }

    void display() {
        final ArrayList<File> mySOngs = findSong(Environment.getExternalStorageDirectory());

        items = new String[mySOngs.size()];

        for (int i = 0; i < mySOngs.size(); i++) {

            items[i] = mySOngs.get(i).getName().toString().replace(".mp3", null).replace("wav", null);

        }
    }


}

package com.example.takeimageapp;

import android.content.Intent;
import android.media.Image;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FotoLain extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    ImageAdapter myImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_lain);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        myImageAdapter = new ImageAdapter(this);
        gridView.setAdapter(myImageAdapter);
        gridView.setOnItemClickListener(this);

        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();
        String targetpath = ExternalStorageDirectoryPath + "/Gambar";
        Toast.makeText(getApplicationContext(),targetpath, Toast.LENGTH_SHORT).show();
        File targetDirector = new File(targetpath);
        File[]files = targetDirector.listFiles();
        for (File file : files){
            myImageAdapter.add(file.getAbsolutePath());
        }

    }
    @Override
    public  void  onClick(View v){

    }
    @Override
    public void  onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(FotoLain.this, "Gambar Dipilih" + position, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, SPhoto.class);
        i.putExtra("Path", myImageAdapter.itemList.get(position));
        startActivity(i);
    }
}

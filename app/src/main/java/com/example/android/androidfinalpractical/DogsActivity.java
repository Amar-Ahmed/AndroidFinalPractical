package com.example.android.androidfinalpractical;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by C4Q on 2/25/18.
 */

public class DogsActivity extends AppCompatActivity {

    private TextView textBreed;
    private RecyclerView recyclerContainer;
    private Retrofit retrofit;
    List<String> listDogs;
    private SharedPreferences sp;
    SharedPreferences.Editor editor;
    private static final String SHARED_PREFS_KEY = "sharedPrefsKey";





}
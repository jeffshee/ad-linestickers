package io.github.jeffshee.discordlinestickers;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {
    private ArrayList<Sticker> stickerList;
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        preferences = getSharedPreferences(MainActivity.PREF_STICKER, MODE_PRIVATE);
        Button button = findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStickers();
                setResult(RESULT_OK);
                finish();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getStickers();
        PackAdapter packAdapter = new PackAdapter(stickerList, this, true);
        recyclerView.setAdapter(packAdapter);
        ItemTouchHelper.Callback callback = new AdapterCallback(packAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        Toast.makeText(this, getString(R.string.msg_tutorial_edit), Toast.LENGTH_LONG).show();
    }

    private void getStickers() {
        Gson gson = new Gson();
        stickerList = gson.fromJson(preferences.getString(MainActivity.STICKER_KEY, ""),
                new TypeToken<ArrayList<Sticker>>() {
                }.getType());
        if (stickerList == null) stickerList = new ArrayList<>();
    }

    private void saveStickers() {
        Gson gson = new Gson();
        preferences.edit().putString(MainActivity.STICKER_KEY, gson.toJson(stickerList)).apply();
    }
}

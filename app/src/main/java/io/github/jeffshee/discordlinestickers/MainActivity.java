package io.github.jeffshee.discordlinestickers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String PACKAGE = "io.github.jeffshee.discordlinestickers";
    public static final String PREF_STICKER = PACKAGE + ".sticker";
    public static final String STICKER_KEY = PACKAGE + ".stickerkey";
    private static final int REQUEST_CODE = 1;

    private ArrayList<Sticker> stickerList;
    private PackAdapter packAdapter;
    private Activity activity = this;
    RecyclerView recyclerView;
    SharedPreferences preferences;
    RelativeLayout placeholder;

    //TODO: Disclaimer, Tutorial (Usage)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case (REQUEST_CODE):
                if (resultCode == RESULT_OK) {
                    Toast.makeText(activity, getString(R.string.msg_refreshing), Toast.LENGTH_SHORT).show();
                    getStickers();
                    if (stickerList.size() == 0) {
                        placeholder.setVisibility(View.VISIBLE);
                    }
                    packAdapter.setData(stickerList);
                    packAdapter.notifyDataSetChanged();
                }
                break;

        }
    }

    /*  NOTE: (some sticker for testing purpose)
        stickerList.add(new Sticker("YURU-YURI", 8031396, 40));
        stickerList.add(new Sticker("YURU-YURI 2", 13831750, 40));*/

    /* NOTE: Nested RecyclerView: auto-scroll problem
     Workaround : Add android:descendantFocusability="blocksDescendants" to Parent's xml */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences(PREF_STICKER, MODE_PRIVATE);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getStickers();
        placeholder = findViewById(R.id.placeholder);
        if (stickerList.size() == 0) {
            placeholder.setVisibility(View.VISIBLE);
        }
        packAdapter = new PackAdapter(stickerList, this, false);
        recyclerView.setAdapter(packAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                addSticker();
                break;
            case R.id.edit:
                Intent intent = new Intent(this, EditActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.about:
                Intent intent1 = new Intent(this, AboutActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getStickers() {
        Gson gson = new Gson();
        stickerList = gson.fromJson(preferences.getString(STICKER_KEY, ""),
                new TypeToken<ArrayList<Sticker>>() {
                }.getType());
        if (stickerList == null) stickerList = new ArrayList<>();
    }

    private void saveStickers() {
        Gson gson = new Gson();
        preferences.edit().putString(STICKER_KEY, gson.toJson(stickerList)).apply();
    }

    private void addSticker() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_add, null, false);
        builder.setView(view);
        final EditText mName = view.findViewById(R.id.stickerName);
        final EditText mId = view.findViewById(R.id.stickerId);
        final EditText mCount = view.findViewById(R.id.stickerCount);
        builder.setPositiveButton(getString(R.string.add_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name;
                int id, count;
                name = mName.getText().toString();
                try {
                    id = Integer.parseInt(mId.getText().toString());
                    count = Integer.parseInt(mCount.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(activity, getString(R.string.msg_invalid_input),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                for (Sticker sticker : stickerList) {
                    if (id == sticker.getId()) {
                        Toast.makeText(activity, getString(R.string.msg_already_exists),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                stickerList.add(new Sticker(name, id, count));
                packAdapter.notifyItemInserted(stickerList.size() - 1);
                saveStickers();
                placeholder.setVisibility(View.INVISIBLE);
                Toast.makeText(activity, getString(R.string.msg_adding),
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(getString(R.string.add_cancel), null);
        builder.show();

    }
}

package io.github.jeffshee.discordlinestickers;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;

public class PackAdapter extends RecyclerView.Adapter implements ItemTouchHelperAdapter {

    private ArrayList<Sticker> stickers;
    private Context context;
    private Boolean isEdit;
    private int selected;

    PackAdapter(ArrayList<Sticker> arrayList, Context c, boolean edit) {
        stickers = arrayList;
        context = c;
        isEdit = edit;
    }

    public void setData(ArrayList<Sticker> arrayList) {
        stickers = arrayList;
    }

    private void minorEdit(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_add, null, false);
        builder.setView(view);
        final EditText mName = view.findViewById(R.id.stickerName);
        final EditText mId = view.findViewById(R.id.stickerId);
        final EditText mCount = view.findViewById(R.id.stickerCount);
        selected = -1;
        for (int i = 0; i < stickers.size(); i++) {
            if (stickers.get(i).getId() == id) selected = i;
        }
        if (selected != -1) {
            mName.setText(stickers.get(selected).getName());
            mId.setText(String.valueOf(stickers.get(selected).getId()));
            mCount.setText(String.valueOf(stickers.get(selected).getCount()));
            builder.setPositiveButton(context.getString(R.string.add_ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String name;
                    int id, count;
                    name = mName.getText().toString();
                    try {
                        id = Integer.parseInt(mId.getText().toString());
                        count = Integer.parseInt(mCount.getText().toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(context, context.getString(R.string.msg_invalid_input),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    stickers.set(selected, new Sticker(name, id, count));
                    notifyItemChanged(id);
                }
            });
            builder.setNegativeButton(context.getString(R.string.add_cancel), null);
            builder.show();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        if (isEdit) {
            itemView = View.inflate(parent.getContext(), R.layout.item_pack_edit, null);
        } else {
            itemView = View.inflate(parent.getContext(), R.layout.item_pack, null);
        }
        return new PackViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final PackViewHolder packViewHolder = (PackViewHolder) holder;
        if (isEdit) {
            String url_f = "https://sdl-stickershop.line.naver.jp/stickershop/v1/sticker/";
            String url_b = "/android/sticker.png;compress=true";
            String s = url_f + String.valueOf(stickers.get(position).getId()) + url_b;
            Glide.with(context).load(s).into(packViewHolder.mPreview);
            packViewHolder.itemView.setTag(stickers.get(position).getId());
            packViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    minorEdit((int) packViewHolder.itemView.getTag());
                }
            });
        } else {
            //final GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
            /* NOTE: Dynamic Span, Inflated view's width won't match parent
            this caused getMeasuredWidth return undesired result
            Workaround: Wrap the view with RelativeLayout */
            // NOTE: Will cause glitch if scroll rapidly
/*            packViewHolder.mRecycler.getViewTreeObserver().addOnGlobalLayoutListener(
                    new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                packViewHolder.mRecycler.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            } else {
                                packViewHolder.mRecycler.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            }
                            int viewWidth = packViewHolder.mRecycler.getMeasuredWidth();
                            float itemWidth = context.getResources().getDimension(R.dimen.sticker_size);
                            int newSpanCount = (int) Math.floor(viewWidth / itemWidth);
                            gridLayoutManager.setSpanCount(newSpanCount);
                            gridLayoutManager.requestLayout();

                        }
                    }
            );*/
            // NOTE: Another implementation -- better
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float viewWidth = (displayMetrics.widthPixels
                    - context.getResources().getDimension(R.dimen.default_padding_2) * 2
                    - context.getResources().getDimension(R.dimen.default_padding) * 2)
                    / displayMetrics.density;
            float itemWidth = (context.getResources().getDimension(R.dimen.sticker_size)
                    + context.getResources().getDimension(R.dimen.default_padding)) / displayMetrics.density;
            int span = (int) Math.floor(viewWidth / itemWidth);
            // Log.d("Span", "viewWidth " + viewWidth + ", " + "itemWidth " + itemWidth);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(context, span);
            packViewHolder.mRecycler.setLayoutManager(gridLayoutManager);
            packViewHolder.mRecycler.setAdapter(new StickerAdapter(stickers.get(position).getId(),
                    stickers.get(position).getCount(), context));
        }
        String s2 = stickers.get(position).getName() + " ID: " + stickers.get(position).getId();
        packViewHolder.mName.setText(s2);

    }

    @Override
    public int getItemCount() {
        return stickers.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(stickers, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(stickers, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        stickers.remove(position);
        notifyItemRemoved(position);
    }

    private class PackViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private RecyclerView mRecycler;
        private ImageView mPreview;

        PackViewHolder(final View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.stickerName);
            if (isEdit) {
                mPreview = itemView.findViewById(R.id.stickerPreview);
            } else {
                mRecycler = itemView.findViewById(R.id.recycler);
            }
        }
    }
}

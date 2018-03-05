package io.github.jeffshee.discordlinestickers;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

public class StickerAdapter extends RecyclerView.Adapter {
    private int id, count;
    private Context context;
    private String url_f = "https://sdl-stickershop.line.naver.jp/stickershop/v1/sticker/";
    private String url_b = "/android/sticker.png;compress=true";

    StickerAdapter(int i, int ic, Context c) {
        id = i;
        count = ic;
        context = c;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.item_sticker, null);
        return new StickerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final StickerViewHolder stickerViewHolder = (StickerViewHolder) holder;
        stickerViewHolder.itemView.setTag(position);
        String s = url_f + String.valueOf(id + position) + url_b;
        stickerViewHolder.textView.setText(context.getString(R.string.txt_loading));
        stickerViewHolder.textView.setTextColor(context.getResources().getColor(R.color.text_dim_discord));
        // NOTE: placeholder won't dismiss even after image loaded successfully, bug?
        RequestOptions requestOptions = new RequestOptions()/*.placeholder(R.drawable.placeholder)*/
                .error(R.drawable.error);
        RequestBuilder<Drawable> requestBuilder = Glide.with(context).load(s);
        requestBuilder.listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                stickerViewHolder.textView.setText(context.getString(R.string.txt_error));
                stickerViewHolder.textView.setTextColor(context.getResources().getColor(R.color.error_discord));
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                stickerViewHolder.textView.setVisibility(View.INVISIBLE);
                return false;
            }
        }).apply(requestOptions).transition(DrawableTransitionOptions.withCrossFade()).into(stickerViewHolder.imageView);
/*        Glide.with(context).load(s).apply(requestOptions).transition(DrawableTransitionOptions.withCrossFade()).
                into(stickerViewHolder.imageView);*/
        stickerViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager)
                        context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Sticker",
                        url_f + String.valueOf(id + (int) stickerViewHolder.itemView.getTag()) + url_b);
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(clip);
                    Toast.makeText(context, context.getString(R.string.msg_copied), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return count;
    }

    private class StickerViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        StickerViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.status);
        }
    }
}

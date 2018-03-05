package io.github.jeffshee.discordlinestickers;

public interface ItemTouchHelperAdapter{
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}

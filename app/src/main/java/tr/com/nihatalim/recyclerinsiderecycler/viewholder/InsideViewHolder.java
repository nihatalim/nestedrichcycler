package tr.com.nihatalim.recyclerinsiderecycler.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import tr.com.nihatalim.recyclerinsiderecycler.R;

public class InsideViewHolder extends RecyclerView.ViewHolder {
    public TextView tvName;

    public InsideViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tvName = itemView.findViewById(R.id.tvName);
    }
}

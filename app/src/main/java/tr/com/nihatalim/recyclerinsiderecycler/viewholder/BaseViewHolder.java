package tr.com.nihatalim.recyclerinsiderecycler.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import tr.com.nihatalim.recyclerinsiderecycler.R;
import tr.com.nihatalim.recyclerinsiderecycler.model.InsideModel;
import tr.com.nihatalim.richcycler.views.Richcycler;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    public Richcycler<InsideViewHolder, InsideModel> rcBase;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.rcBase = itemView.findViewById(R.id.rcBase);
    }
}

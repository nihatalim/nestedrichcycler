package tr.com.nihatalim.recyclerinsiderecycler.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tr.com.nihatalim.recyclerinsiderecycler.R;
import tr.com.nihatalim.recyclerinsiderecycler.model.BaseModel;
import tr.com.nihatalim.recyclerinsiderecycler.model.InsideModel;
import tr.com.nihatalim.recyclerinsiderecycler.viewholder.BaseViewHolder;
import tr.com.nihatalim.recyclerinsiderecycler.viewholder.InsideViewHolder;
import tr.com.nihatalim.richcycler.adapter.OnAdapter;
import tr.com.nihatalim.richcycler.views.Richcycler;

public class MainActivity extends AppCompatActivity {

    private Richcycler<BaseViewHolder, BaseModel> richcycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.richcycler = findViewById(R.id.richcyclerMainActivity);

        this.richcycler.adapter.setOnAdapter(new OnAdapter<BaseViewHolder>() {
            @Override
            public BaseViewHolder onCreate(ViewGroup parent, int viewType, View view) {
                return new BaseViewHolder(view);
            }

            @Override
            public void OnBind(BaseViewHolder baseViewHolder, int position) {
                final Richcycler<InsideViewHolder, InsideModel> rcInside = baseViewHolder.rcBase;
                rcInside.adapter.setOnAdapter(new OnAdapter<InsideViewHolder>() {
                    @Override
                    public InsideViewHolder onCreate(ViewGroup parent, int viewType, View view) {
                        return new InsideViewHolder(view);
                    }

                    @Override
                    public void OnBind(InsideViewHolder insideViewHolder, int positionInside) {
                        insideViewHolder.tvName.setText(rcInside.adapter.getObjectList().get(positionInside).name);
                    }

                    @Override
                    public RecyclerView.LayoutManager setLayoutManager(RecyclerView.LayoutManager defaultLayoutManager) {
                        ((LinearLayoutManager) defaultLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);
                        return defaultLayoutManager;
                    }
                });
                rcInside.adapter.setObjectList(richcycler.adapter.getObjectList().get(position).models);
                rcInside.build();
            }

            @Override
            public RecyclerView.LayoutManager setLayoutManager(RecyclerView.LayoutManager defaultLayoutManager) {
                ((LinearLayoutManager) defaultLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);
                return defaultLayoutManager;
            }
        });

        this.richcycler.adapter.setObjectList(getBaseList());
        this.richcycler.build();
    }


    private List<BaseModel> getBaseList(){
        List<BaseModel> models = new ArrayList<>();
        for (int i=1;i<10;i++){
            List<InsideModel> insideList = new ArrayList<>();
            for(int j=1;j<5;j++){
                insideList.add(new InsideModel("Item" + i + "_" +j));
            }
            models.add(new BaseModel(insideList));
        }

        return models;
    }
}

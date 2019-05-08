package tr.com.nihatalim.recyclerinsiderecycler.model;

import java.util.ArrayList;
import java.util.List;

public class BaseModel {
    public List<InsideModel> models;

    public BaseModel(){
        this.models = new ArrayList<>();
    }

    public BaseModel(List<InsideModel> models){
        this.models = models;
    }
}

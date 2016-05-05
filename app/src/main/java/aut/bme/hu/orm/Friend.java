package aut.bme.hu.orm;

import com.orm.SugarRecord;

public class Friend extends SugarRecord{
    String name;
    String description;
    String birthPlace;

    public Friend(){
    }

    public Friend(String name, String description, String birthPlace) {
        this.name = name;
        this.description = description;
        this.birthPlace = birthPlace;
    }
}

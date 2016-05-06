package aut.bme.hu.orm;

import com.orm.SugarRecord;

public class FriendEntity extends SugarRecord{
    String name;
    String description;
    String birthPlace;

    public FriendEntity(){
    }

    public FriendEntity(String name, String description, String birthPlace) {
        this.name = name;
        this.description = description;
        this.birthPlace = birthPlace;
    }
}

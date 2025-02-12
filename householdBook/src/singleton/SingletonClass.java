package singleton;

import dto.HouseHoldDto;
import java.util.ArrayList;
import java.util.List;

public class SingletonClass {

    private static SingletonClass sc = null;
    public List<HouseHoldDto> list;

    private SingletonClass(){
        list = new ArrayList<>();
    }

    public static SingletonClass getInstance(){
        if(sc == null){
            sc = new SingletonClass();
        }
        return sc;
    }
}

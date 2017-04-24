package model;

/**
 * Created by James on 4/24/2017.
 */
public class DataSingleton {

    static DataSingleton data = new DataSingleton();


    private DataSingleton(){}

    public static DataSingleton getInstance(){
        return data;
    }


}

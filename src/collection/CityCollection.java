package collection;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class CityCollection {
    private LinkedHashMap<String, City> cityMap;
    private LocalDateTime initTime;

    public CityCollection(LinkedHashMap<String, City> cityMap){
        this.cityMap = cityMap;
        this.initTime=LocalDateTime.now();
    }

    public CityCollection(){
        this.cityMap = new LinkedHashMap<>();
        this.initTime=LocalDateTime.now();
    }

    public void update(String s, City c, int id){
        c.setId(id);
        cityMap.put(s, c);
    }

    public LinkedHashMap<String, City> getCityMap() {
        return cityMap;
    }

    public LocalDateTime getInitTime() {
        return initTime;
    }

}

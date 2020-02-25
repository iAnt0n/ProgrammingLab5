package collection;

import utils.JsonWriter;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;

public class CollectionManager {
    private CityCollection collection;

    public CollectionManager(CityCollection col){
        this.collection=col;
    }

    public CityCollection getCollection() {
        return collection;
    }

    public String info(){
        return "Тип коллекции: " + collection.getCityMap().getClass().toString() + "\n" +
                "Время инициализации: " + collection.getInitTime().toString() + "\n" +
                "Элементов в коллекции: " + collection.getCityMap().size() + "\n";
    }

    public String show(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, City> entry : collection.getCityMap().entrySet()) {
            sb.append("Key: ").append(entry.getKey()).append("\n").append("Value: ").append(entry.getValue().toString()).append("\n");
        }
        return sb.toString();
    }

    public void clear(){
        collection.getCityMap().clear();
    }

    public void put(String s, City c){
        collection.getCityMap().put(s, c);
    }

    public void remove(String s){
        collection.getCityMap().remove(s);
    }

    public void update(String s, City c, int id){
        collection.update(s, c, id);
    }

    public void save(String path) throws IOException {
        JsonWriter writer = new JsonWriter();
        writer.write(path, collection.getCityMap());
    }

    public long countByGovernor(Human governor){
        return collection.getCityMap().values().stream().filter(x -> x.getGovernor().compareTo(governor) == 0).count();
    }

    public void removeLower(City c){
        collection.getCityMap().entrySet().removeIf(x -> x.getValue().compareTo(c) < 0);
    }

    public void removeLowerKey(String s){
        collection.getCityMap().entrySet().removeIf(x -> x.getKey().compareTo(s) < 0);
    }

    public boolean replaceIfLower(String s, City c){
        if(c.compareTo(collection.getCityMap().get(s))<0){
            collection.getCityMap().put(s, c);
            return true;
        }
        return false;
    }

    public String minByPopulation(){
        StringBuilder sb = new StringBuilder();
        Map.Entry<String, City> elem = collection.getCityMap().entrySet().stream().min(Comparator.comparing(x->x.getValue().getPopulation())).get();
        return sb.append("Key: ").append(elem.getKey()).append("\n").append("Value: ").append(elem.getValue().toString()).toString();
    }

    public String max_by_standard_of_living() throws NoSuchElementException {
        StringBuilder sb = new StringBuilder();
        Map.Entry<String, City> elem = collection.getCityMap().entrySet().stream().filter(x-> x.getValue().getStandardOfLiving() != null).max(
                Comparator.comparing(x->x.getValue().getStandardOfLiving().getLevel())).get();
        return sb.append("Key: ").append(elem.getKey()).append("\n").append("Value: ").append(elem.getValue().toString()).toString();
    }
}
package collection;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import exceptions.InvalidFieldException;

import java.time.LocalDateTime;

public class City implements Comparable{
    @JsonIgnore
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @JsonIgnore
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float area; //Значение поля должно быть больше 0
    private Long population; //Значение поля должно быть больше 0, Поле не может быть null
    private Float metersAboveSeaLevel;
    private Climate climate; //Поле может быть null
    private Government government; //Поле не может быть null
    private StandardOfLiving standardOfLiving; //Поле может быть null
    private Human governor; //Поле не может быть null
    private static int maxId = 1;

    @JsonCreator
    public City(@JsonProperty("name") String name,
                @JsonProperty("coordinates") Coordinates coordinates,
                @JsonProperty("area") float area,
                @JsonProperty("population") Long population,
                @JsonProperty("metersAboveSeaLevel") Float metersAboveSeaLevel,
                @JsonProperty("climate") Climate climate,
                @JsonProperty("government") Government government,
                @JsonProperty("standardOfLiving") StandardOfLiving standardOfLiving,
                @JsonProperty("governor") Human governor){
        this.name=name;
        this.coordinates=coordinates;
        this.area=area;
        this.population=population;
        this.metersAboveSeaLevel=metersAboveSeaLevel;
        this.climate=climate;
        this.government=government;
        this.standardOfLiving=standardOfLiving;
        this.governor=governor;
        this.creationDate = LocalDateTime.now();
        checkFields();
        this.setId(maxId);
        maxId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public float getArea() {
        return area;
    }

    public Long getPopulation() {
        return population;
    }

    public Float getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }

    public Climate getClimate() {
        return climate;
    }

    public Government getGovernment() {
        return government;
    }

    public StandardOfLiving getStandardOfLiving() {
        return standardOfLiving;
    }

    public Human getGovernor() {
        return governor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void checkFields(){
        if (name==null||name.isEmpty()){
            throw new InvalidFieldException("Ошибка в исходном файле Json: поле name");
        }
        if (coordinates==null){
            throw new InvalidFieldException("Ошибка в исходном файле Json: поле coordinates");
        }
        if (area<0){
            throw new InvalidFieldException("Ошибка в исходном файле Json: поле area");
        }
        if (population <= 0){
            throw new InvalidFieldException("Ошибка в исходном файле Json: поле population");
        }
        if (government==null){
            throw new InvalidFieldException("Ошибка в исходном файле Json: поле government");
        }
        if (governor==null){
            throw new InvalidFieldException("Ошибка в исходном файле Json: поле governor");
        }
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }
        if (!(o instanceof City)) {
            throw new ClassCastException();
        }
        City c = (City) o;
        return (int) (this.area - c.getArea());
    }

    @Override
    public String toString() {
        return "id: "+getId()+", name: "+getName();
    }
}


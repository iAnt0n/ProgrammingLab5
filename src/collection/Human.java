package collection;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import exceptions.InvalidFieldException;

public class Human implements Comparable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int age; //Значение поля должно быть больше 0
    private Double height; //Значение поля должно быть больше 0

    @JsonCreator
    public Human(@JsonProperty("name") String name,
                 @JsonProperty("age") int age,
                 @JsonProperty("height") Double height) {
        this.name = name;
        this.age = age;
        this.height = height;
        checkFields();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Double getHeight() {
        return height;
    }

    private void checkFields() {
        if (name == null || name.isEmpty()) {
            throw new InvalidFieldException("Ошибка в исходном файле Json: поле governor.name");
        }
        if (age <= 0) {
            throw new InvalidFieldException("Ошибка в исходном файле Json: поле governor.age");
        }
        if (height <= 0) {
            throw new InvalidFieldException("Ошибка в исходном файле Json: поле governor.height");
        }
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }
        if (!(o instanceof Human)) {
            throw new ClassCastException();
        }
        Human h = (Human) o;
        return (this.age - h.getAge());
    }
}


package utils;

import collection.*;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class UserInterface {
    private Reader reader;
    private Writer writer;
    private Scanner scanner;
    private boolean interactive;

    public UserInterface(Reader reader, Writer writer, boolean interactive) {
        this.reader = reader;
        this.writer = writer;
        this.scanner = new Scanner(reader);
        this.interactive = interactive;
    }

    public void write(String message) {
        try {
            writer.write(message);
            writer.flush();
        }
        catch (IOException e){
            e.getMessage();
        }
    }

    public void writeln(String message){
        write(message+"\n");
    }

    public String readString(String msg){
        if (interactive) {
            String result = "";
            writeln(msg);
            while (result.isEmpty()) {
                result = scanner.nextLine().trim();
                if (result.isEmpty()) {
                    writeln("Введите непустую строку");
                }
            }
            return result;
        }
        else return scanner.nextLine();
    }

    public Double readDouble(String msg, Double min, Double max){
        if (interactive) {
            writeln(msg);
            Double result = null;
            while (result == null) {
                try {
                    double d = Double.parseDouble(scanner.nextLine().trim());
                    if (checkDouble(d, min, max)) {
                        result = d;
                    } else {
                        writeln("Неверный ввод. Повторите");
                    }
                } catch (NullPointerException | NumberFormatException e) {
                    writeln("Неверный ввод. Повторите");
                }
            }
            return result;
        }
        else return Double.parseDouble(scanner.nextLine());
    }

    public Long readLong(String msg, Long min, Long max){
        if(interactive) {
            writeln(msg);
            Long result = null;
            while (result == null) {
                try {
                    long l = Long.parseLong(scanner.nextLine().trim());
                    if (checkLong(l, min, max)) {
                        result = l;
                    } else {
                        writeln("Неверный ввод. Повторите");
                    }
                } catch (NullPointerException | NumberFormatException e) {
                    writeln("Неверный ввод. Повторите");
                }
            }
            return result;
        }
        else return Long.parseLong(scanner.nextLine());
    }
    public Climate readClimate() {
        if(interactive) {
            writeln("Введите климат из предлженных: Monsoon, Humidcontinental, Oceanic, Mediterranian, - или же пустую строку");
            while (true) {
                String climate = scanner.nextLine().trim();
                if (climate.isEmpty()) {
                    return null;
                }
                switch (climate.toUpperCase()) {
                    case "MONSOON":
                        return Climate.MONSOON;
                    case "HUMIDCONTINENTAL":
                        return Climate.HUMIDCONTINENTAL;
                    case "OCEANIC":
                        return Climate.OCEANIC;
                    case "MEDITERRANIAN":
                        return Climate.MEDITERRANIAN;
                }
                writeln("Нет такого климата");
            }
        }
        else return Climate.valueOf(scanner.nextLine().toUpperCase());
    }

    public Government readGovernment() {
        if(interactive) {
            writeln("Введите режим из предложенных:  Gerontocracy, Despotism, Thalassocracy");
            while (true) {
                String gov = scanner.nextLine().trim();
                if (gov.isEmpty()) {
                    writeln("Режим должен быть известен");
                    continue;
                }
                switch (gov.toUpperCase()) {
                    case "GERONTOCRACY":
                        return Government.GERONTOCRACY;
                    case "DESPOTISM":
                        return Government.DESPOTISM;
                    case "THALASSOCRACY":
                        return Government.THALASSOCRACY;
                }
                writeln("Нет такого режима");
            }
        }
        else return Government.valueOf(scanner.nextLine().toUpperCase());
    }

    public StandardOfLiving readStandardOfLiving() {
        if (interactive) {
            writeln("Введите уровень жизни из предложенных:  Gerontocracy, Despotism, Thalassocracy, - или же пустую строку");
            while (true) {
                String sol = scanner.nextLine().trim();
                if (sol.isEmpty()) {
                    return null;
                }
                switch (sol.toUpperCase()) {
                    case "ULTRA_HIGH":
                        return StandardOfLiving.ULTRA_HIGH;
                    case "LOW":
                        return StandardOfLiving.LOW;
                    case "NIGHTMARE":
                        return StandardOfLiving.NIGHTMARE;
                }
                writeln("Нет такого уровня жизни");
            }
        }
        else return StandardOfLiving.valueOf(scanner.nextLine().toUpperCase());
    }

    public Human readHuman(){
        String name = readString("Введите имя губернатора");
        int age = readLong("Введите возраст губернатора (long > 0)", (long) 0, null).intValue();
        Double height = readDouble("Введите рост губернатора (double > 0)", (double) 0, null);
        return new Human(name, age, height);
    }

    public Coordinates readCoordinates(){
        Integer x = readLong("Введите Х (long > -773)", (long) -773, null).intValue();
        Double y = readDouble("Введите Y (double < 664)", null, (double) 664);
        return new Coordinates(x, y);
    }

    public City readCity(){
        String name = readString("Введите имя города");
        Coordinates coordinates = readCoordinates();
        float area = readDouble("Введите площадь города (double > 0)", (double) 0, null).floatValue();
        Long population = readLong("Введите популяцию (long > 0)", (long) 0, null);
        Float metersAboveSeaLevel = readDouble("Введите высоту (float)", null, null).floatValue(); //WTF
        Climate climate = readClimate();
        Government government = readGovernment();
        StandardOfLiving standardOfLiving = readStandardOfLiving();
        Human governor = readHuman();
        return new City(name, coordinates, area, population, metersAboveSeaLevel, climate, government, standardOfLiving, governor);
    }

    private boolean checkLong(long s, Long min, Long max) {
        if (min == null) {
            return s<max;
        }
        else if (max==null){
            return s>min;
        }
        else{
            return s>min&&s<max;
        }
    }

    private boolean checkDouble(double s, Double min, Double max) {
        if (min==null && max==null){
            return true;
        }
        else if (min == null) {
            return s<max;
        }
        else if (max==null){
            return s>min;
        }
        else{
            return s>min&&s<max;
        }
    }

    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }

    public String read(){
        return scanner.nextLine();
    }

}

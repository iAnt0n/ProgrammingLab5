import collection.CityCollection;
import collection.CollectionManager;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import commands.CommandInvoker;
import exceptions.InvalidArgumentsException;
import utils.JsonReader;
import utils.UserInterface;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;

/**
 * Главный класс программы
 */
public class Main {
    public static void main(String[] args) {
        JsonReader jr = new JsonReader();
        UserInterface ui = new UserInterface(new InputStreamReader(System.in),
                                             new OutputStreamWriter(System.out), true);
        CommandInvoker ci = new CommandInvoker();
        CityCollection collection;
        if (args.length > 0) {
            try {
                collection = new CityCollection(jr.read(args[0]));
                ui.writeln("Коллекция загружена. Введите help для просмотра команд");
            }
            catch (ValueInstantiationException e){
                collection = new CityCollection();
                ui.writeln(e.getMessage());
                ui.writeln("Инициализирована пустая коллекция");
            }
            catch (IOException e) {
                collection = new CityCollection();
                ui.writeln("Ошибка открытия файла. Инициализирована пустая коллекция");
            }
        }
        else{
            collection = new CityCollection();
            ui.writeln("Файл с коллекцей не указан. Инициализирована пустая коллекция");
        }
        CollectionManager cm = new CollectionManager(collection);

        Thread hook = new Thread(() -> {
            ci.executeCommand(cm, ui, "save");
            ui.writeln("Работа программы прервана. Изменения сохранены");
        });
        Runtime.getRuntime().addShutdownHook(hook);

        while (ui.hasNextLine()) {
            try {
                String cmd = ui.read();
                if (cmd.trim().equals("exit")) Runtime.getRuntime().removeShutdownHook(hook);
                ci.executeCommand(cm, ui, cmd);
            }
            catch(NullPointerException e){
                ui.writeln("Неизвестная команда. Используйте help для помощи");
            }
            catch (InvalidArgumentsException e){
                ui.writeln("Неверные аргументы команды. Используйте help для помощи");
            }
            catch (NoSuchElementException e){
                ui.writeln("Ввода больше не будет, сканер принял ислам");
            }
            catch (Exception e){
                ui.writeln("Произошло нечто непредвиденное");
            }
        }
    }
}


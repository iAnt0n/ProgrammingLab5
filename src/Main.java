import collection.CityCollection;
import collection.CollectionManager;
import commands.CommandInvoker;
import exceptions.InvalidArgumentsException;
import utils.JsonReader;
import utils.UserInterface;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        JsonReader jr = new JsonReader();
        UserInterface ui = new UserInterface(new InputStreamReader(System.in),
                                             new OutputStreamWriter(System.out), true);
        CommandInvoker ci = new CommandInvoker();
        CityCollection collection;
        if (args.length > 0) {
            Path pathToInitFile = Paths.get(args[0]);
            try {
                collection = new CityCollection(jr.read(pathToInitFile.toString()));
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
        while (true){
            if (ui.hasNextLine()){
                try {
                    ci.executeCommand(cm, ui, ui.read());
                }
                catch(NullPointerException e){
                    ui.writeln("Неизвестная команда. Используйте help для помощи");
                }
                catch (InvalidArgumentsException e){
                    ui.writeln("Неверные аргументы команды. Используйте help для помощи");
                }
                catch (Exception e){
                    ui.writeln("Случилось нечто страшное и непредвиденное");
                }
            }
        }
    }    
}

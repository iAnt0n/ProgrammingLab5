package commands;

import collection.CollectionManager;
import exceptions.ExecuteScriptException;
import exceptions.InvalidFieldException;
import utils.UserInterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Класс, реализующий команду execute_script
 */
public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand(){
        name = "execute_script";
        helpString = "file_name считать и исполнить скрипт из указанного файла.";
        argLen = 1;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        Path path = Paths.get(args[0]);
        try {
            UserInterface fileInterface = new UserInterface(new BufferedReader(new FileReader(path.toFile())), new OutputStreamWriter(System.out), false);
            while (fileInterface.hasNextLine()) {
                String line = fileInterface.read();
                CommandInvoker.getInstance().executeCommand(cm, fileInterface, line);
            }
        }
        catch (FileNotFoundException e) {
            ui.writeln("Нет такого файла");
        }
        catch (NullPointerException e){
            ui.writeln("Выполнение скрипта прервано из-за ошибки: неизвестная команда");
        }
        catch (InvalidFieldException e){
            ui.writeln("Выполнение скрипта прервано из-за ошибки: неверное значение поля при добавлении или изменении элемента");
        }
        catch (ExecuteScriptException e){
            ui.writeln("Выполнение скрипта прервано из-за ошибки: вызов скрипта в скрипте");
        }
        catch (Exception e){
            ui.writeln("Выполнение скрипта прервано из-за ошибки: неизвестная ошибка");
        }
    }
}

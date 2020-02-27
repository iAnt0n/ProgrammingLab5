package commands;

import collection.CollectionManager;
import utils.UserInterface;

import java.io.IOException;

/**
 * Класс, реализующий команду save
 */
public class SaveCommand extends Command {
    public SaveCommand(){
        name = "save";
        helpString = "Сохранить коллекцию в файл";
        argLen = 0;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        try {
            cm.save("out.json");
        }
        catch (IOException e){
            ui.writeln("Ошибка при записи в файл");
        }
    }
}

package commands;

import collection.CollectionManager;
import exceptions.InvalidArgumentsException;
import utils.UserInterface;

/**
 * Класс, реализующий команду replace_if_lower
 */
public class ReplaceIfLowerCommand extends Command {
    public ReplaceIfLowerCommand(){
        name = "replace_if_lower";
        helpString = "заменить значение по ключу, если новое значение меньше старого";
        argLen = 1;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        String key = args[0];
        if (cm.getCollection().getCityMap().containsKey(key)){
            if (cm.replaceIfLower(args[0], ui.readCity())){
                ui.writeln("Замена произошла успешно");
            }
            else ui.writeln("Новое значение больше старого");
        }
        else throw new InvalidArgumentsException("");
    }
}

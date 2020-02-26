package commands;

import collection.CollectionManager;
import utils.UserInterface;

/**
 * Класс, реализующий команду remove_lower_key
 */
public class RemoveLowerKeyCommand extends Command{
    public RemoveLowerKeyCommand(){
        name = "remove_lower_key";
        helpString = "удалить из коллекции все элементы, ключ которых меньше, чем заданный";
        argLen = 1;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        cm.removeLowerKey(args[0]);
    }
}

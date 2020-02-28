package commands;

import collection.CollectionManager;
import exceptions.InvalidArgumentsException;
import utils.UserInterface;

/**
 * Класс, реализующий команду remove_key
 */
public class RemoveKeyCommand extends Command{
    public RemoveKeyCommand(){
        name = "remove_key";
        helpString = "key удалить элемент из коллекции по его ключу";
        argLen = 1;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        String key = args[0];
        if (cm.getCollection().getCityMap().containsKey(key)){
            cm.remove(key);
            ui.writeln("Из коллекции удален город с ключом "+key);
        }
        else{
            throw new InvalidArgumentsException("");
        }
    }
}

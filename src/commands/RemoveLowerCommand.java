package commands;

import collection.CollectionManager;
import utils.UserInterface;

/**
 * Класс, реализующий команду remove_lower
 */
public class RemoveLowerCommand extends Command {
    public RemoveLowerCommand(){
        name = "remove_lower";
        helpString = "{element} удалить из коллекции все элементы, меньшие, чем заданный";
        argLen = 0;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        cm.removeLower(ui.readCity());
    }
}

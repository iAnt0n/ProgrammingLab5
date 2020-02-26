package commands;

import collection.CollectionManager;
import utils.UserInterface;

/**
 * Класс, реализующий команду show
 */
public class ShowCommand extends Command{
    public ShowCommand(){
        name = "show";
        helpString = "вывести все элементы коллекции в строковом представлении";
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        ui.write(cm.show());
    }
}

package commands;

import collection.CollectionManager;
import utils.UserInterface;

public class InfoCommand extends Command {
    public InfoCommand(){
        name = "info";
        helpString = "вывести информацию о коллекции";
        argLen = 0;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        ui.write(cm.info());
    }
}

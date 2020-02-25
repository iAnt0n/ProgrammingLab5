package commands;

import collection.CollectionManager;
import utils.UserInterface;

public class ClearCommand extends Command{
    public ClearCommand(){
        name = "clear";
        helpString = "очистить коллекцию";
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        cm.clear();
    }
}

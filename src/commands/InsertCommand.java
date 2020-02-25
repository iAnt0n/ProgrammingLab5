package commands;

import collection.CollectionManager;
import utils.UserInterface;

public class InsertCommand extends Command {
    public InsertCommand(){
        name = "insert";
        helpString = "добавить новый элемент с заданным ключом";
        argLen = 1;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        cm.put(args[0], ui.readCity());
        ui.writeln("В коллекцию добавлен город с ключом "+args[0]);
    }
}

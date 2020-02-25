package commands;

import collection.City;
import collection.CollectionManager;
import exceptions.InvalidArgumentsException;
import utils.UserInterface;

import java.util.Map;

public class UpdateIdCommand extends Command {
    public UpdateIdCommand(){
        name = "update";
        helpString = "обновить значение элемента коллекции, id которого равен заданному";
        argLen = 1;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        try {
            int id = Integer.parseInt(args[0]);
            boolean flag = false;
            for (Map.Entry<String, City> e : cm.getCollection().getCityMap().entrySet()) {
                if (e.getValue().getId() == id) {
                    flag = true;
                    cm.update(e.getKey(), ui.readCity(), id);
                    ui.writeln("Элемент с ID " + args[0] + " обновлен");
                }
            }
            if (!flag){
                ui.writeln("Нет элемента с таким ID");
            }
        }
        catch (NumberFormatException e){
            throw new InvalidArgumentsException("");
        }
    }
}

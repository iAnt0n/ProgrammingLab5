package commands;

import collection.CollectionManager;
import utils.UserInterface;

public class MinByPopulationCommand extends Command{
    public MinByPopulationCommand(){
        name = "min_by_population";
        helpString = "вывести любой объект из коллекции, значение поля population которого является минимальным";
        argLen = 0;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        ui.writeln(cm.minByPopulation());
    }
}

package commands;

import collection.CollectionManager;
import utils.UserInterface;

/**
 * Класс, реализующий команду count_by_governor
 */
public class CountByGovernorCommand extends Command{
    public CountByGovernorCommand(){
        name = "count_by_governor";
        helpString = "{human}: вывести количество элементов, значение поля governor которых равно заданному";
        argLen = 0;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        long l = cm.countByGovernor(ui.readHuman());
        ui.writeln("В коллекции "+l+" элементов с таким же полем governor");
    }
}

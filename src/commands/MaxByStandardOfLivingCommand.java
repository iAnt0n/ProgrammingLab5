package commands;

import collection.CollectionManager;
import utils.UserInterface;

import java.util.NoSuchElementException;

/**
 * Класс, реализующий команду max_by_standard_of_living
 */
public class MaxByStandardOfLivingCommand extends Command {
    public MaxByStandardOfLivingCommand(){
        name = "max_by_standard_of_living";
        helpString = "вывести любой объект из коллекции, значение поля standardOfLiving которого является максимальным";
        argLen = 0;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        try{
            ui.writeln(cm.max_by_standard_of_living());
        }
        catch(NoSuchElementException e){
            ui.writeln("Поля всех элементов пусты");
        }
    }
}

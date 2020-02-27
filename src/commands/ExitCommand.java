package commands;

import collection.CollectionManager;
import utils.ShutdownHook;
import utils.UserInterface;

/**
 * Класс, реализующий команду exit
 */
public class ExitCommand extends Command {
    public ExitCommand() {
        name = "exit";
        helpString = "завершить программу (без сохранения в файл)";
        argLen = 0;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        Runtime.getRuntime().removeShutdownHook(ShutdownHook.hook);
        System.exit(0);
    }
}










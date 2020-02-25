package commands;

import collection.CollectionManager;
import utils.UserInterface;

public class ExitCommand extends Command {
    public ExitCommand() {
        name = "exit";
        helpString = "завершить программу (без сохранения в файл)";
        argLen = 0;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        System.exit(0);
    }
}










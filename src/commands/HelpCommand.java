package commands;

import collection.CollectionManager;
import utils.UserInterface;

public class HelpCommand extends Command {
    public HelpCommand(){
        name = "help";
        helpString = "вывести справку по доступным командам";
        argLen = 0;
    }

    @Override
    public void execute(CollectionManager cm, UserInterface ui, String[] args) {
        for (Command command : CommandInvoker.getInstance().getAllCommands()) {
            ui.writeln(command.getName() + ": " + command.getHelpString());
        }
    }
}

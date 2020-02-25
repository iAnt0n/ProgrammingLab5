package commands;

import collection.CollectionManager;
import utils.UserInterface;

public abstract class Command {
    protected String name;
    protected String helpString;
    protected int argLen= 0;

    public String getName() {
        return name;
    }

    public String getHelpString() {
        return helpString;
    }

    public int getArgLen() {
        return argLen;
    }

    public abstract void execute(CollectionManager cm, UserInterface ui, String[] args);
}

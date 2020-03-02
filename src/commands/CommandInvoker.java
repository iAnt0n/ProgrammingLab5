package commands;

import collection.CollectionManager;
import exceptions.ExecuteScriptException;
import exceptions.InvalidArgumentsException;
import utils.UserInterface;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Реализующий singleton класс, который служит для вызова команд на основании введеной пользователем строки
 */
public class CommandInvoker {
    private static CommandInvoker instance;

    public static CommandInvoker getInstance() {
        if (instance == null) {
            instance = new CommandInvoker();
        }
        return instance;
    }

    private HashMap<String, Command> commands = new HashMap<>();
    private HashSet<Path> scripts = new HashSet<>();

    public CommandInvoker(){
        addCmd(new InfoCommand());
        addCmd(new ShowCommand());
        addCmd(new ClearCommand());
        addCmd(new InsertCommand());
        addCmd(new RemoveKeyCommand());
        addCmd(new UpdateIdCommand());
        addCmd(new SaveCommand());
        addCmd(new CountByGovernorCommand());
        addCmd(new RemoveLowerCommand());
        addCmd(new RemoveLowerKeyCommand());
        addCmd(new ReplaceIfLowerCommand());
        addCmd(new MinByPopulationCommand());
        addCmd(new MaxByStandardOfLivingCommand());
        addCmd(new ExecuteScriptCommand());
        addCmd(new ExitCommand());
        addCmd(new HelpCommand());
    }

    private void addCmd(Command cmd){
        commands.put(cmd.getName(), cmd);
    }

    public Collection<Command> getAllCommands() {
        return commands.values();
    }

    public void executeCommand(CollectionManager cm, UserInterface ui, String s){
        String[] cmd = parseCommand(s);
        if (cmd[0].equals("")){
            return;
        }
        String[] args = Arrays.copyOfRange(cmd, 1, cmd.length);
        Command execCmd = commands.get(cmd[0].toLowerCase());
        if (execCmd.getArgLen()!=args.length){
            throw new InvalidArgumentsException("Неверные аргументы команды");
        }
        execCmd.execute(cm, ui, args);
    }

    private String[] parseCommand(String s) {
        return s.trim().split(" +");
    }
}

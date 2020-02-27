package utils;

import commands.Command;
import commands.SaveCommand;

/**
 * Класс, содержащий статическую переменную потока, которая добавляется как ShutdownHook
 */
public class ShutdownHook {
    public static Thread hook = new Thread(){
        public void run(){
            Command save = new SaveCommand();
            save.execute(null, null, null);
        }
    };
}

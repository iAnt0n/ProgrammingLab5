package exceptions;

/**
 * Исключение, сигнализирующее о попытке сломать скрипт
 */
public class ExecuteScriptException extends RuntimeException {
    public ExecuteScriptException(String message){ super(message); }
}

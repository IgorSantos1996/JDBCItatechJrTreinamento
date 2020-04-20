package Excecoes;

public class DbIntegrityExcepetion extends RuntimeException {
    public DbIntegrityExcepetion(String message) {
        super(message);
    }
}

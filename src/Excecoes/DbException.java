package Excecoes;

public class DbException extends RuntimeException {
    public DbException(String msg) {
        super(msg);
    }
}

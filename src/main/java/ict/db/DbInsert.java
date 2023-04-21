package ict.db;

public interface DbInsert<T> {
    /**
     * @return id
     */
    int add(T obj);
}

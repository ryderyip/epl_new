package ict.misc;

import java.sql.SQLException;

public interface Callable<I, O> {
    O call(I input) throws SQLException;
}
package ict.db;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.Instant;

public class DateTimeToInstantConverter {
    public static Instant convert(ResultSet resultSet, String columnName) {
        Instant instant;
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            JDBCType columnType = JDBCType.valueOf(metaData.getColumnType(resultSet.findColumn(columnName)));
            if (columnType.equals(JDBCType.TIMESTAMP_WITH_TIMEZONE)) {
                instant = resultSet.getObject(columnName, Instant.class);
            } else throw new RuntimeException("Unsupported column type: " + columnType);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return instant;
    }
}

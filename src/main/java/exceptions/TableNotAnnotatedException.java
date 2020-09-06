package exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TableNotAnnotatedException extends Exception {
    String tableName;

    @Override
    public String getMessage() {
        return String.format(
                "Table %s not annotated; you may want to use annotations.Table on it.",
                tableName
        );
    }
}

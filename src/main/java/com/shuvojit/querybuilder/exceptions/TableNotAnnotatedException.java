package com.shuvojit.querybuilder.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TableNotAnnotatedException extends Exception {
    String tableName;

    @Override
    public String getMessage() {
        return String.format(
                "Table %s not annotated; you may want to use com.shuvojit.querybuilder.annotations.Table on it.",
                tableName
        );
    }
}

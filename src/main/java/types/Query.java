package types;

import annotations.Table;
import exceptions.TableNotAnnotatedException;
import lombok.Data;

import java.util.List;

@Data
public class Query {

    private String tableName;
    private List<String> selectionSet;
    private Integer limit;
    private Integer offset;
    private List<Join> joins;

    public void setTable(Class tableClass) throws TableNotAnnotatedException{
        if ( tableClass.isAnnotationPresent(Table.class) ) {
            Table table = ( Table ) tableClass.getAnnotation(Table.class);
            String tableName = table.name();
            this.setTableName(tableName);
        } else {
            throw new TableNotAnnotatedException(tableClass.getName());
        }
    }



}

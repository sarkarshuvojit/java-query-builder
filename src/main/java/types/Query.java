package types;

import lombok.Data;

import java.util.List;

@Data
public class Query {

    private String tableName;
    private List<String> selectionSet;
    private Integer limit;
    private Integer offset;



}

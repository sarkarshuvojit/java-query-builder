package types;

import lombok.Data;

@Data
public class Join {

    private JoinType joinType;
    private String destinationTableName;
    private String onCondition;


}

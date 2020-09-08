package com.shuvojit.querybuilder.types;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class Join {

    private JoinType joinType;
    private String destinationTableName;
    private String onCondition;

    public String getJoinString() {
        return String.format("%s %s on %s", joinType.getJoinType(), destinationTableName, onCondition);
    }
}
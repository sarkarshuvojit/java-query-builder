package types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum JoinType {
    LEFT("left join"),
    RIGHT("right join"),
    INNER("inner join");

    @Getter private String joinType;

}

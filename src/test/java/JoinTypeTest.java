import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import types.Join;
import types.JoinType;

public class JoinTypeTest {

    @Test
    public void leftJoinTest() {
        String leftJoin = Join
                .builder()
                .joinType(JoinType.LEFT)
                .destinationTableName("student")
                .onCondition("student.institution_id = institution.id")
                .build()
                .getJoinString();
        Assertions.assertEquals(leftJoin, "left join student on student.institution_id = institution.id");
    }

    @Test
    public void rightJoinTest() {
        String rightJoin = Join
                .builder()
                .joinType(JoinType.RIGHT)
                .destinationTableName("student")
                .onCondition("student.institution_id = institution.id")
                .build()
                .getJoinString();
        Assertions.assertEquals(rightJoin, "right join student on student.institution_id = institution.id");
    }

    @Test
    public void innerJoinTest() {
        String innerJoin = Join
                .builder()
                .joinType(JoinType.INNER)
                .destinationTableName("student")
                .onCondition("student.institution_id = institution.id")
                .build()
                .getJoinString();
        Assertions.assertEquals(innerJoin, "inner join student on student.institution_id = institution.id");
    }

}

import entities.Student;
import exceptions.TableNotAnnotatedException;
import org.junit.jupiter.api.Test;
import types.Query;

public class QueryTest {

    @Test
    public void validateQueryBuilder() throws TableNotAnnotatedException {
        Query.Builder q = new Query.Builder(Student.class)
                .select(new String[]{"name", "student_id"})
                .where("student_name like '%Ramesh%'");
        System.out.println(q.getQuery());
    }

}

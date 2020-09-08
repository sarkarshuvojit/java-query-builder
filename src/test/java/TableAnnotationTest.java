import com.shuvojit.querybuilder.exceptions.TableNotAnnotatedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableAnnotationTest {

    @Test
    public void checkTableName() throws TableNotAnnotatedException {
//        Query.Builder q = new Query.Builder().setTable(Student.class);
//        Assertions.assertEquals(q.(), "student");
    }

    @Test()
    public void checkBrokenClass() throws TableNotAnnotatedException {
        Assertions.assertThrows(
                TableNotAnnotatedException.class,
                () -> {
//                    Query q = new Query();
//                    q.setTable(UnAnnotatedStudent.class);
                }
        );
    }
}

import entities.Student;
import entities.UnAnnotatedStudent;
import exceptions.TableNotAnnotatedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import types.Query;

public class TableAnnotationTest {

    @Test
    public void checkTableName() throws TableNotAnnotatedException {
        Query q = new Query();
        q.setTable(Student.class);
        Assertions.assertEquals(q.getTableName(), "student");
    }

    @Test()
    public void checkBrokenClass() throws TableNotAnnotatedException {
        Assertions.assertThrows(
                TableNotAnnotatedException.class,
                () -> {
                    Query q = new Query();
                    q.setTable(UnAnnotatedStudent.class);
                }
        );
    }
}

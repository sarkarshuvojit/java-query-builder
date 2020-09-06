package entities;

import annotations.Table;
import lombok.Data;

@Table(name="student")
@Data
public class Student {

    private String name;
    private String roll;
}

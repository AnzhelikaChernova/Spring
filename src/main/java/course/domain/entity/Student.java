package course.domain.entity;

import course.domain.enums.Course;
import course.domain.enums.Department;
import course.domain.enums.Grade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("STUDENT")
public class Student extends User {

    @Enumerated(EnumType.STRING)
    private Course course;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Enumerated(EnumType.STRING)
    private Department department;
}

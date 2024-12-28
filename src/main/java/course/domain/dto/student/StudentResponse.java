package course.domain.dto.student;

import course.domain.enums.Course;
import course.domain.enums.Department;
import course.domain.enums.Grade;
import course.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private UserRole role;
    private Course course;
    private Grade grade;
    private Department department;
    private boolean isDeleted;
}

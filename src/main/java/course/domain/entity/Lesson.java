package course.domain.entity;

import course.domain.enums.Course;
import course.domain.enums.DayOfWeek;
import course.domain.enums.Department;
import course.domain.enums.TimeOfLesson;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="lesson")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Department department;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayOfWeek dayOfWeek;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TimeOfLesson timeOfLesson;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Course course;

    @Column(nullable = false)
    private Integer studentCount;

    @Column(nullable = false)
    private Integer cabinet;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private boolean isDeleted = false;
}

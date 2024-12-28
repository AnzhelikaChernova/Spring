package course.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserRole {
    ADMIN("Администратор"),
    STUDENT("Студент"),
    TEACHER("Преподаватель");

    private final String name;
}

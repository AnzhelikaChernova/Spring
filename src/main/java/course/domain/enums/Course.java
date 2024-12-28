package course.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Course {
    FIRST("1-й курс"),
    SECOND("2-й курс"),
    THIRD("3-й курс"),
    FOURTH("4-й курс");

    private final String name;
}

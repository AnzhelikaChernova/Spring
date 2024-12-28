package course.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TimeOfLesson {
    FIRST("08:00 - 09:15"),
    SECOND("09:30 - 10:45"),
    THIRD("11:00 - 12:15"),
    FOURTH("12:30 - 13:45"),
    FIFTH("14:00 - 15:15"),
    SIXTH("15:30 - 16:45"),
    SEVENTH("17:00 - 18:15"),
    EIGHTH("18:30 - 19:45"),
    NINTH("20:00 - 21:15");
    private final String name;
}

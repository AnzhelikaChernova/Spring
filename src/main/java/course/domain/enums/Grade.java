package course.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Grade {
    BACHELOR("Бакалавр"),
    MASTER("Магистр"),
    PHD("Доктор наук");

    private final String name;
}

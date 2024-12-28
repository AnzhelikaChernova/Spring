package course.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Department {
    IT("Школа цифровых технологий"),
    ECONOMICS_AND_MANAGEMENT("Школа экономики и менеджмента"),
    LAW_AND_POLICY("Школа права и государственного управления"),
    ARTS_AND_SOCIAL_SCIENCES("Гуманитарная школа"),
    BUSINESS("Школа бизнеса");

    private final String name;
}

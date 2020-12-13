package subway.domain.function;

import java.util.function.Function;

import subway.controller.ManagementController;

public enum RangeFunction implements Functionable {
    ADD("1", "구간 등록", ManagementController::addRange),
    REMOVE("2", "구간 삭제", ManagementController::removeRange),
    BACK("B", "돌아가기", Function.identity());

    public static final String TITLE = "구간 관리";

    private final String identifier;

    private final String description;

    private final Function<ManagementController, ManagementController> function;

    RangeFunction(final String identifier, final String description,
                  final Function<ManagementController, ManagementController> function) {
        this.identifier = identifier;
        this.description = description;
        this.function = function;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Function<ManagementController, ManagementController> getFunction() {
        return function;
    }

    @Override
    public boolean equalsIdentifier(String identifier) {
        return this.identifier.equals(identifier);
    }
}

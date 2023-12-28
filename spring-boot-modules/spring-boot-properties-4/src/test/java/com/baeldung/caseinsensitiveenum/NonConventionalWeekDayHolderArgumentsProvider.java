package com.baeldung.caseinsensitiveenum;



import static com.baeldung.caseinsensitiveenum.NonConventionalWeekDays.Fri$Day$_$;
import static com.baeldung.caseinsensitiveenum.NonConventionalWeekDays.Mon$Day;
import static com.baeldung.caseinsensitiveenum.NonConventionalWeekDays.Satur$DAY_;
import static com.baeldung.caseinsensitiveenum.NonConventionalWeekDays.Sun$Day;
import static com.baeldung.caseinsensitiveenum.NonConventionalWeekDays.THURS$day_;
import static com.baeldung.caseinsensitiveenum.NonConventionalWeekDays.Tues$DAY_;
import static com.baeldung.caseinsensitiveenum.NonConventionalWeekDays.Wednes$day;

import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class NonConventionalWeekDayHolderArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(final ExtensionContext extensionContext) {
        return Stream.of(
            Arguments.of(((Function<NonConventionalWeekDaysHolder, NonConventionalWeekDays>) NonConventionalWeekDaysHolder::getMonday),Mon$Day),
            Arguments.of(((Function<NonConventionalWeekDaysHolder, NonConventionalWeekDays>) NonConventionalWeekDaysHolder::getTuesday),Tues$DAY_),
            Arguments.of(((Function<NonConventionalWeekDaysHolder, NonConventionalWeekDays>) NonConventionalWeekDaysHolder::getWednesday),Wednes$day),
            Arguments.of(((Function<NonConventionalWeekDaysHolder, NonConventionalWeekDays>) NonConventionalWeekDaysHolder::getThursday),THURS$day_),
            Arguments.of(((Function<NonConventionalWeekDaysHolder, NonConventionalWeekDays>) NonConventionalWeekDaysHolder::getFriday),Fri$Day$_$),
            Arguments.of(((Function<NonConventionalWeekDaysHolder, NonConventionalWeekDays>) NonConventionalWeekDaysHolder::getSaturday),Satur$DAY_),
            Arguments.of(((Function<NonConventionalWeekDaysHolder, NonConventionalWeekDays>) NonConventionalWeekDaysHolder::getSunday),Sun$Day)
        );
    }
}

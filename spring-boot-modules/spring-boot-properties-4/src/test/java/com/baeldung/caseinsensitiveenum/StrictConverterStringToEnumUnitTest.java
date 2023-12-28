package com.baeldung.caseinsensitiveenum;

import static org.assertj.core.api.Assertions.assertThat;

import com.baeldung.caseinsensitiveenum.StrictConverterStringToEnumUnitTest.WeekDayConverterConfiguration;
import java.util.function.Function;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@SpringBootTest(properties = {
    "strict.monday=monday",
    "strict.tuesday=tuesday",
    "strict.wednesday=wednesday",
    "strict.thursday=thursday",
    "strict.friday=friday",
    "strict.saturday=saturday",
    "strict.sunday=sunday",
}, classes = {StrictWeekDaysHolder.class, WeekDayConverterConfiguration.class})
class StrictConverterStringToEnumUnitTest {

    public static class WeekDayConverterConfiguration {
        @Bean
        public ConversionService conversionService() {
            final DefaultConversionService defaultConversionService = new DefaultConversionService();
            defaultConversionService.addConverter(new StrictNullableWeekDayConverter());
            return defaultConversionService;
        }
    }

    @Autowired
    private StrictWeekDaysHolder lenientHolder;

    @ParameterizedTest
    @ArgumentsSource(WeekDayHolderArgumentsProvider.class)
    void givenPropertiesWhenInjectEnumThenValueIsNull(
        Function<WeekDaysHolder, SimpleWeekDays> methodReference, SimpleWeekDays ignored) {
        SimpleWeekDays actual = methodReference.apply(lenientHolder);
        assertThat(actual).isNull();
    }
}

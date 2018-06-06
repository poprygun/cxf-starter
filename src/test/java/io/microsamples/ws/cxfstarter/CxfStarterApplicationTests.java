package io.microsamples.ws.cxfstarter;

import com.holidaywebservice.holidayservice_v2.ArrayOfHolidayCode;
import com.holidaywebservice.holidayservice_v2.Country;
import com.holidaywebservice.holidayservice_v2.HolidayService2;
import com.holidaywebservice.holidayservice_v2.HolidayService2Soap;
import io.microsamples.ws.cxfstarter.config.ClientConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        TestConfig.class
})
public class CxfStarterApplicationTests {

    @Autowired
    private HolidayService2Soap holidayService2Soap;

    @Test
    public void shouldCallWithoutSpringBoot(){
        HolidayService2 holidayService = new HolidayService2();
        HolidayService2Soap holidayService2Soap = holidayService.getHolidayService2Soap();

        ArrayOfHolidayCode holidaysAvailable = holidayService2Soap.getHolidaysAvailable(Country.UNITED_STATES);
        assertThat(holidaysAvailable, is(notNullValue()));
    }


    @Test
    public void shouldCallWeatherService() {
        ArrayOfHolidayCode holidaysAvailable = holidayService2Soap.getHolidaysAvailable(Country.UNITED_STATES);
        assertThat(holidaysAvailable, is(notNullValue()));
    }

}

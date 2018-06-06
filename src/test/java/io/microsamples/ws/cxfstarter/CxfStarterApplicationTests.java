package io.microsamples.ws.cxfstarter;

import com.holidaywebservice.holidayservice_v2.ArrayOfHolidayCode;
import com.holidaywebservice.holidayservice_v2.Country;
import com.holidaywebservice.holidayservice_v2.HolidayService2Soap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CxfStarterApplicationTests {

    @Autowired
    private HolidayService2Soap holidayService2Soap;

    @Test
    public void shouldCallWeatherService() {
        ArrayOfHolidayCode holidaysAvailable = holidayService2Soap.getHolidaysAvailable(Country.UNITED_STATES);
        assertThat(holidaysAvailable, is(notNullValue()));
    }

}

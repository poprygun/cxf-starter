package io.microsamples.ws.cxfstarter;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.common.SingleRootFileSource;
import com.holidaywebservice.holidayservice_v2.ArrayOfHolidayCode;
import com.holidaywebservice.holidayservice_v2.Country;
import com.holidaywebservice.holidayservice_v2.HolidayService2;
import com.holidaywebservice.holidayservice_v2.HolidayService2Soap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

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

    private WireMockServer wireMockServer = new WireMockServer(8787);

    @Before
    public void initWiremock(){
        File mappingsDir = new File("src/test/resources/mappings");
        File filesDir = new File("src/test/resources/__files");

        FileSource mappings = new SingleRootFileSource(mappingsDir.getAbsolutePath());
        FileSource files = new SingleRootFileSource(filesDir.getAbsolutePath());
        wireMockServer.enableRecordMappings(mappings, files);

        wireMockServer.start();
    }

    @After
    public void shutdown() {
        wireMockServer.stop();
    }

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

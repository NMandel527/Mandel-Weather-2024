package mandel.weather;

import org.junit.jupiter.api.Test;
import mandel.weather.json.CurrentWeather;

import static org.junit.jupiter.api.Assertions.*;

class OpenWeatherMapServiceTest {

    @Test
    public void currentWeather() {
        // given
        ApiKey apiKey = new ApiKey();
        OpenWeatherMapService service = new OpenWeatherMapServiceFactory().getService();

        // when
        CurrentWeather currentWeather = service.currentWeather(
                apiKey.toString(),
                "Passaic",
                "standard"
        ).blockingGet();

        // then
        assertNotEquals(0, currentWeather.main.temperature);
        assertNotEquals(0, currentWeather.main.humidity);
        assertNotEquals(0, currentWeather.main.pressure);
        assertNotEquals(0, currentWeather.wind.degrees);
        assertNotEquals(0, currentWeather.wind.gust);
        assertNotEquals(0, currentWeather.wind.speed);
    }

}
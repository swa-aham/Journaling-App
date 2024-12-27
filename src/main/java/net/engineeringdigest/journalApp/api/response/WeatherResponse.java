package net.engineeringdigest.journalApp.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class WeatherResponse {

    public Current current;

    @Getter
    @Setter
    public class Current{
        public String observation_time;
        public int temperature;
        public int weather_code;
        public int feelslike;
    }
}


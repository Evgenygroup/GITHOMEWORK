import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetWeather {

    public static void main(String[] args) throws Exception {
        String city = "Berlin";
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        List<Woeid> woeids = new ArrayList<Woeid>();
        List<Temperature> temps = new ArrayList<>();

        URL url = new URL("https://www.metaweather.com/api/location/search/?query=" + city);
        Woeid[] woeid = mapper.readValue(url, Woeid[].class);

        URL url1 = new URL("https://www.metaweather.com/api/location/" + Arrays.asList(woeid).get(0));

        General temperature = mapper.readValue(url1, General.class);
        General general = Arrays.asList(temperature).get(0);
        System.out.println("Temperature in " + city + " today is " + general.consolidatedWeather[0]);


    }
}


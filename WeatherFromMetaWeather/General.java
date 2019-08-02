import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class General {

    Temperature[] consolidatedWeather;

    public General() {
    }


    public void setConsolidatedWeather(Temperature[] consolidatedWeather) {
        this.consolidatedWeather = consolidatedWeather;
    }

    @Override
    public String toString() {
        return Arrays.toString(consolidatedWeather);
    }
}

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    private String theTemp;

    public Temperature() {
    }

    public void setTheTemp(String theTemp) {
        this.theTemp = theTemp;

    }


    @Override
    public String toString() {
        return theTemp;
    }
}

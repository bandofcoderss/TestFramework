package beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class ExchangeRateResponse {

    @Getter
    private String base;
    private String date;
    private long timeLastUpdated;
    private Rate rate;

}

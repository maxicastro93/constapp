package constApp.web.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class TuplaMontoPeriodo {

    @Getter @Setter
    private String periodo;
    @Getter @Setter
    private BigDecimal monto;

    public TuplaMontoPeriodo(String p, BigDecimal m){
        this.periodo = p;
        this.monto = m;
    }

}

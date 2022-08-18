package constApp.web.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class TriplePesoDolarPeriodo {

    @Getter @Setter
    private String periodo;
    @Getter @Setter
    private BigDecimal montoPesos;
    @Getter @Setter
    private BigDecimal montoDolares;

    public TriplePesoDolarPeriodo(String p, BigDecimal mP, BigDecimal mD){
        this.periodo = p;
        this.montoPesos = mP;
        this.montoDolares = mD;
    }

}

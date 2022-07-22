package constApp.web.Utils;

import constApp.web.models.OCDetalle;
import constApp.web.models.OrdenDeCompra;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class OCDetalleListDto {

    @Getter @Setter
    private ArrayList<OCDetalle> ocDetalleList;

    public OCDetalleListDto() {
        this.ocDetalleList = new ArrayList<OCDetalle>(16);
    }

    public void addOCDetalle(OCDetalle ocdet) {
        this.ocDetalleList.add(ocdet);
    }
}
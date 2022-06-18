package models;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class Root{
    @ApiModelProperty(name = "table", dataType = "String")
    private String table;
    @ApiModelProperty(name = "currency", dataType = "String",example = "zloty")
    private String currency;
    @ApiModelProperty(name = "code", dataType = "String",example = "pln")
    private String code;
    @ApiModelProperty(name = "rates", dataType = "List<Rate>")
    private List<Rate> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}

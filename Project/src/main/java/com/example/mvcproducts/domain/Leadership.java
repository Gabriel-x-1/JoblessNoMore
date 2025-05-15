package com.example.mvcproducts.domain;

public class Leadership {
    private String CEO;
    private String CTO;

    public String getCEO() {
        return CEO;
    }
    public void setCEO(String CEO) {
        this.CEO = CEO;
    }

    public String getCTO() {
        return CTO;
    }
    public void setCTO(String CTO) {
        this.CTO = CTO;
    }

    public Leadership(String CEO, String CTO) {
        this.CEO = CEO;
        this.CTO = CTO;
    }

    public Leadership(){}
}

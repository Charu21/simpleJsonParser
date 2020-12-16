public class model {
    private String name;
    private String sector;
    private String symbol;
    private String isin;
    private Double price;

    public model() {
    }

    public model(String name, String sector, String symbol, String isin, Double price) {
        this.name = name;
        this.sector = sector;
        this.symbol = symbol;
        this.isin = isin;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[ " + this.isin + ", " +this.name +", " +this.symbol +", " +this.price +", " + this.sector + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        model that = (model) o;
        return name.equals(that.name) &&
                sector.equals(that.sector) && symbol.equals(that.symbol) && isin.equals(that.isin) &&
                price.equals(that.price);
    }
}

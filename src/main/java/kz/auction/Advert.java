package kz.auction;

public class Advert {
    private boolean isActive = true;
    private String name;
    private String description;
    private int startPrice;
    private int lastPrice;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setLastPrice(int lastPrice){
        this.lastPrice = lastPrice;

    }
}

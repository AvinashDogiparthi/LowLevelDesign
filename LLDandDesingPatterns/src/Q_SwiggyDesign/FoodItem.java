package Q_SwiggyDesign;

public class FoodItem {

    private String name;
    private String description;
    private int count;
    private int price;

    private FoodItem(FoodItemBuilder foodItemBuilder) {
        this.name = foodItemBuilder.name;
        this.description = foodItemBuilder.description;
        this.count = foodItemBuilder.count;
        this.price = foodItemBuilder.price;
    }

    public int getPrice() {
        return price;
    }

    private void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static class FoodItemBuilder {

        private String name;
        private String description;
        private int count;
        private int price;

        public FoodItemBuilder withName(String name){
            this.name = name;
            return this;
        }

        public FoodItemBuilder withDescription(String description){
            this.description= description;
            return this;
        }

        public FoodItemBuilder withCount(int count){
            this.count= count;
            return this;
        }

        public FoodItemBuilder withPrice(int price){
            this.price = price;
            return this;
        }

        public FoodItem build(){
            return new FoodItem(this);
        }

    }
}

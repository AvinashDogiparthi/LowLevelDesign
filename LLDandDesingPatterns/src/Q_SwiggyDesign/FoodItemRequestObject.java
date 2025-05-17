package Q_SwiggyDesign;

public class FoodItemRequestObject {

    private String name;
    private String description;
    private int count;
    private int price;

    public FoodItemRequestObject(FoodItemRequestBuilder foodItemRequestBuilder) {
        this.name = foodItemRequestBuilder.name;
        this.description = foodItemRequestBuilder.description;
        this.count = foodItemRequestBuilder.count;
        this.price = foodItemRequestBuilder.price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public static class FoodItemRequestBuilder{

        private String name;
        private String description;
        private int count;
        private int price;

        public FoodItemRequestBuilder withName(String name){
            this.name = name;
            return this;
        }

        public FoodItemRequestBuilder withDescription(String description){
            this.description = description;
            return this;
        }

        public FoodItemRequestBuilder withCount(int count){
            this.count = count;
            return this;
        }

        public FoodItemRequestBuilder withPrice(int price){
            this.price = price;
            return this;
        }

        public FoodItemRequestObject build(){
            return new FoodItemRequestObject(this);
        }
    }
}

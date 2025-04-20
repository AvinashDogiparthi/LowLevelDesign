package N_ZeptoStoreDesign;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    public Map<Integer, Integer> selectedProductsCount;
    public Map<Integer, Product> productMap;

    public Cart() {
        this.selectedProductsCount = new HashMap<>();
        this.productMap = new HashMap<>();
    }

    public void addProduct(Product product){
        if(productMap.containsKey(product.getProductID())){
            int currentCount = selectedProductsCount.get(product.getProductID());
            selectedProductsCount.put(product.productID, currentCount+1);
        }else {
            productMap.put(product.productID, product);
            selectedProductsCount.put(product.productID, 1);
        }
    }

    public void removeProduct(Product product){
        if(productMap.containsKey(product.productID)){
            int currentCount = selectedProductsCount.get(product.productID);
            if(currentCount <= 1){
                selectedProductsCount.remove(product.productID);
                productMap.remove(product.productID);
            }
            selectedProductsCount.put(product.productID, currentCount-1);
        } else {
            System.out.println("Product not in cart");
        }
    }

    public void emptyCart(){
        this.selectedProductsCount = new HashMap<>();
    }

    public Map<Integer, Integer> getSelectedProductsCount() {
        return selectedProductsCount;
    }

    public void setSelectedProductsCount(Map<Integer, Integer> selectedProductsCount) {
        this.selectedProductsCount = selectedProductsCount;
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Integer, Product> productMap) {
        this.productMap = productMap;
    }
}

package com.javahongkong.bootcamp.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> ordersOfFurnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
       this.ordersOfFurnitures = new HashMap<>();
    
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        int totalTypeCount = this.getTypeCount(type) + furnitureCount;
        this.ordersOfFurnitures.put(type, totalTypeCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return this.ordersOfFurnitures;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        float totalOrderCost = this.getTypeCost(Furniture.CHAIR)
                + this.getTypeCost(Furniture.TABLE)
                + this.getTypeCost(Furniture.COUCH);

        if (totalOrderCost == 0.0f)
            return 0.0f;
        else
            return totalOrderCost;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        if (this.ordersOfFurnitures.containsKey(type)) {
            return this.ordersOfFurnitures.get(type);
        }
        return 0;

    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        if (this.ordersOfFurnitures.containsKey(type)) {

            return this.getTypeCount(type) * type.cost();
        }
        return 0;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        int totalOrder = 0;
        Set<Map.Entry<Furniture, Integer>> entries =
                ordersOfFurnitures.entrySet();
        for (Map.Entry<Furniture, Integer> entry : entries) {
            totalOrder += entry.getValue();
        }
        return totalOrder;
    }

    public static void main(String[] args) {
        FurnitureOrder furnitureFactory = new FurnitureOrder();
        furnitureFactory.addToOrder(Furniture.CHAIR, 4);
        System.out.println(furnitureFactory.getTypeCount(Furniture.CHAIR));
     
       

    }
}

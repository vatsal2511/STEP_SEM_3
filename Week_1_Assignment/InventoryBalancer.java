package STEP_SEM_3.Week_1_Assignment;

public class InventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        int maxQuantity = -1;
        String maxSection = "";
        int maxItemNum = -1;
        
        // Analyze Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxItemNum = i + 1; // 1-based index
            }
        }
        
        // Analyze Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQuantity) { 
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxItemNum = i + 1;
            }
        }
        
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
            totalA, totalB, status, maxQuantity, maxSection, maxItemNum);
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        
        analyzeInventory(sectionA, sectionB);
    }
}

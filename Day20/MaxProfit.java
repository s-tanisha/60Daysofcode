package Day20;
/*
 * 1. Problem: Best Time to Buy and Sell Stock

Problem Statement:
You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Input:
An array prices where prices[i] is the price of the stock on the ith day.

Output:
The maximum profit that can be achieved.

Example:
Input:
prices = [7,1,5,3,6,4]
Output:
5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

 */
public class MaxProfit {
    public static int MaxProfitStock(int arr[]){
        if(arr == null|| arr.length<=1){
            return 0;
        }

        int minPrice=arr[0];
        int Profit=0;
        
        for(int price: arr){
            minPrice =Math.min(minPrice, price);

            Profit = Math.max(Profit, price-minPrice);
        }
        
        return Profit;
    }
    public static void main(String args[]){
        int Price[]={5, 10, 10, 5, 0, 3};

       int profit= MaxProfitStock(Price);
       System.out.println(profit);
    }
}

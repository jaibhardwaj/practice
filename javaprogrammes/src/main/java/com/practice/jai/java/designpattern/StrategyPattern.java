package com.practice.jai.java.designpattern;

import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy
{
    void payment(int amount);
}

class MasterCard implements PaymentStrategy
{
    private String cardNumber;
    private String cvv;

    public MasterCard(String cardNumber, String cvv)
    {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void payment(int amount)
    {
        System.out.println("Paying Amount using MasterCard :- " + amount);
    }
}

class Paytm implements PaymentStrategy
{
    private String userName;
    private String password;

    public Paytm(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void payment(int amount)
    {
        System.out.println("Paying Amount using Paytm :- " + amount);
    }
}

class ShoppingItem
{
    private String item;
    private int amount;

    public ShoppingItem(String item, int amount)
    {
        this.item = item;
        this.amount = amount;
    }

    public String getItem()
    {
        return item;
    }

    public void setItem(String item)
    {
        this.item = item;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }
}

class ShoppingCart
{
    private List<ShoppingItem> items;

    public ShoppingCart()
    {
        items = new ArrayList<>();
    }

    public void addItem(ShoppingItem item)
    {
        items.add(item);
    }
    public int calculateTotal(){
        int sum = 0;
        for(ShoppingItem item : items){
            sum += item.getAmount();
        }
        return sum;
    }

    public void pay(PaymentStrategy strategy)
    {
        int amount = calculateTotal();
        strategy.payment(amount);
    }
}
public class StrategyPattern
{
    public static void main(String[] args)
    {
        ShoppingCart cart = new ShoppingCart();

        ShoppingItem item1 = new ShoppingItem("1234",10);
        ShoppingItem item2 = new ShoppingItem("5678",40);

        cart.addItem(item1);
        cart.addItem(item2);

        //pay by paytm
        cart.pay(new Paytm("myemail@example.com", "mypwd"));

    }
}

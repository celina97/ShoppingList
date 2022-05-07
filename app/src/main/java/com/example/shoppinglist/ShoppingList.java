package com.example.shoppinglist;

public class ShoppingList  {

    private int imageview1;
    private String textview;
    private String textview3;
    private String divider;

    ShoppingList(int imageview1, String textview, String textview3, String divider){
       this.imageview1 = imageview1;
       this.textview = textview;
       this.textview3 = textview3;
       this.divider = divider;
    }

    public int getImage() {
        return imageview1;
    }

    public String getName() {
        return textview;
    }

    public String getDetail() {
        return textview3;
    }

    public String getDivider() {
        return divider;
    }
}

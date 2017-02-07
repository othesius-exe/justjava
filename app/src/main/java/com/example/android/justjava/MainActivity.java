package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     This method is called when the order button is clicked.

     */
    public void submitOrder(View view) {
        displayMessage(createOrderSummary());
    }

    /**
     *
     * @return orderSummary
     */

    public String createOrderSummary() {
        int price = calculatePrice();
        boolean hasWhippedCream = whippedCream();
        boolean hasChocolateSauce = chocolateSauce();
        String name = "Name: Kaptain Kunal" + "\n";
        String topping = "Has whipped cream? " + hasWhippedCream +"\n" + "Has Chocolate Drizzle? " + hasChocolateSauce + "\n";
        String purchased = "Quantity: " + quantity + "\n";
        String priceMessage = "Total: $" + price + "\nThank You!";
        String orderSummary = name + topping + purchased + priceMessage;

        return orderSummary;

    }

    /**
     *
     * @return state of whipped cream check box
     */
    public boolean whippedCream(){
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_check_box);
        return whippedCream.isChecked();
    }
    /**
     * @return state of chocolate check box
     */
    public boolean chocolateSauce() {
        CheckBox chocolateSauce = (CheckBox) findViewById(R.id.chocolate_check_box);
        return chocolateSauce.isChecked();
    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /** This method is called when the + button is clicked.

     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /** This method is called when the - button is clicked
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    /**

     This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
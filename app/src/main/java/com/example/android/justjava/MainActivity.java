package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calls CreateOrderSummary to create the order summary.
     */
    public void submitOrder(View view) {
        displayMessage(createOrderSummary());
    }

    /**
     * @return orderSummary
     */
    public String createOrderSummary() {
        String name = getName();
        boolean hasWhippedCream = whippedCream();
        boolean hasChocolateSauce = chocolateSauce();
        int price = calculatePrice(hasWhippedCream, hasChocolateSauce);
        String priceMessage = "Order name: " + name;
        priceMessage += "\nAdd whipped cream? " + hasWhippedCream;
        priceMessage += "\nAdd chocolate? " + hasChocolateSauce;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;

    }

    /**
     * @return Will fetch the name from the input field
     */
    public String getName() {
        EditText nameView = (EditText) findViewById(R.id.name_field);
        String orderName = nameView.getText().toString();
        return orderName;
    }

    /**
     * @return state of whipped cream check box
     */
    public boolean whippedCream() {
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
     * @param hasWhippedCream is whippedCream CheckBox selected
     * @param hasChocolateSauce is chocolateSauce CheckBox selected
     * @return totalPrice
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolateSauce) {
        int basePrice = 5;
        if (hasWhippedCream) {
            basePrice += 1;
        }
        if (hasChocolateSauce) {
            basePrice += 2;
        }

        return quantity * basePrice;
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        Toast tooMuchCoffee = Toast.makeText(MainActivity.this, "That's a dangerous amount of coffee", Toast.LENGTH_SHORT);
        if (quantity < 100) {
            quantity += 1;
            displayQuantity(quantity);
        } else {
            tooMuchCoffee.show();
        }
    }

    /**
     * This method is called when the - button is clicked
     */
    public void decrement(View view) {
        Toast notEnoughCoffee = Toast.makeText(MainActivity.this, "That's not enough coffee", Toast.LENGTH_SHORT);
        if (quantity > 1) {
            quantity -= 1;
            displayQuantity(quantity);
        } else {
            notEnoughCoffee.show();
        }
    }

    /**
     * This method displays the given quantity value on the screen.
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
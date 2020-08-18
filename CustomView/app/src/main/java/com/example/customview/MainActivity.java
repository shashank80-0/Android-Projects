package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvProducts;
    ArrayList<Product> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProducts = findViewById(R.id.lvProducts);
        list = new ArrayList<Product>();

        Product product1 = new Product("Lenovo Y540","Shashank Agarwal ownes this laptop",
                "Laptop", 999.99, true);
        Product product2 = new Product("Kingston 2TB Pendrive","For all your memory needs",
                "Memory", 99.99, false);
        Product product3 = new Product("Razr high refresh rate monitor","Get this now!",
                "Screen", 499.99, true);
        Product product4 = new Product("Samsung Gaming Monitor","Shashank Agarwal ownes this Screen",
                "Screen", 300.99, false);
        Product product5 = new Product("ScanDisk 9000","Best hard drive you can buy",
                "Hdd", 15.99, true);

        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        list.add(product5);

        ProductAdapter adapter = new ProductAdapter(this, list);
        lvProducts.setAdapter(adapter);
    }
}
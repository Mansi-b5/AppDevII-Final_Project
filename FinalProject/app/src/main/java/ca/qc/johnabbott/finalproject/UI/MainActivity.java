package ca.qc.johnabbott.finalproject.UI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import ca.qc.johnabbott.finalproject.CartItemListFragment;
import ca.qc.johnabbott.finalproject.Model.CartItem;
import ca.qc.johnabbott.finalproject.Model.CartItemSampleData;
import ca.qc.johnabbott.finalproject.Model.Order;
import ca.qc.johnabbott.finalproject.R;
import ca.qc.johnabbott.finalproject.databinding.ActivityMainBinding;
import ca.qc.johnabbott.finalproject.viewmodel.OrderViewModel;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private NavigationBarView bottomNavigationView;

    private OrderViewModel orderViewModel;

    public MainActivity() {
        orderViewModel = new OrderViewModel();
    }

    public OrderViewModel getOrderViewModel() {
        return orderViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId())
                {
                    case R.id.ic_home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.ic_menu:
                        fragment = new MenuCategoryFragment();
                        break;

                    case R.id.ic_contact:

                        fragment = new ContactFragment();
                        break;

                    case R.id.ic_cart:
                        fragment = new CartItemListFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_wrapper,fragment).commit();

                return true;
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_wrapper,new HomeFragment()).commit();


        Order testOrder = new Order();
//        testOrder.setCartItemList(CartItemSampleData.getData());
        List<CartItem> emptyList = new ArrayList<>();
        testOrder.setCartItemList(emptyList);
        orderViewModel.setOrder(testOrder);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
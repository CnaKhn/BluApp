package god.cna.bluapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BluActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blu);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        BottomNavigationView bottomNavBlu = findViewById(R.id.bottom_nav_blu);
        bottomNavBlu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if (item.getItemId() == R.id.item_account_fragment) {
                    fragmentTransaction.add(R.id.frame_blu, new FragmentAccount());
                    fragmentTransaction.addToBackStack("");
                    fragmentTransaction.commit();
                }
                if (item.getItemId() == R.id.item_transfer_fragment) {
                    fragmentTransaction.replace(R.id.frame_blu, new FragmentTransfer());
                    fragmentTransaction.addToBackStack("");
                    fragmentTransaction.commit();
                }
                return true;
            }
        });
    }
}
package god.cna.bluapp;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private final SharedPreferences sharedPreferences;

    public UserManager(Context context) {
        sharedPreferences = context.getSharedPreferences("blu_user", Context.MODE_PRIVATE);
    }

    public void saveUserInfo(String username, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    public String getUsername() {
        return sharedPreferences.getString("username", "");
    }

    public String getPassword() {
        return sharedPreferences.getString("password", "");
    }
}

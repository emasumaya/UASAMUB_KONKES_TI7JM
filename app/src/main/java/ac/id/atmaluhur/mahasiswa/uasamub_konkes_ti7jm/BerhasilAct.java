package ac.id.atmaluhur.uasamub_konkes_ti7jm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BerhasilAct extends AppCompatActivity {

    Button btn_lanjut;
    ImageView icon_daftar_berhasil;
    TextView app_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhasil);
        icon_daftar_berhasil = findViewById(R.id.icon_daftar_berhasil);
        app_title = findViewById(R.id.app_title);
        btn_lanjut = findViewById(R.id.btn_lanjut);
    }
    public void berhasildaftarkursus(View view) {
        Intent gotohome = new Intent(this, LoginAct.class);
        startActivity(gotohome);
    }
}
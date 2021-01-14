package ac.id.atmaluhur.uasamub_konkes_ti7jm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DaftarAct extends AppCompatActivity {

    EditText nama_lengkap_pasien, no_handphone_pasien,
            alamat_email_pasien, umur, jenis_kelamin_pasien;
    Button btn_daftar_konsul;

    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        nama_lengkap_pasien = findViewById(R.id.nama_lengkap_pasien);
        no_handphone_pasien = findViewById(R.id.no_handphone_pasien);
        alamat_email_pasien = findViewById(R.id.alamat_email_pasien);
        umur = findViewById(R.id.umur);
        jenis_kelamin_pasien = findViewById(R.id.jenis_kelamin_pasien);
        btn_daftar_konsul = findViewById(R.id.btn_daftar);

        btn_daftar_konsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(username_key, nama_lengkap_pasien.getText().toString());
                editor.apply();

                //simpan kepada database
                reference = FirebaseDatabase.getInstance().getReference()
                        .child("pasienKursus").child(nama_lengkap_pasien.getText().toString());
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("nama_lengkap_pasien").setValue(nama_lengkap_pasien.getText().toString());
                        dataSnapshot.getRef().child("no_handphone_pasien").setValue(no_handphone_pasien.getText().toString());
                        dataSnapshot.getRef().child("alamat_email_pasien").setValue(alamat_email_pasien.getText().toString());
                        dataSnapshot.getRef().child("mata_kursus").setValue(umur.getText().toString());
                        dataSnapshot.getRef().child("jenis_kelamin_pasien").setValue(jenis_kelamin_pasien.getText().toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                //berpindah activity
                Intent gotonextregister = new Intent(DaftarAct.this, SukesAct.class);
                startActivity(gotonextregister);

            }
        });
    }
}
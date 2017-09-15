package mx.iteso.is705419.tarea02;

import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;



public class ActivityMain extends AppCompatActivity implements View.OnClickListener {
    ImageView bicycle_imagen;
    ImageButton like_button;
    RadioButton radioGray, radioBrown, radioPink, radioBlack;
    Button botonS, botonM,  botonL, botonXL, boton_cart;

    String carro_texto;
    String tamano_texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bicycle_imagen = (ImageView) findViewById(R.id.bicycle_image);
        bicycle_imagen.setImageResource(R.drawable.bicycle_image);

        like_button = (ImageButton) findViewById(R.id.like_button);
        like_button.setOnClickListener(this);

        radioGray = (RadioButton) findViewById(R.id.radio_gray);
        radioBrown = (RadioButton) findViewById(R.id.radio_brown);
        radioPink = (RadioButton) findViewById(R.id.radio_pink);
        radioBlack = (RadioButton) findViewById(R.id.radio_black);

        botonS = (Button) findViewById(R.id.boton_s);
        botonM = (Button) findViewById(R.id.boton_m);
        botonL = (Button) findViewById(R.id.boton_l);
        botonXL = (Button) findViewById(R.id.boton_xl);
        botonS.setOnClickListener(this);
        botonM.setOnClickListener(this);
        botonL.setOnClickListener(this);
        botonXL.setOnClickListener(this);

        boton_cart = (Button) findViewById(R.id.add_cart);
        boton_cart.setOnClickListener(this);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        carro_texto = boton_cart.getText().toString();

        outState.putString("llave_carro",carro_texto);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        boton_cart.setText(savedInstanceState.getString("llave_carro"));
    }

    public class MyUndoListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            boton_cart.setText("Add to cart");
            // Code to undo the user's last action
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.like_button:
                Toast.makeText(getApplicationContext(),"+1 to Vintage Bicycle"
                        ,Toast.LENGTH_SHORT).show();
                break;

            case R.id.add_cart:
                if (boton_cart.getText() == "Added to cart"){
                    Toast.makeText(getApplicationContext(),"Item already is in cart",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Snackbar snack = Snackbar.make(view, "Added to cart",Snackbar.LENGTH_INDEFINITE);
                    snack.setAction(R.string.undo_string, new MyUndoListener());
                            snack.show();
                    boton_cart.setText("Added to cart");

                }

                break;

            case R.id.boton_s:
                botonS.setBackground(getDrawable(R.drawable.button_pressed));
                botonM.setBackground(getDrawable(R.drawable.button_not_pressed));
                botonL.setBackground(getDrawable(R.drawable.button_not_pressed));
                botonXL.setBackground(getDrawable(R.drawable.button_not_pressed));

                botonS.setTextColor(getResources().getColor(R.color.white));
                botonM.setTextColor(getResources().getColor(R.color.colorPrimary));
                botonL.setTextColor(getResources().getColor(R.color.colorPrimary));
                botonXL.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;

            case R.id.boton_m:
                botonS.setBackground(getDrawable(R.drawable.button_not_pressed));
                botonM.setBackground(getDrawable(R.drawable.button_pressed));
                botonL.setBackground(getDrawable(R.drawable.button_not_pressed));
                botonXL.setBackground(getDrawable(R.drawable.button_not_pressed));

                botonS.setTextColor(getResources().getColor(R.color.colorPrimary));
                botonM.setTextColor(getResources().getColor(R.color.white));
                botonL.setTextColor(getResources().getColor(R.color.colorPrimary));
                botonXL.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;

            case R.id.boton_l:
                botonS.setBackground(getDrawable(R.drawable.button_not_pressed));
                botonM.setBackground(getDrawable(R.drawable.button_not_pressed));
                botonL.setBackground(getDrawable(R.drawable.button_pressed));
                botonXL.setBackground(getDrawable(R.drawable.button_not_pressed));

                botonS.setTextColor(getResources().getColor(R.color.colorPrimary));
                botonM.setTextColor(getResources().getColor(R.color.colorPrimary));
                botonL.setTextColor(getResources().getColor(R.color.white));
                botonXL.setTextColor(getResources().getColor(R.color.colorPrimary));

                break;

            case R.id.boton_xl:
                botonS.setBackground(getDrawable(R.drawable.button_not_pressed));
                botonM.setBackground(getDrawable(R.drawable.button_not_pressed));
                botonL.setBackground(getDrawable(R.drawable.button_not_pressed));
                botonXL.setBackground(getDrawable(R.drawable.button_pressed));

                botonS.setTextColor(getResources().getColor(R.color.colorPrimary));
                botonM.setTextColor(getResources().getColor(R.color.colorPrimary));
                botonL.setTextColor(getResources().getColor(R.color.colorPrimary));
                botonXL.setTextColor(getResources().getColor(R.color.white));
                break;
        }
    }
}

package api.sergigalceran.dsa.eetac.upc.edu.libros_android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import api.sergigalceran.dsa.eetac.upc.edu.libros_android.api.sergigalceran.dsa.eetac.upc.edu.libros_android.api.AppException;
import api.sergigalceran.dsa.eetac.upc.edu.libros_android.api.sergigalceran.dsa.eetac.upc.edu.libros_android.api.Libros;
import api.sergigalceran.dsa.eetac.upc.edu.libros_android.api.sergigalceran.dsa.eetac.upc.edu.libros_android.api.LibrosAPI;

/**
 * Created by Sergi1 on 08/05/2015.
 */
public class LibrosDetailActivity extends Activity {
    private final static String TAG = LibrosDetailActivity.class.getName();


    private class FetchStingTask extends AsyncTask<String, Void, Libros> {
        private ProgressDialog pd;

        @Override
        protected Libros doInBackground(String... params) {
            Libros libro = null;
            try {
                libro = LibrosAPI.getInstance(LibrosDetailActivity.this)
                        .getLibro(params[0]);
            } catch (AppException e) {
                Log.d(TAG, e.getMessage(), e);
            }
            return libro;
        }

        @Override
        protected void onPostExecute(Libros result) {
            loadLibros(result);
            if (pd != null) {
                pd.dismiss();
            }
        }

        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(LibrosDetailActivity.this);
            pd.setTitle("Loading...");
            pd.setCancelable(false);
            pd.setIndeterminate(true);
            pd.show();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.libros_detail_layout);
        String urlLibro = (String) getIntent().getExtras().get("url");
        (new FetchStingTask()).execute(urlLibro);
    }



    private void loadLibros(Libros libros) {
        TextView tvDetailTitulo = (TextView) findViewById(R.id.tvDetailTitulo);
        TextView tvDetailAutor = (TextView) findViewById(R.id.tvDetailAutor);
        TextView tvDetailLengua = (TextView) findViewById(R.id.tvDetailLengua);
        TextView tvDetailEditorial = (TextView) findViewById(R.id.tvDetailEditorial);

        tvDetailTitulo.setText(libros.getTitulo());
        tvDetailAutor.setText(libros.getAutor());
        tvDetailLengua.setText(libros.getLengua());
        tvDetailEditorial.setText(libros.getEditorial());
    }




}

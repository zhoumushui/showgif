package com.zms.showgif;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Main extends ActionBarActivity {
    private GifImageView gifImageView;
    private Button btnPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gifImageView = (GifImageView) findViewById(R.id.imgGif);
        gifImageView.setMovieResource(R.raw.showme);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new OnClickListenerImp());
    }

    private class OnClickListenerImp implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == btnPause) {
                if (gifImageView.isPaused()) {
                    gifImageView.setPaused(false);
                    btnPause.setText("Pause");
                } else {
                    gifImageView.setPaused(true);
                    btnPause.setText("Play");
                }
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

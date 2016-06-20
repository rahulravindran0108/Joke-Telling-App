package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.rahulravindran.udacity.JokesLibrary;
import com.rahulravindran.udacity.backend.libjoke.Libjoke;
import com.rahulravindran.udacity.jokesdisplay.ViewJokeActivity;

import java.io.IOException;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void tellJoke(View view){
        new FetchJokeTask().execute(this);
    }

    private static class FetchJokeTask extends AsyncTask<Context, Void, String> {
        private static Libjoke myApiService = null;
        private Context mContext;

        @Override
        protected final String doInBackground(Context... context) {
            if(myApiService == null) {  // Only do this once
                Libjoke.Builder builder = new Libjoke.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("https://chrome-duality-427.appspot.com//_ah/api/");
                myApiService = builder.build();
            }

            mContext = context[0];
            try {
                return myApiService.getRandomJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String jokeText) {
            Intent viewJokeIntent = new Intent(mContext, ViewJokeActivity.class);
            viewJokeIntent.putExtra(ViewJokeActivity.INTENT_JOKE, jokeText);
            mContext.startActivity(viewJokeIntent);
        }
    }



}

package com.baitulmalfkam.baitulmalfkam.Fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.baitulmalfkam.baitulmalfkam.Adapter.MajalahAdapter;
import com.baitulmalfkam.baitulmalfkam.POJO.Majalah;
import com.baitulmalfkam.baitulmalfkam.R;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 */
public class MajalahFragment extends Fragment {
    RecyclerView rv_majalah;
    ProgressBar progressBar;
    MajalahAdapter adapter;


    public MajalahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_majalah, container, false);

        progressBar = rootView.findViewById(R.id.progressbar_majalah);
        rv_majalah = rootView.findViewById(R.id.rv_majalah);

        new loadUrlMajalah(this).execute();

        rv_majalah.setLayoutManager(new GridLayoutManager(getActivity(),2));
        return rootView;
    }

    private class loadUrlMajalah extends AsyncTask<String, Integer, ArrayList> {
        private WeakReference<MajalahFragment> activityReference;


        public loadUrlMajalah(MajalahFragment context) {
            activityReference = new WeakReference<>(context);
        }

        @Override
        protected void onPreExecute() {
            //textView.setText("Hello !!!");
            progressBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }


        @Override
        protected ArrayList doInBackground(String... strings) {
            SyncHttpClient client = new SyncHttpClient();
            final String url_majalah = "http://majalah.fkam.or.id/wp/api/get_posts/";
            final ArrayList<Majalah> dataMajalah = new ArrayList<>();

            client.get(url_majalah, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    Log.d("Membaca URL Majalah", "BERHASIL");
                    try {
                        JSONObject object = new JSONObject(new String(responseBody));
                        JSONArray posts = object.getJSONArray("posts");
                        dataMajalah.clear();

                        for (int i = 0; i < posts.length(); i++) {
                            JSONObject itemposts = posts.getJSONObject(i);
                            String id = itemposts.getString("id");
                            String type = itemposts.getString("type");
                            String slug = itemposts.getString("slug");
                            String url = itemposts.getString("url");
                            String title = itemposts.getString("title");
                            String date = itemposts.getString("date");
                            String thumbnail = itemposts.getString("thumbnail");
                            String content = itemposts.getString("content");
                            JSONObject custom_fields = itemposts.getJSONObject("custom_fields");
                            JSONArray edisi = custom_fields.getJSONArray("Edisi");
                            String Edisi = edisi.getString(0);


                            // JSONObject thumbnailimages = object.getJSONObject("thumbnail_images");
                            //JSONObject full = thumbnailimages.getJSONObject("full");
                            //String urlgambar = full.getString("url");

                            Majalah majalahbaru = new Majalah(id, type, slug, url, title, date, thumbnail, content, Edisi);
                            dataMajalah.add(majalahbaru);


                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                }
            });

            return dataMajalah;
        }

        protected void onPostExecute(ArrayList dataMajalah) {
            progressBar.setVisibility(View.INVISIBLE);
            adapter = new MajalahAdapter(dataMajalah, getContext());
            rv_majalah.setAdapter(adapter);
            super.onPostExecute(dataMajalah);
        }
    }
}

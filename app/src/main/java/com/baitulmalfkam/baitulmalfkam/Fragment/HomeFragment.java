package com.baitulmalfkam.baitulmalfkam.Fragment;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.baitulmalfkam.baitulmalfkam.Adapter.ItemAdapter;
import com.baitulmalfkam.baitulmalfkam.DonasiActivity;
import com.baitulmalfkam.baitulmalfkam.POJO.ListItem;
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
public class HomeFragment extends Fragment {
    RecyclerView rv;
    ProgressBar progressBar;
    ItemAdapter adapter;
    FloatingActionButton floating_buttton;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        //floating_buttton = rootView.findViewById(R.id.floating_buttton);

        progressBar = rootView.findViewById(R.id.progress_bar);
        floating_buttton = rootView.findViewById(R.id.floating_buttton);

        floating_buttton.setVisibility(View.GONE);
        floating_buttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donasiInten = new Intent(getContext(), DonasiActivity.class);
                getContext().startActivity(donasiInten);


            }
        });

        rv = rootView.findViewById(R.id.rv_content);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        new loadUrlHome(this).execute();
        return rootView;
    }

    private class loadUrlHome extends AsyncTask<String, Integer, ArrayList> {
        private WeakReference<HomeFragment> activityReference;

        public loadUrlHome(HomeFragment context) {
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
            String url_home = "http://baitulmalfkam.com/api/get_recent_posts/";
            final ArrayList<ListItem> dataList = new ArrayList<>();

            client.get(url_home, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    Log.d("Membaca URL","OnSucces : BERHASIL");
                    try {
                        JSONObject object = new JSONObject(new String(responseBody));
                        JSONArray posts = object.getJSONArray("posts");
                        dataList.clear();

                        for (int i =0; i < posts.length(); i++){
                            JSONObject itempost = posts.getJSONObject(i);
                            String id = itempost.getString("id");
                            String url = itempost.getString("url");
                            String title = itempost.getString("title");
                            String content = itempost.getString("content");
                            String date = itempost.getString("date");
                            String thumbnail = itempost.getString("thumbnail");


                            ListItem listItem = new ListItem(id,url,title,content,date,thumbnail);
                            dataList.add(listItem);
                            
                        }




                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                }
            });
            return dataList;
        }

        protected void onPostExecute(ArrayList dataList){
            progressBar.setVisibility(View.INVISIBLE);
            floating_buttton.setVisibility(View.VISIBLE);
            adapter = new ItemAdapter(dataList, getContext());
            rv.setAdapter(adapter);

            rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (dy > 0 && floating_buttton.getVisibility() == View.VISIBLE) {
                        floating_buttton.hide();
                    } else if (dy < 0 && floating_buttton.getVisibility() != View.VISIBLE) {
                        floating_buttton.show();
                    }
                }
            });
            super.onPostExecute(dataList);
        }
    }
}

package com.baitulmalfkam.baitulmalfkam.Fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.baitulmalfkam.baitulmalfkam.ProgramActivity;
import com.baitulmalfkam.baitulmalfkam.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DonasiFragment extends Fragment {

    GridLayout mainGrid;


    public DonasiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_donasi, container, false);

        mainGrid = rootView.findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

        return rootView;
    }

    private void setSingleEvent(final GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final String dhuafa =  getString(R.string.dhuafa_smart);
            final String yatim = getString(R.string.yatim_smart);
            final String muslim = getString(R.string.muslim_medical);
            final String dakwah = getString(R.string.dakwah_pendidikan);
            final String  tanggap = getString(R.string.tanggap_bencana);
            final String sarana = getString(R.string.sarana_ibadah);


          //  final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    switch (mainGrid.getChildCount()){
                        case 0:
                            Intent intent = new Intent(getActivity(),ProgramActivity.class);
                            intent.putExtra("info",dhuafa);
                            startActivity(intent);

                        case 1:
                            Intent intent1 = new Intent(getActivity(),ProgramActivity.class);
                            intent1.putExtra("info",yatim);
                            startActivity(intent1);

                        case 2:
                            Intent intent2 = new Intent(getActivity(),ProgramActivity.class);
                            intent2.putExtra("info",muslim);
                            startActivity(intent2);

                        case 3:
                            Intent intent3 = new Intent(getActivity(),ProgramActivity.class);
                            intent3.putExtra("info",dakwah);
                            startActivity(intent3);

                        case 4:
                            Intent intent4 = new Intent(getActivity(),ProgramActivity.class);
                            intent4.putExtra("info",tanggap);
                            startActivity(intent4);

                        case 5:
                            Intent intent5 = new Intent(getActivity(),ProgramActivity.class);
                            intent5.putExtra("info",sarana);
                            startActivity(intent5);
                    }
                }
            });
        }
    }

}

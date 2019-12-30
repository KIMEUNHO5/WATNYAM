package com.forif.watnyam.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.forif.watnyam.R;
import com.forif.watnyam.Round8Activity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WorldCupFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WorldCupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorldCupFragment extends Fragment {

    int[] imgs = {R.drawable.food1, R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food6,
            R.drawable.food7,R.drawable.food8,R.drawable.food9,R.drawable.food10,R.drawable.food11,R.drawable.food12,R.drawable.food13,
            R.drawable.food14,R.drawable.food15,R.drawable.food16};
    public static int[] r8 = new int[8];
    public static int a=0;

    ImageView image1;
    ImageView image2;
    public static int count=2;

    private OnFragmentInteractionListener mListener;

    public WorldCupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WorldCupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorldCupFragment newInstance(String param1, String param2) {
        WorldCupFragment fragment = new WorldCupFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worldcup, container, false);

        image1 = view.findViewById(R.id.image1);
        image2 = view.findViewById(R.id.image2);

        image1.setOnClickListener(new View.OnClickListener() {
            Intent intent1 = new Intent(getContext(), Round8Activity.class);
            @Override
            public void onClick(View view) {
                if(count>15){
                    r8[a] = count - 2;
                    count=0;
                    intent1.putExtra("key", r8);
                    startActivity(intent1);
                }
                image1.setImageResource(imgs[count]);
                image2.setImageResource(imgs[1 + count]);
                r8[a] = count - 2;
                count += 2;
                a ++;

            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            Intent intent1 = new Intent(getContext(), Round8Activity.class);
            @Override
            public void onClick(View view) {

                if(count>15){
                    r8[a] = count - 1;
//                    Log.d(TAG, "onClick: "+ r8[7]);
                    count=0;
                    intent1.putExtra("key", r8);
                    startActivity(intent1);
                }
                image1.setImageResource(imgs[count]);
                image2.setImageResource(imgs[1 + count]);
                r8[a] = count - 1;
                count += 2;
                a ++;

            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}

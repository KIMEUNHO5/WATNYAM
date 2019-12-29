package com.forif.watnyam.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.forif.watnyam.R;
import com.forif.watnyam.RouletteResultActivity;

import java.util.Timer;
import java.util.TimerTask;


public class RouletteFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    /* variable */
    Button bt1, bt2, bt3;
    ImageView food;
    boolean flag = false;


    public RouletteFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_roulette, container, false);
        /* starting */
        switching();

        /* image 캐스팅 */
        food = view.findViewById(R.id.cv);

        /* start 버튼 캐스팅 */
        bt1 = view.findViewById(R.id.bt1);
        click1 ck1 = new click1();
        bt1.setOnClickListener(ck1);

        /* stop 버튼 캐스팅 */
        bt2 = view.findViewById(R.id.bt2);
        click2 ck2 = new click2();
        bt2.setOnClickListener(ck2);

        /* ok 버튼 캐스팅 */
        bt3 = view.findViewById(R.id.bt3);
        click3 ck3 = new click3();
        bt3.setOnClickListener(ck3);

        // Inflate the layout for this fragment
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /* button1 :: start */
    class click1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (flag == false){
                flag = true;
            }
            else if(flag == true)
                flag = true;
        }
    }

    /* button2 :: stop */
    class click2 implements  View.OnClickListener{
        @Override
        public void onClick(View v){
            flag = false;
        }
    }

    /* button3 :: ok */
    class click3 implements  View.OnClickListener{
        @Override
        public void onClick(View v){

            Intent intent = new Intent(getContext() , RouletteResultActivity.class);
            intent.putExtra("ResultImage", resultNum);
            startActivity(intent);
        }
    }

    int foodlist[] = {
            R.drawable.bossam,
            R.drawable.budaejjigae,
            R.drawable.chicken,
            R.drawable.curry,
            R.drawable.doenjangstew,
            R.drawable.donburi,
            R.drawable.gopchang,
            R.drawable.hamburger,
            R.drawable.jajangmyeon,
            R.drawable.janchiguksu,
            R.drawable.jjamppong,
            R.drawable.jokbal,
            R.drawable.kimchistew,
            R.drawable.malatang,
            R.drawable.naengmyeon,
            R.drawable.pasta,
            R.drawable.pizza,
            R.drawable.porkbelly,
            R.drawable.porkcutlet,
            R.drawable.ramen,
            R.drawable.ricenoodles,
            R.drawable.sandwich,
            R.drawable.sushi,
            R.drawable.toast,
            R.drawable.tteokbokki,
            R.drawable.udon
    };


    int i = 0;
    static int resultNum = 0;

    void switching(){
        final Handler mhandle = new Handler();
        final Timer timer = new Timer();
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                mhandle.post(new Runnable() {
                    @Override
                    public void run() {
                        if(flag == true) {
                            resultNum = i;
                            food.setImageResource(foodlist[i++]);
                            if (i == foodlist.length)
                                i = 0;
                        }
                        else if(flag == false){
                            mhandle.removeMessages(0);
                        }
                    }
                });
            }
        };
        timer.schedule(task,0,500);
    }

}

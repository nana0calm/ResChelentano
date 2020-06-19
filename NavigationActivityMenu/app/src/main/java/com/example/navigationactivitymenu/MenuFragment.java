package com.example.navigationactivitymenu;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.RecyclerView;




import java.util.ArrayList;
import java.util.List;
import android.app.Activity;


public class MenuFragment extends ListFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static MenuFragment instance;
    private Activity activity;
//    MenuFragment s;
     List<DishItem> pizzas = new ArrayList<>();



    public MenuFragment() {
        // Required empty public constructor
    }
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


//    // TODO: Rename and change types and number of parameters
//    public static MenuFragment newInstance(String param1, String param2) {
//        MenuFragment fragment = new MenuFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//@Override
//public void onActivityCreated(Bundle savedInstanceState) {
//    super.onActivityCreated(savedInstanceState);
//
//
//
//}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    private void setInitialData() {

        pizzas.add(new DishItem("Берлин", "700р.", "830 грамм", R.drawable.berlin));
        pizzas.add(new DishItem("Кантри", "500р.", "840 грамм", R.drawable.cantry));
        pizzas.add(new DishItem("Баварская", "600р.", "940 грамм", R.drawable.bavarskaya));
        pizzas.add(new DishItem("Украинская", "550р.", "810 грамм", R.drawable.ukraine));
        pizzas.add(new DishItem("Спарта", "500р.", "860 грамм", R.drawable.sparta));
        pizzas.add(new DishItem("Лучано", "650р.", "650 грамм", R.drawable.luchano));
        pizzas.add(new DishItem("Мексиканка", "600р.", "860 грамм", R.drawable.mecsicanka));

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

     View v= inflater.inflate(R.layout.fragment_menu, container, false);

        setInitialData();
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.pizzaList);

        DishListAdapter  dishAdapter= new DishListAdapter(getContext(),pizzas);


        recyclerView.setAdapter(dishAdapter);

        return v;
    }





}
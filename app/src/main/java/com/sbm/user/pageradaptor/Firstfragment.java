package com.sbm.user.pageradaptor;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Firstfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Firstfragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String Country;
    private String City;
    private int flag;
    public Firstfragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static Firstfragment newInstance(PageWrapper pageWrapper) {
        Firstfragment fragment = new Firstfragment();
        Bundle args = new Bundle();
        args.putString("countries", pageWrapper.county);
        args.putString("City", pageWrapper.capital);
        args.putInt("Flag",pageWrapper.imageId);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Country = getArguments().getString("countries");
            City = getArguments().getString("City");
            flag=getArguments().getInt("Flag",0);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_firstfragment, container, false);
        TextView City1=(TextView)view.findViewById(R.id.City);
        TextView country=(TextView)view.findViewById(R.id.Country);
        City1.setText(City);
        country.setText(Country);
        ImageView imageview=(ImageView)view.findViewById(R.id.flag);
        imageview.setImageResource(flag);
        Button submit=(Button)view.findViewById(R.id.buttonsubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SubmitActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}

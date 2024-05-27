package com.example.shop.ui.description;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.shop.R;
import com.example.shop.databinding.FragmentDescriptionBinding;
import com.example.shop.models.ModelM;

import java.util.ArrayList;

public class DescriptionFragment extends Fragment {
    FragmentDescriptionBinding binding;

    ArrayList<ModelM> d_list = new ArrayList<>();
    DescAdapter adapter;
    NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        adapter = new DescAdapter(requireActivity());

        if(getArguments()!= null){
            d_list = getArguments().getParcelableArrayList("favorite");
        }else{
            Toast.makeText(requireActivity(),"the are nothing", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentDescriptionBinding.inflate(inflater,
                container, false);
        View root = binding.getRoot();

//        if(getArguments()!= null){
//            d_list = getArguments().getParcelableArrayList("favorite");
//        }else{
//            Toast.makeText(requireActivity(),"the are nothing", Toast.LENGTH_LONG).show();
//        }
//        adapter = new DescAdapter(requireActivity(),d_list)
        return root;
    }





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        if(d_list!=null){
            adapter.setListD(d_list);
        }else {
            Toast.makeText(requireActivity(), "Вы не выбрали товар", Toast.LENGTH_SHORT).show();
        }
        binding.rvDetailsCatalog.setAdapter(adapter);

        binding.btnBack.setOnClickListener(v2->{
            navController = Navigation.findNavController(requireActivity(),
                    R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_descriptionFragment_to_navigation_home);
        });
    }



}
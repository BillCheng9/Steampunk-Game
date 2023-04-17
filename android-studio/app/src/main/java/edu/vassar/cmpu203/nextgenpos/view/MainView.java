package edu.vassar.cmpu203.nextgenpos.view;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import edu.vassar.cmpu203.nextgenpos.databinding.FragmentStartScreenBinding;

public class MainView implements IMainView{
    FragmentManager fmanager;
    FragmentStartScreenBinding binding;
    public MainView(FragmentActivity activity){
        this.fmanager = activity.getSupportFragmentManager();
        this.binding = FragmentStartScreenBinding.inflate(activity.getLayoutInflater());
    }
    @Override
    public View getRootView() { return this.binding.getRoot(); }
    @Override
    public void displayFragment(Fragment fragment, boolean reversible, String name) {}
}

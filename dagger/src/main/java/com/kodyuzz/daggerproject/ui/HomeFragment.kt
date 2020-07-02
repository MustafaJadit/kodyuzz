package com.kodyuzz.daggerproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kodyuzz.daggerproject.MyApplication
import com.kodyuzz.daggerproject.R
import com.kodyuzz.daggerproject.di.component.DaggerFragmentComponent
import com.kodyuzz.daggerproject.scope.FragmentScope
import javax.inject.Inject


@FragmentScope
class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeViewModel;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        DaggerFragmentComponent
                .builder()
                .applicationComponent(((getActivity() as MainActivity).getApplication() as MyApplication).getApplicationComponent())
//                .fragmentModule(new FragmentModule())
                .build()
                .inject(this);
        viewModel.updateView();
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}

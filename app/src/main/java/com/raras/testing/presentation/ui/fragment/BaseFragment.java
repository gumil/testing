package com.raras.testing.presentation.ui.fragment;

import android.app.Fragment;

import com.raras.testing.injectors.HasComponent;

public class BaseFragment extends Fragment {

    protected <C> C getComponent(Class<C> component) {
        return component.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}

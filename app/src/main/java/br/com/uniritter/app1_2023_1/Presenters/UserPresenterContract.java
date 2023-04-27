package br.com.uniritter.app1_2023_1.Presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface UserPresenterContract {
    interface View {
        void setUsersAdapter(RecyclerView.Adapter adapter);
        Context getContexto();

    }
    interface Presenter {

        void getAllUsers();

    }
}

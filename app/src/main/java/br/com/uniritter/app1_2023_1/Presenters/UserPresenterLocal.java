package br.com.uniritter.app1_2023_1.Presenters;

import android.util.Log;

import java.util.ArrayList;

import br.com.uniritter.app1_2023_1.Adapters.UserAdapter;
import br.com.uniritter.app1_2023_1.models.User;
import br.com.uniritter.app1_2023_1.Repositories.UserRepository;

public class UserPresenterLocal implements UserPresenterContract.Presenter{

    UserPresenterContract.View view;
    public UserPresenterLocal(UserPresenterContract.View view) {
        this.view = view;
    }

    @Override
    public void getAllUsers() {
        System.out.println("antes->"+ UserRepository.getInstance().getUsers());
        ArrayList<User> users = new ArrayList<User>();
        User a = new User(1, "Gabriela","gabi", "g@g.com.br");
        users.add(a);
        User b = new User(2, "Bruno","bruno", "b@b.com.br");
        users.add(b);
        UserAdapter adapter = new UserAdapter(users);
        view.setUsersAdapter(adapter);


    }
}

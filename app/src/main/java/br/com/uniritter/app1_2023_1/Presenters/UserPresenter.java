package br.com.uniritter.app1_2023_1.Presenters;

import android.util.Log;

import java.util.ArrayList;

import br.com.uniritter.app1_2023_1.Adapters.UserAdapter;
import br.com.uniritter.app1_2023_1.Repositories.PostRepository;
import br.com.uniritter.app1_2023_1.Repositories.UserRepository;
import br.com.uniritter.app1_2023_1.Services.PostsService;
import br.com.uniritter.app1_2023_1.Services.UserService;

public class UserPresenter implements UserPresenterContract.Presenter{

    UserPresenterContract.View view;
    public UserPresenter(UserPresenterContract.View view) {
        this.view = view;
    }

    @Override
    public void getAllUsers() {
        System.out.println("antes->"+ UserRepository.getInstance().getUsers());

        UserService.getAllUsers(view.getContexto(), ()->{
            UserAdapter adapter = new UserAdapter(new ArrayList(UserRepository.getInstance().getUsers()));
            view.setUsersAdapter(adapter);

            PostsService.getAllPosts(view.getContexto(), ()->{
                Log.d("getAllPosts", PostRepository.getInstance().getPost(1).toString() );
                ;
            });
        });
    }
}

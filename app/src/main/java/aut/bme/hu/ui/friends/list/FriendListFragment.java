package aut.bme.hu.ui.friends.list;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import aut.bme.hu.mobszoft_projekt.R;


public class FriendListFragment extends Fragment {


    private UserProvider userProvider;

    private FriendRecyclerViewAdapter adapter;
    private  RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FriendListFragment() {
    }


    public static FriendListFragment newInstance(int columnCount) {
        FriendListFragment fragment = new FriendListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            adapter = new FriendRecyclerViewAdapter( userProvider);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof UserProvider) {
            userProvider = (UserProvider) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement UserProvider");
        }
    }

    @Override
    public void onAttach(Context context) {
        onAttach((Activity) context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        userProvider = null;
    }


    public void update(){
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void update(List<UserRow> rows){
        adapter.setFriends(rows);
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public interface UserProvider {
        void addFriendClicked(UserRow user);

        List<UserRow> getFriends();

        void showDetails(UserRow friend);

    }

}

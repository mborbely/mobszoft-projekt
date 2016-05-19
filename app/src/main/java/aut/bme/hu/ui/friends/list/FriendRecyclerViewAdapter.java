package aut.bme.hu.ui.friends.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import aut.bme.hu.mobszoft_projekt.R;
import aut.bme.hu.model.User;


public class FriendRecyclerViewAdapter extends RecyclerView.Adapter<FriendRecyclerViewAdapter.ViewHolder> {

    private final List<User> friends;
    private final FriendListFragment.UserProvider userProvider;

    public FriendRecyclerViewAdapter(FriendListFragment.UserProvider userProvider) {
        this.userProvider = userProvider;
        friends = userProvider.getFriends();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_friend_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.userModel = friends.get(position);
        holder.name.setText(holder.userModel.getName());
        holder.mView.setClickable(false);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != userProvider) {
                    userProvider.showDetails(holder.userModel);
                }
            }
        });

        holder.addFriendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != userProvider) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    v.setVisibility(View.INVISIBLE);
                    userProvider.userClicked(holder.userModel);
                    holder.mView.setClickable(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView name;
        public final Button addFriendButton;

        public User userModel;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            name = (TextView) view.findViewById(R.id.name);
            addFriendButton = (Button) view.findViewById(R.id.addfriend);
        }

    }


}

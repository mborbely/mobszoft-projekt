package aut.bme.hu.ui.friends.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import aut.bme.hu.mobszoft_projekt.R;


public class FriendRecyclerViewAdapter extends RecyclerView.Adapter<FriendRecyclerViewAdapter.ViewHolder> {

    private List<UserRow> friends;
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
        holder.name.setText(holder.userModel.getPerson().getName());
        final boolean isFriend = holder.userModel.isFriend();
        holder.mView.setClickable(isFriend);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != userProvider) {
                    if (isFriend){
                        userProvider.showDetails(holder.userModel);
                    }
                }
            }
        });

        if (isFriend){
            holder.addFriendButton.setVisibility(View.GONE);
        }

        holder.addFriendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != userProvider) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                        userProvider.addFriendClicked(holder.userModel);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public void setFriends(List<UserRow> rows){
        friends.clear();
        friends.addAll(rows);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView name;
        public final Button addFriendButton;

        public UserRow userModel;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            name = (TextView) view.findViewById(R.id.name);
            addFriendButton = (Button) view.findViewById(R.id.addfriend);
        }

    }


}

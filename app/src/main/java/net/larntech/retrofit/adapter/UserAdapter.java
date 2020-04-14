package net.larntech.retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.larntech.retrofit.R;
import net.larntech.retrofit.model.response.UserResponse;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterAh> implements Filterable {

    private List<UserResponse> userResponseList;
    private List<UserResponse> userResponseListFiltered;
    private Context context;
    private ClickListener onClickListener;

    public UserAdapter(ClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setData(List<UserResponse> userResponseList){
        this.userResponseList = userResponseList;
        this.userResponseListFiltered = userResponseList;
    }

    @NonNull
    @Override
    public UserAdapterAh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UserAdapter.UserAdapterAh(LayoutInflater.from(context).inflate(R.layout.row_users,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterAh holder, int position) {

        UserResponse userResponse = userResponseList.get(position);

        String username  =userResponse.getUsername();
        Boolean isActive = userResponse.isIs_active();
        holder.username.setText(username);

        String active;
        if(isActive){
            active = "A";
        }else{
            active = "D";
        }
        holder.prefix.setText(active);


        holder.view_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.clickedItem(userResponse);
            }
        });
    }

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = userResponseListFiltered.size();
                    filterResults.values = userResponseListFiltered;

                }else{

                    String searchStr = constraint.toString().toLowerCase();

                    List<UserResponse> resultData = new ArrayList<>();

                    for(UserResponse userResponse:userResponseListFiltered){
                        if(userResponse.getUsername().toLowerCase().contains(searchStr)){
                            resultData.add(userResponse);
                        }
                    }

                    filterResults.count = resultData.size();
                    filterResults.values = resultData;



                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                userResponseList = (List<UserResponse>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }


    public interface  ClickListener{
        void clickedItem(UserResponse userResponse);
    }

    @Override
    public int getItemCount() {
        return userResponseList.size();
    }

    public class UserAdapterAh extends RecyclerView.ViewHolder {
        TextView prefix;
        TextView username;
        ImageView view_user;


        public UserAdapterAh(@NonNull View itemView) {
            super(itemView);
            prefix = itemView.findViewById(R.id.prefix);
            username = itemView.findViewById(R.id.username);
            view_user = itemView.findViewById(R.id.view_details);


        }
    }
}

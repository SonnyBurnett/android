package nl.tsbakker.studentportal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

//
// Name:    PortalObjectAdapter
// Purpose: Handle the Adpter, which means connect the datamodel to the Reccycleview
//          Connection to the Recyclerview is done via the ViewHolder.
//          The Adapter is called to create new items (in the form of ViewHolders).
//          Provides the viewholders with data.
//          Returns information about data (how many items…).
// Author:  Taco Bakker
// Date:    25-9-2018
//

public class PortalObjectAdapter extends RecyclerView.Adapter<PortalObjectViewHolder> {
    private Context context;
    public List<PortalObject> listPortalObject;


    //
    // Constructor
    //
    public PortalObjectAdapter(Context context, List<PortalObject> listGeoObject) {
        this.context = context;
        this.listPortalObject = listPortalObject;
    }

    //
    // Adapter must always have these three methods (at least)
    // onCreateViewHolder
    // onBindViewHolder
    // getItemCount
    //

    // onCreateViewHolder
    // called when the RecyclerView instantiates a new ViewHolder instance
    // (inflates the items view from xml → creates them in code → return a new ViewHolder object).
    @Override
    public PortalObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_portalnames, parent, false);
        return new PortalObjectViewHolder(view);
    }


    // onBindViewHolder:
    // called when RecyclerView wants to populate the view with data from our model so that the user can see it.
    @Override
    public void onBindViewHolder(final PortalObjectViewHolder holder, final int position) {
        // Gets a single item in the list from its position
        final PortalObject geoObject = listPortalObject.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.portalTextView.setText("");
    }


    // getItemCount: returns the number of items in our data source.
    @Override
    public int getItemCount() {
        // return listGeoObject.size();
        return 0;
    }

    // Remove an item from the RecyclerView
    public void deleteItem(int index) {
        //listGeoObject.remove(index);
        //this.notifyItemRangeRemoved(index);
    }
}

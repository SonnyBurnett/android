package nl.tsbakker.studentportal;

//
// Name:    PortalObjectViewHolder
// Purpose: Handle the viewholder, which means translate the layout of the object in the Contentview to the Recycleview
//          It is the very object that represents each item in our collection and will be used to display it.
//          In other words: Used to provide the RecyclerView with new views when needed.
//          For example when scrolling
// Author:  Taco Bakker
// Date:    25-9-2018
//

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PortalObjectViewHolder extends RecyclerView.ViewHolder {
    public TextView portalTextView;
    public View view;

    public PortalObjectViewHolder(View itemView) {
        super(itemView);
        portalTextView = itemView.findViewById(R.id.portal_names);
        view = itemView;
    }
}

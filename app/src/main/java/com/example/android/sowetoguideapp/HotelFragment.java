package com.example.android.sowetoguideapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;


public class HotelFragment extends Fragment {

        Context context;

        private static final String ANONYMOUS = "House party";
        private static  final String DESCRIPTION = "the house party of the season";

        private ListView tToursListView;
        private TourAdapter tToursAdapter;
        private DatabaseReference tToursHeadDatabaseReference;
        private ChildEventListener tChildEventListener;
        private FirebaseDatabase tFirebaseDatabase;
        FirebaseStorage tFirebaseStorage;
        private StorageReference tPhotoStorageReference;
        String tDestinationDescription;
        String tDestinationName;



        public HotelFragment() {
        }



        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.tour_list, container, false);


            tFirebaseDatabase = FirebaseDatabase.getInstance();
            tFirebaseStorage = FirebaseStorage.getInstance();
            tDestinationName = ANONYMOUS;
            tDestinationDescription = DESCRIPTION;
            tToursHeadDatabaseReference = tFirebaseDatabase.getReference()
                    .child("hotel");

            tPhotoStorageReference = tFirebaseStorage.getReference().child("tour_photos");

            tToursListView = rootView.findViewById(R.id.list);
            final List<Tour> tours = new ArrayList<>();
            tToursAdapter = new TourAdapter(getActivity(),R.layout.list_item,tours);
            tToursListView.setAdapter(tToursAdapter);




            tChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Tour tour = dataSnapshot.getValue(Tour.class);
                    tToursAdapter.add(tour);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
            tToursHeadDatabaseReference.addChildEventListener(tChildEventListener);



            tToursListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    AlertDialog.Builder builder = new  AlertDialog.Builder(getActivity());

                    LayoutInflater inflater = getActivity().getLayoutInflater();
                    View dailogView = inflater.inflate(R.layout.activity_more_info,null);
                    ImageView photoImageView = dailogView.findViewById(R.id.profile_image_view);
                    TextView headTextView = dailogView.findViewById(R.id.profile_heading);
                    TextView descriptionTextView = dailogView.findViewById(R.id.profile_description);


                    Tour tour = tours.get(i);
                    boolean isPhoto = tour.getPhotoUrl() != null;
                    if  (isPhoto) {
                        Glide.with(photoImageView.getContext())
                                .load(tour.getPhotoUrl())
                                .into(photoImageView);

                        headTextView.setText(tour.getHead());
                        descriptionTextView.setText(tour.getDescription());

                    }

                    else {
                        photoImageView.setVisibility(View.GONE);
                        headTextView.setText(tour.getHead());
                        descriptionTextView.setText(tour.getDescription());
                    }
                    builder.setView(dailogView);
                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();

                }
            });







            return rootView;
        }



}

















package com.mmadapps.mysecondpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mmadapps.mysecondpro.utils.SimpleDividerItemDecoration;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView vL_atc_corporatepckglist;
    CorporatePackageAdapter corporatePackageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initializeViews();
    }

    private void initializeViews() {
        vL_atc_corporatepckglist= (RecyclerView) findViewById(R.id.vL_atc_corporatepckglist);

        corporatePackageAdapter =  new CorporatePackageAdapter();
        vL_atc_corporatepckglist.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this));
        vL_atc_corporatepckglist.setItemAnimator(new DefaultItemAnimator());
        vL_atc_corporatepckglist.setHasFixedSize(false);
        vL_atc_corporatepckglist.setAdapter(corporatePackageAdapter);
        vL_atc_corporatepckglist.addItemDecoration(new SimpleDividerItemDecoration(this));

    }


    public class CorporatePackageAdapter extends RecyclerView.Adapter<CorporatePackageAdapter.ViewHolder>
    {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent, false);
            return new CorporatePackageAdapter.ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(CorporatePackageAdapter.ViewHolder holder, final int position) {



            /*holder.vT_msl_radiostnname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    CorporatePckagedetails = parseJson.toJson(SelectedCorpratelist.get(position));
                    Intent iRedirectScreen = new Intent(AddtoCartActivity.this,SpecialPackageActivity.class);
                    iRedirectScreen.putExtra("ShowDetailsofSpcialpckg", CorporatePckagedetails);
                    iRedirectScreen.putExtra("AddCampRequired","no");
                    iRedirectScreen.putExtra("isSelected","false");
                    startActivity(iRedirectScreen);

                }
            });*/



        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {


            TextView vT_msl_radiostnname,vT_msl_campaignfinalvalue,vT_msl_stn,vT_msl_totalcount;
            ImageView vI_msl_delete,vI_msl_edit;

            public ViewHolder(View itemView) {
                super(itemView);

                vT_msl_radiostnname = (TextView) itemView.findViewById(R.id.vT_msl_radiostnname);
                vT_msl_campaignfinalvalue = (TextView) itemView.findViewById(R.id.vT_msl_campaignfinalvalue);
                vT_msl_stn= (TextView) itemView.findViewById(R.id.vT_msl_stn);
                vT_msl_totalcount= (TextView) itemView.findViewById(R.id.vT_msl_totalcount);
                vI_msl_delete= (ImageView) itemView.findViewById(R.id.vI_msl_delete);
                vI_msl_edit= (ImageView) itemView.findViewById(R.id.vI_msl_edit);

            }
        }

    }








}

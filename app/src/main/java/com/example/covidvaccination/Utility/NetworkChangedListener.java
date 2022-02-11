package com.example.covidvaccination.Utility;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import com.example.covidvaccination.R;

public class NetworkChangedListener extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
        if(!Common.isConnectedToInternet(context)){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View layout_Dialog = LayoutInflater.from(context).inflate(R.layout.alert_diagram,null);
            builder.setView(layout_Dialog);

            AppCompatButton btnRetry = layout_Dialog.findViewById(R.id.btnRetry);
            final AlertDialog dialog = builder.create();
            dialog.show();
            dialog.setCancelable(false);

            dialog.getWindow().setGravity(Gravity.CENTER);

            btnRetry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    onReceive(context,intent);
                }
            });
        }
    }
}

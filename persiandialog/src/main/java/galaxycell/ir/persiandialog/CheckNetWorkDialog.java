package galaxycell.ir.persiandialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by MrRadio on 10/22/2018.
 */

public class CheckNetWorkDialog {

    public Dialog dialog;
    private LinearLayout mainLayout;
    public TextView message,tWifi;
    public ImageView iWifi;

    public CheckNetWorkDialog(Context context)
    {
        // define Dialog
        dialog=new Dialog(context, R.style.PauseDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.check_network_dialog_layout);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background_border);

        //define widget Dialog
        mainLayout=(LinearLayout)dialog.findViewById(R.id.check_network_dialog_layout_linearLayout_mainLayout);
        message=(TextView)dialog.findViewById(R.id.check_network_dialog_layout_textView_message);
        tWifi=(TextView)dialog.findViewById(R.id.check_network_dialog_layout_textView_wifi);
        iWifi=(ImageView)dialog.findViewById(R.id.check_network_dialog_layout_imageView_wifi);


        //set size
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mainLayout.getLayoutParams().width=displaymetrics.widthPixels-20;
    }
}

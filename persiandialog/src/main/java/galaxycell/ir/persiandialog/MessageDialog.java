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

public class MessageDialog {

    public Dialog dialog;
    private LinearLayout mainLayout;
    public TextView message,tOK;
    public ImageView iOK;

    public MessageDialog(Context context)
    {
        // define Dialog
        dialog=new Dialog(context, R.style.PauseDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.message_dialog_layout);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background_border);

        //define widget Dialog
        mainLayout=(LinearLayout)dialog.findViewById(R.id.message_dialog_layout_linearLayout_mainLayout);
        message=(TextView) dialog.findViewById(R.id.message_dialog_layout_textView_message);
        tOK=(TextView)dialog.findViewById(R.id.message_dialog_layout_textView_ok);
        iOK=(ImageView)dialog.findViewById(R.id.message_dialog_layout_imageView_ok);



        //set size
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mainLayout.getLayoutParams().width=displaymetrics.widthPixels-20;
    }
}

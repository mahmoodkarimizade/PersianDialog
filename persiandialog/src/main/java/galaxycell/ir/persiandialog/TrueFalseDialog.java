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
 * Created by MrRadio on 10/23/2018.
 */

public class TrueFalseDialog {

    public Dialog dialog;
    private LinearLayout mainLayout;
    public TextView message,tTrue,tFalse;
    public ImageView iTrue,iFalse;

    public TrueFalseDialog(Context context)
    {
        // define Dialog
        dialog=new Dialog(context, R.style.PauseDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.true_false_dialog_layout);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background_border);

        //define widget Dialog
        mainLayout=(LinearLayout)dialog.findViewById(R.id.true_false_dialog_layout_linearLayout_mainLayout);
        message=(TextView)dialog.findViewById(R.id.true_false_dialog_layout_textView_message);
        tTrue=(TextView)dialog.findViewById(R.id.true_false_dialog_layout_textView_true);
        tFalse=(TextView)dialog.findViewById(R.id.true_false_dialog_layout_textView_false);
        iTrue=(ImageView) dialog.findViewById(R.id.true_false_dialog_layout_ImageView_true);
        iFalse=(ImageView) dialog.findViewById(R.id.true_false_dialog_layout_imageView_false);


        //set size
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mainLayout.getLayoutParams().width=displaymetrics.widthPixels-20;
    }
}

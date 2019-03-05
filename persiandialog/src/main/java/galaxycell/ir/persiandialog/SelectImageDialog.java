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

public class SelectImageDialog
{
    public Dialog dialog;
    private LinearLayout mainLayout;
    public ImageView iGallery,iCamera;
    public TextView message ,tGallery,tCamera;

    public SelectImageDialog(Context context)
    {
        // define Dialog
        dialog=new Dialog(context, R.style.PauseDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.selectimage_dialog_layout);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background_border);

        //define widget Dialog
        mainLayout=(LinearLayout)dialog.findViewById(R.id.selectimage_dialog_layout_cardView_mainLayout);
        message=(TextView)dialog.findViewById(R.id.selectimage_dialog_layout_textView_message);
        tGallery=(TextView)dialog.findViewById(R.id.selectimage_dialog_layout_textView_gallery);
        tCamera=(TextView)dialog.findViewById(R.id.selectimage_dialog_layout_textView_camera);
        iGallery=(ImageView) dialog.findViewById(R.id.selectimage_dialog_layout_imageView_gallery);
        iCamera=(ImageView) dialog.findViewById(R.id.selectimage_dialog_layout_imageView_camera);

        //set size
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mainLayout.getLayoutParams().width=displaymetrics.widthPixels-20;
    }
}

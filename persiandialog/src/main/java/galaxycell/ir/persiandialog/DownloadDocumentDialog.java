package galaxycell.ir.persiandialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * Created by MrRadio on 10/23/2018.
 */

public class DownloadDocumentDialog {
    public Dialog dialog;
    private LinearLayout mainLayout;
    public LinearLayout okLayout;
    public ProgressBar progressBar;
    public TextView message,percent,afterDownload,tOK;
    public ImageView iOK;

    public DownloadDocumentDialog(Context context)
    {
        // define Dialog
        dialog=new Dialog(context, R.style.PauseDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.download_document_dialog_layout);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background_border);
        dialog.setCancelable(false);

        //define widget Dialog
        mainLayout=(LinearLayout) dialog.findViewById(R.id.download_document_dialog_layout_linearLayout_mainLayout);
        okLayout=(LinearLayout) dialog.findViewById(R.id.download_document_dialog_layout_linearLayout_okLayout);
        progressBar=(ProgressBar) dialog.findViewById(R.id.download_document_dialog_layout_progressBar);
        message=(TextView)dialog.findViewById(R.id.download_document_dialog_layout_textView_message);
        percent=(TextView)dialog.findViewById(R.id.download_document_dialog_layout_textView_percent);
        afterDownload=(TextView)dialog.findViewById(R.id.download_document_dialog_layout_textView_afterDownload);
        tOK=(TextView)dialog.findViewById(R.id.download_document_dialog_layout_textView_ok);
        iOK=(ImageView) dialog.findViewById(R.id.download_document_dialog_layout_imageView_ok);

        //set size
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mainLayout.getLayoutParams().width=displaymetrics.widthPixels-20;

    }
}

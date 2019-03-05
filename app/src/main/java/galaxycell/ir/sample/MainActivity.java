package galaxycell.ir.sample;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import galaxycell.ir.persiandialog.CheckNetWorkDialog;
import galaxycell.ir.persiandialog.DownloadDocumentDialog;
import galaxycell.ir.persiandialog.MessageDialog;
import galaxycell.ir.persiandialog.SelectImageDialog;
import galaxycell.ir.persiandialog.TrueFalseDialog;

public class MainActivity extends AppCompatActivity
{

    private Button B1,B2,B3,B4,B5;
    private String typeFile,fileName,fileUrl;
    private TrueFalseDialog trueFalseDialog;
    private MessageDialog messageDialog;
    private CheckNetWorkDialog checkNetWorkDialog;
    private SelectImageDialog selectImageDialog;
    private DownloadDocumentDialog downloadDocumentDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        B1=(Button)findViewById(R.id.main_activity_button1);
        B2=(Button)findViewById(R.id.main_activity_button2);
        B3=(Button)findViewById(R.id.main_activity_button3);
        B4=(Button)findViewById(R.id.main_activity_button4);
        B5=(Button)findViewById(R.id.main_activity_button5);


        //define true and false dialog
        trueFalseDialog=new TrueFalseDialog(this);
        trueFalseDialog.message.setText("Your Question ?");
        trueFalseDialog.tFalse.setText("Cancel");
        trueFalseDialog.tTrue.setText("OK");
        trueFalseDialog.iFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //do some thing
                trueFalseDialog.dialog.dismiss();
            }
        });
        trueFalseDialog.iTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //do some thing
                trueFalseDialog.dialog.dismiss();
            }
        });


        //define message dialog
        messageDialog=new MessageDialog(this);
        messageDialog.message.setText("Your Message !");
        messageDialog.tOK.setText("OK");
        messageDialog.iOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //do some thing
                messageDialog.dialog.dismiss();
            }
        });

        //define check network dialog
        checkNetWorkDialog=new CheckNetWorkDialog(this);
        checkNetWorkDialog.message.setText("Plz check your network and try again!");
        checkNetWorkDialog.tWifi.setText("OK");
        checkNetWorkDialog.iWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //do some thing
                checkNetWorkDialog.dialog.dismiss();
            }
        });

        //define select image Dialog
        selectImageDialog=new SelectImageDialog(this);
        selectImageDialog.message.setText("plz select your image!");
        selectImageDialog.tCamera.setText("Camera");
        selectImageDialog.tGallery.setText("Gallery");
        selectImageDialog.iCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //do some thing
                selectImageDialog.dialog.dismiss();
            }
        });
        selectImageDialog.iCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //do some thing
                selectImageDialog.dialog.dismiss();
            }
        });


        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                trueFalseDialog.dialog.show();
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                messageDialog.dialog.show();
            }
        });

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkNetWorkDialog.dialog.show();
            }
        });

        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectImageDialog.dialog.show();
            }
        });

        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DownloadFileFromURL().execute("https://github.com/mahmoodkarimizade/PersianDialog/blob/master/PersianDialog.gif");
            }
        });

    }



    //Background Async Task to download file
    public class DownloadFileFromURL extends AsyncTask<String, String, String>
    {

        //Before starting background thread Show Progress Bar Dialog
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            //define download document dialog
            downloadDocumentDialog=new DownloadDocumentDialog(MainActivity.this);
            downloadDocumentDialog.message.setText("Document Downloading ...");
            downloadDocumentDialog.tOK.setText("OK");
            downloadDocumentDialog.afterDownload.setText("Your message after download ...");
            downloadDocumentDialog.okLayout.setVisibility(View.GONE);
            downloadDocumentDialog.afterDownload.setVisibility(View.GONE);
            downloadDocumentDialog.dialog.show();


        }


        //Downloading file in background thread
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try
            {
                URL url = new URL(f_url[0]);
                fileUrl=f_url[0];
                URLConnection conection = url.openConnection();
                conection.connect();

                // this will be useful so that you can show a tipical 0-100%
                // progress bar
                int lenghtOfFile = conection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(),8192);

                // get type file from path file


                String [] m=url.toString().split("\\.");
                typeFile = m[m.length-1].toLowerCase();
                fileName= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());


                // create folder in sdk for save download files
                File myDirectory = new File(Environment.getExternalStorageDirectory(), "/PersianDialog");
                if(!myDirectory.exists())
                {
                    myDirectory.mkdirs();
                }

                // Output stream
                OutputStream output = new FileOutputStream(Environment.getExternalStorageDirectory().toString()+"/PersianDialog/"+fileName+"."+typeFile);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();
                return  myDirectory.getPath()+"/";

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        //Updating progress bar
        protected void onProgressUpdate(String... progress) {
            downloadDocumentDialog.progressBar.setProgress(Integer.parseInt(progress[0]));
            downloadDocumentDialog.percent.setText(String.valueOf(progress[0]) + "%");

        }


        //After completing background task Dismiss the progress dialog

        @Override
        protected void onPostExecute(final String path)
        {
            downloadDocumentDialog.okLayout.setVisibility(View.VISIBLE);
            downloadDocumentDialog.afterDownload.setVisibility(View.VISIBLE);
            downloadDocumentDialog.iOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //do some thing
                    downloadDocumentDialog.dialog.dismiss();
                }
            });


        }

    }
}

package android.com.rootchecker;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.WindowCallbackWrapper;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView Text1,Text2,Text3,Text4;
    Button bt1;
    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    img1=(ImageView)findViewById(R.id.img);
    Text1=(TextView)findViewById(R.id.textView5);
    Text2=(TextView)findViewById(R.id.textView6);
    Text3=(TextView)findViewById(R.id.textView7);
    Text4=(TextView)findViewById(R.id.textView8);
    bt1=(Button)findViewById(R.id.button2);
    bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String command[] = { "su", "-c", "ls", "/data" };
            Shell shell = new Shell();
            String text = shell.sendShellCommand(command);
            if ((text.indexOf("app") > -1) || (text.indexOf("anr") > -1)
                    || (text.indexOf("user") > -1)
                    || (text.indexOf("data") > -1)) {
                // setNewTextInTextView("This phone is not rooted");
                // //Debugging
                img1.setBackgroundResource(R.drawable.tick);
            } else {
                // setNewTextInTextView("This phone is rooted!");
                // //Debugging
                img1.setBackgroundResource(R.drawable.cross);
            }
        }
    });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String curModel = Build.MODEL;
        String curProduct = Build.PRODUCT;
        String curMan = Build.MANUFACTURER;
        String curBrand = Build.BRAND;
        String curDevice = Build.DEVICE;
        String curVer = Build.VERSION.RELEASE;


        Text1.setText("Device:"+curDevice);
        Text2.setText("Model:"+curModel);
        Text3.setText("Manufacturer:"+curMan);
        Text4.setText("Android Version:"+curVer);

    }

}


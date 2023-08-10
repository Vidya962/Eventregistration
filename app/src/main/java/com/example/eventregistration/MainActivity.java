package com.example.eventregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner eventspinner;
    private Spinner aboutspinner;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    //

  //  String messagestr, contact_number= "";

    private Button register;








    private TextView Design,Backend_development,VFX_animations,Videography,Phototyping,Figma,Others;
    private EditText firstname,lastname,emailid,mobile_number,website,bio,github,twitter;
    private RadioGroup gender;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventspinner=findViewById(R.id.spinner1);
        aboutspinner=findViewById(R.id.spinner2);

        //
        Design=findViewById(R.id.text1);
        Backend_development=findViewById(R.id.text2);
        VFX_animations=findViewById(R.id.text3);
        Videography=findViewById(R.id.text4);
        Phototyping=findViewById(R.id.text5);
        Figma=findViewById(R.id.text6);
        Others=findViewById(R.id.text7);
        firstname=findViewById(R.id.txtfirstname);
        lastname=findViewById(R.id.txtlastname);
        emailid=findViewById(R.id.email);
        mobile_number=findViewById(R.id.phonenumber);
        website=findViewById(R.id.txtwebsite);
        bio=findViewById(R.id.txtbio);
        github=findViewById(R.id.txtgithub);
        twitter=findViewById(R.id.txttwitter);
        gender=findViewById(R.id.radiogroup);

        register=findViewById(R.id.signing);

        reference=FirebaseDatabase.getInstance().getReference();

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.passes,R.layout.spinner_codes);
        adapter.setDropDownViewResource(R.layout.my_spinner_dropdown);
        eventspinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this, R.array.Medias,R.layout.spinner_codes1);
        adapter1.setDropDownViewResource(R.layout.my_spinner_dropdown1);
        aboutspinner.setAdapter(adapter1);


        // Set a single click listener for all TextViews
        View.OnClickListener textViewClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) view;
                textView.setSelected(!textView.isSelected()); // Toggle selection state
                updateTextViewState(textView);
            }
        };
        Design.setOnClickListener(textViewClickListener);
        Backend_development.setOnClickListener(textViewClickListener);
        VFX_animations.setOnClickListener(textViewClickListener);
        Videography.setOnClickListener(textViewClickListener);
        Phototyping.setOnClickListener(textViewClickListener);
        Figma.setOnClickListener(textViewClickListener);
        Others.setOnClickListener(textViewClickListener);

     /*   Design.setOnClickListener(new View.OnClickListener() {
            private boolean stateChanged;
            public void onClick(View view) {
                if(stateChanged) {
                    // reset background to default;
                    Design.setBackgroundResource(R.drawable.textview_bg);
                    Design.setTextColor(Color.WHITE);

                } else {
                    Design.setBackgroundResource(R.drawable.choice_bg);
                    Design.setTextColor(Color.BLACK);
                }
                stateChanged = !stateChanged;
            }
        });

        Backend_development.setOnClickListener(new View.OnClickListener() {
            private boolean stateChanged;
            public void onClick(View view) {
                if(stateChanged) {
                    // reset background to default;
                    Backend_development.setBackgroundResource(R.drawable.textview_bg);
                    Backend_development.setTextColor(Color.WHITE);

                } else {
                    Backend_development.setBackgroundResource(R.drawable.choice_bg);
                    Backend_development.setTextColor(Color.BLACK);
                }
                stateChanged = !stateChanged;
            }
        });


        VFX_animations.setOnClickListener(new View.OnClickListener() {
            private boolean stateChanged;
            public void onClick(View view) {
                if(stateChanged) {
                    // reset background to default;
                    VFX_animations.setBackgroundResource(R.drawable.textview_bg);
                    VFX_animations.setTextColor(Color.WHITE);

                } else {
                    VFX_animations.setBackgroundResource(R.drawable.choice_bg);
                    VFX_animations.setTextColor(Color.BLACK);
                }
                stateChanged = !stateChanged;
            }
        });

        Videography.setOnClickListener(new View.OnClickListener() {
            private boolean stateChanged;
            public void onClick(View view) {
                if(stateChanged) {
                    // reset background to default;
                    Videography.setBackgroundResource(R.drawable.textview_bg);
                    Videography.setTextColor(Color.WHITE);
                } else {
                    Videography.setBackgroundResource(R.drawable.choice_bg);
                    Videography.setTextColor(Color.BLACK);
                }
                stateChanged = !stateChanged;
            }
        });

        Phototyping.setOnClickListener(new View.OnClickListener() {
            private boolean stateChanged;
            public void onClick(View view) {
                if(stateChanged) {
                    // reset background to default;
                    Phototyping.setBackgroundResource(R.drawable.textview_bg);
                    Phototyping.setTextColor(Color.WHITE);
                } else {
                    Phototyping.setBackgroundResource(R.drawable.choice_bg);
                    Phototyping.setTextColor(Color.BLACK);
                }
                stateChanged = !stateChanged;
            }
        });

        Figma.setOnClickListener(new View.OnClickListener() {
            private boolean stateChanged;
            public void onClick(View view) {
                if(stateChanged) {
                    // reset background to default;
                    Figma.setBackgroundResource(R.drawable.textview_bg);
                    Figma.setTextColor(Color.WHITE);
                } else {
                    Figma.setBackgroundResource(R.drawable.choice_bg);
                    Figma.setTextColor(Color.BLACK);
                }
                stateChanged = !stateChanged;
            }
        });

       Others.setOnClickListener(new View.OnClickListener() {
            private boolean stateChanged;
            public void onClick(View view) {
                if(stateChanged) {
                    // reset background to default;
                    Others.setBackgroundResource(R.drawable.textview_bg);
                   Others.setTextColor(Color.WHITE);


                } else {
                   Others.setBackgroundResource(R.drawable.choice_bg);
                    Others.setTextColor(Color.BLACK);
                }
                stateChanged = !stateChanged;
            }
        });*/

       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String First_name=firstname.getText().toString();
               String Last_name=lastname.getText().toString();
               String Email_id=emailid.getText().toString();
               String Phone_number=mobile_number.getText().toString();
               String Website=website.getText().toString();
               String Bio=bio.getText().toString();
               String Github=github.getText().toString();
               String Twitter=twitter.getText().toString();
               String selectedTextView = getSelectedtextview();
             //  String Backend_developments=Backend_development.getText().toString();
              // String Designs=Design.getText().toString();
              // String VFX_Animations=VFX_animations.getText().toString();
             //  String Videographys=Videography.getText().toString();
            //   String Phototypings=Phototyping.getText().toString();
             //  String Figmas=Figma.getText().toString();
             //  String Other=Others.getText().toString();
               String radioSelection = ((RadioButton) findViewById(gender.getCheckedRadioButtonId())).getText().toString();
               String dropdownSelection1 = eventspinner.getSelectedItem().toString();
               String dropdownSelection2 = aboutspinner.getSelectedItem().toString();

               modelclass modelclass = new modelclass(First_name,Last_name,Email_id,Phone_number,selectedTextView
                       ,Website,Bio,Github,
                       Twitter,radioSelection,dropdownSelection1,dropdownSelection2);

               firebaseDatabase=FirebaseDatabase.getInstance();
               reference=firebaseDatabase.getReference().child("details");

               reference.push().setValue(modelclass);


               Toast.makeText(MainActivity.this, "details are added", Toast.LENGTH_SHORT).show();

               if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){

                   if(checkSelfPermission(android.Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){

                       sendSMS();

                   }else {
                       requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                   }

               }

               //


             //  messagestr = firstname.getText().toString();
             //  contact_number = mobile_number.getText().toString();

            /*   if (!First_name.isEmpty() && !Phone_number.isEmpty()) {

                //   countryCodePicker.registerCarrierNumberEditText(mobile_number);
                //   phonestr = countryCodePicker.getFullNumber();

                   if (isWhatappInstalled()){

                       Intent i = new Intent(Intent.ACTION_VIEW);
                       //, Uri.parse("https://api.whatsapp.com/send?phone="+Phone_number+
                      //         "&text="+First_name));

                       i.setData(Uri.parse("http://api.whatsapp.com/send?phone="+Phone_number +"&text="+First_name));
                       startActivity(i);
                       firstname.setText("");
                       mobile_number.setText("");


                   }else {

                       Toast.makeText(MainActivity.this,"Whatsapp is not installed",Toast.LENGTH_SHORT).show();

                   }


               } else {

                   Toast.makeText(MainActivity.this, "Please fill in the Phone no. and message it can't be empty", Toast.LENGTH_LONG).show();

               }*/


               //

               boolean installed = appInstalledOrNot("com.whatsapp");
               if (installed){
                   Intent intent = new Intent(Intent.ACTION_VIEW);
                   intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+Phone_number + "&text="+First_name+"\n"+Last_name+"\n"+Github+"\n"+Twitter+"\n"+selectedTextView
                           +"\n"+dropdownSelection1+"\n"+dropdownSelection2+"\n"+"thank you for register"));
                   startActivity(intent);
               }else {
                   Toast.makeText(MainActivity.this, "Whats app not installed on your device", Toast.LENGTH_SHORT).show();
               }


           }
       });
    }

    private boolean appInstalledOrNot(String url) {

        PackageManager packageManager =getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(url,PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }catch (PackageManager.NameNotFoundException e){
            app_installed = false;
        }
        return app_installed;
    }

    /* private boolean isWhatappInstalled() {
          PackageManager packageManager = getPackageManager();
          boolean whatsappInstalled;

          try {

              packageManager.getPackageInfo("com.whatsapp",PackageManager.GET_ACTIVITIES);
              whatsappInstalled = true;


          }catch (PackageManager.NameNotFoundException e){

              whatsappInstalled = false;

          }

          return whatsappInstalled;

      }*/
    private void sendSMS() {
        String First_name=firstname.getText().toString();
        String Last_name=lastname.getText().toString();
        String phoneNo=mobile_number.getText().toString();
       // String textmessage=message.getText().toString().trim();
        String Github=github.getText().toString();
        String Twitter=twitter.getText().toString();
        String selectedTextView = getSelectedtextview();
        String dropdownSelection1 = eventspinner.getSelectedItem().toString();
        String dropdownSelection2 = aboutspinner.getSelectedItem().toString();

        try {

            SmsManager smsManager=SmsManager.getDefault();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                smsManager.sendTextMessage(phoneNo,null,First_name +"\n"+Last_name+"\n"+Github+"\n"+Twitter+"\n"+selectedTextView
                        +"\n"+dropdownSelection1+"\n"+dropdownSelection2+"\n"+"thank you for register",null,null);
            }

            Toast.makeText(this, "message sent", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "message not sent", Toast.LENGTH_SHORT).show();
        }
    }

    private String getSelectedtextview() {
        List<String> selectedPreferences = new ArrayList<>();

        if (Design.isSelected()) {
            selectedPreferences.add(Design.getText().toString());
            return Design.getText().toString();
        } else if (Backend_development.isSelected()) {
            selectedPreferences.add(Backend_development.getText().toString());
            return Backend_development.getText().toString();
        } else if (VFX_animations.isSelected()) {
            selectedPreferences.add(VFX_animations.getText().toString());
            return VFX_animations.getText().toString();
        } else if (Videography.isSelected()) {
            selectedPreferences.add(Videography.getText().toString());
            return Videography.getText().toString();
        } else if (Phototyping.isSelected()) {
            selectedPreferences.add(Phototyping.getText().toString());
            return Phototyping.getText().toString();
        } else if (Figma.isSelected()) {
            selectedPreferences.add(Figma.getText().toString());
            return Figma.getText().toString();
        } else if (Others.isSelected()) {
            selectedPreferences.add(Others.getText().toString());
            return Others.getText().toString();
        } else {
            return ""; // No text view selected

        }
    }
    private void updateTextViewState(TextView textView) {

        String selectedPreference = textView.getText().toString();
        boolean isSelected = textView.isSelected();


        if (textView.isSelected()) {
            textView.setBackgroundResource(R.drawable.textview_bg);
            textView.setTextColor(Color.WHITE);
        } else {
            textView.setBackgroundResource(R.drawable.choice_bg);
            textView.setTextColor(Color.BLACK);
        }
        // Update the Firebase database
        //
         reference.child(selectedPreference).child("SelectedPreferences").child(selectedPreference).setValue(isSelected);
    }
}
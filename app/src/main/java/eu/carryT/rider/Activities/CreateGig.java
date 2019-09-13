package eu.carryT.rider.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


import eu.carryT.rider.R;

import static eu.carryT.rider.Activities.MainActivity.NEW_GIG;

public class CreateGig extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    // input variables

    EditText gigName;
    EditText gigValue;
    RadioGroup check;

    RadioGroup personMeet;
    RadioGroup pickUpChoice;

    EditText deliveryLocation;
    EditText optionalDeliveryLocation;
    RadioGroup personReceiving;
    CheckBox signature;

    EditText time;
    CalendarView date;

    RadioGroup additional_note_check;
    EditText additional_note;


    // Controller variables used by Gig Information

    FrameLayout gigInfo;
    TextView gigLabel;
    TextView gigLabel1;
    ImageView tick;

    // Controller variables used by Pickup Location

    TextView pickUpLabel;
    TextView pickUpLabel1;
    FrameLayout pickup;

    // Controller variables used by Delivery Location
    TextView deliveryLabel;
    TextView deliveryLabel1;
    FrameLayout delivery;

    // Controller variables used by Deadline
    TextView deliveryDeadLabel;
    TextView deliveryDeadLabel1;
    FrameLayout deliveryDeadLine;

    // Controller variables used by Additional Details
    TextView additionalDetailLabel;
    TextView additionalDetailLabel1;
    FrameLayout additionalDetail;

    // Controller variable used by Insurance
    TextView insuranceLabel;
    TextView insuranceLabel1;
    FrameLayout insurance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_gig);
    }

    public void Gig_InfoClick(View view) {

        gigInfo = findViewById(R.id.fragment_container1);
        gigLabel = findViewById(R.id.gig_information_label);
        gigLabel1 = findViewById(R.id.gig_information_label_noclick);

        gigLabel.setVisibility(View.GONE);
        gigInfo.setVisibility(View.VISIBLE);
        gigLabel1.setVisibility(View.VISIBLE);
    }

    public void upLoadImage(View view) {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView imageView = findViewById(R.id.image_containar);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void pickUpLocationClick(View view) {

        tick = findViewById(R.id.gig_information_label_tick);
        gigLabel = findViewById(R.id.gig_information_label);
        deliveryLabel = findViewById(R.id.delivery_location_label);
        pickUpLabel1 = findViewById(R.id.pickup_location_label1);
        pickup = findViewById(R.id.fragment_container2);

        check = findViewById(R.id.cagro_size);
        gigName = findViewById(R.id.gig_name_input);
        gigValue = findViewById(R.id.item_value);

        gigInfo = findViewById(R.id.fragment_container1);
        gigLabel1 = findViewById(R.id.gig_information_label_noclick);
        deliveryLabel1 = findViewById(R.id.delivery_location_label1);
        pickUpLabel = findViewById(R.id.pickup_location_label);

        if (check.getCheckedRadioButtonId() != -1 && !gigName.getText().toString().isEmpty() && !gigValue.getText().toString().isEmpty()) {
            gigInfo.setVisibility(View.GONE);
            gigLabel1.setVisibility(View.GONE);
            deliveryLabel1.setVisibility(View.GONE);
            pickUpLabel.setVisibility(View.GONE);

            tick.setVisibility(View.VISIBLE);
            gigLabel.setVisibility(View.VISIBLE);
            deliveryLabel.setVisibility(View.VISIBLE);
            pickUpLabel1.setVisibility(View.VISIBLE);
            pickup.setVisibility(View.VISIBLE);
        } else {
            if (check.getCheckedRadioButtonId() == -1) {
                Toast.makeText(getApplicationContext(), "Select At least one cargo sise", Toast.LENGTH_SHORT).show();
            } else if (gigName.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Gig name is missing", Toast.LENGTH_SHORT).show();
            } else if (gigValue.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Gig Value is missing", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Some thing Want wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void deliveryLocationClick(View view) {

        personMeet = findViewById(R.id.personmeet_at_loaction);
        pickUpChoice = findViewById(R.id.earliest_pickup);

        gigLabel1 = findViewById(R.id.gig_information_label_noclick);
        pickUpLabel = findViewById(R.id.pickup_location_label);
        tick = findViewById(R.id.pickup_from_location_tick);
        deliveryLabel1 = findViewById(R.id.delivery_location_label1);
        delivery = findViewById(R.id.fragment_container3);
        deliveryDeadLabel = findViewById(R.id.delivery_deadline_label);

        gigLabel = findViewById(R.id.gig_information_label);
        pickUpLabel1 = findViewById(R.id.pickup_location_label1);
        deliveryLabel = findViewById(R.id.delivery_location_label);
        pickup = findViewById(R.id.fragment_container2);
        deliveryDeadLabel1 = findViewById(R.id.delivery_deadline_label1);

        if (personMeet.getCheckedRadioButtonId() != -1 && pickUpChoice.getCheckedRadioButtonId() != -1) {
            gigLabel.setVisibility(View.GONE);
            pickUpLabel1.setVisibility(View.GONE);
            pickup.setVisibility(View.GONE);
            deliveryLabel.setVisibility(View.GONE);
            deliveryDeadLabel1.setVisibility(View.GONE);

            gigLabel1.setVisibility(View.VISIBLE);
            pickUpLabel.setVisibility(View.VISIBLE);
            deliveryLabel1.setVisibility(View.VISIBLE);
            deliveryDeadLabel.setVisibility(View.VISIBLE);
            tick.setVisibility(View.VISIBLE);
            delivery.setVisibility(View.VISIBLE);

        } else {
            if (personMeet.getCheckedRadioButtonId() == -1) {
                Toast.makeText(getApplicationContext(), "Select Who will come to meet", Toast.LENGTH_SHORT).show();
            } else if (pickUpChoice.getCheckedRadioButtonId() == -1) {
                Toast.makeText(getApplicationContext(), "Select Pick Up Time", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Some thing Want wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void deliveryDeadLineClick(View view) {

        deliveryLocation = findViewById(R.id.delivery_location);
        optionalDeliveryLocation = findViewById(R.id.optional_delivery_location);
        personReceiving = findViewById(R.id.reciving_person);
        signature = findViewById(R.id.signature_check);

        tick = findViewById(R.id.delivery_tick);
        pickUpLabel1 = findViewById(R.id.pickup_location_label1);
        deliveryLabel = findViewById(R.id.delivery_location_label);
        deliveryDeadLine = findViewById(R.id.fragment_container4);
        additionalDetailLabel = findViewById(R.id.additional_details_label);
        deliveryDeadLabel1 = findViewById(R.id.delivery_deadline_label1);

        pickUpLabel = findViewById(R.id.pickup_location_label);
        deliveryLabel1 = findViewById(R.id.delivery_location_label1);
        delivery = findViewById(R.id.fragment_container3);
        additionalDetailLabel1 = findViewById(R.id.additional_details_label1);
        deliveryDeadLabel = findViewById(R.id.delivery_deadline_label);


        if (!deliveryLocation.getText().toString().isEmpty() && personReceiving.getCheckedRadioButtonId() != -1) {

            pickUpLabel.setVisibility(View.GONE);
            deliveryLabel1.setVisibility(View.GONE);
            delivery.setVisibility(View.GONE);
            additionalDetailLabel1.setVisibility(View.GONE);
            deliveryDeadLabel.setVisibility(View.GONE);

            deliveryLabel.setVisibility(View.VISIBLE);
            pickUpLabel1.setVisibility(View.VISIBLE);
            tick.setVisibility(View.VISIBLE);
            deliveryDeadLine.setVisibility(View.VISIBLE);
            additionalDetailLabel.setVisibility(View.VISIBLE);
            deliveryDeadLabel1.setVisibility(View.VISIBLE);

        } else {
            if (deliveryLocation.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Enter the Delivery Location", Toast.LENGTH_SHORT).show();
            } else if (personReceiving.getCheckedRadioButtonId() == -1) {
                Toast.makeText(getApplicationContext(), "Select the Person receiving option", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Some thing Want wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void additionalDetailClick(View view) {

        time = findViewById(R.id.input_time);
        date = findViewById(R.id.calendarView);

        additionalDetail = findViewById(R.id.fragment_container5);
        tick = findViewById(R.id.delivery_dealine_tick);
        additionalDetailLabel = findViewById(R.id.additional_details_label);
        deliveryDeadLabel = findViewById(R.id.delivery_deadline_label);
        deliveryLabel1 = findViewById(R.id.delivery_location_label1);
        insuranceLabel = findViewById(R.id.insuranceLabel);

        deliveryDeadLine = findViewById(R.id.fragment_container4);
        additionalDetailLabel1 = findViewById(R.id.additional_details_label1);
        deliveryDeadLabel1 = findViewById(R.id.delivery_deadline_label1);
        deliveryLabel = findViewById(R.id.delivery_location_label);
        insuranceLabel1 = findViewById(R.id.insuranceLabel1);

        if (!time.getText().toString().isEmpty()) {

            deliveryDeadLine.setVisibility(View.GONE);
            additionalDetailLabel.setVisibility(View.GONE);
            deliveryDeadLabel1.setVisibility(View.GONE);
            deliveryLabel.setVisibility(View.GONE);
            insuranceLabel1.setVisibility(View.GONE);

            additionalDetailLabel1.setVisibility(View.VISIBLE);
            additionalDetail.setVisibility(View.VISIBLE);
            deliveryDeadLabel.setVisibility(View.VISIBLE);
            tick.setVisibility(View.VISIBLE);
            deliveryLabel1.setVisibility(View.VISIBLE);
            insuranceLabel.setVisibility(View.VISIBLE);

        } else {
            Toast.makeText(getApplicationContext(), "Some thing Want wrong", Toast.LENGTH_SHORT).show();
        }

    }

    public void insuranceClick(View view) {


        additional_note_check = findViewById(R.id.additional_note_radio);
        additional_note = findViewById(R.id.additional_details_input);


        insurance = findViewById(R.id.fragment_container6);
        tick = findViewById(R.id.additional_tick);
        additionalDetailLabel = findViewById(R.id.additional_details_label);
        insuranceLabel1 = findViewById(R.id.insuranceLabel1);
        deliveryDeadLabel1 = findViewById(R.id.delivery_deadline_label1);

        additionalDetail = findViewById(R.id.fragment_container5);
        additionalDetailLabel1 = findViewById(R.id.additional_details_label1);
        insuranceLabel = findViewById(R.id.insuranceLabel);
        deliveryDeadLabel = findViewById(R.id.delivery_deadline_label);

        if (additional_note_check.getCheckedRadioButtonId() != -1) {

            additionalDetail.setVisibility(View.GONE);
            insuranceLabel.setVisibility(View.GONE);
            deliveryDeadLabel.setVisibility(View.GONE);
            additionalDetailLabel1.setVisibility(View.GONE);

            deliveryDeadLabel1.setVisibility(View.VISIBLE);
            additionalDetailLabel.setVisibility(View.VISIBLE);
            insuranceLabel1.setVisibility(View.VISIBLE);
            tick.setVisibility(View.VISIBLE);
            insurance.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(getApplicationContext(), "Some thing Want wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void postThisGig(View view) {

        tick = findViewById(R.id.insurance_tick);
        additionalDetailLabel1 = findViewById(R.id.additional_details_label1);
        insuranceLabel1 = findViewById(R.id.insuranceLabel1);

        insuranceLabel = findViewById(R.id.insuranceLabel);
        insurance = findViewById(R.id.fragment_container6);
        additionalDetailLabel = findViewById(R.id.additional_details_label);

        tick.setVisibility(View.VISIBLE);
        additionalDetailLabel1.setVisibility(View.VISIBLE);
        insuranceLabel1.setVisibility(View.VISIBLE);

        insurance.setVisibility(View.GONE);
        insuranceLabel.setVisibility(View.GONE);
        additionalDetailLabel.setVisibility(View.GONE);

        Toast.makeText(getApplicationContext(), "Gig is Posted Successfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, NEW_GIG);


    }
}
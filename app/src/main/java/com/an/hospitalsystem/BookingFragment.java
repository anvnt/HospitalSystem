package com.an.hospitalsystem;

import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookingFragment extends Fragment {
    View view;
    Spinner spSex;
    ArrayAdapter <String>adapter;
    EditText edtFullName,  edtPhone, edtEmail, edtAddress;
    TextView edtDOB,edtDate,edtTime;
    Calendar calendarDate=Calendar.getInstance();
    SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
    Calendar calendarTime=Calendar.getInstance();
    SimpleDateFormat sdfTime=new SimpleDateFormat("HH:mm");
    Button btnBooking;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_booking,container,false);
            addControls();
            addEvents();
            return view ;
    }

    private void addEvents() {
        edtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moManHinhDatePickerDialog();
            }
        });
        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moManHinhDatePickerDialogBooking();
            }
        });
        edtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moManHInhTimePickerDialog();
            }
        });
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyTaoNotification(v);
            }
        });
    }

    private void moManHInhTimePickerDialog() {
        TimePickerDialog.OnTimeSetListener callBack = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendarTime.set(Calendar.HOUR,hourOfDay);
                calendarTime.set(Calendar.MINUTE,minute);
                edtTime.setText(sdfTime.format(calendarTime.getTime()));
            }
        };
        TimePickerDialog dialog= new TimePickerDialog(
                view.getContext(),
                callBack,
                calendarTime.get(Calendar.HOUR),
                calendarTime.get(Calendar.MINUTE),
        true
        );
        dialog.show();
    }


    private void moManHinhDatePickerDialog() {
        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarDate.set(Calendar.YEAR,year);
                calendarDate.set(Calendar.MONTH,month);
                calendarDate.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                edtDOB.setText(sdfDate.format(calendarDate.getTime()));

            }
        };
        DatePickerDialog dialog=new DatePickerDialog(
                view.getContext(),
                callBack,
                calendarDate.get(Calendar.YEAR),
                calendarDate.get(Calendar.MONTH),
                calendarDate.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    private void moManHinhDatePickerDialogBooking() {
        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarDate.set(Calendar.YEAR,year);
                calendarDate.set(Calendar.MONTH,month);
                calendarDate.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                edtDate.setText(sdfDate.format(calendarDate.getTime()));

            }
        };
        DatePickerDialog dialog=new DatePickerDialog(
                view.getContext(),
                callBack,
                calendarDate.get(Calendar.YEAR),
                calendarDate.get(Calendar.MONTH),
                calendarDate.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    private void addControls() {
        spSex=view.findViewById(R.id.spSex);
        adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item);
        adapter.add("Male");
        adapter.add("Female");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSex.setAdapter(adapter);
        edtDOB=view.findViewById(R.id.edtDOB);
        edtDate=view.findViewById(R.id.edtDate);
        edtTime=view.findViewById(R.id.edtTime);
        btnBooking=view.findViewById(R.id.btnBooking);
    }

    //Hàm tạo Channel cho notification
    public static String createNotificationChannel(Context context) {

        // NotificationChannels are required for Notifications on O (API 26) and above.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // The id of the channel.
            String channelId = "Channel_id";

            // The user-visible name of the channel.
            CharSequence channelName = "Application_name";
            // The user-visible description of the channel.
            String channelDescription = "Application_name Alert";
            int channelImportance = NotificationManager.IMPORTANCE_DEFAULT;
            boolean channelEnableVibrate = true;
            //            int channelLockscreenVisibility = Notification.;

            // Initializes NotificationChannel.
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, channelImportance);
            notificationChannel.setDescription(channelDescription);
            notificationChannel.enableVibration(channelEnableVibrate);
            //            notificationChannel.setLockscreenVisibility(channelLockscreenVisibility);

            // Adds NotificationChannel to system. Attempting to create an existing notification
            // channel with its original values performs no operation, so it's safe to perform the
            // below sequence.
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);

            return channelId;
        } else {
            // Returns null for pre-O (26) devices.
            return null;
        }
    }
    public void xuLyTaoNotification(View view) {
        //Tạo channel ID
        String channel_id = createNotificationChannel(getActivity());

        //Thêm action cho noti
        Intent intent = new Intent(getActivity(),MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);

        NotificationCompat.Builder Builder = new NotificationCompat.Builder(getActivity(), channel_id)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Congrats")
                .setContentText("Your booking successfully !!! Thanks for choosing us.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        ;


        //Show Noti
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getActivity());
        notificationManager.notify(113, Builder.build());

    }


}

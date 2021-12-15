package ca.qc.johnabbott.finalproject;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Date;

import ca.qc.johnabbott.finalproject.UI.MainActivity;

public class NotificationThread implements Runnable{

    private int  currentNotificationId = 0;

    public MainActivity getActivity() {
        return activity;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    public MainActivity activity;
    @Override
    public void run() {
        try {

            Thread.sleep(10000);
            reportDone();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void reportDone(){
        Intent intent = new Intent(activity, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(activity, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity, MainActivity.NOTIFICATION_CHANNEL)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Pizza Ready")
                .setContentText("Pizza is ready for pickup")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                ;

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getActivity());

        // notificationId is a unique int for each notification that you must define


        notificationManager.notify(currentNotificationId++, builder.build());
    }

}

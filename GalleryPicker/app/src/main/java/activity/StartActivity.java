package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import model.Image;
import test.launcher.mummu.gallerypicker.R;

/**
 * Created by muhammed on 8/29/2016.
 */
public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_PICKER = 10;
    private Button mButton;
    ArrayList<Image> images = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy);
        mButton = (Button) findViewById(R.id.button2);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ImagePicker.create(this)
                .title("Tap to select") // picker's title
                .single()
                .limit(10)
                .showCamera(false)
                .folderMode(true)
                .origin(images)
                .start(REQUEST_CODE_PICKER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICKER && resultCode == RESULT_OK && data != null) {
            ArrayList<Image> images = data.getParcelableArrayListExtra(ImagePickerActivity.INTENT_EXTRA_SELECTED_IMAGES);
            // do your logic ....
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

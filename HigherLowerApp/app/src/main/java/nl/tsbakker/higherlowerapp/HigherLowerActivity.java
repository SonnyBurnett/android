package nl.tsbakker.higherlowerapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HigherLowerActivity extends AppCompatActivity {


    private TextView mScoreValue;
    private TextView mHighScoreValue;
    private ListView mScoreList;
    private ImageView mDiceImage;
    private FloatingActionButton mLowerButton;
    private FloatingActionButton mHigherButton;
    private int[] mImageNames;
    private int randomImageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_higher_lower);

        mScoreValue = findViewById(R.id.score_value);
        mHighScoreValue = findViewById(R.id.highscore_value);
        mScoreList = findViewById(R.id.score_list);
        mDiceImage = findViewById(R.id.dice_image);
        mLowerButton = findViewById(R.id.lower_button);
        mHigherButton = findViewById(R.id.higher_button);


        mImageNames = new int[]{R.drawable.d1, R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6};

        // Define what happens when the user clicks the "next image" button
        mLowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomImageIndex = 3;
                mDiceImage.setImageResource(mImageNames[randomImageIndex]);
            }
        });

        mHigherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomImageIndex = 5;
                mDiceImage.setImageResource(mImageNames[randomImageIndex]);
            }

        });

    }
}

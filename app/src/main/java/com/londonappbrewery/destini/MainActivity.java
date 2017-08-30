package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    TextView mStatusTextView;
    int Raund;
    int mStory;
    GoodorBad NowBuffer;

    final private GoodorBad[] mStoryBank =new GoodorBad[]{
            new GoodorBad(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new GoodorBad(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new GoodorBad(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new GoodorBad(R.string.T4_End,0,0),
            new GoodorBad(R.string.T5_End,0,0),
            new GoodorBad(R.string.T6_End,0,0),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState !=null)
        {
            Raund = savedInstanceState.getInt("index");
        }
        else
        {
            Raund=0;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mStatusTextView =(TextView)findViewById(R.id.storyTextView);

        PutStory(Raund);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallStory(NowBuffer,true);
            }
        });
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallStory(NowBuffer,false);
            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:



    }
    private void CallStory(GoodorBad userSelection,boolean Red)
    {
        if(userSelection.getRedAnsverID()==R.string.T1_Ans1 && Red==true )
        {
            //story3
            PutStory(2);
            Raund=2;
        }
        else if(userSelection.getBlueAnsverID()==R.string.T1_Ans2 && Red==false)
        {
            //story 2
            PutStory(1);
            Raund=1;
        }
        else if (userSelection.getRedAnsverID()==R.string.T2_Ans1&& Red==true)
        {
            //story3
            PutStory(2);
            Raund=2;
        }
        else if(userSelection.getBlueAnsverID() == R.string.T3_Ans2&& Red==false )
        {
            //end t5
            PutStory(4);
            Raund=4;
        }
        else if(userSelection.getRedAnsverID()==R.string.T3_Ans1&& Red==true)
        {
            //end t6
            PutStory(5);
            Raund=5;
        }
        else if(userSelection.getBlueAnsverID() == R.string.T2_Ans2 && Red==false)
        {
            //end t4
            PutStory(3);
            Raund=3;
        }

    }
    private void PutStory(int index)
    {
        mStatusTextView.setText(mStoryBank[index].getStoryID());
        mButtonTop.setText(mStoryBank[index].getRedAnsverID());
        mButtonBottom.setText(mStoryBank[index].getBlueAnsverID());
        NowBuffer=new GoodorBad(mStoryBank[index].getStoryID(),mStoryBank[index].getRedAnsverID(),mStoryBank[index].getBlueAnsverID());
    }
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("index",Raund);
    }

}

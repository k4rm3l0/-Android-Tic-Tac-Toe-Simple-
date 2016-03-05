package it.k4rm3l0.tris;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final Integer PLAYER_1   = new Integer(0);
    private static final Integer PLAYER_2   = new Integer(1);
    private static final Integer NO_PLAYER  = new Integer(-1);

    private int actualPlayer                = PLAYER_1;
    private int actualTurnCounter           = 0;

    private FloatingActionButton fab;
    private ImageButton          imageButton1,
                                 imageButton2,
                                 imageButton3,
                                 imageButton4,
                                 imageButton5,
                                 imageButton6,
                                 imageButton7,
                                 imageButton8,
                                 imageButton9;
    private TextView             topTextBar;
    private ImageView            actualPlayerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //**************************************************************************************************************
        // UI-ELEMENTS INITIALIZATION
        //**************************************************************************************************************

        // Bind ui-elements to variables

        actualPlayerImage   = (ImageView) findViewById(R.id.topImageView);
        topTextBar          = (TextView) findViewById(R.id.topTextBar);
        fab                 = (FloatingActionButton) findViewById(R.id.fab);
        imageButton1        = (ImageButton) findViewById(R.id.bottone1);
        imageButton2        = (ImageButton) findViewById(R.id.bottone2);
        imageButton3        = (ImageButton) findViewById(R.id.bottone3);
        imageButton4        = (ImageButton) findViewById(R.id.bottone4);
        imageButton5        = (ImageButton) findViewById(R.id.bottone5);
        imageButton6        = (ImageButton) findViewById(R.id.bottone6);
        imageButton7        = (ImageButton) findViewById(R.id.bottone7);
        imageButton8        = (ImageButton) findViewById(R.id.bottone8);
        imageButton9        = (ImageButton) findViewById(R.id.bottone9);

        // Tag Buttons to "NO_PLAYER"

        imageButton1.setTag(NO_PLAYER);
        imageButton2.setTag(NO_PLAYER);
        imageButton3.setTag(NO_PLAYER);
        imageButton4.setTag(NO_PLAYER);
        imageButton5.setTag(NO_PLAYER);
        imageButton6.setTag(NO_PLAYER);
        imageButton7.setTag(NO_PLAYER);
        imageButton8.setTag(NO_PLAYER);
        imageButton9.setTag(NO_PLAYER);

        // Set EMPTY background to cells

        imageButton1.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton2.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton3.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton4.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton5.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton6.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton7.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton8.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton9.setBackgroundColor(getResources().getColor(R.color.GRAY));

        // Set ClickListeners

        imageButton1.setOnClickListener(getClickListener());
        imageButton2.setOnClickListener(getClickListener());
        imageButton3.setOnClickListener(getClickListener());
        imageButton4.setOnClickListener(getClickListener());
        imageButton5.setOnClickListener(getClickListener());
        imageButton6.setOnClickListener(getClickListener());
        imageButton7.setOnClickListener(getClickListener());
        imageButton8.setOnClickListener(getClickListener());
        imageButton9.setOnClickListener(getClickListener());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewGame(view);
            }
        });

        // Avoid click on first run

        imageButton1.setClickable(false);
        imageButton2.setClickable(false);
        imageButton3.setClickable(false);
        imageButton4.setClickable(false);
        imageButton5.setClickable(false);
        imageButton6.setClickable(false);
        imageButton7.setClickable(false);
        imageButton8.setClickable(false);
        imageButton9.setClickable(false);

        // On first run show only welcome message

        actualPlayerImage.setVisibility(View.GONE);
        topTextBar.setText(getString(R.string.start_new_game));

        // Set the grid height at runtime

        ViewTreeObserver viewTreeObserver = imageButton1.getViewTreeObserver();
        viewTreeObserver.addOnPreDrawListener(new OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                imageButton1.getViewTreeObserver().removeOnPreDrawListener(this);
                imageButton1.getLayoutParams().height = imageButton1.getMeasuredWidth();
                imageButton2.getLayoutParams().height = imageButton2.getMeasuredWidth();
                imageButton3.getLayoutParams().height = imageButton3.getMeasuredWidth();
                imageButton4.getLayoutParams().height = imageButton4.getMeasuredWidth();
                imageButton5.getLayoutParams().height = imageButton5.getMeasuredWidth();
                imageButton6.getLayoutParams().height = imageButton6.getMeasuredWidth();
                imageButton7.getLayoutParams().height = imageButton7.getMeasuredWidth();
                imageButton8.getLayoutParams().height = imageButton8.getMeasuredWidth();
                imageButton9.getLayoutParams().height = imageButton9.getMeasuredWidth();
                return true;
            }
        });
    }

    private OnClickListener getClickListener(){
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                click((ImageButton) v);
            }
        };
    }

    //******************************************************************************************************************
    // START NEW GAME
    //******************************************************************************************************************

    private void startNewGame(View view){

        imageButton1.setImageResource(R.drawable.empty_bg);
        imageButton2.setImageResource(R.drawable.empty_bg);
        imageButton3.setImageResource(R.drawable.empty_bg);
        imageButton4.setImageResource(R.drawable.empty_bg);
        imageButton5.setImageResource(R.drawable.empty_bg);
        imageButton6.setImageResource(R.drawable.empty_bg);
        imageButton7.setImageResource(R.drawable.empty_bg);
        imageButton8.setImageResource(R.drawable.empty_bg);
        imageButton9.setImageResource(R.drawable.empty_bg);

        imageButton1.setTag(NO_PLAYER);
        imageButton2.setTag(NO_PLAYER);
        imageButton3.setTag(NO_PLAYER);
        imageButton4.setTag(NO_PLAYER);
        imageButton5.setTag(NO_PLAYER);
        imageButton6.setTag(NO_PLAYER);
        imageButton7.setTag(NO_PLAYER);
        imageButton8.setTag(NO_PLAYER);
        imageButton9.setTag(NO_PLAYER);

        imageButton1.setClickable(true);
        imageButton2.setClickable(true);
        imageButton3.setClickable(true);
        imageButton4.setClickable(true);
        imageButton5.setClickable(true);
        imageButton6.setClickable(true);
        imageButton7.setClickable(true);
        imageButton8.setClickable(true);
        imageButton9.setClickable(true);

        imageButton1.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton2.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton3.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton4.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton5.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton6.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton7.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton8.setBackgroundColor(getResources().getColor(R.color.GRAY));
        imageButton9.setBackgroundColor(getResources().getColor(R.color.GRAY));

        actualPlayerImage.setImageResource(actualPlayer == PLAYER_1 ? R.drawable.circle_bg : R.drawable.cross_bg);
        actualPlayerImage.setVisibility(View.VISIBLE);
        topTextBar.setText(getString(R.string.turn));
        Snackbar.make(view, getString(R.string.new_game_started), Snackbar.LENGTH_LONG).show();

        actualTurnCounter = 0;
    }

    //******************************************************************************************************************
    // ON CELL CLICK
    //******************************************************************************************************************

    private void click(ImageButton bottone){

        //**************************************************************************************************************
        // Escape conditions
        //**************************************************************************************************************

        if(actualTurnCounter >= 9){
            return;
        }

        if(checkWinner()!=-1){
            return;
        }

        if(bottone.getTag() != NO_PLAYER){
            return;
        }

        //**************************************************************************************************************
        // Play
        //**************************************************************************************************************

        if(actualPlayer == PLAYER_1){
            // GIOCATORE 0 (CERCHIO)
            bottone.setImageResource(R.drawable.circle_bg);
            bottone.setTag(PLAYER_1);
            actualPlayer = PLAYER_2;

        }else{
            // GIOCATORE 0 (CROCE)
            bottone.setImageResource(R.drawable.cross_bg);
            bottone.setTag(PLAYER_2);
            actualPlayer = PLAYER_1;
        }

        actualTurnCounter++;

        String testo = getString(R.string.turn);
        actualPlayerImage.setImageResource(actualPlayer == PLAYER_1 ? R.drawable.circle_bg : R.drawable.cross_bg);
        actualPlayerImage.setVisibility(View.VISIBLE);

        //**************************************************************************************************************
        // Check for winner
        //**************************************************************************************************************

        if(checkWinner() == PLAYER_1 ){

            testo = getString(R.string.player_wins);
            actualPlayerImage.setImageResource(R.drawable.circle_bg);
            actualPlayerImage.setVisibility(View.VISIBLE);
            Snackbar.make(bottone, getString(R.string.end_game), Snackbar.LENGTH_LONG).show();

        }else if( checkWinner() == PLAYER_2 ){

            testo = getString(R.string.player_wins);
            actualPlayerImage.setImageResource(R.drawable.cross_bg);
            actualPlayerImage.setVisibility(View.VISIBLE);
            Snackbar.make(bottone, getString(R.string.end_game), Snackbar.LENGTH_LONG).show();

        }else if( actualTurnCounter >= 9 ){

            Snackbar.make(bottone, getString(R.string.no_winner), Snackbar.LENGTH_LONG).show();
        }

        topTextBar.setText(testo);
    }

    //******************************************************************************************************************
    // FIND A WINNER!
    //******************************************************************************************************************
    private int checkWinner(){

        int winner = NO_PLAYER;

       // Check all PLAYER_1 combinations

        if(imageButton1.getTag() == PLAYER_1 && imageButton4.getTag() == PLAYER_1 && imageButton7.getTag() == PLAYER_1){
            imageButton1.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton4.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton7.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_1;
        }
        if(imageButton2.getTag() == PLAYER_1 && imageButton5.getTag() == PLAYER_1 && imageButton8.getTag() == PLAYER_1){
            imageButton2.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton5.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton8.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_1;
        }
        if(imageButton3.getTag() == PLAYER_1 && imageButton6.getTag() == PLAYER_1 && imageButton9.getTag() == PLAYER_1){
            imageButton3.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton6.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton9.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_1;
        }
        if(imageButton1.getTag() == PLAYER_1 && imageButton2.getTag() == PLAYER_1 && imageButton3.getTag() == PLAYER_1){
            imageButton1.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton2.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton3.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_1;
        }
        if(imageButton4.getTag() == PLAYER_1 && imageButton5.getTag() == PLAYER_1 && imageButton6.getTag() == PLAYER_1){
            imageButton4.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton5.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton6.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_1;
        }
        if(imageButton7.getTag() == PLAYER_1 && imageButton8.getTag() == PLAYER_1 && imageButton9.getTag() == PLAYER_1){
            imageButton7.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton8.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton9.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_1;
        }
        if(imageButton1.getTag() == PLAYER_1 && imageButton5.getTag() == PLAYER_1 && imageButton9.getTag() == PLAYER_1){
            imageButton1.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton5.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton9.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_1;
        }
        if(imageButton3.getTag() == PLAYER_1 && imageButton5.getTag() == PLAYER_1 && imageButton7.getTag() == PLAYER_1){
            imageButton3.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton5.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton7.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_1;
        }

        // Check all PLAYER_2 combinations

        if(imageButton1.getTag() == PLAYER_2 && imageButton4.getTag() == PLAYER_2 && imageButton7.getTag() == PLAYER_2){
            imageButton1.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton4.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton7.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_2;
        }
        if(imageButton2.getTag() == PLAYER_2 && imageButton5.getTag() == PLAYER_2 && imageButton8.getTag() == PLAYER_2){
            imageButton2.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton5.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton8.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_2;
        }
        if(imageButton3.getTag() == PLAYER_2 && imageButton6.getTag() == PLAYER_2 && imageButton9.getTag() == PLAYER_2){
            imageButton3.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton6.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton9.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_2;
        }
        if(imageButton1.getTag() == PLAYER_2 && imageButton2.getTag() == PLAYER_2 && imageButton3.getTag() == PLAYER_2){
            imageButton1.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton2.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton3.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_2;
        }
        if(imageButton4.getTag() == PLAYER_2 && imageButton5.getTag() == PLAYER_2 && imageButton6.getTag() == PLAYER_2){
            imageButton4.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton5.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton6.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_2;
        }
        if(imageButton7.getTag() == PLAYER_2 && imageButton8.getTag() == PLAYER_2 && imageButton9.getTag() == PLAYER_2){
            imageButton7.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton8.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton9.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_2;
        }
        if(imageButton1.getTag() == PLAYER_2 && imageButton5.getTag() == PLAYER_2 && imageButton9.getTag() == PLAYER_2){
            imageButton1.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton5.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton9.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_2;
        }
        if(imageButton3.getTag() == PLAYER_2 && imageButton5.getTag() == PLAYER_2 && imageButton7.getTag() == PLAYER_2){
            imageButton3.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton5.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            imageButton7.setBackgroundColor(getResources().getColor(R.color.YELLOW));
            winner = PLAYER_2;
        }

        return winner;
    }
}

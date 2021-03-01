package com.example.tiktactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView fScore, sScore, fName, sName;
    ImageView g00, g01, g02, g10, g11, g12, g20, g21, g22;
    LinearLayout l00, l01, l02, l10, l11, l12, l20, l21, l22;

    private boolean turn = true;
    private String[][] answer;
    private AlertDialog.Builder alert;
    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        answer = new String[3][3];

        fName = findViewById(R.id.firstname);
        sName = findViewById(R.id.secondname);
        fScore = findViewById(R.id.firstscore);
        sScore = findViewById(R.id.secondscore);

        g00 = findViewById(R.id.grid00);
        g01 = findViewById(R.id.grid01);
        g02 = findViewById(R.id.grid02);
        g10 = findViewById(R.id.grid10);
        g11 = findViewById(R.id.grid11);
        g12 = findViewById(R.id.grid12);
        g20 = findViewById(R.id.grid20);
        g21 = findViewById(R.id.grid21);
        g22 = findViewById(R.id.grid22);

        l00 = findViewById(R.id.lay00);
        l01 = findViewById(R.id.lay01);
        l02 = findViewById(R.id.lay02);
        l10 = findViewById(R.id.lay10);
        l11 = findViewById(R.id.lay11);
        l12 = findViewById(R.id.lay12);
        l20 = findViewById(R.id.lay20);
        l21 = findViewById(R.id.lay21);
        l22 = findViewById(R.id.lay22);

        g00.setOnClickListener(this);
        g01.setOnClickListener(this);
        g02.setOnClickListener(this);
        g10.setOnClickListener(this);
        g11.setOnClickListener(this);
        g12.setOnClickListener(this);
        g20.setOnClickListener(this);
        g21.setOnClickListener(this);
        g22.setOnClickListener(this);

        openDialog();
    }
    public void getAnswer(String character){
        if(character == "o") {
            String name = fName.getText().toString();
            String fix = name.substring(0, name.length() - 3);
            if (answer[0][0] == "o" && answer[0][1] == "o" && answer[0][2] == "o") {
                setColor("00-02");
                updateScore("first");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            } else if (answer[1][0] == "o" && answer[1][1] == "o" && answer[1][2] == "o") {
                setColor("10-12");
                updateScore("first");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            } else if (answer[2][0] == "o" && answer[2][1] == "o" && answer[2][2] == "o") {
                setColor("20-22");
                updateScore("first");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            } else if (answer[0][0] == "o" && answer[1][0] == "o" && answer[2][0] == "o") {
                setColor("00-20");
                updateScore("first");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            } else if (answer[0][1] == "o" && answer[1][1] == "o" && answer[2][1] == "o") {
                setColor("01-21");
                updateScore("first");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            } else if (answer[0][2] == "o" && answer[1][2] == "o" && answer[2][2] == "o") {
                setColor("02-22");
                updateScore("first");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            } else if (answer[0][0] == "o" && answer[1][1] == "o" && answer[2][2] == "o") {
                setColor("00-22");
                updateScore("first");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            } else if (answer[0][2] == "o" && answer[1][1] == "o" && answer[2][0] == "o") {
                setColor("02-20");
                updateScore("first");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            }
        }else{
            String name = sName.getText().toString();
            String fix = name.substring(0, name.length() -3);
            if(answer[0][0] == "x" && answer[0][1] == "x" && answer[0][2] == "x"){
                setColor("00-02");
                updateScore("second");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            }else if(answer[1][0] == "x" && answer[1][1] == "x" && answer[1][2] == "x"){
                setColor("10-12");
                updateScore("second");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            }else if(answer[2][0] == "x" && answer[2][1] == "x" && answer[2][2] == "x"){
                setColor("20-22");
                updateScore("second");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            }else if(answer[0][0] == "x" && answer[1][0] == "x" && answer[2][0] == "x") {
                setColor("00-20");
                updateScore("second");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            }else if(answer[0][1] == "x" && answer[1][1] == "x" && answer[2][1] == "x"){
                setColor("01-21");
                updateScore("second");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            }else if(answer[0][2] == "x" && answer[1][2] == "x" && answer[2][2] == "x"){
                setColor("02-22");
                updateScore("second");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            }else if(answer[0][0] == "x" && answer[1][1] == "x" && answer[2][2] == "x"){
                setColor("00-22");
                updateScore("second");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            }else if(answer[0][2] == "x" && answer[1][1] == "x" && answer[2][0] == "x"){
                setColor("02-20");
                updateScore("second");
                Toast.makeText(MainActivity.this, fix + " Won", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void bottomDialog(){
        BottomSheetDialog bottom = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
        View v = getLayoutInflater().inflate(R.layout.score_dialog, findViewById(R.id.scoreContainer));
        ImageButton quit = v.findViewById(R.id.scoreDialogQuit);
        ImageButton restart = v.findViewById(R.id.scoreDialogRestart);
        ImageButton con = v.findViewById(R.id.scoreDialogContinue);

        bottom.setCancelable(false);
        bottom.setContentView(v);
        bottom.show();

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Quit Successfully", Toast.LENGTH_LONG).show();
                System.exit(0);
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom.dismiss();
                restart();
            }
        });
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom.dismiss();
                clear();
            }
        });
    }
    public void restart(){
        clear();
        fScore.setText("0");
        sScore.setText("0");
    }
    public void clear(){
        g00.setImageResource(0);
        l00.setBackgroundResource(R.drawable.round_layout);
        g01.setImageResource(0);
        l01.setBackgroundResource(R.drawable.round_layout);
        g02.setImageResource(0);
        l02.setBackgroundResource(R.drawable.round_layout);
        g10.setImageResource(0);
        l10.setBackgroundResource(R.drawable.round_layout);
        g11.setImageResource(0);
        l11.setBackgroundResource(R.drawable.round_layout);
        g12.setImageResource(0);
        l12.setBackgroundResource(R.drawable.round_layout);
        g20.setImageResource(0);
        l20.setBackgroundResource(R.drawable.round_layout);
        g21.setImageResource(0);
        l21.setBackgroundResource(R.drawable.round_layout);
        g22.setImageResource(0);
        l22.setBackgroundResource(R.drawable.round_layout);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                answer[i][j] = null;
            }
        }
        turn = true;
    }
    public void updateScore(String name){
        if(name.equals("first")){
            int score = Integer.parseInt(fScore.getText().toString()) + 1;
            fScore.setText(String.valueOf(score));
        }else{
            int score = Integer.parseInt(sScore.getText().toString()) + 1;
            sScore.setText(String.valueOf(score));
        }
        bottomDialog();
    }
    public void setColor(String code){
        switch (code){
            case "00-02":
                l00.setBackgroundResource(R.drawable.small_round_layout);
                l01.setBackgroundResource(R.drawable.small_round_layout);
                l02.setBackgroundResource(R.drawable.small_round_layout);
                break;
            case "10-12":
                l10.setBackgroundResource(R.drawable.small_round_layout);
                l11.setBackgroundResource(R.drawable.small_round_layout);
                l12.setBackgroundResource(R.drawable.small_round_layout);
                break;
            case "20-22":
                l20.setBackgroundResource(R.drawable.small_round_layout);
                l21.setBackgroundResource(R.drawable.small_round_layout);
                l22.setBackgroundResource(R.drawable.small_round_layout);
                break;
            case "00-20":
                l00.setBackgroundResource(R.drawable.small_round_layout);
                l10.setBackgroundResource(R.drawable.small_round_layout);
                l20.setBackgroundResource(R.drawable.small_round_layout);
                break;
            case "01-21":
                l01.setBackgroundResource(R.drawable.small_round_layout);
                l11.setBackgroundResource(R.drawable.small_round_layout);
                l21.setBackgroundResource(R.drawable.small_round_layout);
                break;
            case "02-22":
                l02.setBackgroundResource(R.drawable.small_round_layout);
                l12.setBackgroundResource(R.drawable.small_round_layout);
                l22.setBackgroundResource(R.drawable.small_round_layout);
                break;
            case "00-22":
                l00.setBackgroundResource(R.drawable.small_round_layout);
                l11.setBackgroundResource(R.drawable.small_round_layout);
                l22.setBackgroundResource(R.drawable.small_round_layout);
                break;
            case "02-20":
                l02.setBackgroundResource(R.drawable.small_round_layout);
                l11.setBackgroundResource(R.drawable.small_round_layout);
                l20.setBackgroundResource(R.drawable.small_round_layout);
                break;
        }
    }
    public void openDialog(){
        alert = new AlertDialog.Builder(this);
        View v = getLayoutInflater().inflate(R.layout.welcome_dialog, findViewById(R.id.dialogContainer));
        EditText first = v.findViewById(R.id.dialogFirstName);
        EditText second = v.findViewById(R.id.dialogSecondName);
        TextView cancel = v.findViewById(R.id.dialogCancel);
        TextView confirm = v.findViewById(R.id.dialogConfirm);

        alert.setView(v);
        dialog = alert.create();
        dialog.show();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f = first.getText().toString().trim();
                String s = second.getText().toString().trim();
                if(f.equals("") || s.equals("")){
                    Toast.makeText(MainActivity.this, "Do not leave field empty", Toast.LENGTH_LONG).show();
                }else{
                    fName.setText(f + " : ");
                    sName.setText(s + " : ");
                    dialog.dismiss();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "We will replace player 1 with Player X and player 2 with Player Y", Toast.LENGTH_LONG).show();
                fName.setText("Player X : ");
                sName.setText("Player Y : ");
            }
        });
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.grid00:
                if(answer[0][0] == null){
                    if(turn) {
                        g00.setImageResource(R.drawable.ic_baseline_circle_24);
                        turn = false;
                        answer[0][0] = "o";
                        getAnswer("o");
                    }else{
                        g00.setImageResource(R.drawable.ic_baseline_close_24);
                        turn = true;
                        answer[0][0] = "x";
                        getAnswer("x");
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Section already chosen", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.grid01:
                if(answer[0][1] == null){
                    if(turn) {
                        g01.setImageResource(R.drawable.ic_baseline_circle_24);
                        turn = false;
                        answer[0][1] = "o";
                        getAnswer("o");
                    }else{
                        g01.setImageResource(R.drawable.ic_baseline_close_24);
                        turn = true;
                        answer[0][1] = "x";
                        getAnswer("x");
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Section already chosen", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.grid02:
                if(answer[0][2] == null){
                    if(turn) {
                        g02.setImageResource(R.drawable.ic_baseline_circle_24);
                        turn = false;
                        answer[0][2] = "o";
                        getAnswer("o");
                    }else{
                        g02.setImageResource(R.drawable.ic_baseline_close_24);
                        turn = true;
                        answer[0][2] = "x";
                        getAnswer("x");
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Section already chosen", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.grid10:
                if(answer[1][0] == null){
                    if(turn) {
                        g10.setImageResource(R.drawable.ic_baseline_circle_24);
                        turn = false;
                        answer[1][0] = "o";
                        getAnswer("o");
                    }else{
                        g10.setImageResource(R.drawable.ic_baseline_close_24);
                        turn = true;
                        answer[1][0] = "x";
                        getAnswer("x");
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Section already chosen", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.grid11:
                if(answer[1][1] == null){
                    if(turn) {
                        g11.setImageResource(R.drawable.ic_baseline_circle_24);
                        turn = false;
                        answer[1][1] = "o";
                        getAnswer("o");
                    }else{
                        g11.setImageResource(R.drawable.ic_baseline_close_24);
                        turn = true;
                        answer[1][1] = "x";
                        getAnswer("x");
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Section already chosen", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.grid12:
                if(answer[1][2] == null){
                    if(turn) {
                        g12.setImageResource(R.drawable.ic_baseline_circle_24);
                        turn = false;
                        answer[1][2] = "o";
                        getAnswer("o");
                    }else{
                        g12.setImageResource(R.drawable.ic_baseline_close_24);
                        turn = true;
                        answer[1][2] = "x";
                        getAnswer("x");
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Section already chosen", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.grid20:
                if(answer[2][0] == null){
                    if(turn) {
                        g20.setImageResource(R.drawable.ic_baseline_circle_24);
                        turn = false;
                        answer[2][0] = "o";
                        getAnswer("o");
                    }else{
                        g20.setImageResource(R.drawable.ic_baseline_close_24);
                        turn = true;
                        answer[2][0] = "x";
                        getAnswer("x");
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Section already chosen", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.grid21:
                if(answer[2][1] == null){
                    if(turn) {
                        g21.setImageResource(R.drawable.ic_baseline_circle_24);
                        turn = false;
                        answer[2][1] = "o";
                        getAnswer("o");
                    }else{
                        g21.setImageResource(R.drawable.ic_baseline_close_24);
                        turn = true;
                        answer[2][1] = "x";
                        getAnswer("x");
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Section already chosen", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.grid22:
                if(answer[2][2] == null){
                    if(turn) {
                        g22.setImageResource(R.drawable.ic_baseline_circle_24);
                        turn = false;
                        answer[2][2] = "o";
                        getAnswer("o");
                    }else{
                        g22.setImageResource(R.drawable.ic_baseline_close_24);
                        turn = true;
                        answer[2][2] = "x";
                        getAnswer("x");
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Section already chosen", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
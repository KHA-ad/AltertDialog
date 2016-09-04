package cn.edu.bistu.cs.se.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnT;
    private Button btnL;
    private static final String TAG="MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnT = (Button) findViewById(R.id.TestBtn);
        btnL = (Button) findViewById(R.id.loginBtn);
        btnT.setOnClickListener(new View.OnClickListener() { //定义提示按钮的监听器
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();
                builder.setMessage("请点击登陆按钮，输入用户名和密码")  //设置提示对话框
                        .setTitle("Login")
                        // Add action buttons
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();
                            }
                        });
                builder.show();
            }
        });
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater1 = getLayoutInflater();

                builder1.setView(inflater1.inflate(R.layout.login, null)) //设置登陆按钮，检查用户名及密码
                        .setTitle("Login")
                        // Add action buttons
                        .setPositiveButton(R.string.Login, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // login
                                final EditText userN=(EditText)findViewById(R.id.editTextUserId);
                                final EditText userP=(EditText)findViewById(R.id.editTextPwd);
                                String usrname= userN.getText().toString();
                                String password= userP.getText().toString();
                                if(usrname.equals("abc") && password.equals("123")){
                                    Log.v(TAG,"登陆成功");
                                    Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Log.v(TAG,"登陆失败");
                                    Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_LONG).show();
                                }
                            }
                        })
                        .setNegativeButton(R.string.cancel, null ); //设置取消按钮
                builder1.show();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
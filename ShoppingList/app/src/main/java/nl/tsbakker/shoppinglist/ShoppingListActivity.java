package nl.tsbakker.shoppinglist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private List<String> mItems;
    private EditText mEditText;

    private void updateUI() {
// If the list adapter is null, a new one will be instantiated and set on our list view.
        if (mAdapter == null) {
            // We can use ‘this’ for the context argument because an Activity is a subclass of the Context class.
            // The ‘android.R.layout.simple_list_item_1’ argument refers to the simple_list_item_1 layout of the Android layout directory.
            mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mItems);
            mListView.setAdapter(mAdapter);
        } else {
            // When the adapter is not null, it has to know what to do when our dataset changes, when a change happens we need to call this method on the adapter so that it will update internally.
            mAdapter.notifyDataSetChanged();
        }
    }

    private void addItem() {
        // Getting the String text from the edit text view.
        String newItem = mEditText.getText().toString();

        // A simple check checking if the text is empty, if so then it cannot be added and the user will be notified.
        if (!newItem.isEmpty()) {
            mItems.add(newItem);
            mEditText.setText("");
            updateUI();
            Toast.makeText(this, "Item added.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter a value in the text field.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = findViewById(R.id.list_view);
        mItems = new ArrayList<>();
        mEditText = findViewById(R.id.add_item_edit_text);

        mItems.add("Pizza");
        mItems.add("icecream");
        mItems.add("XboxOne");
        updateUI();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shopping_list, menu);
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

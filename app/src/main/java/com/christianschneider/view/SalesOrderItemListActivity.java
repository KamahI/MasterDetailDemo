package com.christianschneider.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.christianschneider.masterdetaildemo.R;
import com.christianschneider.model.SalesOrder;
import com.christianschneider.model.SalesOrderDataSingleton;
import com.christianschneider.services.OnlineODataStoreException;

import java.util.ArrayList;


/**
 * An activity representing a list of Products. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link SalesOrderItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p> </p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link SalesOrderItemListFragment} and the item details
 * (if present) is a {@link SalesOrderDetailFragment}.
 * <p> </p>
 * This activity also implements the required
 * {@link SalesOrderItemListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class SalesOrderItemListActivity extends ActionBarActivity
        implements SalesOrderItemListFragment.Callbacks
{

    Button button;
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order_item_list);
//        Bundle keyBundle = getIntent().getExtras();
//        String key = keyBundle.getString("key");
//        keyBundle.putString("key", key);
//        SalesOrderItemListFragment fragment = new SalesOrderItemListFragment();
//        fragment.setArguments(keyBundle);
//        button = (Button) findViewById(R.id.button_item);
//        button.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ArrayList<SalesOrderItem> helpList = new ArrayList<>();
//                try {
//                    helpList = SalesOrderItemDataSingleton.getSalesOrderItems();
//                } catch (OnlineODataStoreException e) {
//                    e.printStackTrace();
//                }
//                finish();
//                startActivity(getIntent());
//            }
//        });

        if (findViewById(R.id.sales_order_item_detail_container) != null)
        {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((SalesOrderItemListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.sales_order_item_list))
                    .setActivateOnItemClick(true);
        }
    }

    /**
     * Callback method from {@link SalesOrderItemListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     * @param id ID of selected item
     */
    @Override
    public void onItemSelected(String id)
    {
        if (mTwoPane)
        {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(SalesOrderItemDetailFragment.ARG_ITEM_ID, id);
            SalesOrderItemDetailFragment fragment = new SalesOrderItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.sales_order_item_detail_container, fragment)
                    .commit();

        } else
        {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, SalesOrderItemDetailActivity.class);
            detailIntent.putExtra(SalesOrderItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle)
    {

    }
}

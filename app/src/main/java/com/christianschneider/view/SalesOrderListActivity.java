package com.christianschneider.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.christianschneider.masterdetaildemo.R;


/**
 * An activity representing a list of Products. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link SalesOrderDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p> </p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link SalesOrderListFragment} and the item details
 * (if present) is a {@link SalesOrderDetailFragment}.
 * <p> </p>
 * This activity also implements the required
 * {@link SalesOrderListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class SalesOrderListActivity extends FragmentActivity
        implements SalesOrderListFragment.Callbacks
{

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order_list);

        if (findViewById(R.id.sales_order_detail_container) != null)
        {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((SalesOrderListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.sales_order_list))
                    .setActivateOnItemClick(true);
        }
    }

    /**
     * Callback method from {@link SalesOrderListFragment.Callbacks}
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
            arguments.putString(SalesOrderDetailFragment.ARG_ITEM_ID, id);
            SalesOrderDetailFragment fragment = new SalesOrderDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.sales_order_detail_container, fragment)
                    .commit();

        } else
        {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, SalesOrderDetailActivity.class);
            detailIntent.putExtra(SalesOrderDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle)
    {

    }
}

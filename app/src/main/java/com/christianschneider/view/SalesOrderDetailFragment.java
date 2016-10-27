package com.christianschneider.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.christianschneider.model.SalesOrder;
import com.christianschneider.model.SalesOrderDataSingleton;
import com.christianschneider.masterdetaildemo.R;

/**
 * A fragment representing a single SalesOrder detail screen.
 * This fragment is either contained in a {@link SalesOrderListActivity}
 * in two-pane mode (on tablets) or a {@link SalesOrderDetailActivity}
 * on handsets.
 */
public class SalesOrderDetailFragment extends Fragment
{
    /**
     * The fragment argument representing the item ID that this fragment
     * represents. Used as the HashMap (ITEM_MAP) key.
     */
    public static final String ARG_ITEM_ID = "item_id";

    //EditText fields for the detail view UI
    private TextView salesOrderId, note, noteLanguage, customerId, customerName, currencyCode, grossAmount, netAmount, taxAmount;
    private TextView lifecycleStatusDescription, billingStatusDescription, deliveryStatusDescription;

    /**
     * The content this fragment is presenting.
     */
    private SalesOrder mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SalesOrderDetailFragment()
    {
    }

    /**
     * Load the product data based on the fragment arguments (which item the user selected)
     * @param savedInstanceState contains user selection
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID))
        {
            // Load the SalesOrder object content specified by the fragment
            // arguments.
            mItem = SalesOrderDataSingleton.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    /**
     * Inflates the fragment, gets references to the UI items, then calls initializeViews() to
     * populate the data
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return Updated View Object
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_sales_order_detail, container, false);

        // Get the TextView items from the fragment_product_detail.xml file.
        if (mItem != null)
        {
            salesOrderId = (TextView) rootView.findViewById(R.id.sales_order_id);
            note = (TextView) rootView.findViewById(R.id.note);
            noteLanguage = (TextView) rootView.findViewById(R.id.note_language);
            customerId = (TextView) rootView.findViewById(R.id.customer_id);
            customerName = (TextView) rootView.findViewById(R.id.customer_name);
            currencyCode = (TextView) rootView.findViewById(R.id.currency_code);
            grossAmount = (TextView) rootView.findViewById(R.id.gross_amount);
            netAmount = (TextView) rootView.findViewById(R.id.net_amount);
            taxAmount = (TextView) rootView.findViewById(R.id.tax_amount);
            lifecycleStatusDescription = (TextView) rootView.findViewById(R.id.lifecycle_status_description);
            billingStatusDescription = (TextView) rootView.findViewById(R.id.billing_status_description);
            deliveryStatusDescription = (TextView) rootView.findViewById(R.id.delivery_status_description);

            // Update the TextView items with data from the selected SalesOrder Object
            initializeViews();
        }

        return rootView;
    }

    /**
     * Set the value of the TextView elements to the selected SalesOrder Object
     */
    private void initializeViews()
    {
        if (mItem != null)
        {
            salesOrderId.setText(mItem.getSalesOrderID());
            note.setText(mItem.getNote());
            noteLanguage.setText(mItem.getNoteLanguage());
            customerId.setText(mItem.getCustomerId());
            grossAmount.setText(mItem.getGrossAmount());
            netAmount.setText(mItem.getNetAmount());
            customerName.setText(mItem.getCustomerName());
            currencyCode.setText(mItem.getCurrencyCode());
            taxAmount.setText(mItem.getTaxAmount());
            lifecycleStatusDescription.setText(mItem.getLifecycleStatusDescription());
            billingStatusDescription.setText(mItem.getBillingStatusDescription());
            deliveryStatusDescription.setText(mItem.getDeliveryStatusDescription());
        }
    }
}

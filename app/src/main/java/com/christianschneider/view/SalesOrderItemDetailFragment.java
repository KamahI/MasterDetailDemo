package com.christianschneider.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.christianschneider.masterdetaildemo.R;
import com.christianschneider.model.SalesOrderItem;
import com.christianschneider.model.SalesOrderItemDataSingleton;

/**
 * A fragment representing a single SalesOrder detail screen.
 * This fragment is either contained in a {@link SalesOrderListActivity}
 * in two-pane mode (on tablets) or a {@link SalesOrderDetailActivity}
 * on handsets.
 */
public class SalesOrderItemDetailFragment extends Fragment
{
    /**
     * The fragment argument representing the item ID that this fragment
     * represents. Used as the HashMap (ITEM_MAP) key.
     */
    public static final String ARG_ITEM_ID = "item_id";

    //EditText fields for the detail view UI
    private TextView salesOrderId, note, itemPosition, noteLanguage, productID, currencyCode;
    private TextView grossAmount, netAmount, taxAmount, deliveryDate, quantity, quantityUnit;

    /**
     * The content this fragment is presenting.
     */
    private SalesOrderItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SalesOrderItemDetailFragment()
    {
    }

    /**
     * Load the SalesOrder data based on the fragment arguments (which item the user selected)
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
            mItem = SalesOrderItemDataSingleton.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
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
        View rootView = inflater.inflate(R.layout.fragment_sales_order_item_detail, container, false);

        // Get the TextView items from the fragment_sales_order_detail.xml file.
        if (mItem != null)
        {
            salesOrderId = (TextView) rootView.findViewById(R.id.sales_order_id);
            note = (TextView) rootView.findViewById(R.id.note);
            noteLanguage = (TextView) rootView.findViewById(R.id.note_language);
            itemPosition = (TextView) rootView.findViewById(R.id.item_position);
            currencyCode = (TextView) rootView.findViewById(R.id.currency_code);
            grossAmount = (TextView) rootView.findViewById(R.id.gross_amount);
            netAmount = (TextView) rootView.findViewById(R.id.net_amount);
            taxAmount = (TextView) rootView.findViewById(R.id.tax_amount);
            deliveryDate = (TextView) rootView.findViewById(R.id.delivery_date);
            quantity = (TextView) rootView.findViewById(R.id.quantity);
            quantityUnit = (TextView) rootView.findViewById(R.id.quantity_unit);

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
            salesOrderId.setText(mItem.getSalesOrderId());
            note.setText(mItem.getNote());
            noteLanguage.setText(mItem.getNoteLanguage());
            itemPosition.setText(mItem.getItemPosition());
            grossAmount.setText(mItem.getGrossAmount());
            netAmount.setText(mItem.getNetAmount());
            currencyCode.setText(mItem.getCurrencyCode());
            taxAmount.setText(mItem.getTaxAmount());
            deliveryDate.setText(mItem.getDeliveryDate());
            quantity.setText(mItem.getQuantity());
            quantityUnit.setText(mItem.getQuantityUnit());
        }
    }
}

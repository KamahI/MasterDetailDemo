package com.christianschneider.masterdetaildemo;
import android.app.Application;

import com.christianschneider.model.SalesOrderDataSingleton;

/**
 * Subclass of Android Application class to hold product data as a global variable.
 */
public class MasterDetailDemo extends Application
{
    /**
     * Container for product data received from the OData service
     */
    public SalesOrderDataSingleton salesOrderData = null;

    /**
     * Initialize the parent class and initialize the Singletons
     */
    @Override
    public void onCreate()
    {
        super.onCreate();

        initSingleton();

    }

    /**
     * Initialize the Singleton (instance of SalesOrderDataSingleton)
     */
    private void initSingleton()
    {
        SalesOrderDataSingleton.createInstance();
        salesOrderData = SalesOrderDataSingleton.getInstance();
    }

}

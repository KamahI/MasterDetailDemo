package com.christianschneider.services;

import android.util.Log;

import com.sap.smp.client.odata.ODataEntity;
import com.sap.smp.client.odata.ODataEntitySet;
import com.sap.smp.client.odata.exception.ODataException;
import com.sap.smp.client.odata.online.OnlineODataStore;
import com.sap.smp.client.odata.store.ODataRequestExecution;
import com.sap.smp.client.odata.store.ODataRequestListener;
import com.sap.smp.client.odata.store.ODataRequestParamSingle;
import com.sap.smp.client.odata.store.ODataResponse;
import com.sap.smp.client.odata.store.ODataResponseSingle;
import com.sap.smp.client.odata.store.impl.ODataRequestParamSingleDefaultImpl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by christianschneider on 03.11.16.
 */

public class GetRequest implements ODataRequestListener{

    String TAG = this.getClass().getSimpleName();
    String resourcePath;
    /**
     * Send GET request to the offline store
     * @param collection URL of the collection, for example “Customers”
     * @param customTag description of the request
     * @param requestListener request listener
     * @throws OnlineODataStoreException
     */
    public static void sendGETRequest(String collection, String customTag,

                                      ODataRequestListener requestListener) throws OnlineODataStoreException {

        ODataOpenListener openListener = ODataOpenListener.getInstance();
        OnlineODataStore store = openListener.getStore();

        if (store!=null){
            try {
                ODataRequestParamSingle request = new ODataRequestParamSingleDefaultImpl();
                request.setMode(ODataRequestParamSingle.Mode.Read);
                request.setResourcePath(collection);
                request.setCustomTag(customTag);

                store.scheduleRequest(request, requestListener);
            } catch (Exception e) {
                throw new OnlineODataStoreException(e);
            }
        }
    }

    @Override
    public void requestStarted(ODataRequestExecution oDataRequestExecution) {

    }

    @Override
    public void requestCacheResponse(ODataRequestExecution oDataRequestExecution) {

    }

    @Override
    public void requestServerResponse(ODataRequestExecution oDataRequestExecution) {

        Log.d(TAG, "requestServerResponse");
        if (oDataRequestExecution!=null && oDataRequestExecution.getResponse() !=null) {
            String customTag = oDataRequestExecution.getRequest().getCustomTag();
            //Parse the response
            ODataResponseSingle response = (ODataResponseSingle) oDataRequestExecution.getResponse();

            //Get the http status code
            Map<ODataResponse.Headers, String> headerMap = response.getHeaders();
            String code = headerMap.get(ODataResponse.Headers.Code);
            Log.d(TAG, "requestServerResponse – status code " + code);

         //   Collections customerCollection = CustomerEntityCollection.getInstance();


//Get the response payload
            ODataEntitySet feed = (ODataEntitySet) response.getPayload();
//Store the URL required to get the next set of customers
           // customerCollection.setNextResourcePath(feed.getNextResourcePath());

//Get the list of ODataEntity
            List<ODataEntity> entities = feed.getEntities();
          //  customerCollection.setCustomersCache(entities);

         //   notifySuccessToListener("success");

        } else {
          //  notifyErrorToListener(new OnlineODataStoreException("no response"));

        }
    }

    @Override
    public void requestFailed(ODataRequestExecution oDataRequestExecution, ODataException e) {

    }

    @Override
    public void requestFinished(ODataRequestExecution oDataRequestExecution) {

    }
}

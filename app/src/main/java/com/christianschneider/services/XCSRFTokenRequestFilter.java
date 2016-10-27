package com.christianschneider.services;

import android.util.Log;

import com.sap.maf.tools.logon.core.LogonCoreContext;
import com.sap.maf.tools.logon.core.LogonCoreException;
import com.sap.smd.e2e.trace.bustrans.IResponse;
import com.sap.smd.e2e.trace.bustrans.impl.Response;
import com.sap.smp.client.httpc.HttpMethod;
import com.sap.smp.client.httpc.events.ISendEvent;
import com.sap.smp.client.httpc.filters.IRequestFilter;
import com.sap.smp.client.httpc.filters.IRequestFilterChain;
import com.sap.smp.client.odata.offline.ODataOfflineStore;

import java.util.Map;


/**
 * Manages XCSRF Tokens for OData requests
 */
public class XCSRFTokenRequestFilter implements IRequestFilter {
    //private static final String HTTP_HEADER_SUP_APPCID = "X-SUP-APPCID";
    private static final String HTTP_HEADER_SMP_APPCID = "X-SMP-APPCID";

    private static XCSRFTokenRequestFilter instance;

    private String lastXCSRFToken = null;
    private final LogonCoreContext lgCtx;

    private XCSRFTokenRequestFilter(LogonCoreContext logonContext) {
        lgCtx = logonContext;
    }


    /**
     * Creates new request filter if non exists
     *
     * @param logonContext logon context
     * @return XCSRFTokenRequestFilter request filter
     */
    public static XCSRFTokenRequestFilter getInstance(LogonCoreContext logonContext) throws LogonCoreException {
        if (instance == null) {
            Log.d("XCSRTOKENREQUESTurl", logonContext.getAppEndPointUrl());
            Log.d("XCSRTOKENREQUESTappid", logonContext.getAppId());
            Log.d("XCSRTOKENREQUESTpw", logonContext.getBackendPassword());
            Log.d("XCSRTOKENREQUESTuser", logonContext.getBackendUser());
            Log.d("XCSRTOKENREQUESTconnid", logonContext.getConnId());
            //Log.d("XCSRTOKENREQUESTcert", logonContext.getCertificate());
            Log.d("XCSRTOKENREQUESTappid", logonContext.getAppId());
            Log.d("XCSRTOKENREQUESTdom", logonContext.getDomain());
            Log.d("XCSRTOKENREQUESTfarmid", logonContext.getFarmId());
            Log.d("XCSRTOKENREQUESTgwc", logonContext.getGatewayClient());
            Log.d("XCSRTOKENREQUESThost", logonContext.getHost());
            // Log.d("XCSRTOKENREQUESTlastEx", logonContext.getLastException());
            // Log.d("XCSRTOKENREQUESTppath", logonContext.getPingpath());
            Log.d("XCSRTOKENREQUESTrespath", logonContext.getResourcePath());
            Log.d("XCSRTOKENREQUESTseccon", logonContext.getSecurtityConfig());
            // Log.d("XCSRTOKENREQUESTssopin", logonContext.getSSOPin());
            // Log.d("XCSRTOKENREQUESTssotok", logonContext.getSsoToken());
            // Log.d("XCSRTOKENREQUESTsuppw", logonContext.getSupPassword());
            // Log.d("XCSRTOKENREQUESTsupuser", logonContext.getSupUserName());
            // Log.d("XCSRTOKENREQUESTlgstate", String.valueOf(logonContext.getLogonState().));
            Log.d("XCSRTOKENREQUESTport", String.valueOf(logonContext.getPort()));

            instance = new XCSRFTokenRequestFilter(logonContext);

        }
        return instance;
    }


    @Override
    public Object filter(ISendEvent event, IRequestFilterChain chain) {
        HttpMethod method = event.getMethod();
        Log.d("XCSRFTokenRequestFilter", "method: " + method + ", lastXCSRFToken: " + lastXCSRFToken);
        if (method == HttpMethod.GET /*&& lastXCSRFToken == null*/) {
//            event.getRequestHeaders().put("authorization", "Basic U2NobmVpZGVyQzp3ZWxjb21lMTIz");
//            event.getRequestHeaders().put("content-type", "application/xml");
            event.getRequestHeaders().put("X-CSRF-Token", "Fetch");
            Log.d("request Header", event.getRequestHeaders().get("X-CSRF-Token"));
        } else if (lastXCSRFToken != null) {
            event.getRequestHeaders().put("X-CSRF-Token", lastXCSRFToken);
        } else {
            event.getRequestHeaders().put("X-Requested-With", "XMLHttpRequest");
        }

        String appConnID = null;

        try {

            appConnID = lgCtx.getConnId();
            //appConnID = "48091f5b-4171-42df-a524-1cf155c6954d";
            Log.d("Hier muss connID kommen", "jaaa wirklich!!");
            Log.d("ConnID", appConnID);
        } catch (LogonCoreException e) {
            Log.e("XCSRFTokenRequestFilter", "error getting connection id", e);
        }

        //for backward compatibility. not needed for SMP 3.0 SP05
        if (appConnID != null) {
            //event.getRequestHeaders().put(HTTP_HEADER_SUP_APPCID, appConnID);
            event.getRequestHeaders().put(HTTP_HEADER_SMP_APPCID, appConnID);
        }
        event.getRequestHeaders().put("Connection", "Keep-Alive");

        return chain.filter();
    }

    @Override
    public Object getDescriptor() {
        return "XCSRFTokenRequestFilter";
    }

    public void setLastXCSRFToken(String lastXCSRFToken) {
        this.lastXCSRFToken = lastXCSRFToken;
    }

}
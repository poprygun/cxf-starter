package io.microsamples.ws.cxfstarter.config;

import org.apache.cxf.ext.logging.LoggingFeature;

public class PrettyLoggingFeature extends LoggingFeature {

    public PrettyLoggingFeature(){
        super.setPrettyLogging(true);
    }
}
package com.marklogic.developer.corb;

import com.marklogic.xcc.ResultSequence;
import com.marklogic.xcc.exceptions.XQueryException;
/**
 * Transform task that ignores XQuery exceptions and continues on
 * It will log the Xquery exception but it will not stop the job for the uri
 * This task must be specified using property: PROCESS-TASK=com.marklogic.developer.corb.ResilientTransform
 * 
 * @author Richard Kennedy, richard.kennedy@marklogic.com
 *
 */
public class ResilientTransform extends AbstractTask{

    
	protected String processResult(ResultSequence seq) throws CorbException{
		return TRUE;
	}
	
    public String call() throws Exception {
    	try{
    		return invokeModule();
    	} catch (CorbException corbException) {
    		// checking to see if Xquery Exception caused transform failure
    		if (corbException!= null && corbException.getCause()!= null && 
    				corbException.getCause() instanceof XQueryException) {
    			logger.logException("Skipping URI=" +inputUri + " due to XqueryException", corbException);
    			return inputUri;
    		} else {
    			throw corbException;
    		}
    		
    	} finally{
    		cleanup();
    	}
    }
}

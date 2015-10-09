package com.marklogic.developer.corb;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Richard Kennedy, richard.kennedy@marklogic.com
 */
public class RestartManager {

    /**
     * Alternative main class that will restart corb immediately after it finishes
     * @param args
     * @throws URISyntaxException
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
	public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		
		while (true) {
			Manager.main(args);
		}
	}
}

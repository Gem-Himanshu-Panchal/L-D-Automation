package com.qa.lms.stepdefinition;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.Before;

public class HOOK {
    @Before
    public void Start() throws GemException {
        DriverManager.setUpBrowser();
    }
}

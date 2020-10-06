package com.cogmentocrm.qa.dataproviders;

import com.cogmentocrm.qa.util.TestUtil;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;

public class NewContactDataProvider {

    @DataProvider
    public static Iterator<Object[]> contactData()
    {

        ArrayList<Object[]> testData = TestUtil.getContactDataFromExcel();
        return testData.iterator();
    }
}

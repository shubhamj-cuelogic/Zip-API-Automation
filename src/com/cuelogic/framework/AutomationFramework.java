package com.cuelogic.framework;

import com.cuelogic.framework.configuration.Configuration;

/**
 * Created by ninad on 15/01/16.
 */
public class AutomationFramework
{
    public static void initWithGlobalConfiguration(String globalConfigureationFileWithPath)
    {
        Configuration.globalConfiguration().setGlobalConfigurationFile(globalConfigureationFileWithPath);
    }


}
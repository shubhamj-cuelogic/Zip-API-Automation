package com.cuelogic.framework.queue;

import com.cuelogic.framework.network.HTTPRequest;

/**
 * Created by ninad on 22/01/16.
 */
public class QueueData {

    private String queueId;
    private String requestId;

    public HTTPRequest request;

    public QueueStatus queueStatus;
}

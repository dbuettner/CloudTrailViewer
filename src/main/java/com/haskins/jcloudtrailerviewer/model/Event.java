package com.haskins.jcloudtrailerviewer.model;

import java.util.List;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonProperty;

public class Event {
    
    @JsonProperty("eventTime")
    private String eventTime = "";
    
    @JsonProperty("eventVersion")
    private String eventVersion = "";
    
    @JsonProperty("userIdentity")
    private UserIdentity userIdentity;
    
    @JsonProperty("eventName")
    private String eventName = "";
    
    @JsonProperty("awsRegion")
    private String awsRegion = "";
    
    @JsonProperty("sourceIPAddress")
    private String sourceIPAddress = "";
    
    @JsonProperty("userAgent")
    private String userAgent = "";
    
    @JsonProperty("eventSource")
    private String eventSource = "";
    
    @JsonProperty("errorCode")
    private String errorCode = "";
    
    @JsonProperty("errorMessage")
    private String errorMessage = "";

    @JsonProperty("requestParameters")
    private Map requestParameters;
    
    @JsonProperty("responseElements")
    private Map responseElements;
    
    @JsonProperty("requestID")
    private String requestId = "";
    
    @JsonProperty("eventID")
    private String eventId = "";
    
    @JsonProperty("eventType")
    private String eventType = "";
    
    @JsonProperty("apiVersion")
    private String apiVersion = "";
    
    @JsonProperty("recipientAccountId")
    private String recipientAccountId = "";
    
    
    // NOT MENTIONED IN DOCS
    @JsonProperty("additionalEventData")
    private AdditionalEventData additionalEventData;
    
    @JsonProperty("readOnly")
    private String readOnly = "";  
       
    @JsonProperty("resources")
    private List<Resource> resources; 
    

    /** Internal Use **/
    private String rawJson;
    
    public void setRawJSON(String json) {
        this.rawJson = json;
    }
    public String getRawJSON() {
    	return this.rawJson;
    }


    /**
     * @return the eventVersion
     */
    public String getEventVersion() {
        return eventVersion;
    }

    /**
     * @param eventVersion the eventVersion to set
     */
    public void setEventVersion(String eventVersion) {
        this.eventVersion = eventVersion;
    }

    /**
     * @return the userIdentity
     */
    public UserIdentity getUserIdentity() {
        return userIdentity;
    }

    /**
     * @param userIdentity the userIdentity to set
     */
    public void setUserIdentity(UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
    }

    /**
     * @return the eventTime
     */
    public String getEventTime() {
        return eventTime;
    }

    /**
     * @param eventTime the eventTime to set
     */
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * @return the eventSource
     */
    public String getEventSource() {
        return eventSource;
    }

    /**
     * @param eventSource the eventSource to set
     */
    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the awsRegion
     */
    public String getAwsRegion() {
        return awsRegion;
    }

    /**
     * @param awsRegion the awsRegion to set
     */
    public void setAwsRegion(String awsRegion) {
        this.awsRegion = awsRegion;
    }

    /**
     * @return the sourceIPAddress
     */
    public String getSourceIPAddress() {
        return sourceIPAddress;
    }

    /**
     * @param sourceIPAddress the sourceIPAddress to set
     */
    public void setSourceIPAddress(String sourceIPAddress) {
        this.sourceIPAddress = sourceIPAddress;
    }

    /**
     * @return the userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * @param userAgent the userAgent to set
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * @return the requestParameters
     */
    public Map getRequestParameters() {
        return requestParameters;
    }

    /**
     * @param requestParameters the requestParameters to set
     */
    public void setRequestParameters(Map requestParameters) {
        this.requestParameters = requestParameters;
    }

    /**
     * @return the responseElements
     */
    public Map getResponseElements() {
        return responseElements;
    }

    /**
     * @param responseElements the responseElements to set
     */
    public void setResponseElements(Map responseElements) {
        this.responseElements = responseElements;
    }

    /**
     * @return the requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @param requestId the requestId to set
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * @return the eventId
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * @param eventId the eventId to set
     */
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the readOnly
     */
    public String getReadOnly() {
        return readOnly;
    }

    /**
     * @param readOnly the readOnly to set
     */
    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * @return the resources
     */
    public List getResources() {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(List resources) {
        this.resources = resources;
    }
    
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getRecipientAccountId() {
        return recipientAccountId;
    }

    public void setRecipientAccountId(String recipientAccountId) {
        this.recipientAccountId = recipientAccountId;
    }

    /**
     * @return the additionalEventData
     */
    public AdditionalEventData getAdditionalEventData() {
        return additionalEventData;
    }

    /**
     * @param additionalEventData the additionalEventData to set
     */
    public void setAdditionalEventData(AdditionalEventData additionalEventData) {
        this.additionalEventData = additionalEventData;
    }

    /**
     * @return the apiVersion
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * @param apiVersion the apiVersion to set
     */
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}

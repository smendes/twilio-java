package com.twilio.sdk.twiml;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * TwiML wrapper for {@see https://www.twilio.com/docs/api/twiml/record}.
 */
@JacksonXmlRootElement
public class Record extends TwiML {

    @JacksonXmlProperty(isAttribute = true)
    private final boolean transcribe;

    @JacksonXmlProperty(isAttribute = true)
    private final boolean playBeep;

    @JacksonXmlProperty(isAttribute = true)
    private final int timeout;

    @JacksonXmlProperty(isAttribute = true)
    private final int maxLength;

    @JacksonXmlProperty(isAttribute = true)
    private final String action;

    @JacksonXmlProperty(isAttribute = true)
    private final Method method;

    @JacksonXmlProperty(isAttribute = true)
    private final String finishOnKey;

    @JacksonXmlProperty(isAttribute = true)
    private final String transcribeCallback;

    @JacksonXmlProperty(isAttribute = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private final Trim trim;

    private Record(Builder b) {
        this.transcribe = b.transcribe;
        this.playBeep = b.playBeep;
        this.timeout = b.timeout;
        this.maxLength = b.maxLength;
        this.action = b.action;
        this.method = b.method;
        this.finishOnKey = b.finishOnKey;
        this.transcribeCallback = b.transcribeCallback;
        this.trim = b.trim;
    }

    public boolean isTranscribe() {
        return transcribe;
    }

    public boolean isPlayBeep() {
        return playBeep;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public String getAction() {
        return action;
    }

    public Method getMethod() {
        return method;
    }

    public String getFinishOnKey() {
        return finishOnKey;
    }

    public String getTranscribeCallback() {
        return transcribeCallback;
    }

    public Trim getTrim() {
        return trim;
    }

    public static class Builder {
        private boolean transcribe = false;
        private boolean playBeep = true;
        private int timeout = 5;
        private int maxLength = 3600;
        private String action;
        private Method method = Method.POST;
        private String finishOnKey = "1234567890*#";
        private String transcribeCallback;
        private Trim trim = Trim.TRIM_SILENCE;

        public Builder transcribe(boolean transcribe) {
            this.transcribe = transcribe;
            return this;
        }

        public Builder playBeep(boolean playBeep) {
            this.playBeep = playBeep;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder maxLength(int maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public Builder action(String action) {
            this.action = action;
            return this;
        }

        public Builder method(Method method) {
            this.method = method;
            return this;
        }

        public Builder finishOnKey(String finishOnKey) {
            this.finishOnKey = finishOnKey;
            return this;
        }

        public Builder transcribeCallback(String transcribeCallback) {
            this.transcribeCallback = transcribeCallback;
            return this;
        }

        public Builder trim(Trim trim) {
            this.trim = trim;
            return this;
        }

        public Record build() {
            return new Record(this);
        }
    }
}

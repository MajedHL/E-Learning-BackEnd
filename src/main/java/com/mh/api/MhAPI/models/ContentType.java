package com.mh.api.MhAPI.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ContentType {
    TEXT, IMAGE, VIDEO;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}

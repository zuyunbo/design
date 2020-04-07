package com.example.abstractdocument.domain;

import com.example.abstractdocument.Document;
import com.example.abstractdocument.domain.enums.Property;

import java.util.Optional;

public interface HasModel extends Document {

    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(Property.MODEL.toString()));
    }

}

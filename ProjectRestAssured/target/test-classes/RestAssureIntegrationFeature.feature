@wip
Feature: Get the population data for the country

  Background: Rest Assured Integration Scenarios Background
    Given the user has provided the Nation detail

  Scenario: Rest Assured Integration Scenario steps
    When the user has requested the population information
    Then the system responds with the status code 200
    And the system responds with UnitedStates as nation
    And the system responds with nations population for the years
    And the response json contains the source info
    And the response json matches the schema:
    """
{
    "$schema": "http://json-schema.org/draft-06/schema#",
    "$ref": "#/definitions/Welcome6",
    "definitions": {
        "Welcome6": {
            "type": "object",
            "additionalProperties": false,
            "properties": {
                "data": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/Datum"
                    }
                },
                "source": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/Source"
                    }
                }
            },
            "required": [
                "data",
                "source"
            ],
            "title": "Welcome6"
        },
        "Datum": {
            "type": "object",
            "additionalProperties": false,
            "properties": {
                "ID Nation": {
                    "type": "string"
                },
                "Nation": {
                    "type": "string"
                },
                "ID Year": {
                    "type": "integer"
                },
                "Year": {
                    "type": "string",
                    "format": "integer"
                },
                "Population": {
                    "type": "integer"
                },
                "Slug Nation": {
                    "type": "string"
                }
            },
            "required": [
                "ID Nation",
                "ID Year",
                "Nation",
                "Population",
                "Slug Nation",
                "Year"
            ],
            "title": "Datum"
        },
        "Source": {
            "type": "object",
            "additionalProperties": false,
            "properties": {
                "measures": {
                    "type": "array",
                    "items": {
                        "type": "string"
                    }
                },
                "annotations": {
                    "$ref": "#/definitions/Annotations"
                },
                "name": {
                    "type": "string"
                },
                "substitutions": {
                    "type": "array",
                    "items": {}
                }
            },
            "required": [
                "annotations",
                "measures",
                "name",
                "substitutions"
            ],
            "title": "Source"
        },
        "Annotations": {
            "type": "object",
            "additionalProperties": false,
            "properties": {
                "source_name": {
                    "type": "string"
                },
                "source_description": {
                    "type": "string"
                },
                "dataset_name": {
                    "type": "string"
                },
                "dataset_link": {
                    "type": "string",
                    "format": "uri",
                    "qt-uri-protocols": [
                        "http"
                    ]
                },
                "table_id": {
                    "type": "string"
                },
                "topic": {
                    "type": "string"
                },
                "subtopic": {
                    "type": "string"
                }
            },
            "required": [
                "dataset_link",
                "dataset_name",
                "source_description",
                "source_name",
                "subtopic",
                "table_id",
                "topic"
            ],
            "title": "Annotations"
        }
    }
}
    """

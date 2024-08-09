package com.project.populationdata.steps;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PopulationPojo {
    public ArrayList<Datum> data;
    public ArrayList<Source> source;

    static class Datum{
        @JsonProperty("ID Nation")
        public String iD_Nation;
        @JsonProperty("Nation")
        public String nation;
        @JsonProperty("ID Year")
        public int iD_Year;
        @JsonProperty("Year")
        public String year;
        @JsonProperty("Population")
        public int population;
        @JsonProperty("Slug Nation")
        public String slug_Nation;
    }

    static class Annotations{
        public String source_name;
        public String source_description;
        public String dataset_name;
        public String dataset_link;
        public String table_id;
        public String topic;
        public String subtopic;
    }

    static class Source{
        public ArrayList<String> measures;
        public Annotations annotations;
        public String name;
        public ArrayList<Object> substitutions;
    }
}

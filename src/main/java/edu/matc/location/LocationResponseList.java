package edu.matc.location;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

public class LocationResponseList {

        @JsonProperty("zipcodes")
        private List<ZipcodesList> zipcodes;

        @JsonProperty("city_lists")
        private List<CityList> city;


        public void setZipcodes(List<ZipcodesList> zipcodes){
            this.zipcodes = zipcodes;
        }

        public List<ZipcodesList> getZipcodes(){
            return zipcodes;
        }

        public void setCityLists(List<CityList> cityLists){
            this.city = cityLists;
        }

        public List<CityList> getCityStates(){
            return city;
        }


        @Override
        public String toString(){
            return
                    "SmartyResponseItem{" +
                            "zipcodes = '" + zipcodes + '\'' +
                            ",city_lists = '" + city + '\'' +
                            "}";
        }
    }


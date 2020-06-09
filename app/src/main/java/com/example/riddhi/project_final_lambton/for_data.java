package com.example.riddhi.project_final_lambton;

import java.io.Serializable;

/**
 * Created by RIDDHI on 13-12-17.
 */

public class for_data implements Serializable {





    /**
     * Created by Belal on 9/30/2017.
     */


        int id;
        String name,level,agency,web,country,phone,add;
       // double salary;

        public for_data( String name,String level,String agency,String web,String country,String phone,String add) {
            this.id = id;
            this.name = name;
            this.level = level;
            this.agency = agency;
            this.web = web;
            this.country = country;
            this.phone = phone;
            this.add = add;

        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getLevel() {
            return level;
        }

        public String getAgency() {
            return agency;
        }

        public String getWeb() {
            return web;
        }


    public String getCountry() {
        return country;

    }
    public String getPhone() {
        return phone;
    }
    public String getAdd() {
        return add;
    }



}


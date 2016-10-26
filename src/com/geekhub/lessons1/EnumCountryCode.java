package com.geekhub.lessons1;

public enum EnumCountryCode {
    UKRAINE {
        public int getCountryPhonePrefix() {
            return 380;
        }
    },
    USA {
        public int getCountryPhonePrefix() {
            return 180;
        }
    };

}

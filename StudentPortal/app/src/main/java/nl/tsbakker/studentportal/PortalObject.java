package nl.tsbakker.studentportal;

public class PortalObject {

    //
// Name:    PortlObject
// Purpose: Handle the datamodel
// Author:  Taco Bakker
// Date:    25-9-2018
//

        private String mPortalUrl;
        private String mPortalName;

        public PortalObject(String mPortalName, String mPortalUrl) {
            this.mPortalUrl = mPortalUrl;
            this.mPortalName = mPortalName;
        }

        public String getmPortalUrl() {
            return mPortalUrl;
        }

        public void setmPortalUrl(String mPortalUrl) {
            this.mPortalUrl = mPortalUrl;
        }

        public String getmPortalName() {
            return mPortalName;
        }

        public void setmPortalName(String mPortalName) {
            this.mPortalName = mPortalName;
        }



}

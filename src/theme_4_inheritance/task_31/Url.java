package theme_4_inheritance.task_31;

public class Url {
    String urlWebSite = "https://www.cbr.ru/scripts/XML_dynamic.asp";
    String prefixStartDate = "date_req1=";
    String startDate;
    String prefixEndDate = "date_req2=";
    String endDate;
    String unique_code = "VAL_NM_RQ=R01235";

    Url() {
    }

    Url(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Url(String urlWebSite, String prefixStartDate, String startDate,
               String prefixEndDate, String endDate, String unique_code) {
        this.urlWebSite = urlWebSite;
        this.prefixStartDate = prefixStartDate;
        this.startDate = startDate;
        this.prefixEndDate = prefixEndDate;
        this.endDate = endDate;
        this.unique_code = unique_code;
    }

    String getUrl() {
        return urlWebSite + "?" + prefixStartDate + startDate + "&" + prefixEndDate + endDate + "&" + unique_code;
    }
}

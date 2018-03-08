package com.disney.cast.platform.vacationplanner.ui.snow.pages.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

@SuppressWarnings("unused")
public class PerformanceVO extends ValueObject {

    private final String userName;
    private final String periodStartDate;
    private final String periodName;
    private final String periodEndDate;
    private final String reportDate;

    /**
     * PerformanceVO
     *
     * @param userName
     * @param periodStartDate
     * @param periodName
     * @param periodEndDate
     * @param reportDate
     */
    public PerformanceVO(String userName, String periodStartDate, String periodName, String periodEndDate,
            String reportDate) {
        super();
        this.userName = userName;
        this.periodStartDate = periodStartDate.contains("/") ? reformatDate(periodStartDate) : periodStartDate;
        this.periodName = periodName;
        this.periodEndDate = periodEndDate.contains("/") ? reformatDate(periodEndDate) : periodEndDate;
        this.reportDate = reportDate.contains("/") ? reformatDate(reportDate) : reportDate;
    }

    private String reformatDate(String dateUnformatted) {
        SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = format1.parse(dateUnformatted);
            return format2.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "NotADate";
    }
}

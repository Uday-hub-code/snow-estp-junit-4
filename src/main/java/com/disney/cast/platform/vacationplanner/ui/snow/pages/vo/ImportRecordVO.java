package com.disney.cast.platform.vacationplanner.ui.snow.pages.vo;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

@SuppressWarnings("unused")
public class ImportRecordVO extends ValueObject {
    private final String number;
    private final String destinationTable;
    private final String documentID;
    private final String status;
    private final String tableName;

    public ImportRecordVO(String number, String destinationTable, String documentID, String status,
            String tableName) {
        super();
        this.number = number;
        this.destinationTable = destinationTable;
        this.documentID = documentID;
        this.status = status;
        this.tableName = tableName;
    }
}
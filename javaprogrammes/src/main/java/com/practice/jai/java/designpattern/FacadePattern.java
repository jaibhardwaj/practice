package com.practice.jai.java.designpattern;

import java.sql.Connection;
/*
* Problem Statement
* **********************************/
interface MySqlInterface
{
    Connection MySqlConnection(String username, String password);
    void generatePDFReport(String tableName, String size);
    void generateXMLReport(String tableName, String size);
}

interface OracleSqlInterface
{
    Connection OracleSqlConnection(String username, String password);
    void generatePDFReport(String tableName, String size);
    void generateXMLReport(String tableName, String size);
}

/************************************************************/

/*
* Solution Using FacadePattern
* */

interface ReportGenerator
{
    void generateReport(DBType dbType, String username, String password, ReportType reportType, String size);
}
class ReportGeneratorImpl implements ReportGenerator
{

    @Override
    public void generateReport(DBType dbType, String username, String password, ReportType reportType, String size)
    {
        switch (dbType)
        {
            case MYSQL:
            {
                switch (reportType)
                {
                    case PDF:
                    break;
                    case XML:
                    break;

                }
            };
            case ORACLE:
            {
                switch (reportType)
                {
                    case PDF:
                        break;
                    case XML:
                        break;

                }
            }
        }
    }
}
public class FacadePattern
{

}

enum DBType
{
    MYSQL,
    ORACLE;
}

enum ReportType
{
    PDF,
    XML,
    HTML;
}

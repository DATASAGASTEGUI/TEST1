/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivoscsv;

/**
 *
 * @author DAM 2
 */
public class Financial {
    private String Segment; //1
    private String Country; //2
    private String Product; //3
    private String Discount_Band; //4
    private String Units_sold; //5
    private String Manufacturing_Price; //6 
    private String Sale_Price; //7
    private String Gross_Sales; //8
    private String Disconunts; //9
    private String Sales; //10
    private String COGS; //11
    private String profit; //12
    private String Date; //13
    private String MonthNumber; //14 
    private String MonthName; //15
    private String Year; //16

    public Financial(String Segment, String Country, String Product, String Discount_Band, String Units_sold, String Manufacturing_Price, String Sale_Price, String Gross_Sales, String Disconunts, String Sales, String COGS, String profit, String Date, String MonthNumber, String MonthName, String Year) {
        this.Segment = Segment;
        this.Country = Country;
        this.Product = Product;
        this.Discount_Band = Discount_Band;
        this.Units_sold = Units_sold;
        this.Manufacturing_Price = Manufacturing_Price;
        this.Sale_Price = Sale_Price;
        this.Gross_Sales = Gross_Sales;
        this.Disconunts = Disconunts;
        this.Sales = Sales;
        this.COGS = COGS;
        this.profit = profit;
        this.Date = Date;
        this.MonthNumber = MonthNumber;
        this.MonthName = MonthName;
        this.Year = Year;
    }

    public String getSegment() {
        return Segment;
    }

    public String getCountry() {
        return Country;
    }

    public String getProduct() {
        return Product;
    }

    public String getDiscount_Band() {
        return Discount_Band;
    }

    public String getUnits_sold() {
        return Units_sold;
    }

    public String getManufacturing_Price() {
        return Manufacturing_Price;
    }

    public String getSale_Price() {
        return Sale_Price;
    }

    public String getGross_Sales() {
        return Gross_Sales;
    }

    public String getDisconunts() {
        return Disconunts;
    }

    public String getSales() {
        return Sales;
    }

    public String getCOGS() {
        return COGS;
    }

    public String getProfit() {
        return profit;
    }

    public String getDate() {
        return Date;
    }

    public String getMonthNumber() {
        return MonthNumber;
    }

    public String getMonthName() {
        return MonthName;
    }

    public String getYear() {
        return Year;
    }
    
    
    
}

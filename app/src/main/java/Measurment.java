import java.util.Date;

public class Measurment {

    //Temperaturemeasuremnets
    private static  int _FP_ID = 5;
    private static  String _bezeichnug;
    private static Date _date;
    private static double _outsideTemperature;
    private static double _containerTemperature;
    private static double _waterTermperature;
    //  private static double _flowrateTemperature;  --> Sensor für Messung fehlt

    //other measurements
    private static double _waterlevel;
    //private static double _flowrate ;   --> haben noch keinen Sensor für die Messung
    private static double _gas;

    public Measurment(String bez, Date d, Double outsideTemp, double waterTemp, double containerTemp, double waterLev, double gas) {
        this._FP_ID ++;
        this._bezeichnug = bez;
        this._date = d;
        this._outsideTemperature = outsideTemp;
        this._containerTemperature = containerTemp;
        this._waterTermperature = waterTemp;
        this._waterlevel = waterLev;
        this._gas = gas;
    }

    public Measurment() {
    }

    public static double getOutsideTemperature() {
        return _outsideTemperature;
    }

    public static double getContainerTemperature() {
        return _containerTemperature;
    }

    public static double getWaterTermperature() {
        return _waterTermperature;
    }

    public static double getWaterlevel() {
        return _waterlevel;
    }

    public static double getGas() {
        return _gas;
    }

    public static void setOutsideTemperature(double outsideTemperature) {
        Measurment._outsideTemperature = outsideTemperature;
    }

    public static int getFpId() {
        return _FP_ID;
    }

    public static void setFpId(int FpId) {
        _FP_ID = FpId;
    }

    public static String get_bezeichnug() {
        return _bezeichnug;
    }

    public static void set_bezeichnug(String _bezeichnug) {
        Measurment._bezeichnug = _bezeichnug;
    }

    public static Date get_date() {
        return _date;
    }

    public static void set_date(Date _date) {
        Measurment._date = _date;
    }

    public static void setContainerTemperature(double containerTemperature) {
        Measurment._containerTemperature = containerTemperature;
    }

    public static void setWaterTermperature(double waterTermperature) {
        Measurment._waterTermperature = waterTermperature;
    }

    public static void setWaterlevel(double waterlevel) {
        Measurment._waterlevel = waterlevel;
    }

    public static void setGas(double gas) {
        Measurment._gas = gas;
    }

    @Override
    public String toString() {
        return "Name: " + get_bezeichnug() + " Date: " + get_date()+ " Außentemperatur: " + getOutsideTemperature() + " ContainterTemp: " + _containerTemperature + " Watertemp: " + getWaterTermperature() + " Wasserlevel: " + getWaterlevel() + " Gas: " + getGas();
    }
}
